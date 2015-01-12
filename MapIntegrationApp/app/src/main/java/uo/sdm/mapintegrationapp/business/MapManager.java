package uo.sdm.mapintegrationapp.business;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 *
 * Manager que extiende la funcionalidad del mapa y se encarga de gestionarlo.
 *
 * Created by Hans on 27/12/2014.
 */
public class MapManager {

    private GoogleMap googleMap;
    private LocationManager locationManager;
    public MapManager (final GoogleMap initialMap, final LocationManager locationManager) {
        this.googleMap = initialMap;
        this.locationManager = locationManager;
        setUpMap();
        //moveToGps();
    }

    private void setUpMap() {
        String provider = locationManager.NETWORK_PROVIDER;
        Location myLocation = locationManager.getLastKnownLocation(provider);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Get latitude of the current location
        double latitude = myLocation.getLatitude();

        // Get longitude of the current location
        double longitude = myLocation.getLongitude();

        // Create a LatLng object for the current location
        LatLng myCoordinates = new LatLng(latitude, longitude);

        // Show the current location in Google Map
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(myCoordinates)      // Sets the center of the map to LatLng (refer to previous snippet)
                .zoom(17)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        // Zoom in the Google Map
        googleMap.addMarker(new MarkerOptions()
                .position(myCoordinates)
                .title("You are here!")
                .snippet("Consider yourself located"));

    }
}
