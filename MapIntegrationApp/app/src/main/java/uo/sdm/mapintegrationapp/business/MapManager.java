package uo.sdm.mapintegrationapp.business;

import android.location.Location;

import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;

/**
 *
 * Manager que extiende la funcionalidad del mapa y se encarga de gestionarlo.
 *
 * Created by Hans on 27/12/2014.
 */
public class MapManager {

    private GoogleMap googleMap;
    private LocationClient locationClient;
    public MapManager (final GoogleMap initialMap, final LocationClient locationClient) {
        this.googleMap = initialMap;
        this.locationClient = locationClient;
        locationClient.connect();
    }


    public void moveToGps(){
        Location location = locationClient.getLastLocation();
        if(location != null)
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),location.getLongitude()),14));
    }
}
