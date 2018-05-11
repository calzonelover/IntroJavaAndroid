package com.jab.localweather;

import android.Manifest;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class MainActivity extends AppCompatActivity {
    private GoogleApiClient mGoogleApiClient;
    private TextView mTextViewLatitude;
    private TextView mTextViewLongitude;
    private double mLastLatitude = 0;
    private double mLastLongitude = 0;
    private final int MY_PERMISSION_REQUEST_READ_FINE_LOCATION = 0;
    private final int MY_PERMISSION_REQUEST_READ_COARSE_LOCATION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewLatitude = (TextView)findViewById(R.id.textViewLatitude);
        mTextViewLongitude = (TextView)findViewById(R.id.textViewLongitude);
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
                            .setInterval(5000)
                            .setFastestInterval(5000)
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
                mTextViewLatitude.append("\n" + latitude);
                mTextViewLongitude.append("\n" + longitude);
                mLastLatitude = latitude;
                mLastLongitude = longitude;
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

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
