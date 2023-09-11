package com.example.calculatorappsaraiya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalcHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_history);

        Intent intent = getIntent();
        //name has to match when sending package
        String hist = intent.getStringExtra("HISTORY");
        TextView hisTV = findViewById(R.id.calcHistory);
        hisTV.setText(hist);
    }

    public void continueCalc(View v){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }
}