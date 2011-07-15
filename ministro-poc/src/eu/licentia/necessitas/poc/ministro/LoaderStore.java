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

/**
 * Implementation of a simple repository for Loader APKs. 
 * 
 * @author Robert Schuster <r.schuster@tarent.de>
 *
 */
public class LoaderStore {

	private File filesDir;
	private Resources resources;

	private Map<Integer, LoaderInfo> loaderInfos = new HashMap<Integer, LoaderInfo>();

	private Object lock = new Object();

	/** Creates a {@link LoaderStore} instance that stores all files in <code>filesDir</code>.
	 * 
	 * @param res
	 * @param filesDir
	 */
	LoaderStore(Resources res, File filesDir) {
		this.resources = res;
		this.filesDir = filesDir;
	}

	/** Initializes the {@link LoaderStore} with the given array of loader files
	 * and their respective class names.
	 * 
	 * @param loaderFiles
	 * @param loaderClassNames
	 */
	void init(String[] loaderFiles, String[] loaderClassNames) {
		for (int i = 0; i < loaderFiles.length; i++) {
			ensureAvailability(i + 1, loaderFiles[i], loaderClassNames[i]);
		}
	}

	/**
	 * Makes sure that the specified loader file is available use by applications.
	 * 
	 * The current very simple system just checks the availability of the file. If it
	 * is there it is assumed the APK file is correct.
	 * 
	 * TODO: Add checksum.
	 * 
	 * @param loaderLevel
	 * @param name
	 * @param loaderClassName
	 */
	private void ensureAvailability(int loaderLevel, String name, String loaderClassName) {
		synchronized (lock) {
			File file = new File(filesDir, name + ".apk");

			if (!file.exists()) {
				try {
					// Look up the resource
					int resourceId = getRawResourceId(name);
					
					// store the input stream in the filesystem
					toFile(resources.openRawResource(resourceId), file);

					// and make the file accessible for everyone
					Ministro2.makeWorldReadable(file.getAbsolutePath());
				} catch (IOException ioe) {
					// rethrow something
					throw new RuntimeException();
				}
			}
			loaderInfos.put(loaderLevel, new LoaderInfo(file.getAbsolutePath(),
					loaderClassName));
		}
	}

	/**
	 * Stores the given {@link InputStream} in the {@link File}.
	 *  
	 * @param is
	 * @param file
	 * @throws IOException
	 */
	private void toFile(InputStream is, File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file, false);

		OutputStream os = new BufferedOutputStream(fos, 8192);

		byte[] buffer = new byte[8192];

		int byteRead = 0;

		while ((byteRead = is.read(buffer)) > 0) {
			os.write(buffer, 0, byteRead);
		}
		os.flush();
		os.close();
		fos.close();
	}

	/**
	 * Looks up the resource id of a raw resource by means of a string.
	 * 
	 * @param name
	 * @return
	 */
	private int getRawResourceId(String name) {
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
