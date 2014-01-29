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
import com.kyxadious.perdidoemquixada.model.EscolherLugares;
import com.kyxadious.perdidoemquixada.model.Lugar;
import com.kyxadious.perdidoemquixada.model.LugaresDeQuixada;
import com.kyxadious.perdidoemquixada.model.RowItem;
import com.kyxadious.perdidoemquixada.model.Tipo;


import android.content.Intent;
import android.content.res.Configuration;
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

	
	private GoogleMap googleMap;
	private LugaresDeQuixada lugaresDeQuixada = new LugaresDeQuixada();
	static final LatLng QUIXADA = new LatLng(-4.970261, -39.015738);
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mFragmentTitles;
	
	RowItem rowItem;
	List<RowItem> rowItems = new ArrayList<RowItem>();
	public static final Integer[] icons = { R.drawable.ic_launcher, 
											  R.drawable.ic_launcher, 
											  R.drawable.ic_launcher,
											  R.drawable.ic_launcher,
											  R.drawable.ic_launcher}; 
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		mTitle = mDrawerTitle = getTitle();
		mFragmentTitles = getResources().getStringArray(R.array.itens_menu);
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
		mDrawerList = (ListView)findViewById(R.id.drawer_list);
		
		//mDrawerLayout.setDrawerShadow(R.drawable.ic_drawer_shadow, GravityCompat.START);
		
		
	
		
		for (int i=0; i< mFragmentTitles.length; i++) {
			rowItem = new RowItem(icons[i], mFragmentTitles[i]);
			rowItems.add(rowItem);
			
		}
		//mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mFragmentTitles));
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
			selectItem(0);
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
			
			//Fragment newFragment = new Fragment_1();
			//FragmentManager fm = getSupportFragmentManager();
			
			Intent intent = new Intent(MainActivity.this, MapActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			//Sources sources = new Sources();
			
		
			//fm.beginTransaction()
			//.replace(R.id.content_frame, sources)
			//.commit();
			
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
		Intent intent;
		
		switch(position){
		case 1:
			intent = new Intent(getApplicationContext(), ListViewActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("NOME-ACTION-BAR", mFragmentTitles[position]);
			startActivity(intent);
			break;
		case 2:
		
			break;
		case 3:
		
			break;
		case 4:
		
			break;
		}
		
		
		mDrawerList.setItemChecked(position, true);
		setTitle(mFragmentTitles[position]);
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
		googleMap = ((SupportMapFragment) (getSupportFragmentManager()
				.findFragmentById(R.id.map_main))).getMap();
		googleMap.setMyLocationEnabled(true);
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(QUIXADA, 11));

		Marker municipio;
		ArrayList<Lugar> lugares = lugaresDeQuixada.getLugaresDeQuixada();
		Log.d("DEBUG-1-QUANTIDADE-LUGARES", String.valueOf(lugares.size()));

		EscolherLugares escolherLugares = new EscolherLugares(lugares);
		Log.d("DEBUG-2-QUANTIDADE-LUGARES", String.valueOf(lugares.size()));

		ArrayList<Lugar> lugaresEscolhidos = escolherLugares
				.getLugares(Tipo.TODOS);
		
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


}
