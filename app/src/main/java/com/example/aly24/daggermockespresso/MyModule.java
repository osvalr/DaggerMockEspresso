package com.example.aly24.daggermockespresso;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by aly24 on 10-Feb-17.
 */
@Module
public class MyModule {
	public MyModule(){
	}

	@Provides
	@Singleton
	public RestService provideRestService(){
		return new RestService();
	}

	@Provides
	@Singleton
	public MyPrinter provideMyPrinter(){
		return new MyPrinter();
	}
}
