package com.example.aly24.daggermockespresso;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.inject.Inject;


/**
 * Created by aly24 on 10-Feb-17.
 */

public class MainServiceDaggerTest {
	@Inject RestService restService;

	@Inject MyPrinter myPrinter;

	@Inject MainService mainService;

	@Before
	public void setUp(){
		TestComponent component = DaggerTestComponent.builder()
				.myModule(new TestModule())
				.build();
		component.inject(this);
	}

	@Test
	public void testDoSomething(){
		Mockito.when(restService.getSomething()).thenReturn("abc");
		mainService.doSomeThing();
		Mockito.verify(myPrinter).print("ABC");
	}
}
