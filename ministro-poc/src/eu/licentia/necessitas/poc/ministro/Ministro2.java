package eu.licentia.necessitas.poc.ministro;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.EditText;

public class Ministro2 extends Service {

	private static final String TAG = "Ministro2";

	private static final int SUPPORTED_MINISTRO_LEVEL = 1;
	
	private EditText log;
	
	static Ministro2 instance;
	
	public Ministro2() {
		Log.i(TAG, "service started");
		instance = this;
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
			log("checkCompatibility(" + ministroLevel + ");");
			
			return ministroLevel > 0
					&& ministroLevel <= SUPPORTED_MINISTRO_LEVEL;
		}

		@Override
		public void serve(ICallback1 callback) throws RemoteException {
			log("serving app: " + callback.getApplicationName());
			log("required Loader level: " + callback.getRequiredLoaderLevel());

			Result r = new Result();
			
			switch (callback.getRequiredLoaderLevel())
			{
				case 1:
					r.loaderPath = "/data/local/loader.apk";
					r.loaderClassName = "eu.licentia.necessitas.ministro.loader1.Loader1Impl";
					r.success = true;
					break;
				default:
					r.success = false;
			}
			
			callback.finished(r);
		}
	};

}
