package com.example.aly24.daggermockespresso;

import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by aly24 on 10-Feb-17.
 */

public class DaggerApplication extends Application{
	MyComponent myComponent;

	@Override
	public void onCreate(){
		myComponent = DaggerMyComponent.builder().build();
	}

	public void setComponent(MyComponent component){
		myComponent = component;
	}

	public MyComponent getMyComponent(){
		Log.d("Application", "getMyComponent: ");
		return myComponent;
	}
}
