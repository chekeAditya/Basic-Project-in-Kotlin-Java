package com.application.memoryleak;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    SomeRandomSampleClass someRandomSampleClass;
    private static WeakReference<MainActivity> activityWeakReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        someRandomSampleClass = SomeRandomSampleClass.getSomeRandomSampleClass(this);
    }
}