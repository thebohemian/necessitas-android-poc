package eu.licentia.necessitas.poc.appv1;

import java.util.concurrent.atomic.AtomicBoolean;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import dalvik.system.DexClassLoader;
import eu.licentia.necessitas.poc.ministro.ICallback1;
import eu.licentia.necessitas.poc.ministro.IMinistroService;
import eu.licentia.necessitas.poc.ministro.IResult;
import eu.licentia.necessitas.poc.ministro.Loader1;

/**
 * Minimal starter that interacts with the Ministro service to do application
 * startup.
 * 
 * TODO: Show error dialogs TODO: Do not show this Activity at startup somehow
 * TODO: Evaluate 'use local libs' flag.
 * 
 * @author Robert Schuster <r.schuster@tarent.de>
 * 
 */
public class StarterActivity extends Activity {

	static final String BUILTIN_LOADER_PATH = "/data/local/qt/loader/loader.apk";

	static final String BUILTIN_LOADER_CLASSNAME = "eu.licentia.necessitas.ministro.loader1.Loader1Impl";

	private static final String TAG = "Starter4";

	private static final int MINIMUM_MINISTRO_LEVEL = 1;

	private static final int MINIMUM_LOADER_LEVEL = 1;

	static Loader1 loader;

	private IMinistroService ministroService;

	private AtomicBoolean startupFinished = new AtomicBoolean(false);

	private boolean useLocalLibs = false;

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			ministroService = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			ministroService = IMinistroService.Stub.asInterface(service);
			if (!startupFinished.get())
				startup();
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (useLocalLibs) {
			// Loader location and classname is known
			startApplication(BUILTIN_LOADER_PATH, BUILTIN_LOADER_CLASSNAME);
		} else {
			bindService(new Intent(IMinistroService.class.getName()),
					connection, Context.BIND_AUTO_CREATE);
		}
	}

	private void startup() {
		try {
			if (!ministroService.checkCompatibility(MINIMUM_MINISTRO_LEVEL)) {
				Log.d(TAG, "Ministro needs to be updated.");
				return;
			}

			ministroService.serve(callback);

		} catch (RemoteException re) {
			Log.e(TAG, "Failed to call method: " + re);
		}
	}

	ICallback1 callback = new ICallback1.Stub() {

		@Override
		public int getRequiredLoaderLevel() throws RemoteException {
			return MINIMUM_LOADER_LEVEL;
		}

		@Override
		public String getApplicationName() throws RemoteException {
			return getResources().getString(R.string.app_name);
		}

		@Override
		public void finished(IResult result) throws RemoteException {
			startupFinished.set(true);

			Log.d(TAG, "success: " + result.isSuccess());
			Log.d(TAG, "loaderPath: " + result.getLoaderPath());
			Log.d(TAG, "loaderClassName: " + result.getLoaderClassName());

			if (result.isSuccess()) {
				startApplication(result.getLoaderPath(),
						result.getLoaderClassName());
			} else {
				Log.e(TAG, "Ministro is not able to start the application");
			}

		}
	};

	void startApplication(String loaderPath, String loaderClassName) {
		loader = createLoaderInstance(loaderPath, loaderClassName);

		if (loader != null) {
			Intent i = new Intent(StarterActivity.this, AppTemplate.class);
			startActivity(i);
		} else {
			Log.e(TAG, "No Loader instance available.");
		}

		// We're done.
		finish();
	}

	/**
	 * Creates an instance of a {@link Loader1} using the given APK file and
	 * class name.
	 * 
	 * <p>
	 * The classname denotes a class that can be instantiated using the default
	 * constructor.
	 * </p>
	 * 
	 * @param path
	 * @param className
	 * @return
	 */
	Loader1 createLoaderInstance(String path, String className) {
		try {
			DexClassLoader cl = new DexClassLoader(path, getFilesDir()
					.getAbsolutePath(), null, getClassLoader());

			@SuppressWarnings("unchecked")
			Class<Loader1> klass = (Class<Loader1>) Class.forName(className,
					false, cl);

			return klass.newInstance();

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Returns the instance of {@link Loader1} that was created during the
	 * startup.
	 * 
	 * <p>
	 * If the instance does not exist a {@link RuntimeException} is thrown.
	 * </p>
	 * 
	 * @return
	 */
	static Loader1 getLoaderInstance() {
		if (loader == null) {
			throw new RuntimeException("Loader is not there!");
		}

		return loader;
	}

}