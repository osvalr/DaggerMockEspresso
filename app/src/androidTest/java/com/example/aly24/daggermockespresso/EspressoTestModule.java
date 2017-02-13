package com.example.aly24.daggermockespresso;

import org.mockito.Mockito;

/**
 * Created by aly24 on 10-Feb-17.
 */

public class EspressoTestModule extends MyModule {
	@Override
	public RestService provideRestService() {
		System.out.println("create mock service");
 		return Mockito.mock(RestService.class);
	}

	@Override
	public MyPrinter provideMyPrinter() {
		System.out.println("create mock printer");
		return Mockito.mock(MyPrinter.class);
	}
}
