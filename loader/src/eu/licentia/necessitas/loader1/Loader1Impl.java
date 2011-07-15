package eu.licentia.necessitas.loader1;

import android.app.Activity;
import eu.licentia.necessitas.poc.loader1.ActivityDelegate4;
import eu.licentia.necessitas.poc.loader1.Loader1;

public class Loader1Impl implements Loader1 {
	
	public Loader1Impl() {
		// must exist. This class is instantiated from outside.
	}

	@Override
	public ActivityDelegate4 createActivityDelegate4(Activity activity,
			ActivityDelegate4 superActivity, int layoutId) {
		return new Activity4(activity, superActivity, layoutId);
	}

}
