package com.example.calculatorappsaraiya;

import static java.util.Objects.isNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private String his;
    private TextView outputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        his = "";
        outputView = findViewById(R.id.Output);
    }

    public void onDigitInput(View view) {
        EditText input = (EditText) view;
        String text = input.getText().toString();
        if (!text.isEmpty()) {
            char lastChar = text.charAt(text.length() - 1);
            if (Character.isDigit(lastChar)) {
                int digit = Character.getNumericValue(lastChar);
                changeScreenColor(digit);
            }
        }
    }

    private void changeScreenColor(int digit) {
        int colorResId;
        switch (digit) {
            case 0:
                colorResId = R.color.digit_0;
                break;
            case 1:
                colorResId = R.color.digit_1;
                break;
            case 2:
                colorResId = R.color.digit_2;
                break;
            case 3:
                colorResId = R.color.digit_3;
                break;
            case 4:
                colorResId = R.color.digit_4;
                break;
            case 5:
                colorResId = R.color.digit_5;
                break;
            case 6:
                colorResId = R.color.digit_6;
                break;
            case 7:
                colorResId = R.color.digit_7;
                break;
            case 8:
                colorResId = R.color.digit_8;
                break;
            case 9:
                colorResId = R.color.digit_9;
                break;
            default:
                colorResId = R.color.md_theme_dark_primary;
        }
        outputView.setBackgroundColor(ContextCompat.getColor(this, colorResId));
    }

    public void Calculate(View v){
        //get numbers from edit text and convert to Integer
        EditText in1 = findViewById(R.id.editTextInput1);
        EditText in2 = findViewById(R.id.editTextInput2);

        String i1 = checkNull(in1.getText().toString());
        String i2 = checkNull(in2.getText().toString());

        int int1 = Integer.valueOf(i1);
        int int2 = Integer.valueOf(i2);

        String ans = int1 + "";

        double fin = 1;

        if(v.getId()==R.id.add){
            fin = int1 + int2;
            ans += " + " + int2;
        }
        if(v.getId()==R.id.absolute){
            fin = Math.abs(int1);
            ans = "|" + ans + "|";
        }
        if(v.getId()==R.id.divide){
            if(int2 == 0){
                int2 = 1;
            }
            fin = Double.valueOf(int1)/int2;
            ans += " / " + int2;
        }
        if(v.getId()==R.id.subtract){
            fin = int1 - int2;
            ans += " - " + int2;
        }
        if(v.getId()==R.id.multiply){
            fin = int1 * int2;
            ans += " X " + int2;
        }
        if(v.getId()==R.id.factorial){
            for(int l = 2; l <= int1; l++){
                fin = fin * l;
            }
            ans += "!";
        }
        if(v.getId()==R.id.exponent){
            fin = Math.pow(int1, int2);
            ans += " ^ " + int2;
        }
        if(v.getId()==R.id.identity){
            fin = int1;
        }

        ans += " = ";
        outputView.setText(ans);
        his += ans + "\n";
    }

    public String checkNull(String n){
        if(n.matches("")){
            return "1";
        }
        return n;
    }


    public void showHistory(View v){
        Intent intent = new Intent(this, CalcHistory.class);
        intent.putExtra("HISTORY", his);
        startActivity(intent);
    }


    
}