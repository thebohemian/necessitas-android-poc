package eu.licentia.necessitas.poc.ministro;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;

public class LoaderStore {

	private File filesDir;
	private Resources resources;

	private Map<Integer, LoaderInfo> loaderInfos = new HashMap<Integer, LoaderInfo>();

	private Object lock = new Object();

	LoaderStore(Resources res, File filesDir) {
		this.resources = res;
		this.filesDir = filesDir;
	}
	
	void init(String[] loaderFiles, String[] loaderClassNames) {
		for (int i = 0; i < loaderFiles.length; i++) {
			ensureAvailability(i + 1, loaderFiles[i], loaderClassNames[i]);
		}
	}

	void ensureAvailability(int loaderLevel, String name, String loaderClassName) {
		synchronized (lock) {
			File file = new File(filesDir, name + ".apk");

			if (!file.exists()) {
				try {
					int resourceId = getResourceId(name);
					toFile(resources.openRawResource(resourceId), file);
				} catch (IOException ioe) {
					// rethrow something
					throw new RuntimeException();
				}
			}
			loaderInfos.put(loaderLevel, new LoaderInfo(file.getAbsolutePath(), loaderClassName));
		}
	}

	private void toFile(InputStream is, File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file, false);

		OutputStream os = new BufferedOutputStream(fos);

		byte[] buffer = new byte[16384];

		int byteRead = 0;

		while ((byteRead = is.read(buffer)) > 0) {
			os.write(buffer, 0, byteRead);
		}
		fos.close();
		
		//Ministro2.makeWorldReadable(file.getAbsolutePath());
	}
	
	private int getResourceId(String name) {
		Field f;
		try {
			f = R.raw.class.getField(name);
			return (Integer) f.get(null);
		} catch (SecurityException e) {
		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}
		
		return -1;
	}

	LoaderInfo getLoaderInfo(int loaderLevel) {
		return loaderInfos.get(loaderLevel);
	}
	
}
