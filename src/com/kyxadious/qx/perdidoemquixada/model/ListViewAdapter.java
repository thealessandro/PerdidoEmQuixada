package com.kyxadious.qx.perdidoemquixada.model;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<ItemListView> {

	private Context context;
	private int idImageView;
	private int idTextView;
	private int idListItem;

	public ListViewAdapter(Context context, int idListItem,
			List<ItemListView> items, int idImageView, int idTextView) {
		super(context, idListItem, items);
		this.context = context;
		this.idImageView = idImageView;
		this.idTextView = idTextView;
		this.idListItem = idListItem;
	}

	private static class ViewHolder {
		public ImageView imageView;
		public TextView textView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
			
		View view = convertView;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		ViewHolder holder;
		ItemListView rowItem = getItem(position);

		if (view == null) {
			view = inflater.inflate(idListItem, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) view.findViewById(idImageView);
			holder.textView = (TextView) view.findViewById(idTextView);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		// Setando o texto no item 
		holder.textView.setText(rowItem.getTexto().toString()); // Setando o texto no textView
		
		// Setando a imagem no item na escala de 100x100
		Bitmap myBitmap;	
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(context.getResources(), rowItem.getImagem(), options);
		Bitmap.createBitmap(options.outHeight, options.outHeight, Bitmap.Config.ARGB_8888);
		options.inJustDecodeBounds = false;
		options.inSampleSize = 6; // 1/8th of actual image.
		myBitmap = BitmapFactory.decodeResource(context.getResources(), rowItem.getImagem(), options);
		myBitmap = Bitmap.createScaledBitmap(myBitmap, 100, 100, false); // resize bitmap
		holder.imageView.setImageBitmap(myBitmap); // Setando o bitmap no imageView
		
		if (myBitmap.isRecycled()) {
			myBitmap.recycle(); // Reciclando o myBitmap
		}
		
		return view;
	}
}
