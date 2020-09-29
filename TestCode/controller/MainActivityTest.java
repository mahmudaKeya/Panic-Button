package com.example.betatest_1.controller;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.example.betatest_1.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(StartActivity.class.getName(),null, false);
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOnLogoutbtn() {
        assertNotNull(mActivity.findViewById(R.id.logout));

        onView(withId(R.id.logout)).perform(click());

        Activity startActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,0);

        assertNotNull(startActivity);

        startActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}