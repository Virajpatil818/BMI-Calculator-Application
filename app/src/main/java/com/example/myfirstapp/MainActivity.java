package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightFt,edtHeightin;
        AppCompatButton btncalculate;
        TextView txtResult;
        LinearLayout llMain;


        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightft);
        edtHeightin = findViewById(R.id.edtHeightIn);
        btncalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);


        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt = Integer.parseInt(edtWeight.getText().toString());
               int htFt = Integer.parseInt(edtHeightFt.getText().toString());
               int htIn = Integer.parseInt(edtHeightin.getText().toString());

               int totalIn = htFt*12 + htIn ;
               double totalCm = totalIn * 2.53;
               double totalM = totalCm / 100;

               double bmi = wt / (totalM*totalM);

               if(bmi > 25){
                   txtResult.setText("You are OverWeight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
               } else if (bmi < 18) {
                   txtResult.setText("You are UnderWeight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
               }else {
                   txtResult.setText("You are Healthy");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorh));
               }
            }
        });
    }
}