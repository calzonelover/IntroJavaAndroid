package com.jab.localweather;

import android.Manifest;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Debug;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
/// try
import android.text.Html;
import android.graphics.Typeface;

/// was downloaded in App (gandle) file
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {
    private GoogleApiClient mGoogleApiClient;
    private TextView mTextViewLatitude;
    private TextView mTextViewLongitude;
    /// for weather
    TextView cityField, updatedField, detailsField, currentTemperatureField, humidity_field, weatherIcon;
    Typeface weatherFont;
    private double mLastLatitude = 0;
    private double mLastLongitude = 0;
    private final int MY_PERMISSION_REQUEST_READ_FINE_LOCATION = 0;
    private final int MY_PERMISSION_REQUEST_READ_COARSE_LOCATION = 1;
    // waiting time
    private final int TIME_UPDATE = 1000;// milliseconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherFont = Typeface.createFromAsset(getApplicationContext().getAssets()
                , "fonts/weathericons-regular-webfont.ttf");
        //////////////////////////////////
        /// Longtitude Latitude Google ///
        //////////////////////////////////
        mTextViewLatitude = (TextView)findViewById(R.id.textViewLatitude);
        mTextViewLongitude = (TextView)findViewById(R.id.textViewLongitude);
        // Append text
        mTextViewLatitude.append("\n" + "Start");
        mTextViewLongitude.append("\n" + "Start");
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                mTextViewLatitude.append("\n" + "Ask Permission?");
            }
            else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        MY_PERMISSION_REQUEST_READ_FINE_LOCATION);
            }
        }
        else {
// Has permission --
        }
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(mCallback)
                .addOnConnectionFailedListener(mOnFailed).build();

    }
    private GoogleApiClient.ConnectionCallbacks mCallback =
            new GoogleApiClient.ConnectionCallbacks() {
                @Override
                public void onConnected(Bundle bundle) {
                    LocationRequest request = new LocationRequest()
                            .setInterval(TIME_UPDATE)
                            .setFastestInterval(TIME_UPDATE)
                            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                    try {
                        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                                request, mLocationListener);
                    }
                    catch(SecurityException ex) {
// Do nothing.
                        mTextViewLatitude.append("\n" + ex.getMessage());
                    }
                }
                @Override
                public void onConnectionSuspended(int i) {}
            };
    private GoogleApiClient.OnConnectionFailedListener mOnFailed =
            new GoogleApiClient.OnConnectionFailedListener() {
                @Override
                public void onConnectionFailed(ConnectionResult connectionResult) {
                    mTextViewLatitude.append("\n" + "Failed");
                    mTextViewLongitude.append("\n" + "Failed");
                }
            };
    private LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            if (latitude != mLastLatitude && longitude != mLastLongitude) {
                mTextViewLatitude.setText(Double.toString(latitude));
                mTextViewLongitude.setText(Double.toString(longitude));
//                mTextViewLatitude.append("\n" + latitude);
//                mTextViewLongitude.append("\n" + longitude);
                mLastLatitude = latitude;
                mLastLongitude = longitude;
                //////////////////////////////////
                ///       Weather API          ///
                //////////////////////////////////
                cityField = (TextView)findViewById(R.id.textCity);
                updatedField = (TextView)findViewById(R.id.textViewUpdated);
                detailsField = (TextView)findViewById(R.id.details_field);
                currentTemperatureField = (TextView)findViewById(R.id.textTemp);
                humidity_field = (TextView)findViewById(R.id.textHumid);
//        TextView pressure_field = (TextView)findViewById(R.id.pressure_field);
                weatherIcon = (TextView)findViewById(R.id.weather_icon);
                weatherIcon.setTypeface(weatherFont);
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
                weatherIcon.setText(Html.fromHtml(weather_iconText));
                    }
                });
                asyncTask.execute(Double.toString(mLastLatitude)
                        , Double.toString(mLastLongitude)); // asyncTask.execute("Latitude", "Longitude")
            }

        }
    };
    @Override
    public void onStart() {
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
        super.onStart();
    }
    @Override
    public void onStop() {
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
        super.onStop();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_READ_FINE_LOCATION: {
// If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    mTextViewLatitude.append("\n" + "RequestPermissionsResult - > PERMISSION_GRANTED");
                }
                else {
                    mTextViewLatitude.append("\n" + "RequestPermissionsResult - > PERMISSION_DENIED_GRANTED");
                }
                return;
            }
// other 'case' lines to check for other
// permissions this app might request
        }
    }
}