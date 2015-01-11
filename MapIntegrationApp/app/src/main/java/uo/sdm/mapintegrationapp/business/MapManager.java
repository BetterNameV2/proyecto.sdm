package uo.sdm.mapintegrationapp.business;

import android.app.PendingIntent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.Toast;

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
    private LocationManager locationManager;
    public MapManager (final GoogleMap initialMap, final LocationManager locationManager) {
        this.googleMap = initialMap;
        this.locationManager = locationManager;
        moveToGps();
    }

    private void moveToGps(){
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER){

        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(43.3625,-5.850278),14));
    }
}
