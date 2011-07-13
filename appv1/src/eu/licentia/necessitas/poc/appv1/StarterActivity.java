package eu.licentia.necessitas.poc.appv1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import dalvik.system.DexClassLoader;
import eu.licentia.necessitas.poc.ministro.ICallback1;
import eu.licentia.necessitas.poc.ministro.IMinistroService;
import eu.licentia.necessitas.poc.ministro.IResult;
import eu.licentia.necessitas.poc.ministro.Loader1;

public class StarterActivity extends Activity {

	private static final String TAG = "Starter";

	private static final int MINIMUM_MINISTRO_LEVEL = 1;

	private static final int MINIMUM_LOADER_LEVEL = 1;

	IMinistroService ministroService;

	static EditText log;
	
	Button startButton;

	static Loader1 loader;

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			ministroService = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			ministroService = IMinistroService.Stub.asInterface(service);
			start();
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		log = (EditText) findViewById(R.id.log);
		startButton = (Button) findViewById(R.id.startButton);
		startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startApplication();
			}
		});
		
		bindService(new Intent(IMinistroService.class.getName()), connection,
				Context.BIND_AUTO_CREATE);
	}

	static void log(String msg) {
		log.append(msg + "\n");
	}

	private void start() {
		log("AppV1 starting ...");
		try {
			if (!ministroService.checkCompatibility(MINIMUM_MINISTRO_LEVEL)) {
				log("Ministro needs to be updated.");
				return;
			}

			log("Ministro version adequate. Letting serve us.");
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
			return "AppV1";
		}

		@Override
		public void finished(IResult result) throws RemoteException {
			log("Ministro finished processing.");
			log("success: " + result.isSuccess());
			log("loaderPath: " + result.getLoaderPath());
			log("loaderClassName: " + result.getLoaderClassName());
			
			loader = createLoaderInstance(result.getLoaderPath(),
					result.getLoaderClassName());
			
			log("loader acquired: " + loader);

			if (loader == null)
			{
				startButton.setText("Close");
			}
			
			startButton.setEnabled(true);
		}
	};
	
	void startApplication() {
		if (loader != null)
		{
			Intent i = new Intent(StarterActivity.this, Appv1Activity.class);
			startActivity(i);
		}
		
		// We're done.
		finish();
	}


	Loader1 createLoaderInstance(String path, String className) {
		try {
			log("filesDir: " + getFilesDir());
			DexClassLoader cl = new DexClassLoader(
					path,
					getFilesDir().getAbsolutePath(),
					null,
					getClassLoader());

			@SuppressWarnings("unchecked")
			Class<Loader1> klass = (Class<Loader1>) Class.forName(className,
					false, cl);

			return klass.newInstance();

		} catch (Exception e) {
			return null;
		}
	}

	static Loader1 getLoaderInstance() {
		if (loader == null) {
			throw new RuntimeException("Loader is not there!");
		}

		return loader;
	}

}