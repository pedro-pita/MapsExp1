package com.example.android.googlemaps1;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    public static LatLng CasaPita = new LatLng(32.70361075596513 , -17.09917130117981);
    //public static LatLng CasaAgostinho = new LatLng(32.714518538304176 , -17.12361538578807);
    private GoogleMap mMap;
    private GoogleMapOptions options;
    private Marker CasaAgostinho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        options = new GoogleMapOptions();
        /*CompassEnabled - Define se a bussola deve estar ativada.
        rotateGesturesEnabled- Define se os gestos de rotação devia ser ativados.
        tiltGesturesEnabled- Define se os gestos de inclinação devem ser ativados.
         */
        options.mapType(GoogleMap.MAP_TYPE_SATELLITE)
                .compassEnabled(false)
                .rotateGesturesEnabled(false)
                .tiltGesturesEnabled(false);

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

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;
        mMap.setMapType(mMap.MAP_TYPE_TERRAIN);
        //Ativar o layer do trafego, exibir informações sobre o transito visualmente no mapa (a rua aparecer vermelha em caso de engarrafamento por exemplo)
        mMap.setTrafficEnabled(true);
        CameraPosition position = new CameraPosition.Builder()
                .target(CasaPita)
                .zoom(12).build();
        /*Metodos de deslocamento de camera
            animateCamera: deslocamento com animação
            moveCamera: deslocamento sem animação
         */
        //mover a camera com animação para a posição definida
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(position));
        //Alterar o tipo de mapa na proximidade
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //atualizar a localizção atual do dispositivo (botao)
        mMap.setMyLocationEnabled(true);

        //Controlos graficos. gestos de deslocamento sobre o mapa
        //Desativar os controlos do zoom
        mMap.getUiSettings().setZoomControlsEnabled(false);
        //Desativar a bussula
        mMap.getUiSettings().setCompassEnabled(false);
        //Desativar a rotação do mapa
        mMap.getUiSettings().setRotateGesturesEnabled(false);

        //Marcador do Agostinho
        LatLng CasaAgostinho = new LatLng(32.714518538304176 , -17.12361538578807);
        //Criação é adição do marcador no mapa
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("Mesmo no centro do funchal!!");
        mMap.addMarker(markerOptions);
        mMap.addMarker(new MarkerOptions()
                .position(CasaAgostinho)
                .title("Marker in Casa do Agostinho"));

        //Criação pela classe Marker

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}