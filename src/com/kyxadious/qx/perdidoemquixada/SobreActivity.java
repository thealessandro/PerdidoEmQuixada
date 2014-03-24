package com.kyxadious.qx.perdidoemquixada;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.kyxadious.qx.perdidoemquixada.R;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class SobreActivity extends SherlockFragmentActivity {

	private ImageView imageViewLogo;
	private String tituloActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobre);

		imageViewLogo = (ImageView) findViewById(R.id.img_logo);
		
		/* Ativa o butão home do action bar */
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		/* Setting título da activity */
		tituloActivity = getResources().getString(R.string.title_activity_sobre);
		setTitle(tituloActivity);
		
		/* Setting a imagem no imageView */
		Bitmap myBitmap;
		BitmapFactory.Options options = new BitmapFactory.Options();
		myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_perdido_quixada, options);
		myBitmap = Bitmap.createScaledBitmap(myBitmap, 200, 200, false);
		imageViewLogo.setImageBitmap(myBitmap);
		
		if (myBitmap.isRecycled()) {
			myBitmap.recycle();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.sobre, menu);
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
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	// Fim onOptionsItemSelected
	

}
