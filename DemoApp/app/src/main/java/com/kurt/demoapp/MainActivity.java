package com.kurt.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int getCheckedIdFromRadioGroup(int radioListId){
        RadioGroup radioGroup = (RadioGroup) findViewById(radioListId);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        return checkedId;
    }

    public void cmdConvertCurrency(View view){
        int checkedFromId = getCheckedIdFromRadioGroup(R.id.listFromSelector);
        int checkedToId = getCheckedIdFromRadioGroup(R.id.listToSelector);
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
    }
}
