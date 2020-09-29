package com.example.betatest_1.view;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Notification;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.betatest_1.R;
import com.example.betatest_1.controller.StartActivity;
import com.example.betatest_1.model.loginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class NotificationActivityTest {


    @Rule
    public ActivityTestRule<NotificationActivity> lActivityTestRule = new ActivityTestRule<NotificationActivity>(NotificationActivity.class);

    private NotificationActivity lActivit = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(NotificationActivity.class.getName(),null, false);

    //private loginActivity email = null;

    @Before
    public void setUp() throws Exception {
        lActivit = lActivityTestRule.getActivity();
    }

    @Test
    public void name() {
        View view = lActivit.findViewById(R.id.text_view1);

        Activity startActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        lActivit = null;
    }





}