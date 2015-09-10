package com.example.hitdraganddrop;

import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

public interface DragAndDropInterface {
	//start Action
    public boolean onDrag(View v, MotionEvent motionevent);
    //Drop
    public void onDrop(View v, DragEvent dragevent);
    
    public void onDropExit(View v, DragEvent dragevent);
    
    public void onDropEntered(View v, DragEvent dragevent);
    
    public void onDropEnded(View v, DragEvent dragevent);
   
}