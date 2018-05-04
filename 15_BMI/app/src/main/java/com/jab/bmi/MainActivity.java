package com.jab.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton1 = (Button) findViewById(R.id.commitButton);

        // Anonymous class
        myButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText myEditTextHeight = (EditText) findViewById(R.id.myHeight);
                EditText myEditTextWeight = (EditText) findViewById(R.id.myWeight);
                TextView myEditTextBMI = findViewById(R.id.textBMI);
                ImageView myImageView = findViewById(R.id.BMIImage);

                float height = Float.valueOf(myEditTextHeight.getText().toString());
                float weight = Float.valueOf(myEditTextWeight.getText().toString());

                float valueBMI = BMI.getValueFloat(height, weight);

                myEditTextBMI.setText("your BMI value : "+BMI.getValueString(height, weight));

                /// Check for health
                // skinny
                if (valueBMI < BMI.minBMIValue){
                    myImageView.setImageResource(R.mipmap.skinny);
                    myEditTextBMI.append("\n Skinny");
                }
                // fat
                else if (valueBMI > BMI.maxBMIValue){
                    myImageView.setImageResource(R.mipmap.fat);
                    myEditTextBMI.append("\n Fat");
                }
                // well
                else {
                    myImageView.setImageResource(R.mipmap.well);
                    myEditTextBMI.append("\n Looking good !");
                }

            }
        });

    }
}
