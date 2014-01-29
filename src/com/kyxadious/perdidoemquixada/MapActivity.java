package com.kyxadious.perdidoemquixada;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kyxadious.perdidoemquixada.model.EscolherLugares;
import com.kyxadious.perdidoemquixada.model.Lugar;
import com.kyxadious.perdidoemquixada.model.LugaresDeQuixada;
import com.kyxadious.perdidoemquixada.model.Tipo;

public class MapActivity extends SherlockFragmentActivity {

	private GoogleMap googleMap;
	private LugaresDeQuixada lugaresDeQuixada = new LugaresDeQuixada();
	static final LatLng QUIXADA = new LatLng(-4.970261, -39.015738);

	// Início onCreate
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

		/* Ativa o butão home do action bar */
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		
		/* Setting nome da action bar */
		//Intent intent = getIntent();
		//setTitle(intent.getStringExtra("NOME-ACTION-BAR").toString());

		googleMap = ((SupportMapFragment) (getSupportFragmentManager()
				.findFragmentById(R.id.map))).getMap();
		googleMap.setMyLocationEnabled(true);
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(QUIXADA, 11));

		Marker municipio;
		ArrayList<Lugar> lugares = lugaresDeQuixada.getLugaresDeQuixada();
		Log.d("DEBUG-1-QUANTIDADE-LUGARES", String.valueOf(lugares.size()));

		EscolherLugares escolherLugares = new EscolherLugares(lugares);
		Log.d("DEBUG-2-QUANTIDADE-LUGARES", String.valueOf(lugares.size()));

		ArrayList<Lugar> lugaresEscolhidos = escolherLugares
				.getLugares(Tipo.RESTAURANTE);
		Log.d("DEBUG-3-QUANTIDADE-LUGARES-ESCOLHIDOS",
				String.valueOf(lugaresEscolhidos.size()));

		for (int i = 0; i < lugaresEscolhidos.size(); i++) {
			municipio = googleMap.addMarker(new MarkerOptions()
					.position(lugaresEscolhidos.get(i).getLocalizacao())
					.title(lugaresEscolhidos.get(i).getNome())
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.ic_launcher)));
		}

		Log.d("QUANTIDADE-LUGARES-ESCOLHIDOS",
				String.valueOf(lugaresEscolhidos.size()));
	}
	// Fim onCreate

	// Início onCreateOptionsMenu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.map, menu);
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	// Fim onCreateOptionsMenu

	// Início onOptionsItemSelected
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		
		switch (item.getItemId()) {
		case android.R.id.home:
			intent = new Intent(getApplicationContext(), MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	// Fim onOptionsItemSelected
}
