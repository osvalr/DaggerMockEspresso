package com.example.aly24.daggermockespresso;

import javax.inject.Inject;

/**
 * Created by aly24 on 10-Feb-17.
 */

public class MainService {
	private RestService restService;
	private MyPrinter printer;

	@Inject
	public MainService(RestService restService, MyPrinter printer){
		this.restService = restService;
		this.printer = printer;
	}

	public void doSomeThing(){
		String s = restService.getSomething();
		printer.print(s.toUpperCase());
	}
}
