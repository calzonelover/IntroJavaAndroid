package com.jab.api;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    // JSON Node names
    private static final String TAG_CODE = "CODE";
    private static final String TAG_NAME = "NAME";
    private static final String TAG_FACTORY = "FACTORY";
    private static final String TAG_WORK_CENTER = "WORK_CENTER";

    // Declare view objects
    private Button mButtonLogin;
    private EditText mLogin;
    private TextView mCODE;
    private TextView mNAME;
    private TextView mFACTORY;
    private TextView mWORK_CENTER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create view objects
        this.CreateView();

        // Reset view objects
        this.ResetView();

        // Set button on click listener
        this.mButtonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
    }

    private void CreateView() {
        this.mButtonLogin = (Button)findViewById(R.id.buttonLogin);
        this.mLogin = (EditText)findViewById(R.id.editTextLogin);
        this.mCODE = (TextView)findViewById(R.id.TextViewAssetCODE);
        this.mNAME = (TextView)findViewById(R.id.textViewAssetNAME);
        this.mFACTORY = (TextView)findViewById(R.id.textViewAssetFACTORY);
        this.mWORK_CENTER = (TextView)findViewById(R.id.textViewAssetWORK_CENTER);

    }

    private void ResetView() {
        // Reset View object
        this.mButtonLogin.setText("Login");
        this.mCODE.setText("");
        this.mNAME.setText("");
        this.mFACTORY.setText("");
        this.mWORK_CENTER.setText("");
    }

    private void onButtonClick(View v){
        // บังคับให้ Run แบบไม่มี Background เพื่อไม่ให้เกิด Error : android.os.NetworkOnMainThreadException
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if (this.mLogin.getText().toString().trim().length() != 0)
            if (this.mButtonLogin.getText() == "Login") {
                String str = "http://192.168.143.1/TnT-Factory/api/login/?loginName=" + this.mLogin.getText().toString();

                try {
                    URL url = new URL(str);
                    URLConnection urlConnection = url.openConnection();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                    String json;

                    json = bufferedReader.readLine();

                    json = json.replace("\\", "");

                    //json = json.substring(1, json.length() - 1);
                    json = json.substring(json.indexOf("{"), json.lastIndexOf("}") + 1);

                    //this.mModel.setText(json);

                    JSONObject jsonObject = new JSONObject(json.toString());

                    this.mNAME.setText(jsonObject.getString(TAG_NAME));
                    this.mFACTORY.setText(jsonObject.getString(TAG_FACTORY));
                    this.mWORK_CENTER.setText(jsonObject.getString(TAG_WORK_CENTER));

                    this.mButtonLogin.setText("ค้นหาใหม่");
                } catch (Throwable t) {
                    Toast.makeText(this, "Request failed: " + t.toString(),
                            Toast.LENGTH_LONG).show();
                }
            } else {
                this.ResetView();
            }
        else {
            Toast.makeText(this, "กรุณาป้อนข้อมูล",
                    Toast.LENGTH_LONG).show();
        }

    }

    private String RefineJsonLine(String jsonLine) {
        jsonLine = jsonLine.replace("\\", "");      // Remove \ in the line

        //jsonLine = jsonLine.substring(1, jsonLine.length() - 1);                              // Remove { and } in the begin and end
        jsonLine = jsonLine.substring(jsonLine.indexOf("{"), jsonLine.lastIndexOf("}") + 1);    // Remove { and } in the begin and end

        return jsonLine;
    }

}



//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
