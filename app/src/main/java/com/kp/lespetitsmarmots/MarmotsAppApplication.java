package com.kp.lespetitsmarmots;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by kevin on 2016-01-18.
 */
public class MarmotsAppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "pQVy1gXC9eMKzjlIJhcAzJjcwi7Gy1UXUcNujNXs", "xQh91QgoGVc4QUuBVshZgycwzfCF8WdAw6ecuKmC");
    }
}
