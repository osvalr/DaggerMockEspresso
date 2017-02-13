package com.example.aly24.daggermockespresso;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by aly24 on 10-Feb-17.
 */

public class MainServiceTest {
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock RestService restService;

	@Mock MyPrinter myPrinter;

	@InjectMocks MainService mainService;

	@Test
	public void testDoSomething(){
		when(restService.getSomething()).thenReturn("abc");
		mainService.doSomeThing();
		verify(myPrinter).print("ABC");
	}
}
