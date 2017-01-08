package com.kurt.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> drawableIds;
    int currentIndex = 0;

    private void incrementIndex(){
        if(currentIndex < drawableIds.size() - 1){
            currentIndex++;
        } else {
            currentIndex = 0;
        }
    }

    public void cmdSwitchImage(View view) {
        incrementIndex();
        ImageView image = (ImageView)findViewById(R.id.imageView);
        image.setImageResource(drawableIds.get(currentIndex));
    }

    private String getTextFromView(View view){
        EditText textField = (EditText)view;
        return textField.getText().toString();
    }

    private void logTextField(String prefix, View view){
        Log.i(prefix, getTextFromView(view));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawableIds = new ArrayList<Integer>();
        drawableIds.add(R.drawable.cat1);
        drawableIds.add(R.drawable.cat2);
        drawableIds.add(R.drawable.cat3);
    }
}
