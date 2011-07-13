package eu.licentia.necessitas.ministro.loader1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import eu.licentia.necessitas.poc.ministro.ActivityDelegate4;

class Activity4 implements ActivityDelegate4 {
	
	private Activity that;
	private ActivityDelegate4 superThat;
	private int layoutId;

	Activity4(Activity activity, ActivityDelegate4 superActivity, int layoutId) {
		that = activity;
		superThat = superActivity;
		this.layoutId = layoutId; 
	}

	/*
	@Override
	public void onAttachedToWindow() {
	}
	*/

	/*
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
	}
	*/

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CharSequence onCreateDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View onCreatePanelView(int featureId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	@Override
	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	@Override
	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		
	}
	*/

	/*
	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	*/

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	*/

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	*/

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onPreparePanel(int featureId, View view, Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onUserInteraction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWindowAttributesChanged(LayoutParams params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onApplyThemeResource(Theme theme, int resid, boolean first) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChildTitleChanged(Activity childActivity, CharSequence title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		superThat.onCreate(savedInstanceState);
		
		that.setContentView(layoutId);
	}

	@Override
	public Dialog onCreateDialog(int id) {
		return null;
	}

	/*
	@Override
	public Dialog onCreateDialog(int id, Bundle args) {
		return onCreateDialog(id);
	}
	*/

	@Override
	public void onDestroy() {
		superThat.onDestroy();
	}

	@Override
	public void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		superThat.onPostCreate(savedInstanceState);
		
	}

	@Override
	public void onPostResume() {
		superThat.onPostResume();
		
	}

	@Override
	public void onPrepareDialog(int id, Dialog dialog) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	public void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		// TODO Auto-generated method stub
		
	}
	*/

	@Override
	public void onRestart() {
		superThat.onRestart();
		
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onResume() {
		superThat.onResume();
		
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart() {
		superThat.onStart();
		
	}

	@Override
	public void onStop() {
		superThat.onStop();
		
	}

	@Override
	public void onTitleChanged(CharSequence title, int color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserLeaveHint() {
		// TODO Auto-generated method stub
		
	}

}
