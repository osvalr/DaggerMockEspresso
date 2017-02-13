package com.example.aly24.daggermockespresso;

import org.mockito.Mockito;

/**
 * Created by aly24 on 10-Feb-17.
 */

public class TestModule extends MyModule {
	@Override
	public RestService provideRestService() {
		return Mockito.mock(RestService.class);
	}

	@Override
	public MyPrinter provideMyPrinter() {
		return Mockito.mock(MyPrinter.class);
	}
}
