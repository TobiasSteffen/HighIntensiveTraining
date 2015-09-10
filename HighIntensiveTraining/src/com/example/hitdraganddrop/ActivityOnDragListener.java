package com.example.hitdraganddrop;

import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;

public class ActivityOnDragListener implements OnTouchListener {

	private DragAndDropInterface activity;
	
    public ActivityOnDragListener(DragAndDropInterface activity){
        this.activity = activity;
    }
    
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		this.onDrag(v, event);
		return true;
	}

	public boolean onDrag(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		activity.onDrag(v, event);
		return true;
	}


}
