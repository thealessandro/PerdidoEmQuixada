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
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kyxadious.perdidoemquixada.model.EscolherIcone;
import com.kyxadious.perdidoemquixada.model.EscolherLugar;
import com.kyxadious.perdidoemquixada.model.Lugar;
import com.kyxadious.perdidoemquixada.model.LugaresDeQuixada;
import com.kyxadious.perdidoemquixada.model.Tipo;

public class MapActivity extends SherlockFragmentActivity {

	private Intent intent;
	private GoogleMap googleMap;
	private Marker marcador, ultimoPontoNoMapa;
	private LatLng quixada = new LatLng(-4.970261, -39.015738);
	
	private Tipo tipoDoLugar;
	private ArrayList<Lugar> lugares;
	private LugaresDeQuixada lugaresDeQuixada;
	private EscolherIcone escolherIcone;
	private EscolherLugar escolherLugar;

	public static final String TITULO = "com.kyxadious.perdidoemquixada.titulolugarescolhido";
	public static final String TIPO = "com.kyxadious.perdidoemquixada.tipolugarescolhido";
	public static final String LUGAR = "com.kyxadious.perdidoemquixada.lugarescolhido";
	
	
	// Início onCreate
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

		/* Ativa o butão home do action bar */
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		
		/* Setting nome da action bar */
		intent = getIntent();
		setTitle(intent.getStringExtra(TITULO).toString());
		tipoDoLugar = (Tipo) intent.getSerializableExtra(TIPO);

		googleMap = ((SupportMapFragment) (getSupportFragmentManager().findFragmentById(R.id.map))).getMap();
		googleMap.setMyLocationEnabled(true);
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(quixada, 11));


		/* Trazendo os lugares */
		escolherIcone = new EscolherIcone();
		lugaresDeQuixada = new LugaresDeQuixada();
		escolherLugar = new EscolherLugar(lugaresDeQuixada.getLugaresDeQuixada());
		lugares = escolherLugar.getLugares(tipoDoLugar);

		for (int i = 0; i < lugares.size(); i++) {
			marcador = googleMap.addMarker(new MarkerOptions()
					.position(lugares.get(i).getLocalizacao())
					.title(lugares.get(i).getNome())
					.snippet(lugares.get(i).getDescricao())
					.icon(BitmapDescriptorFactory
					.fromResource(escolherIcone.getIcone(tipoDoLugar))));			
		}
		
		// Tela LugarActivity é startada quando um marker é clicado
		ultimoPontoNoMapa = null;
		googleMap.setOnMarkerClickListener(new OnMarkerClickListener() {
			
			@Override
			public boolean onMarkerClick(Marker marker) {
				
				if (ultimoPontoNoMapa != null) {
					ultimoPontoNoMapa.hideInfoWindow();
					
					if (ultimoPontoNoMapa.equals(marker)) {
						ultimoPontoNoMapa = null;
						Lugar lugarProcurado = lugaresDeQuixada.getLugar(marker.getTitle().toString());
						Intent intent = new Intent(getApplicationContext(), LugarActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
						intent.putExtra(LUGAR, lugarProcurado);
						intent.putExtra(TITULO, getTitle().toString());
						startActivity(intent);
					}
				}
				
				ultimoPontoNoMapa = marker;
				ultimoPontoNoMapa.showInfoWindow();
				
				return true;
			}
		});

		
		Log.d("QUANTIDADE-LUGARES-ESCOLHIDOS", String.valueOf(lugares.size()));
	}
	// Fim onCreate

	// Início onCreateOptionsMenu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.map, menu);
		//getSupportMenuInflater().inflate(R.menu.main, menu);
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
