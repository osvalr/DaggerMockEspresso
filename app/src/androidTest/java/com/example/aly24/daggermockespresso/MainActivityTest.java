package com.example.aly24.daggermockespresso;


import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

	@Rule
	public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class, false, false);

	@Inject RestService restService;
	@Inject MyPrinter  myPrinter;

	@Before
	public void setUp() throws Exception{
		EspressoTestComponent component = DaggerEspressoTestComponent.builder()
				.myModule(new EspressoTestModule())
				.build();
		getApp().setComponent(component);
		component.inject(this);
	}

	private DaggerApplication getApp() {
		return (DaggerApplication) InstrumentationRegistry.getInstrumentation()
				.getTargetContext().getApplicationContext();
	}

	@Test
	public void mainActivityTest() {
		mActivityTestRule.launchActivity(null);
		when(restService.getSomething()).thenReturn("abc");

		ViewInteraction floatingActionButton = onView(allOf(withId(R.id.fab), isDisplayed()));
		floatingActionButton.perform(click());
		verify(restService).getSomething();
		verify(myPrinter).print("ABC");

		openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

		ViewInteraction appCompatTextView = onView(allOf(withId(R.id.title), withText("Settings"), isDisplayed()));
		appCompatTextView.perform(click());

		reset(restService);
		reset(myPrinter);
		when(restService.getSomething()).thenReturn("lol");
		ViewInteraction floatingActionButton2 = onView(allOf(withId(R.id.fab), isDisplayed()));
		floatingActionButton2.perform(click());
		verify(restService).getSomething();
		verify(myPrinter).print("LOL");

	}

}
