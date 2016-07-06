package com.amazing.amazing.demo;

import android.app.Activity;
import android.os.Bundle;

import com.amazing.amazing.R;
import com.amazing.amazing.custom.FootPrintItemView;


public class CustomActivity extends Activity {

    private FootPrintItemView footPrintItemView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        footPrintItemView = (FootPrintItemView) findViewById(R.id.foot_print_view);
        footPrintItemView.configure(R.mipmap.ic_launcher,"我是好人我是好人我是好人我是好人我是好人我是好人","我好人");
    }
}