package com.hit.calendarview;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class HitCalendarView extends View {

	public HitCalendarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	
		//Creating background Rectangle
		Rect background = new Rect();
		background.set(0, 0, canvas.getHeight(), canvas.getWidth());
		
		//Coloring the Background White
		Paint white = new Paint();
		white.setColor(Color.GRAY);
		white.setStyle(Paint.Style.FILL);
		
		//Painting the Background
		canvas.drawRect(background, white);
	}
}
