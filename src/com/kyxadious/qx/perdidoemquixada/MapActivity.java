package com.kyxadious.qx.perdidoemquixada;

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
import com.kyxadious.qx.perdidoemquixada.R;
import com.kyxadious.qx.perdidoemquixada.model.SeletorIconeMenu;
import com.kyxadious.qx.perdidoemquixada.model.EscolherLugares;
import com.kyxadious.qx.perdidoemquixada.model.Lugar;
import com.kyxadious.qx.perdidoemquixada.model.LugaresDeQuixada;
import com.kyxadious.qx.perdidoemquixada.model.CategoriaLugar;

public class MapActivity extends SherlockFragmentActivity {

	private int zoom;
	private Intent intent;
	private LatLng localizacao;
	private GoogleMap googleMap;
	private Marker marcador, ultimoPontoNoMapa;
	
	private CategoriaLugar tipoDoLugar;
	private Lugar lugar;
	private ArrayList<Lugar> lugares;
	private LugaresDeQuixada lugaresDeQuixada;
	private SeletorIconeMenu seletorIconeMenu;
	private EscolherLugares escolherLugares;

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
		
		/* Configuração padrão no mapa */
		zoom = 14;
		localizacao = new LatLng(-4.968679,-39.017086);
		
		/* Trazendo os lugares */
		seletorIconeMenu = new SeletorIconeMenu();
		lugaresDeQuixada = new LugaresDeQuixada();
		
		/* Pegando os valores da intent */
		intent = getIntent();
		setTitle(intent.getStringExtra(TITULO).toString());
		tipoDoLugar = (CategoriaLugar) intent.getSerializableExtra(TIPO);
		
		// Se for null, é porque eu quero visuzlizar apenas um lugar no mapa
		if (intent.getSerializableExtra(LUGAR) != null) {
			lugar = (Lugar) intent.getSerializableExtra(LUGAR);
			setZoom(15); // Aproximação da câmera 
			setLocatizacao(lugar.getLocalizacao()); // Centralização no mapa naquele ponto
			lugares = new ArrayList<Lugar>();
			lugares.add(lugar);		
		} else { // Senão for null, é para exibir um conjunto de lugares
			escolherLugares = new EscolherLugares(lugaresDeQuixada.getLugaresDeQuixada());
			lugares = escolherLugares.getLugares(tipoDoLugar);
		}

		googleMap = ((SupportMapFragment) (getSupportFragmentManager().findFragmentById(R.id.map))).getMap();
		googleMap.setMyLocationEnabled(true);
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localizacao, zoom));


		for (int i = 0; i < lugares.size(); i++) {
			marcador = googleMap.addMarker(new MarkerOptions()
					.position(lugares.get(i).getLocalizacao())
					.title(lugares.get(i).getNome())
					.snippet(lugares.get(i).getDescricao())
					.icon(BitmapDescriptorFactory
					.fromResource(seletorIconeMenu.getIcone(tipoDoLugar))));			
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
	
	public void setZoom(int zoom){
		this.zoom = zoom;
	}
	
	public void setLocatizacao(LatLng localizacao){
		this.localizacao = localizacao;
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		seletorIconeMenu = null;
		lugaresDeQuixada = null;
		lugares = null;
		marcador = null;
		super.onDestroy();
	}
}
