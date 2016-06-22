package com.amazing.amazing.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amazing.amazing.R;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bDemo1_click(View v) {
        startActivity(new Intent(this, SectionRecyclerActivity.class));
    }

    public void bDemo2_click(View v) {
        startActivity(new Intent(this, CustomActivity.class));
    }
}