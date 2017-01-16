package com.kurt.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Converter converter;

    private String getStringFromCheckedButton(int radioListId){
        RadioGroup radioGroup = (RadioGroup) findViewById(radioListId);
        int checkedId= radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(checkedId);
        return radioButton.getText().toString();
    }

    public void cmdConvertCurrency(View view) throws InterruptedException, ExecutionException, MalformedURLException {
        String checkedFromCurrecy = getStringFromCheckedButton(R.id.listFromSelector);
        String checkedToCurrency = getStringFromCheckedButton(R.id.listToSelector);
        View amountBox = findViewById(R.id.editText);
        String amount = getTextFromView(amountBox);
        converter.getConvertedCurrency(Integer.parseInt(amount), checkedFromCurrecy, checkedToCurrency);
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
        converter = new Converter();
    }
}
