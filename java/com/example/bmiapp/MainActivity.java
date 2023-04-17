package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weight;
    private EditText height;
    private Button calculate;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        calculate = findViewById(R.id.cal);
        resultTextView = findViewById(R.id.result);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String w = weight.getText().toString();
        String h = height.getText().toString();

        if (!w.isEmpty() && !h.isEmpty()) {
            float weight = Float.parseFloat(w);
            float height = Float.parseFloat(h) / 100;

            float bmi = weight / (height * height);

            String result;
            if (bmi < 16) {
                result = "Extremly Underweight...";
            } else if (bmi >= 16 && bmi < 18.5) {
                result = " Underweight...";
            } else if (bmi >= 18.5 && bmi < 25) {
                result = "Normal...";
            } else if (bmi >= 25 && bmi < 30) {
                result = "Overweight...";
            } else {
                result = "Obese...";
            }

            resultTextView.setText("Result: Your BMI is "+bmi+"\n\n" + result);
            resultTextView.setTextColor(Color.rgb(255,215,0));
        } else {
            resultTextView.setText("Please Enter weight and height.");
            resultTextView.setTextColor(Color.RED);
        }
    }
}