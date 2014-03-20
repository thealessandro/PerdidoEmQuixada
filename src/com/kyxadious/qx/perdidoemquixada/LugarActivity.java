package com.kyxadious.qx.perdidoemquixada;

import java.util.Locale;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.model.LatLng;
import com.kyxadious.qx.perdidoemquixada.R;
import com.kyxadious.qx.perdidoemquixada.model.Lugar;
import com.kyxadious.qx.perdidoemquixada.model.SeletorTipoDoLugar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class LugarActivity extends SherlockFragmentActivity {

	private Intent intent;
	private ImageView imageViewImagem;
	private TextView textViewNome;
	private TextView textViewDescricao;
	private TextView textViewEndereco;
	private MenuItem menuItemGPS;
	private MenuItem menuItemMapa;
	private Lugar novoLugar;
	private SeletorTipoDoLugar nomeDoTipoDoLugar;

	public static final String TITULO = "com.kyxadious.perdidoemquixada.titulolugarescolhido";
	public static final String TIPO = "com.kyxadious.perdidoemquixada.tipolugarescolhido";
	public static final String LUGAR = "com.kyxadious.perdidoemquixada.lugarescolhido";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lugar);
		
		nomeDoTipoDoLugar = new SeletorTipoDoLugar();
			
		/* Componentes UI */
		imageViewImagem = (ImageView) findViewById(R.id.image_view_imagem_lugar);
		textViewNome = (TextView) findViewById(R.id.text_view_nome_lugar);
		textViewDescricao = (TextView) findViewById(R.id.text_view__descricao_lugar);
		textViewEndereco = (TextView) findViewById(R.id.text_view__endereco_lugar);

		/* Ativa o butão home do action bar */
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		/* Intent */
		intent = getIntent();
		novoLugar = (Lugar) intent.getSerializableExtra(LUGAR);
		setTitle(nomeDoTipoDoLugar.getNomeTipoDoLugar(novoLugar.getTipo()));

		/* Getting o width da tela */	
		Display display = getWindowManager().getDefaultDisplay(); 
		int width = display.getWidth();  // deprecated
		Bitmap myBitmap = null;	
		/* Setting a imagem no imageView */
		BitmapFactory.Options options = new BitmapFactory.Options();
		myBitmap = BitmapFactory.decodeResource(getResources(), novoLugar.getIdImag(), options);
		myBitmap = Bitmap.createScaledBitmap(myBitmap, width, width, false);
		imageViewImagem.setImageBitmap(myBitmap);
		
		/* Reciclando o myBitmap */ 
		if (myBitmap.isRecycled()) {
			myBitmap.recycle();
		}
	
		/* Setting o nome do lugar */
		textViewNome.setText(novoLugar.getNome());
		/* Setting a descrição do lugar */
		textViewDescricao.setText(novoLugar.getDescricao());
		/* Setting o endereço do lugar */
		textViewEndereco.setText(novoLugar.getEndereco());
		
		/* Ativar GPS do dispositivo */
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		if (!(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))) {
			ativarGPS();
		}

	}

	
	// Início ativarGPS
	private void ativarGPS() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setMessage("O GPS do seu dispositivo está desabilitado. É fortemente recomendado que você habilite seu GPS para poder traçar rotas até o lugar desejado.");
		alertDialogBuilder.setPositiveButton("Ativar GPS", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent gpsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
						startActivity(gpsIntent);
					}
				});
		alertDialogBuilder.setNegativeButton("Cancelar", null);
		alertDialogBuilder.show();
	}
	// Fim ativarGPS

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menuItemMapa = menu.add(0, R.id.action_mapa, 0, null);
		menuItemMapa.setIcon(R.drawable.ic_mapa).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		menuItemGPS = menu.add(0, R.id.action_gps, 0, null);
		menuItemGPS.setIcon(R.drawable.ic_gps).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		// getSupportMenuInflater().inflate(R.menu.main, menu);
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
		case R.id.action_gps:
			try {
				String uri = String.format(Locale.ENGLISH, "google.navigation:q=%f,%f", novoLugar.getLat(), novoLugar.getLng());
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
				startActivity(intent);
			} catch (Exception e) {
				Log.d("SEM GOOGLE MAPS", e.toString());
				Toast.makeText(getApplicationContext(), "Oops! Você não tem instalado o Google Mapas em seu dispositivo.", Toast.LENGTH_LONG).show();
			}
			return true;
		case R.id.action_mapa:
			intent = new Intent(getApplicationContext(), MapActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra(TITULO, getTitle().toString());
			intent.putExtra(TIPO, novoLugar.getTipo());
			intent.putExtra(LUGAR, novoLugar);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	// Fim onOptionsItemSelected

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		nomeDoTipoDoLugar = null;
		super.onDestroy();
	}
}
