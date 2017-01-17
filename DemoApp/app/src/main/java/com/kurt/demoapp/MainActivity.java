package com.kurt.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Converter converter;

    private String getStringFromCheckedButton(int radioListId){
        RadioGroup radioGroup = (RadioGroup) findViewById(radioListId);
        int checkedId= radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(checkedId);
        return radioButton.getText().toString();
    }

    public void cmdConvertCurrency(View view) throws InterruptedException, ExecutionException, IOException {
        String checkedFromCurrency = getStringFromCheckedButton(R.id.listFromSelector);
        String checkedToCurrency = getStringFromCheckedButton(R.id.listToSelector);
        float rate = converter.getConvertedCurrencyRate(checkedFromCurrency, checkedToCurrency);
        showToastForConvertedCurrency(rate);
    }

    private void showToastForConvertedCurrency(float rate){
        View amountBox = findViewById(R.id.editText);
        String amountString = getTextFromView(amountBox);
        float amountVal = Float.parseFloat(amountString);
        float finalVal = amountVal * rate;
        Toast t = Toast.makeText(this, String.valueOf(finalVal), Toast.LENGTH_LONG);
        t.show();
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
