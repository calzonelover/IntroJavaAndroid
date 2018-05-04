package com.jab.myapplication;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button myButton1 = (Button) findViewById(R.id.myButton1);
        Button myButton2 = (Button) findViewById(R.id.myButton2);
        Button myButton3 = (Button) findViewById(R.id.myButton3);
        Button myButton4 = (Button) findViewById(R.id.myButton4);

//        /// (1) usual example
//        myButton1.setOnClickListener(this);
//        myButton2.setOnClickListener(this);
//        myButton3.setOnClickListener(this);
//        myButton4.setOnClickListener(this);

        /// (2) Anonymous class
        myButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView myTextView1 = (TextView)findViewById(R.id.myTextView1);
                EditText myEditText1 = (EditText) findViewById(R.id.myEditText1);
                EditText myEditText2 = (EditText) findViewById(R.id.myEditText2);

                float var1 = Float.valueOf(myEditText1.getText().toString());
                float var2 = Float.valueOf(myEditText2.getText().toString());

                String result = Float.toString(var1 + var2);
                myTextView1.setText(result);

            }
        });
        myButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView myTextView1 = (TextView)findViewById(R.id.myTextView1);
                EditText myEditText1 = (EditText) findViewById(R.id.myEditText1);
                EditText myEditText2 = (EditText) findViewById(R.id.myEditText2);

                float var1 = Float.valueOf(myEditText1.getText().toString());
                float var2 = Float.valueOf(myEditText2.getText().toString());

                String result = Float.toString(var1 - var2);
                myTextView1.setText(result);
            }
        });
        myButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView myTextView1 = (TextView)findViewById(R.id.myTextView1);
                EditText myEditText1 = (EditText) findViewById(R.id.myEditText1);
                EditText myEditText2 = (EditText) findViewById(R.id.myEditText2);

                float var1 = Float.valueOf(myEditText1.getText().toString());
                float var2 = Float.valueOf(myEditText2.getText().toString());

                String result = Float.toString(var1 * var2);
                myTextView1.setText(result);
            }
        });
        myButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView myTextView1 = (TextView)findViewById(R.id.myTextView1);
                EditText myEditText1 = (EditText) findViewById(R.id.myEditText1);
                EditText myEditText2 = (EditText) findViewById(R.id.myEditText2);

                float var1 = Float.valueOf(myEditText1.getText().toString());
                float var2 = Float.valueOf(myEditText2.getText().toString());

                String result = Float.toString(var1 / var2);
                myTextView1.setText(result);

            }
        });


    }

    /// Will be using by 1) usual example
    @Override
    public void onClick(View v){
//        Button myButton = (Button)v;
//        String myButtonText = myButton.getText().toString();

        String result;
        TextView myTextView1 = (TextView)findViewById(R.id.myTextView1);
        EditText myEditText1 = (EditText) findViewById(R.id.myEditText1);
        EditText myEditText2 = (EditText) findViewById(R.id.myEditText2);

        float var1 = Float.valueOf(myEditText1.getText().toString());
        float var2 = Float.valueOf(myEditText2.getText().toString());

        switch (v.getId()){
            // For math operator
            case R.id.myButton1:
                result = Float.toString(var1 + var2);
                myTextView1.setText(result);
                break;
            case R.id.myButton2:
                result = Float.toString(var1 - var2);
                myTextView1.setText(result);
                break;
            case R.id.myButton3:
                result = Float.toString(var1 * var2);
                myTextView1.setText(result);
                break;
            case R.id.myButton4:
                result = Float.toString(var1 / var2);
                myTextView1.setText(result);
                break;
        }
    }



/// EX 1
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

}