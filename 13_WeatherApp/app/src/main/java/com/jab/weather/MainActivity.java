package com.jab.weather;

import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.*;

public class MainActivity extends AppCompatActivity {
    TextView cityField, updatedField, detailsField, currentTemperatureField, humidity_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityField = (TextView)findViewById(R.id.textCity);
        updatedField = (TextView)findViewById(R.id.textViewUpdated);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.textTemp);
        humidity_field = (TextView)findViewById(R.id.textHumid);
//        TextView pressure_field = (TextView)findViewById(R.id.pressure_field);
//        TextView weatherIcon = (TextView)findViewById(R.id.weather_icon);
//        TextView weatherIcon.setTypeface(weatherFont);
        Weather.placeIdTask asyncTask = new Weather.placeIdTask(new Weather.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature
                                    , String weather_humidity, String weather_pressure, String weather_updatedOn
                                    , String weather_iconText, String sun_rise) {
                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidity_field.setText("Humidity: "+weather_humidity);
//                pressure_field.setText("Pressure: "+weather_pressure);
//                weatherIcon.setText(Html.fromHtml(weather_iconText));
            }
        });
        asyncTask.execute("13.75", "100.52"); // asyncTask.execute("Latitude", "Longitude")

    }
}