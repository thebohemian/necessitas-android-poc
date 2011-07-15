package eu.licentia.necessitas.poc.apptemplate;

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
import eu.licentia.necessitas.poc.loader1.ActivityDelegate4;

/**
 * Activity implementation which calls the superclass implementations
 * of the 'onXXX' methods of a given {@link AppTemplate}.
 * 
 * That way an outside party can call the superclass implementations
 * and that party can do that without needing to access a new API
 * as the normal 'onXXX' methods are used.
 *
 * With this approach a third party can completely implement the
 * behavior of an {@link Activity} implementation without being
 * its subclass.
 */
final class Super implements ActivityDelegate4 {

	AppTemplate delegate;

	public Super(AppTemplate delegate) {
		this.delegate = delegate;
	}

	// 11 void onActionModeFinished(ActionMode mode);

	// 11 void onActionModeStarted(ActionMode mode);

	// 11 void onAttachFragment(Fragment fragment);

	/* API level 5
	@Override
	public void onAttachedToWindow() {
		delegate.onAttachedToWindow();
	}
	*/

	/* API level 5
	@Override
	public void onBackPressed() {
		delegate.onBackPressed();
	}
	*/

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		delegate.superOnConfigurationChanged(newConfig);
	}

	@Override
	public void onContentChanged() {
		delegate.superOnContentChanged();
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		return delegate.superOnContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		delegate.superOnContextMenuClosed(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenu.ContextMenuInfo menuInfo) {
		delegate.superOnCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public CharSequence onCreateDescription() {
		return delegate.superOnCreateDescription();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return delegate.superOnCreateOptionsMenu(menu);
	}

	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		return delegate.superOnCreatePanelMenu(featureId, menu);
	}

	@Override
	public View onCreatePanelView(int featureId) {
		return delegate.superOnCreatePanelView(featureId);
	}

	@Override
	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		return delegate.superOnCreateThumbnail(outBitmap, canvas);
	}

	/* API level 11
	@Override
	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		return delegate.superOnCreateView(parent, name, context, attrs);
	}
	*/

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		return delegate.superOnCreateView(name, context, attrs);
	}

	/* API level 5
	@Override
	public void onDetachedFromWindow() {
		delegate.superOnDetachedFromWindow();
	}
	*/

	/* API level 12
	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		return delegate.superOnGenericMotionEvent(event);
	}
	*/

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return delegate.superOnKeyDown(keyCode, event);
	}

	/* API level 5
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		return delegate.superOnKeyLongPress(keyCode, event);
	}
	*/

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		return delegate.superOnKeyMultiple(keyCode, repeatCount, event);
	}

	/* API level 11
	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		return delegate.superOnKeyShortcut(keyCode, event);
	}
	*/

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		return delegate.superOnKeyUp(keyCode, event);
	}

	@Override
	public void onLowMemory() {
		delegate.superOnLowMemory();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		return delegate.superOnMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		return delegate.superOnMenuOpened(featureId, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return delegate.superOnOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		delegate.superOnOptionsMenuClosed(menu);
	}

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		delegate.superOnPanelClosed(featureId, menu);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return delegate.superOnPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onPreparePanel(int featureId, View view, Menu menu) {
		return delegate.superOnPreparePanel(featureId, view, menu);
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return delegate.superOnRetainNonConfigurationInstance();
	}

	@Override
	public boolean onSearchRequested() {
		return delegate.superOnSearchRequested();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return delegate.superOnTouchEvent(event);
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		return delegate.superOnTrackballEvent(event);
	}

	@Override
	public void onUserInteraction() {
		delegate.superOnUserInteraction();
	}

	@Override
	public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
		delegate.superOnWindowAttributesChanged(params);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		delegate.superOnWindowFocusChanged(hasFocus);
	}

	// 11 ActionMode onWindowStartingActionMode(ActionMode.Callback callback);

	// Protected onXXX methods - cracked open using the 'public' keyword

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		delegate.superOnActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onApplyThemeResource(Resources.Theme theme, int resid,
			boolean first) {
		delegate.superOnApplyThemeResource(theme, resid, first);
	}

	@Override
	public void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		delegate.superOnChildTitleChanged(childActivity, title);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		delegate.superOnCreate(savedInstanceState);
	}

	@Override
	public Dialog onCreateDialog(int id) {
		return delegate.superOnCreateDialog(id);
	}

	/* API level 8
	@Override
	public Dialog onCreateDialog(int id, Bundle args) {
		return delegate.superOnCreateDialog(id, args);
	}
	*/

	@Override
	public void onDestroy() {
		delegate.superOnDestroy();
	}

	@Override
	public void onNewIntent(Intent intent) {
		delegate.superOnNewIntent(intent);
	}

	@Override
	public void onPause() {
		delegate.superOnPause();
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		delegate.superOnPostCreate(savedInstanceState);
	}

	@Override
	public void onPostResume() {
		delegate.superOnPostResume();
	}

	@Override
	public void onPrepareDialog(int id, Dialog dialog) {
		delegate.superOnPrepareDialog(id, dialog);
	}

	/* API level 8
	@Override
	public void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		delegate.superOnPrepareDialog(id, dialog, args);
	}
	*/

	@Override
	public void onRestart() {
		delegate.superOnRestart();
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		delegate.superOnRestoreInstanceState(savedInstanceState);
	}

	@Override
	public void onResume() {
		delegate.superOnResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		delegate.superOnSaveInstanceState(outState);
	}

	@Override
	public void onStart() {
		delegate.superOnStart();
	}

	@Override
	public void onStop() {
		delegate.superOnStop();
	}

	@Override
	public void onTitleChanged(CharSequence title, int color) {
		delegate.superOnTitleChanged(title, color);
	}

	@Override
	public void onUserLeaveHint() {
		delegate.superOnUserLeaveHint();
	}

}