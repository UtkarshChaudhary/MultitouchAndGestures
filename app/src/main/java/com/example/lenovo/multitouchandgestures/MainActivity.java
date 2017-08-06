package com.example.lenovo.multitouchandgestures;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.style.RelativeSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
 RelativeLayout relativeLayout;
    HashMap<Integer,View> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);
        map=new HashMap<>();
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int index=event.getActionIndex();
                int id=event.getPointerId(index);
                if(event.getActionMasked()==MotionEvent.ACTION_DOWN){

                    float x=event.getX(index);
                    float y=event.getY(index);
                    View newView=new View(MainActivity.this);
                    newView.setLayoutParams(new LinearLayoutCompat.LayoutParams(200,200));
                    newView.setBackgroundColor(Color.BLACK);
                    newView.setX(x-100); //100 is half of height and width given in layout params
                    newView.setY(y-100); // -100 is written so that view comes on middle of click
                    map.put(id,newView);
                    relativeLayout.addView(newView);


                }else if(event.getActionMasked()==MotionEvent.ACTION_POINTER_DOWN){
                    float x=event.getX(index);
                    float y=event.getY(index);
                    View newView=new View(MainActivity.this);
                    newView.setLayoutParams(new LinearLayoutCompat.LayoutParams(200,200));
                    newView.setBackgroundColor(Color.BLACK);
                    newView.setX(x-100); //100 is half of height and width given in layout params
                    newView.setY(y-100); // -100 is written so that view comes on middle of click
                    map.put(id,newView);
                    relativeLayout.addView(newView);
                }else if(event.getActionMasked()==MotionEvent.ACTION_POINTER_UP){

                    View removeView=map.get(id);
                    map.remove(id);
                    relativeLayout.removeView(removeView);

                }else if(event.getActionMasked()==MotionEvent.ACTION_UP){

                    View removeView=map.get(id);
                    map.remove(id);
                    relativeLayout.removeView(removeView);

                }else if(event.getActionMasked()==MotionEvent.ACTION_MOVE){
                   //while moving id remain same
                    for(int i=0;i<event.getPointerCount();i++){
                        View view=map.get(event.getPointerId(i));
                        float x=event.getX(i);
                        float y=event.getY(i);
                        view.setX(x-100);
                        view.setY(y-100);
                    }
                }
                return true;
           }
        });
    }
}
