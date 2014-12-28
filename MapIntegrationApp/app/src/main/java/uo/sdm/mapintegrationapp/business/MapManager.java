package uo.sdm.mapintegrationapp.business;

import com.google.android.gms.maps.*;

/**
 *
 * Manager que extiende la funcionalidad del mapa y se encarga de gestionarlo.
 *
 * Created by Hans on 27/12/2014.
 */
public class MapManager {

    private GoogleMap googleMap;

    public MapManager (final GoogleMap initialMap) {
        this.googleMap = initialMap;
    }
}
