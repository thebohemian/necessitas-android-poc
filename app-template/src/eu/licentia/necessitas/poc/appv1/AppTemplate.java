package eu.licentia.necessitas.poc.appv1;

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
import eu.licentia.necessitas.poc.ministro.ActivityDelegate4;
import eu.licentia.necessitas.poc.ministro.Loader1;

public class AppTemplate extends Activity {

	Loader1 loader;
	ActivityDelegate4 delegate;

	public AppTemplate() {
		loader = StarterActivity.getLoaderInstance();
		
		delegate = loader.createActivityDelegate4(this, new Super(this), R.layout.main);
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
		delegate.onConfigurationChanged(newConfig);
	}

	@Override
	public void onContentChanged() {
		delegate.onContentChanged();
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		return delegate.onContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		delegate.onContextMenuClosed(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenu.ContextMenuInfo menuInfo) {
		delegate.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public CharSequence onCreateDescription() {
		return delegate.onCreateDescription();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return delegate.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		return delegate.onCreatePanelMenu(featureId, menu);
	}

	@Override
	public View onCreatePanelView(int featureId) {
		return delegate.onCreatePanelView(featureId);
	}

	@Override
	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		return delegate.onCreateThumbnail(outBitmap, canvas);
	}

	/* API level 11
	@Override
	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		return delegate.onCreateView(parent, name, context, attrs);
	}
	*/

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		return delegate.onCreateView(name, context, attrs);
	}

	/* API level 5
	@Override
	public void onDetachedFromWindow() {
		delegate.onDetachedFromWindow();
	}
	*/

	/* API level 12
	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		return delegate.onGenericMotionEvent(event);
	}
	*/

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return delegate.onKeyDown(keyCode, event);
	}

	/* API level 5
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		return delegate.onKeyLongPress(keyCode, event);
	}
	*/

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		return delegate.onKeyMultiple(keyCode, repeatCount, event);
	}

	/* API level 11
	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		return delegate.onKeyShortcut(keyCode, event);
	}
	*/

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		return delegate.onKeyUp(keyCode, event);
	}

	@Override
	public void onLowMemory() {
		delegate.onLowMemory();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		return delegate.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		return delegate.onMenuOpened(featureId, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return delegate.onOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		delegate.onOptionsMenuClosed(menu);
	}

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		delegate.onPanelClosed(featureId, menu);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return delegate.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onPreparePanel(int featureId, View view, Menu menu) {
		return delegate.onPreparePanel(featureId, view, menu);
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return delegate.onRetainNonConfigurationInstance();
	}

	@Override
	public boolean onSearchRequested() {
		return delegate.onSearchRequested();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return delegate.onTouchEvent(event);
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		return delegate.onTrackballEvent(event);
	}

	@Override
	public void onUserInteraction() {
		delegate.onUserInteraction();
	}

	@Override
	public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
		delegate.onWindowAttributesChanged(params);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		delegate.onWindowFocusChanged(hasFocus);
	}

	// 11 ActionMode onWindowStartingActionMode(ActionMode.Callback callback);

	// Protected onXXX methods

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		delegate.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onApplyThemeResource(Resources.Theme theme, int resid,
			boolean first) {
		delegate.onApplyThemeResource(theme, resid, first);
	}

	@Override
	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		delegate.onChildTitleChanged(childActivity, title);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		delegate.onCreate(savedInstanceState);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		return delegate.onCreateDialog(id);
	}

	/* API level 8
	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		return delegate.onCreateDialog(id, args);
	}
	*/

	@Override
	protected void onDestroy() {
		delegate.onDestroy();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		delegate.onNewIntent(intent);
	}

	@Override
	protected void onPause() {
		delegate.onPause();
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		delegate.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onPostResume() {
		delegate.onPostResume();
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		delegate.onPrepareDialog(id, dialog);
	}

	/* API level 8
	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		delegate.onPrepareDialog(id, dialog, args);
	}
	*/

	@Override
	protected void onRestart() {
		delegate.onRestart();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		delegate.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onResume() {
		delegate.onResume();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		delegate.onSaveInstanceState(outState);
	}

	@Override
	protected void onStart() {
		delegate.onStart();
	}

	@Override
	protected void onStop() {
		delegate.onStop();
	}

	@Override
	protected void onTitleChanged(CharSequence title, int color) {
		delegate.onTitleChanged(title, color);
	}

	@Override
	protected void onUserLeaveHint() {
		delegate.onUserLeaveHint();
	}

	/* When on overrides a method its superclass implementation is hidden forever.
	 * By adding new methods that only call the superclass implementation we make this
	 * API available again.
	 * 
	 * The superclass implementations are needed to allow the ActivityDelegate a
	 * proper implementation of them.
	 */
	
	/* API level 11
	void superOnActionModeFinished(ActionMode mode) {
		super.onActionModeFinished(mode);
	}
	 */

	// 11 void onActionModeStarted(ActionMode mode);
	/* API level 11
	void superOnActionModeStarted(ActionMode mode) [
		super.onActionModeStarted(mode);
	}
	 */

	// 11 void onAttachFragment(Fragment fragment);
	/* API level 11
	void superOnAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
	}
	 */

	/* API level 5
	void superOnAttachedToWindow() {
		super.onAttachedToWindow();
	}
	*/

	/* API level 5
	public void superOnBackPressed() {
		super.onBackPressed();
	}
	*/

	void superOnConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	void superOnContentChanged() {
		super.onContentChanged();
	}

	boolean superOnContextItemSelected(MenuItem item) {
		return super.onContextItemSelected(item);
	}

	void superOnContextMenuClosed(Menu menu) {
		super.onContextMenuClosed(menu);
	}

	void superOnCreateContextMenu(ContextMenu menu, View v,
			ContextMenu.ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	CharSequence superOnCreateDescription() {
		return super.onCreateDescription();
	}

	boolean superOnCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	boolean superOnCreatePanelMenu(int featureId, Menu menu) {
		return super.onCreatePanelMenu(featureId, menu);
	}

	View superOnCreatePanelView(int featureId) {
		return super.onCreatePanelView(featureId);
	}

	boolean superOnCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		return super.onCreateThumbnail(outBitmap, canvas);
	}

	/* API level 11
	View superOnCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		return super.onCreateView(parent, name, context, attrs);
	}
	*/

	View superOnCreateView(String name, Context context, AttributeSet attrs) {
		return super.onCreateView(name, context, attrs);
	}

	/* API level 5
	void superOnDetachedFromWindow() {
		super.onDetachedFromWindow();
	}
	*/

	/* API level 12
	boolean superOnGenericMotionEvent(MotionEvent event) {
		return super.onGenericMotionEvent(event);
	}
	*/

	boolean superOnKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}

	/* API level 5
	boolean superOnKeyLongPress(int keyCode, KeyEvent event) {
		return super.onKeyLongPress(keyCode, event);
	}
	*/

	boolean superOnKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	/* API level 11
	boolean superOnKeyShortcut(int keyCode, KeyEvent event) {
		return super.onKeyShortcut(keyCode, event);
	}
	*/

	boolean superOnKeyUp(int keyCode, KeyEvent event) {
		return super.onKeyUp(keyCode, event);
	}

	void superOnLowMemory() {
		super.onLowMemory();
	}

	boolean superOnMenuItemSelected(int featureId, MenuItem item) {
		return super.onMenuItemSelected(featureId, item);
	}

	boolean superOnMenuOpened(int featureId, Menu menu) {
		return super.onMenuOpened(featureId, menu);
	}

	boolean superOnOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

	void superOnOptionsMenuClosed(Menu menu) {
		super.onOptionsMenuClosed(menu);
	}

	void superOnPanelClosed(int featureId, Menu menu) {
		super.onPanelClosed(featureId, menu);
	}

	boolean superOnPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	boolean superOnPreparePanel(int featureId, View view, Menu menu) {
		return super.onPreparePanel(featureId, view, menu);
	}

	Object superOnRetainNonConfigurationInstance() {
		return super.onRetainNonConfigurationInstance();
	}

	boolean superOnSearchRequested() {
		return super.onSearchRequested();
	}

	boolean superOnTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
	}

	boolean superOnTrackballEvent(MotionEvent event) {
		return super.onTrackballEvent(event);
	}

	void superOnUserInteraction() {
		super.onUserInteraction();
	}

	void superOnWindowAttributesChanged(WindowManager.LayoutParams params) {
		super.onWindowAttributesChanged(params);
	}

	void superOnWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
	}

	// 11 ActionMode onWindowStartingActionMode(ActionMode.Callback callback);

	// Protected onXXX methods

	void superOnActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	void superOnApplyThemeResource(Resources.Theme theme, int resid,
			boolean first) {
		super.onApplyThemeResource(theme, resid, first);
	}

	void superOnChildTitleChanged(Activity childActivity,
			CharSequence title) {
		super.onChildTitleChanged(childActivity, title);
	}

	void superOnCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	Dialog superOnCreateDialog(int id) {
		return super.onCreateDialog(id);
	}

	/* API level 8
	Dialog superOnCreateDialog(int id, Bundle args) {
		return super.onCreateDialog(id, args);
	}
	*/

	void superOnDestroy() {
		super.onDestroy();
	}

	void superOnNewIntent(Intent intent) {
		super.onNewIntent(intent);
	}

	void superOnPause() {
		super.onPause();
	}

	void superOnPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	void superOnPostResume() {
		super.onPostResume();
	}

	void superOnPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
	}

	/* API level 8
	void superOnPrepareDialog(int id, Dialog dialog, Bundle args) {
		super.onPrepareDialog(id, dialog, args);
	}
	*/

	void superOnRestart() {
		super.onRestart();
	}

	void superOnRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	void superOnResume() {
		super.onResume();
	}

	void superOnSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	void superOnStart() {
		super.onStart();
	}

	void superOnStop() {
		super.onStop();
	}

	void superOnTitleChanged(CharSequence title, int color) {
		super.onTitleChanged(title, color);
	}

	void superOnUserLeaveHint() {
		super.onUserLeaveHint();
	}

}