package com.application.memoryleak;

import android.content.Context;

public class SomeRandomSampleClass {

    private static SomeRandomSampleClass someRandomSampleClass;

    private Context context;

    private SomeRandomSampleClass(Context context) {
        this.context = context;
    }

    public static SomeRandomSampleClass getSomeRandomSampleClass(Context context) {
        if (someRandomSampleClass == null){
            someRandomSampleClass = new SomeRandomSampleClass(context);
        }
        return someRandomSampleClass;
    }
}
