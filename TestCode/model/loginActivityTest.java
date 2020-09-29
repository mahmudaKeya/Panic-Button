package com.example.betatest_1.model;

import android.content.Context;

import com.example.betatest_1.R;
import android.view.View;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class loginActivityTest {

    @Mock
    Context mMockContext;

    private static final String FAKE_STRING = "empty credentials";

    private static final String lengthCheck = "password okay";

    loginActivity myObjectUnderTest = new loginActivity(mMockContext);

    @Test
    public void loginUserTest() {


        String email = "";
        String password= "";

        String result = myObjectUnderTest.validate(email,password);

        // ...then the result should be the expected one.
        assertThat(result, is(FAKE_STRING));


    }

    @Test
    public void passwordLenght() {

        String result = myObjectUnderTest.length("123456");

        assertThat(result, is(lengthCheck));

    }


}