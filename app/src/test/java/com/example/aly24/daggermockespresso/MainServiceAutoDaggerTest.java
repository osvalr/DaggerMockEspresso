package com.example.aly24.daggermockespresso;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by aly24 on 10-Feb-17.
 */

public class MainServiceAutoDaggerTest {
//	@Rule
//	public DaggerMockRule<MyComponent> mockitoRule = new DaggerMockRule<>(MyComponent.class, new MyModule())
//			.set(component -> mainService = component.mainService());

	@Mock RestService restService;

	@Mock MyPrinter myPrinter;

	MainService mainService;

	@Test
	public void testDoSomething(){
		when(restService.getSomething()).thenReturn("abc");
		mainService.doSomeThing();
		verify(myPrinter).print("ABC");
	}
}
