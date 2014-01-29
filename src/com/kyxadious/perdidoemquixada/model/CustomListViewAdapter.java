package com.kyxadious.perdidoemquixada.model;

import java.util.List;

import com.kyxadious.perdidoemquixada.R;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListViewAdapter extends ArrayAdapter<RowItem> {

	private Context context;
	private int idImageView;
	private int idTextView;
	private int idListItem;
	
	public CustomListViewAdapter(Context context, int idListItem, List<RowItem> items, int idImageView, int idTextView) {
		super(context, idListItem, items);
        this.context = context;
        this.idImageView = idImageView;
        this.idTextView = idTextView;
        this.idListItem = idListItem;
	}
	
	private class ViewHolder {
		ImageView imageView;
		TextView textView;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder = null;
		RowItem rowItem = getItem(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		
		if (convertView == null) {
			convertView = inflater.inflate(idListItem, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) convertView.findViewById(idImageView);
			holder.textView = (TextView) convertView.findViewById(idTextView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.textView.setText(rowItem.getText().toString());
		holder.imageView.setImageResource(rowItem.getImg());
		
		return convertView;
	}
}
