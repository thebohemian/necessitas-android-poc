package eu.licentia.necessitas.poc.ministro;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.EditText;

public class MinistroPoCActivity extends Activity {
	
	private Ministro2 ministroService;
	
	private ServiceConnection connection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			ministroService = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			ministroService = Ministro2.instance();
			EditText log = (EditText) findViewById(R.id.log);
			ministroService.setEditText(log);
		}
	};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bindService(new Intent(IMinistroService.class.getName()), connection, Context.BIND_AUTO_CREATE);
    }
}