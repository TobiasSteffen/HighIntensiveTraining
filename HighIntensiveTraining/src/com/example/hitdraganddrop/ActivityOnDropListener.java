package com.example.hitdraganddrop;

import com.example.highintensivetraining.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ActivityOnDropListener implements OnDragListener {

	private DragAndDropInterface activity;
	
	public ActivityOnDropListener(DragAndDropInterface activity){
	    this.activity = activity;
	}
	
	@Override
	public boolean onDrag(View v, DragEvent dragevent) {
		// TODO Auto-generated method stub
		switch (dragevent.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				this.onDropEntered(v, dragevent);
				break;
			case DragEvent.ACTION_DRAG_EXITED:        
				this.onDropExit(v, dragevent);
				break;
			case DragEvent.ACTION_DROP:
				this.onDrop(v, dragevent);
				break;
			case DragEvent.ACTION_DRAG_ENDED:
				this.onDropEnded(v, dragevent);
			default:
				break;
		}
		return true;  
	}
	
	private void onDropEnded(View v, DragEvent dragevent) {
		// TODO Auto-generated method stub
		activity.onDropEnded(v, dragevent);
	}

	private void onDropExit(View v, DragEvent dragevent) {
		// TODO Auto-generated method stub
		activity.onDropExit(v, dragevent);
	}

	private void onDropEntered(View v, DragEvent dragevent) {
		// TODO Auto-generated method stub
		activity.onDropEntered(v, dragevent);
	}

	private void onDrop(View v, DragEvent dragevent) {
		// TODO Auto-generated method stub
		activity.onDrop(v, dragevent);
	}	
}


