package com.example.calculatorappsaraiya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class HistoryClass extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_history);

        //inside the onCreate, get intent

        Intent intent = getIntent();
        //name has to match when sending package
        String hist = intent.getStringExtra("HISTORY");
        TextView hisTV = findViewById(R.id.history);
        hisTV.setText(hist);

    }

}
