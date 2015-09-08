package com.example.highintensivetraining;

import android.support.v7.app.ActionBarActivity;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

	Calendar cal = Calendar.getInstance(Locale.GERMANY);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Setting the Month on top
		TextView tvmonth = (TextView) findViewById(R.id.tvmonth);
		tvmonth.setText(cal.getDisplayName(Calendar.MONTH, 
				Calendar.LONG, Locale.GERMANY));
		
		//get the first day number of the Month
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String dayName = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.GERMANY);
		int dayOfWeek = dayOfWeek(dayName);

		
		GridLayout glmonth = (GridLayout) findViewById(R.id.glmonth);

		LayoutInflater inflater = LayoutInflater.from(getBaseContext());
		
		FrameLayout empty_day = (FrameLayout) inflater.inflate(R.layout.empty_day, glmonth, false);
		FrameLayout style_day = (FrameLayout) inflater.inflate(R.layout.style_day, glmonth, false);
		
		//Setting up empty_days
		for (int i=0; i<dayOfWeek; i++) {
			glmonth.addView(empty_day);
			empty_day = (FrameLayout) inflater.inflate(R.layout.empty_day, glmonth, false);	
		}
		
		//Setting up style_day
		int daysOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i=0; i < daysOfMonth; i++){
			glmonth.addView(style_day);
			style_day = (FrameLayout) inflater.inflate(R.layout.style_day, glmonth, false);	
		}
		
		//Setting up Day text Numbers and tags
		for (int i = dayOfWeek; i <= daysOfMonth; i++) {
			((TextView) (((GridLayout) (((GridLayout) (((FrameLayout) glmonth.getChildAt(i)).getChildAt(0)))
					.getChildAt(0))).getChildAt(2))).setText(((Integer) (i)).toString());
			((GridLayout) (((FrameLayout) glmonth.getChildAt(i)).getChildAt(0)))
				.setTag("day" + i);
		}
		
		/*
		glmonth.addView(style_day);
		
		style_day = (FrameLayout) inflater.inflate(R.layout.style_day, glmonth, false);
		glmonth.addView(style_day);
		
		
		for (int i = 0;i!=10;i+=1) {
			style_day = (FrameLayout) inflater.inflate(R.layout.style_day, null, false);
			glmonth.addView(style_day);
		}
		*/
		
		//layout.setLayoutParams(new LayoutParams());
		
		//geht nicht
		//GridLayout test = (GridLayout) findViewById(R.id.day1);
		
		//GridLayout.LayoutParams labelLayoutParams = new GridLayout.LayoutParams();
		//labelLayoutParams.height = test.getHeight();
		//labelLayoutParams.width = test.getWidth();
		//layout.setLayoutParams(labelLayoutParams);
		
		//glmonth.addView(R.layout.style_day);
		
		//String str = 
		Toast.makeText(getApplicationContext(), ((Integer) dayOfWeek).toString() , 
				Toast.LENGTH_SHORT).show();
		
		//GridLayout glmonth = (GridLayout) findViewById(n);

		//month.setOnClickListener((android.view.View.OnClickListener) this);
		//month.setOnClickListener((android.view.View.OnClickListener) this);
	}
	
	private int dayOfWeek(String s) {
		Hashtable<String, Integer> days
			= new Hashtable<String, Integer>();
		days.put("Montag", 0);
		days.put("Dienstag", 1);
		days.put("Mitwoch", 2);
		days.put("Donnerstag", 3);
		days.put("Freitag", 4);
		days.put("Samstag", 5);
		days.put("Sonntag", 6);
			   		
		return days.get(s);
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
	
		//Iterate threw all Days and find out which button was clicked
		int i = 1;
		int j = getResources().getIdentifier("day" + i, "id",
				getPackageName());
		int p = v.getId();
		
		int n = v.getId();
	
		String s = "";
		//String t = ((TextView) ((GridLayout) glmonth.getChildAt(1)).
		//		getChildAt(3)).getText().toString();
		
		Toast.makeText(getApplicationContext(), ((String) v.getTag()).toString() , 
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	on
}
