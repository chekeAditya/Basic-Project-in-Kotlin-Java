package com.application.memoryleak;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MyCustomApplication extends Application {

    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        MyCustomApplication application = (MyCustomApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //variable in application are accessible application wide
        //Best place to have any app wide Global instance variables
        // One time initialization can be carried out here
        //before going to the production stage remove all the stuff
        refWatcher = LeakCanary.install(this);
    }
}
