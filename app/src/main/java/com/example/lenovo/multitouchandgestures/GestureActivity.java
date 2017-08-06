package com.example.lenovo.multitouchandgestures;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class GestureActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
RelativeLayout relativeLayout;
    GestureDetectorCompat gestureDetectorCompat;
    String TAG="GestureActivityTag";
    GestureOverlayView gestureOverlayView;
    GestureLibrary library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayoutGesture);
      library= GestureLibraries.fromRawResource(this,R.raw.gesture);
        library.load();

        gestureOverlayView=(GestureOverlayView)findViewById(R.id.gestureOverLay);

        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                Log.i(TAG, "onGesturePerformed");

                ArrayList<Prediction> predictions = library.recognize(gesture);
                Log.i(TAG, "Predictions size " + predictions.size());

                for(Prediction prediction : predictions){
                    Log.i(TAG, prediction.name +" " +prediction.score+"");
                }
            }
        });
//        gestureDetectorCompat=new GestureDetectorCompat(this, this);
//        //one this is context other is listener
//
//        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
//       @Override
//       public boolean onTouch(View v, MotionEvent event) {
//           gestureDetectorCompat.onTouchEvent(event);
//           return true;
//        // if false is written then its parent will handle this event
//       }
//   });
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.i(TAG, "onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i(TAG, "onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i(TAG, "onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i(TAG, "onScroll");

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i(TAG, "onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i(TAG, "onFling");

        return true;
    }
}
