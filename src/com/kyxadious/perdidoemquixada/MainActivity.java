package com.kyxadious.perdidoemquixada;


import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kyxadious.perdidoemquixada.model.Lugar;
import com.kyxadious.perdidoemquixada.model.LugaresDeQuixada;

public class MainActivity extends FragmentActivity {

	
	private GoogleMap googleMap;
	private LugaresDeQuixada lugaresDeQuixada = new LugaresDeQuixada();
	static final LatLng QUIXADA = new LatLng(-4.970261,-39.015738);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		googleMap = ((SupportMapFragment)(getSupportFragmentManager().findFragmentById(R.id.map))).getMap();
		googleMap.setMyLocationEnabled(true);
		googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(QUIXADA, 11));
		
		Marker municipio;
	    ArrayList<Lugar> lugares = lugaresDeQuixada.getLugaresDeQuixada();
		for(int i=0; i<lugares.size(); i++){
			  municipio = googleMap.addMarker(new MarkerOptions()
			  						.position(new LatLng(lugares.get(i).getLat(), lugares.get(i).getLng()))
			  						.title(lugares.get(i).getNome())
			  						.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
		}
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
