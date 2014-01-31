package com.kyxadious.perdidoemquixada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.kyxadious.perdidoemquixada.model.CustomListViewAdapter;
import com.kyxadious.perdidoemquixada.model.EscolherIcone;
import com.kyxadious.perdidoemquixada.model.EscolherLugar;
import com.kyxadious.perdidoemquixada.model.Lugar;
import com.kyxadious.perdidoemquixada.model.LugaresDeQuixada;
import com.kyxadious.perdidoemquixada.model.RowItem;
import com.kyxadious.perdidoemquixada.model.Tipo;


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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends SherlockFragmentActivity {

	
	private Marker pontoNoMapa;
	private GoogleMap googleMap;
	private LatLng quixada; 
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	
	private Tipo tipoDoLugar;
	private RowItem rowItem;
	private List<RowItem> rowItems;
	private String[] nomeDosTipos;
	private TypedArray iconeDosTipos;
	private ArrayList<Lugar> lugares;
	private EscolherIcone escolherIcone;
	private LugaresDeQuixada lugaresDeQuixada;
	
	public static final String TITULO = "com.kyxadious.perdidoemquixada.titulolugarescolhido";
	public static final String TIPO = "com.kyxadious.perdidoemquixada.tipolugarescolhido";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		mTitle = mDrawerTitle = getTitle();
		nomeDosTipos = getResources().getStringArray(R.array.itens_menu);
		iconeDosTipos = getResources().obtainTypedArray(R.array.icons_menu);
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
		mDrawerList = (ListView)findViewById(R.id.drawer_list);
		
		/* Logging */
		Log.d("ICON",String.valueOf(iconeDosTipos.getResourceId(0, 0)));
		
		//mDrawerLayout.setDrawerShadow(R.drawable.ic_drawer_shadow, GravityCompat.START);
		
		rowItems = new ArrayList<RowItem>();
		for (int i=0; i< nomeDosTipos.length; i++) {
			rowItem = new RowItem(iconeDosTipos.getResourceId(i, 0), nomeDosTipos[i]);
			rowItems.add(rowItem);
		}
		
		CustomListViewAdapter adapter = new CustomListViewAdapter(getApplicationContext(), 
																  R.layout.drawer_list_item, 
																  rowItems, 
																  R.id.imge1,
																  R.id.text1);
		mDrawerList.setAdapter(adapter);
		

		
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
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
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main, menu);
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
			
			Intent intent = new Intent(MainActivity.this, MapActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		
			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position, long id){
			selectItem(position);
		}
	}
	
	private void selectItem(int position){
		Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra(TITULO, nomeDosTipos[position]);
		
		switch(position){
		case 0:
			// Banco
			intent.putExtra(TIPO, Tipo.BANCO);
			startActivity(intent);
			break;
		case 1:
			// Bar
			intent.putExtra(TIPO, Tipo.BAR);
			startActivity(intent);
			break;
		case 2:
			// Detran
			intent.putExtra(TIPO, Tipo.DETRAN);
			startActivity(intent);
			break;
		case 3:
			// Faculdade
			intent.putExtra(TIPO, Tipo.FACULDADE);
			startActivity(intent);
			break;
		case 4:
			// Farmácia
			intent.putExtra(TIPO, Tipo.FARMACIA);
			startActivity(intent);
			break;
		case 5:
			// Hospital 
			intent.putExtra(TIPO, Tipo.HOSPITAL);
			startActivity(intent);
			break;
		case 6:
			// Hotel 
			intent.putExtra(TIPO, Tipo.HOTEL);
			startActivity(intent);
			break;
		case 7:
			// Lanchonete
			intent.putExtra(TIPO, Tipo.LANCHONETE);
			startActivity(intent);
			break;
		case 8:
			// Loja de departamento 
			intent.putExtra(TIPO, Tipo.LOJA_DE_DEPARTAMENTO);
			startActivity(intent);
			break;
		case 9:
			// Padaria
			intent.putExtra(TIPO, Tipo.PADARIA);
			startActivity(intent);
			break;
		case 10:
			// Pizzaria
			intent.putExtra(TIPO, Tipo.PIZZARIA);
			startActivity(intent);
			break;
		case 11:
			// Polícia
			intent.putExtra(TIPO, Tipo.POLICIA);
			startActivity(intent);
			break;
		case 12:
			// Restaurante 
			intent.putExtra(TIPO, Tipo.RESTAURANTE);
			startActivity(intent);
			break;
		case 13:
			// Sorveteria
			intent.putExtra(TIPO, Tipo.SORVETERIA);
			startActivity(intent);
			break;
		case 14:
			// Supermercado
			intent.putExtra(TIPO, Tipo.SUPERMERCADO);
			startActivity(intent);
			break;
		}	
		
		mDrawerList.setItemChecked(position, true);
		setTitle(nomeDosTipos[position]);
		mDrawerLayout.closeDrawer(mDrawerList);
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
		
		quixada = new LatLng(-4.970261, -39.015738);
		googleMap = ((SupportMapFragment) (getSupportFragmentManager().findFragmentById(R.id.map_main))).getMap();
		googleMap.setMyLocationEnabled(true);
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(quixada, 11));

		/* Trazendo os lugares */
		escolherIcone = new EscolherIcone();
		lugaresDeQuixada = new LugaresDeQuixada();
		lugares = lugaresDeQuixada.getLugaresDeQuixada();		

		for (int i = 0; i < lugares.size(); i++) {
			
			tipoDoLugar = lugares.get(i).getTipo();
			pontoNoMapa = googleMap.addMarker(new MarkerOptions()
					.position(lugares.get(i).getLocalizacao())
					.title(lugares.get(i).getNome())
					.icon(BitmapDescriptorFactory
					.fromResource( escolherIcone.getIcone(tipoDoLugar) )));
		}

		Log.d("QUANTIDADE_DE_LUGARES",String.valueOf(lugares.size()));
	}


}
