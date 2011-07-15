package eu.licentia.necessitas.poc.loader1;

import android.app.Activity;

public interface Loader1 {
	
	/**
	 * Creates a new {@ActivityDelegate4} using the given {@link Activity} instance
	 * that the delegate can access and another instance which allows the delegate
	 * to call the superclass implementation of the 'onXXX' methods of the first
	 * argument.
	 * 
	 * @param activity
	 * @param superActivity
	 */
	ActivityDelegate4 createActivityDelegate4(Activity activity, ActivityDelegate4 superActivity, int layoutId);

}
