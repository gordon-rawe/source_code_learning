package com.amazing.amazing.demo;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

import com.amazing.amazing.R;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void bDemo1_click(View v) {
		startActivity(new Intent(this, SectionDemoActivity.class));
	}
	
	public void bDemo2_click(View v) {
		startActivity(new Intent(this, PaginationDemoActivity.class));
	}
}