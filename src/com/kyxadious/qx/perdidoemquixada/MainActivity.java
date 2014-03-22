package com.kyxadious.qx.perdidoemquixada;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kyxadious.qx.perdidoemquixada.R;
import com.kyxadious.qx.perdidoemquixada.model.ListViewAdapter;
import com.kyxadious.qx.perdidoemquixada.model.ListViewAdapterMenu;
import com.kyxadious.qx.perdidoemquixada.model.ListaMenuClassificacaoLugares;
import com.kyxadious.qx.perdidoemquixada.model.SeletorIconeMenu;
import com.kyxadious.qx.perdidoemquixada.model.Lugar;
import com.kyxadious.qx.perdidoemquixada.model.LugaresDeQuixada;
import com.kyxadious.qx.perdidoemquixada.model.ItemListView;
import com.kyxadious.qx.perdidoemquixada.model.SeletorTipoDoLugar;
import com.kyxadious.qx.perdidoemquixada.model.CategoriaLugar;


import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Advanceable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends SherlockFragmentActivity {
	
	private LatLng localizacao; 
	private GoogleMap googleMap;
	private Marker pontoNoMapa, ultimoPontoNoMapa;
	
	private MenuItem menuItem;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	
	private CategoriaLugar tipoDoLugar;
	private ArrayList<Lugar> lugares;
	private SeletorIconeMenu seletorIconeMenu;
	private LugaresDeQuixada lugaresDeQuixada;
	private SeletorTipoDoLugar seletorTipoDoLugar;
	private ListaMenuClassificacaoLugares menuClassificacaoLugares;
	
	public static final String TITULO = "com.kyxadious.perdidoemquixada.titulolugarescolhido";
	public static final String TIPO = "com.kyxadious.perdidoemquixada.tipolugarescolhido";
	public static final String LUGAR = "com.kyxadious.perdidoemquixada.lugarescolhido";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
		mDrawerList = (ListView)findViewById(R.id.drawer_list);
		
		/* Trazendo os lugares */
		menuClassificacaoLugares = new ListaMenuClassificacaoLugares();
		seletorTipoDoLugar = new SeletorTipoDoLugar();
		seletorIconeMenu = new SeletorIconeMenu();
		lugaresDeQuixada = new LugaresDeQuixada();
		
		// Trazendo todo os lugares
		lugares = lugaresDeQuixada.getLugaresDeQuixada();
	
		
		// Colocando os itens no menu
		ArrayList<ItemListView> itensListViewMenu = menuClassificacaoLugares.getLista();  
		ListViewAdapterMenu adapter = new ListViewAdapterMenu(getApplicationContext(), R.layout.drawer_list_item, itensListViewMenu, R.id.imge1, R.id.text1);
		mDrawerList.setAdapter(adapter);
		
		// Aqui a mágica acontece quando um item do menu de lugar é clicado
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				TextView textViewNomeDaCategoriaDoLugar = (TextView) view.findViewById(R.id.text1);
			 	
			 	Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra(TITULO, textViewNomeDaCategoriaDoLugar.getText().toString());
				startActivity(intent);
				
				Log.d("BUG-TEXTO", textViewNomeDaCategoriaDoLugar.getText().toString());
			
				
				// Após escolher o lugar, o drawer fecha
				mDrawerLayout.closeDrawer(mDrawerList);
				
			}
		});
		
		
		
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		mDrawerToggle = new ActionBarDrawerToggle(this, 
				mDrawerLayout, 
				R.drawable.ic_drawer, 
				R.string.drawer_open, 
				R.string.drawer_close){
			public void onDrawerClosed(View v){
				getSupportActionBar().setTitle(mTitle);
				supportInvalidateOptionsMenu();
			}
			public void onDrawerOpened(View v){
				getSupportActionBar().setTitle(mDrawerTitle);
				supportInvalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		if (savedInstanceState == null){
			// Se está comentado é porque tem um motivo muito importante
			//selectItem(0);
		}
		
		/* Mapa principal */
		mapaPrincipal();
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menuItem = menu.add(0, R.id.action_settings, 0, null);
		menuItem.setIcon(R.drawable.ic_sobre).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		//getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case android.R.id.home:
			if (mDrawerLayout.isDrawerOpen(mDrawerList)){
				mDrawerLayout.closeDrawer(mDrawerList);
			} else {
				mDrawerLayout.openDrawer(mDrawerList);
			}
			return true;
		case R.id.action_settings:
			Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
		
	
	@Override
	public void setTitle(CharSequence title){
		mTitle = title;
		getSupportActionBar().setTitle(title);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState){
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	public void mapaPrincipal(){
		
		localizacao = new LatLng(-4.968679,-39.017086); 
		googleMap = ((SupportMapFragment) (getSupportFragmentManager().findFragmentById(R.id.map_main))).getMap();
		googleMap.setMyLocationEnabled(true);
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localizacao, 14));		

		for (int i = 0; i < lugares.size(); i++) {
			tipoDoLugar = lugares.get(i).getTipo();
			pontoNoMapa = googleMap.addMarker(new MarkerOptions()
					.position(lugares.get(i).getLocalizacao())
					.title(lugares.get(i).getNome())
					.snippet(lugares.get(i).getDescricao())
					.icon(BitmapDescriptorFactory
					.fromResource( seletorIconeMenu.getIcone(tipoDoLugar) )));
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
	
		Log.d("QUANTIDADE_DE_LUGARES",String.valueOf(lugares.size()));
		
	}

	@Override
	protected void onDestroy() {
	
		seletorTipoDoLugar = null;
		seletorIconeMenu = null;
		lugaresDeQuixada = null;
		menuClassificacaoLugares = null;
		lugares = null;
		
		super.onDestroy();
	}
	

}
