package com.example.betatest_1.controller;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.example.betatest_1.R;
import com.example.betatest_1.model.RegisterActivity;
import com.example.betatest_1.model.loginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class StartActivityTest {

    @Rule
    public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<StartActivity>(StartActivity.class);

    private StartActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(loginActivity.class.getName(),null, false);




    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOnStartActivitytoRegisterActivity() {
        assertNotNull(mActivity.findViewById(R.id.login));

        onView(withId(R.id.login)).perform(click());

        Activity registerActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,100000);

        assertNotNull(registerActivity);

        registerActivity.finish();

    }


    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }




}