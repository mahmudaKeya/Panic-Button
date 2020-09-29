package com.example.betatest_1.model;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class RegisterActivityTest {

    @Mock
    Context mMockContext;

    private static final String FAKE_STRING = "empty credentials";

    private static final String lengthCheck = "password okay";

    RegisterActivity myObjectUnderTest = new RegisterActivity(mMockContext);

    @Test
    public void checkRegisterEmailNull() {
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