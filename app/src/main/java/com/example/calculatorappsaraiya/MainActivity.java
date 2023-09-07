package com.example.calculatorappsaraiya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //https://stackoverflow.com/questions/25905086/multiple-buttons-onclicklistener-android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v){
        //get numbers from edit text and convert to Integer
        EditText in1 = findViewById(R.id.editTextInput1);
        EditText in2 = findViewById(R.id.editTextInput2);

        int int1 = Integer.valueOf(in1.getText().toString());
        int int2 = Integer.valueOf(in2.getText().toString());

        //find operation
        //calc (learned)
        //input in output box
    }

    
}