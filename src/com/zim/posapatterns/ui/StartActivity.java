package com.zim.posapatterns.ui;

import android.app.Activity;
import android.os.Bundle;
import com.zim.posapatterns.R;

public class StartActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}