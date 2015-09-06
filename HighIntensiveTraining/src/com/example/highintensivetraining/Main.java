package com.example.highintensivetraining;

import android.support.v7.app.ActionBarActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//GridLayout month = (GridLayout) findViewById(R.id.month);
		//month.setOnClickListener((android.view.View.OnClickListener) this);
		//month.setOnClickListener((android.view.View.OnClickListener) this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		/*
		String activities[] = { "day1" };
		
		int id = v.getId();
		for (int i = 0; i < activities.length; i++) {
			if (id == getResources().getIdentifier("day" + i, "id",
					getPackageName())) {
				Toast.makeText(getApplicationContext(), i , 
						Toast.LENGTH_SHORT).show();
			}
		}
		*/
		
		int j = getResources().getIdentifier("day1", "id",
				getPackageName());
		int p = v.getId();
		
		Toast.makeText(getApplicationContext(), ((Integer) p).toString() +
				"und j ist" + ((Integer) j).toString() , 
				Toast.LENGTH_SHORT).show();
		
	}
}
