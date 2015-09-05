package com.example.highintensivetraining;

import android.support.v7.app.ActionBarActivity;

import com.hit.calendarview.HitCalendarView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main extends Activity implements OnDateChangeListener {

	HitCalendarView calendar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		calendar = new HitCalendarView(this);
		
		setContentView(R.layout.main);	
		
		//MyCalendarView y = new MyCalendarView(this);
		//setContentView(y);
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

	@Override
	public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), 
		           "Year: " + year + "\n" +
		           "Month: " + month + "\n" +
		           "Day of Month: " + dayOfMonth, 
		           Toast.LENGTH_SHORT).show();
	}
}
