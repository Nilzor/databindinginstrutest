package com.example.databindinstrutest;

import android.test.ActivityInstrumentationTestCase2;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void testMainActivity() {
        getActivity();
        try {Thread.sleep(5000);}catch(Exception ex){}
    }
}
