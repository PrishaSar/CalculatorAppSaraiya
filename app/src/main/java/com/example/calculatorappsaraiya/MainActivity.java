package com.example.calculatorappsaraiya;

import static java.util.Objects.isNull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private String his;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        his = "";
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
        TextView out = findViewById(R.id.Output);
        ans += String.valueOf(fin);
        his += ans + "\n";
        out.setText(ans);

    }

    public String checkNull(String n){
        if(n.matches("")){
            return "1";
        }
        return n;
    }


    public void showHistory(View v){
        Intent intent = new Intent(this, HistoryClass.class);
        intent.putExtra("HISTORY", his);
        startActivity(intent);
    }


    
}