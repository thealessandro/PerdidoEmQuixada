package com.kyxadious.qx.perdidoemquixada.model;

import java.io.File;
import java.text.BreakIterator;
import java.util.List;
import java.util.Formatter.BigDecimalLayoutForm;

import com.google.android.gms.internal.bm;
import com.kyxadious.qx.perdidoemquixada.R;

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


public class ListViewAdapterMenu extends ArrayAdapter<ItemListView>{


	private Context context;
	private int idImageView;
	private int idTextView;
	private int idListItem;

	public ListViewAdapterMenu(Context context, int idListItem,
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
		
		System.gc();
		
		View v = convertView;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		ViewHolder holder;
		ItemListView rowItem = getItem(position);

		if (v == null) {
			v = inflater.inflate(idListItem, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) v.findViewById(idImageView);
			holder.textView = (TextView) v.findViewById(idTextView);
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}

		holder.textView.setText(rowItem.getTexto().toString());
		Bitmap myBitmap = null;	
		
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(context.getResources(), rowItem.getImagem(), options);
		Bitmap.createBitmap(options.outHeight, options.outHeight, Bitmap.Config.ARGB_8888);
		options.inJustDecodeBounds = false;
		//options.inBitmap = bitmap;
		options.inSampleSize = 1; // 1/8th of actual image.
		myBitmap = BitmapFactory.decodeResource(context.getResources(), rowItem.getImagem(), options);
		holder.imageView.setImageBitmap(myBitmap);
		
		holder.imageView.clearColorFilter();
		
		if (myBitmap.isRecycled()) {
			myBitmap.recycle();
		}
		
		return v;
	}

}


