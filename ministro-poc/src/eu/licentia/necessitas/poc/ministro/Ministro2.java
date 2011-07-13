package eu.licentia.necessitas.poc.ministro;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class Ministro2 extends Service {

	private static final String TAG = "Ministro2";

	private static final int SUPPORTED_MINISTRO_LEVEL = 1;

	static Ministro2 instance;
	
	private LoaderStore store;
	
	private EditText log;

	static {
        //System.loadLibrary("helper");
    }

    public Ministro2() {
		Log.i(TAG, "service started");
		instance = this;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();

		Resources r = getResources();
		store = new LoaderStore(r, getFilesDir());
		
		String loaderFiles[] = r.getStringArray(R.array.loaderFiles);
		String loaderClassNames[] = r.getStringArray(R.array.loaderClassNames);
		store.init(loaderFiles, loaderClassNames);
	}

	static Ministro2 instance() {
		return instance;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return service;
	}

	void setEditText(EditText l) {
		this.log = l;
	}

	void log(String msg) {
		if (log != null) {
			log.append(msg);
			log.append("\n");
		}
		
	}

	private IMinistroService.Stub service = new IMinistroService.Stub() {
		
		@Override
		public boolean checkCompatibility(int ministroLevel)
				throws RemoteException {
			boolean result = ministroLevel > 0
					&& ministroLevel <= SUPPORTED_MINISTRO_LEVEL;
			log("checkCompatibility(" + ministroLevel + ") = " + result);
			return result;
		}

		@Override
		public void serve(ICallback1 callback) throws RemoteException {
			log("serving app: " + callback.getApplicationName());
			log("required Loader level: " + callback.getRequiredLoaderLevel());

			Result r = new Result();

			int level = callback.getRequiredLoaderLevel();
			LoaderInfo info = store.getLoaderInfo(level);
			if (info != null) {
				r.loaderPath = info.path;
				r.loaderClassName = info.loaderClassName;
				r.success = true;
			} else
			{
				r.success = false;
			}

			callback.finished(r);
		}
	};

	native static int makeWorldReadable(String filepath);
}
