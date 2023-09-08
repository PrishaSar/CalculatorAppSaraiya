package com.example.calculatorappsaraiya;

import static java.util.Objects.isNull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Calculate(View v){
        //get numbers from edit text and convert to Integer
        EditText in1 = findViewById(R.id.editTextInput1);
        EditText in2 = findViewById(R.id.editTextInput2);

        int int1 = Integer.valueOf(in1.getText().toString());
        int int2 = Integer.valueOf(in2.getText().toString());

        String ans = int1 + "";

        double fin = 0;

        int1 = checkNull(int1);
        if(v.getId()==R.id.add){
            int2 = checkNull(int2);
            fin = int1 + int2;
            ans += " + " + int2;
        }
        if(v.getId()==R.id.absolute){
            fin = Math.abs(int1);
            ans = "|" + ans + "|";
        }
        if(v.getId()==R.id.divide){
            int2 = checkNull(int2);
            if(int2 == 0){
                int2 = 1;
            }
            fin = Double.valueOf(int1)/int2;
            ans += " / " + int2;
        }
        if(v.getId()==R.id.subtract){
            int2 = checkNull(int2);
            fin = int1 - int2;
            ans += " - " + int2;
        }
        if(v.getId()==R.id.multiply){
            int2 = checkNull(int2);
            fin = int1 * int2;
            ans += " X " + int2;
        }
        if(v.getId()==R.id.factorial){
            for(int l = int1; l <= int1; l++){
                fin = fin * l;
            }
            ans += "!";
        }
        if(v.getId()==R.id.exponent){
            int2 = checkNull(int2);
            fin = Math.pow(int1, int2);
            ans += " ^ " + int2;
        }
        if(v.getId()==R.id.identity){
            fin = int1;
        }

        ans += " = ";
        TextView out = findViewById(R.id.Output);
        ans += String.valueOf(fin);
        out.setText(ans);

    }

    public int checkNull(int n){
        if(isNull(n)){
            return 0;
        }
        return n;
    }


    
}