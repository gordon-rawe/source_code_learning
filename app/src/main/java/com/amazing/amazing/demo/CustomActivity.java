package com.amazing.amazing.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.amazing.amazing.R;
import com.amazing.amazing.custom.FootPrintItemView;
import com.amazing.amazing.pinnable.PinnableRecyclerAdapter;
import com.amazing.amazing.pinnable.PinnableRecyclerView;

import java.util.List;


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