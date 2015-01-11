package uo.sdm.mapintegrationapp.ui;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import uo.sdm.mapintegrationapp.R;
import uo.sdm.mapintegrationapp.business.MapManager;

public class MapActivity extends ActionBarActivity{

    private GoogleMap googleMap;
    private MapManager mapManager;
    private LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        createMapManager();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Inicializa el mapview
     */
    private void createMapManager() {
        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapView)).getMap();

                if (googleMap == null) {
                    Toast.makeText(getApplicationContext(), "Error en la creación del mapa", Toast.LENGTH_SHORT).show();
                }
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                mapManager = new MapManager(googleMap,locationManager );
            }
        }catch (NullPointerException exception) {
            Log.e( R.string.app_name + " createMapView", exception.toString());
        }
    }

    /**
     * Añade el marcador
     */
    private void addMarker(){
        if (googleMap != null) {
            googleMap.addMarker(new MarkerOptions()
                                .position(new LatLng(0,0))
                                .title("Marcador")
                                .draggable(true)
            );
        }
    }
}
