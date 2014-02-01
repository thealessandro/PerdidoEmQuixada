package com.kyxadious.perdidoemquixada;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.GoogleMap;
import com.kyxadious.perdidoemquixada.model.CustomListViewAdapter;
import com.kyxadious.perdidoemquixada.model.EscolherLugar;
import com.kyxadious.perdidoemquixada.model.Lugar;
import com.kyxadious.perdidoemquixada.model.LugaresDeQuixada;
import com.kyxadious.perdidoemquixada.model.RowItem;
import com.kyxadious.perdidoemquixada.model.Tipo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListViewActivity extends SherlockFragmentActivity {

	private Intent intent;
	private ListView listView;
	private MenuItem menuItem;
	
	private Tipo tipoDoLugar;
	private RowItem rowItem;
	private List<RowItem> rowItems; 
	private ArrayList<Lugar> lugares;
	private LugaresDeQuixada lugaresDeQuixada;
	private EscolherLugar escolherLugar;
	private CustomListViewAdapter adapter;
	
	public static final String TITULO = "com.kyxadious.perdidoemquixada.titulolugarescolhido";
	public static final String TIPO = "com.kyxadious.perdidoemquixada.tipolugarescolhido";
	public static final String LUGAR = "com.kyxadious.perdidoemquixada.lugarescolhido";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);

		
		listView = (ListView) findViewById(R.id.list_view);
		
		/* Ativa o butão home do action bar */
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		/* Setting nome da action bar */
		intent = getIntent();
		setTitle(intent.getStringExtra(TITULO).toString());
		tipoDoLugar = (Tipo) intent.getSerializableExtra(TIPO);
		
		/* Trazendo os lugares */
		lugaresDeQuixada = new LugaresDeQuixada();
		escolherLugar = new EscolherLugar(lugaresDeQuixada.getLugaresDeQuixada());
		lugares = escolherLugar.getLugares(tipoDoLugar);
		
		/* logging do número de lugares escolhidos */
		Log.d("LUGARES_ESCOLHIDOS", String.valueOf(lugares.size()));
		
		rowItems = new ArrayList<RowItem>();
		for (int i = 0; i < lugares.size(); i++ ) {
			rowItem = new RowItem();
			rowItem.setImg(lugares.get(i).getIdImag());
			rowItem.setText(lugares.get(i).getNome());
			rowItems.add(rowItem);
		}
		
		//mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mFragmentTitles));
		
		
		adapter = new CustomListViewAdapter(getApplicationContext(), 
																  R.layout.lugares_list_item, 
																  rowItems,
																  R.id.image_view_lugar,
																  R.id.text_view_lugar);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
				
				TextView nome = (TextView) view.findViewById(R.id.text_view_lugar);
				ImageView imagem = (ImageView) view.findViewById(R.id.image_view_lugar);
				
				Lugar lugarProcurado = lugaresDeQuixada.getLugar(nome.getText().toString());
				Intent intent = new Intent(getApplicationContext(), LugarActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
				intent.putExtra(LUGAR, lugarProcurado);
				intent.putExtra(TITULO, getTitle().toString());
				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.list_view, menu);
		menuItem = menu.add(0, R.id.action_mapa, 0, null);
		menuItem.setIcon(R.drawable.ic_mapa).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		//getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Início onOptionsItemSelected
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;

		switch (item.getItemId()) {
		case android.R.id.home:
			intent = new Intent(getApplicationContext(), MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		case R.id.action_mapa:
			intent = new Intent(getApplicationContext(), MapActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra(TITULO, getTitle().toString());
			intent.putExtra(TIPO, tipoDoLugar);
			startActivity(intent);
			return true;	
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	// Fim onOptionsItemSelected

}
