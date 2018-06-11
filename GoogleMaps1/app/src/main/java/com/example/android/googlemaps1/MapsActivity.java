package com.example.android.googlemaps1;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap     ;
    public static LatLng Porto = new LatLng(41.14 , -8.63);
    public static LatLng CasaPita = new LatLng(32.70361075596513 , -17.09917130117981);
    public static LatLng CasaAgostinho = new LatLng(32.714518538304176 , -17.12361538578807);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(CasaPita).title("Marker in Porto"));
        mMap.addMarker(new MarkerOptions().position(CasaAgostinho).title("Marker in Porto"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CasaPita));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CasaAgostinho));
    }
}
