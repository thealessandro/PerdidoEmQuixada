package com.kyxadious.perdidoemquixada;

import java.util.Locale;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.model.LatLng;
import com.kyxadious.perdidoemquixada.model.Lugar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
	private MenuItem menuItem;
	private Lugar novoLugar;

	public static final String LUGAR = "com.kyxadious.perdidoemquixada.lugarescolhido";
	public static final String TITULO = "com.kyxadious.perdidoemquixada.titulolugarescolhido";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lugar);

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
		setTitle(intent.getStringExtra(TITULO).toString());
		novoLugar = (Lugar) intent.getSerializableExtra(LUGAR);

		/* Setting o novo lugar */
		imageViewImagem.setScaleType(ScaleType.FIT_XY);
		imageViewImagem.setImageResource(novoLugar.getIdImag());
		textViewNome.setText(novoLugar.getNome());
		textViewDescricao.setText(novoLugar.getDescricao());
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
		alertDialogBuilder.setMessage("O GPS do seu dispositivo está desabilitado. É fortemente recomendado que você habilite seu GPS.");
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

		menuItem = menu.add(0, R.id.action_settings, 0, null);
		menuItem.setIcon(R.drawable.ic_gps).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_ALWAYS);
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
		case R.id.action_settings:
			try {
				String uri = String.format(Locale.ENGLISH,
						"google.navigation:q=%f,%f", novoLugar.getLat(),
						novoLugar.getLng());
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
				startActivity(intent);
			} catch (Exception e) {
				Log.d("SEM GOOGLE MAPS", e.toString());
				Toast.makeText(getApplicationContext(), "Oops! Você não tem instalado o Google Mapas em seu dispositivo.", Toast.LENGTH_LONG).show();
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	// Fim onOptionsItemSelected

}
