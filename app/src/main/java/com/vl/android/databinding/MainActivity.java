package com.vl.android.databinding;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                                .replace(R.id.fragment, new MainFragment())
                                .commit();
        }
    }
}
