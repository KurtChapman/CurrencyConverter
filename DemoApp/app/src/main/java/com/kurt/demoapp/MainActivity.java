package com.kurt.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void cmdLogIn(View view) {
        logTextField("Username", findViewById(R.id.text_field_username));
        logTextField("Password", findViewById(R.id.text_field_password));
    }

    private void logTextField(String prefix, View view){
        EditText textField = (EditText)view;
        Log.i(prefix, textField.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
