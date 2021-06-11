package com.example.inter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	SurfaceJeux maSurface;
	TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		maSurface = new SurfaceJeux(this);
		setContentView(maSurface);
		text = new TextView(this);
		text.setText("bonjours");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		maSurface.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		maSurface.resume();
	}
}
