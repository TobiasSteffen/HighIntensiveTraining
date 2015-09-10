package com.example.highintensivetraining;

import android.support.v7.app.ActionBarActivity;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Locale;

import com.example.hitdraganddrop.ActivityOnDragListener;
import com.example.hitdraganddrop.ActivityOnDropListener;
import com.example.hitdraganddrop.DragAndDropInterface;
import com.example.hitswipe.ActivitySwipeDetector;
import com.example.hitswipe.SwipeInterface;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity implements SwipeInterface, DragAndDropInterface {

	private Calendar cal = Calendar.getInstance(Locale.GERMANY);
	private GridLayout glmonth;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		glmonth = (GridLayout) findViewById(R.id.glmonth);
		setupView();

		LinearLayout lltraining = (LinearLayout) findViewById(R.id.lltraining);
		GridLayout trainingday = ((GridLayout) (((FrameLayout) lltraining.getChildAt(0)).getChildAt(0)));
		
		ActivityOnDragListener drag = new ActivityOnDragListener(this);
		trainingday.setOnTouchListener(drag);
		
	}

	private void setupView() {
		// TODO Auto-generated method stub

		LayoutInflater inflater = LayoutInflater.from(getBaseContext());
		FrameLayout empty_day = (FrameLayout) inflater.inflate(R.layout.empty_day, glmonth, false);
		FrameLayout style_day = (FrameLayout) inflater.inflate(R.layout.style_day, glmonth, false);
		ActivitySwipeDetector swipe = new ActivitySwipeDetector(this);
		ActivityOnDropListener drop = new ActivityOnDropListener(this);
		
		// setting the Month on top
		TextView tvmonth = (TextView) findViewById(R.id.tvmonth);
		tvmonth.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.GERMANY));

		// get the first day number of the Month
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String dayName = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.GERMANY);
		int dayOfWeek = dayOfWeek(dayName);

		// AddView empty_days
		for (int i = 0; i < dayOfWeek; i++) {
			glmonth.addView(empty_day);
			empty_day = (FrameLayout) inflater.inflate(R.layout.empty_day, glmonth, false);
		}

		// AddView style_day
		int daysOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 0; i < daysOfMonth; i++) {
			glmonth.addView(style_day);
			style_day = (FrameLayout) inflater.inflate(R.layout.style_day, glmonth, false);
		}
		
		// Set android:text, android:setTag and OnTouchListener
		glmonth.setOnTouchListener(swipe);
		glmonth.setOnDragListener(drop);
		for (int i = 1; i <= daysOfMonth; i++) {
			GridLayout day = ((GridLayout) (((FrameLayout) glmonth.getChildAt(i + dayOfWeek - 1)).getChildAt(0)));
			((TextView) (((GridLayout) (day).getChildAt(0))).getChildAt(2)).setText(((Integer) (i)).toString());
			day.setTag("day" + i);
			day.setOnTouchListener(swipe);
			day.setOnDragListener(drop);
		}
	}

	private int dayOfWeek(String s) {
		Hashtable<String, Integer> days = new Hashtable<String, Integer>();
		days.put("Montag", 0);
		days.put("Dienstag", 1);
		days.put("Mittwoch", 2);
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
		// Toast.makeText(getApplicationContext(), ((String)
		// v.getTag()).toString() ,
		// Toast.LENGTH_SHORT).show();
	}

	@Override
	public void bottom2top(View v) {

	}
	public void top2bottom(View v) {
		
	}
	
	@Override
	public void left2right(View v) {
		// TODO Auto-generated method stub
		// Toast.makeText(getApplicationContext(), ((String) v.getTag()) ,
		// Toast.LENGTH_SHORT).show();
		// startActivity(new Intent("android.intent.action.MAIN"));
		glmonth.removeAllViews();
		cal.add(Calendar.MONTH, -1);
		setupView();
	}

	@Override
	public void right2left(View v) {
		// TODO Auto-generated method stub
		glmonth.removeAllViews();
		cal.add(Calendar.MONTH, 1);
		setupView();
	}

	@Override
	public boolean onDrag(View v, MotionEvent motionevent) {
		// TODO Auto-generated method stub
		if (motionevent.getAction() == MotionEvent.ACTION_DOWN) {
		      ClipData data = ClipData.newPlainText("", "");
		      DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
		      v.startDrag(data, shadowBuilder, v, 0);
		      return true;
		}
		return false;
	}
	
	@Override
	public void onDrop(View v, DragEvent event) {
		// TODO Auto-generated method stub
		
		v.setBackgroundColor(getResources().getColor(R.color.Red));
		
		/*
		View view = (View) event.getLocalState();
		ViewGroup owner = (ViewGroup) view.getParent();
		owner.removeView(view);
		LinearLayout container = (LinearLayout) v;
		container.addView(view);
		view.setVisibility(View.VISIBLE);
		*/
		
	}

	@Override
	public void onDropExit(View v, DragEvent dragevent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDropEntered(View v, DragEvent dragevent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDropEnded(View v, DragEvent dragevent) {
		// TODO Auto-generated method stub

	}
}
