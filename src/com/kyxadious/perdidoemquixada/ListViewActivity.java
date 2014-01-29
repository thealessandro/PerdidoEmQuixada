package com.kyxadious.perdidoemquixada;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.kyxadious.perdidoemquixada.model.CustomListViewAdapter;
import com.kyxadious.perdidoemquixada.model.RowItem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewActivity extends SherlockFragmentActivity {



	RowItem rowItem;
	List<RowItem> rowItems = new ArrayList<RowItem>();
	public static final String[] titles = {"text", "text", "text", "text", "text"};
	public static final Integer[] icons = { R.drawable.ic_hospital,
			R.drawable.ic_adele, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);

		/* Ativa o butão home do action bar */
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		/* Setting nome da action bar */
		Intent intent = getIntent();
		setTitle(intent.getStringExtra("NOME-ACTION-BAR").toString());
		
		ListView listView = (ListView) findViewById(R.id.list_view);
		
		for (int i=0; i < titles.length; i++) {
			rowItem = new RowItem(icons[i], titles[i]);
			rowItems.add(rowItem);
			
		}
		//mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mFragmentTitles));
		CustomListViewAdapter adapter = new CustomListViewAdapter(getApplicationContext(), 
																  R.layout.lugares_list_item, 
																  rowItems,
																  R.id.image_view_lugar,
																  R.id.text_view_lugar);
		listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.list_view, menu);
		getSupportMenuInflater().inflate(R.menu.main, menu);
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
