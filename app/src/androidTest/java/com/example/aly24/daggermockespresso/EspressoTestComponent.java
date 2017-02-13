package com.example.aly24.daggermockespresso;

import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by aly24 on 10-Feb-17.
 */
@Singleton
@Component(modules = MyModule.class)
public interface EspressoTestComponent extends MyComponent{
	void inject(MainActivityTest test);
}
