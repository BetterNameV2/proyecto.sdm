package uo.sdm.mapintegrationapp.business;

import android.location.Location;
import android.location.LocationManager;
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
    }

    public void moveToGps(){
        googleMap.setMyLocationEnabled(true);

    }

}
