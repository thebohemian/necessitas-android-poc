package eu.licentia.necessitas.poc.ministro;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public interface ActivityDelegate4 {

	// public onXXX methods

	// 11 void onActionModeFinished(ActionMode mode);

	// 11 void onActionModeStarted(ActionMode mode);

	// 11 void onAttachFragment(Fragment fragment);

	// 11 void onAttachedToWindow();

	// void onBackPressed();

	void onConfigurationChanged(Configuration newConfig);

	void onContentChanged();

	boolean onContextItemSelected(MenuItem item);

	void onContextMenuClosed(Menu menu);

	void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenu.ContextMenuInfo menuInfo);

	CharSequence onCreateDescription();

	boolean onCreateOptionsMenu(Menu menu);

	boolean onCreatePanelMenu(int featureId, Menu menu);

	View onCreatePanelView(int featureId);

	boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas);

	// 11 View onCreateView(View parent, String name, Context context, AttributeSet attrs);

	View onCreateView(String name, Context context, AttributeSet attrs);

	// 5 void onDetachedFromWindow();

	// 11 boolean onGenericMotionEvent(MotionEvent event);

	boolean onKeyDown(int keyCode, KeyEvent event);

	// 5 boolean onKeyLongPress(int keyCode, KeyEvent event);

	boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event);

	// 5 boolean onKeyShortcut(int keyCode, KeyEvent event);

	boolean onKeyUp(int keyCode, KeyEvent event);

	void onLowMemory();

	boolean onMenuItemSelected(int featureId, MenuItem item);

	boolean onMenuOpened(int featureId, Menu menu);

	boolean onOptionsItemSelected(MenuItem item);

	void onOptionsMenuClosed(Menu menu);

	void onPanelClosed(int featureId, Menu menu);

	boolean onPrepareOptionsMenu(Menu menu);

	boolean onPreparePanel(int featureId, View view, Menu menu);

	Object onRetainNonConfigurationInstance();

	boolean onSearchRequested();

	boolean onTouchEvent(MotionEvent event);

	boolean onTrackballEvent(MotionEvent event);

	void onUserInteraction();

	void onWindowAttributesChanged(WindowManager.LayoutParams params);

	void onWindowFocusChanged(boolean hasFocus);

	// 11 ActionMode onWindowStartingActionMode(ActionMode.Callback callback);

	// Protected onXXX methods

	void onActivityResult(int requestCode, int resultCode, Intent data);

	void onApplyThemeResource(Resources.Theme theme, int resid, boolean first);

	void onChildTitleChanged(Activity childActivity, CharSequence title);

	void onCreate(Bundle savedInstanceState);

	Dialog onCreateDialog(int id);

	// 5 Dialog onCreateDialog(int id, Bundle args);

	void onDestroy();

	void onNewIntent(Intent intent);

	void onPause();

	void onPostCreate(Bundle savedInstanceState);

	void onPostResume();

	void onPrepareDialog(int id, Dialog dialog);

	// 5 void onPrepareDialog(int id, Dialog dialog, Bundle args);

	void onRestart();

	void onRestoreInstanceState(Bundle savedInstanceState);

	void onResume();

	void onSaveInstanceState(Bundle outState);

	void onStart();

	void onStop();

	void onTitleChanged(CharSequence title, int color);

	void onUserLeaveHint();
}
