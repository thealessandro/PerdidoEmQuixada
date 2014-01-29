package com.kyxadious.perdidoemquixada.model;

import android.R.string;

public class RowItem {

	private int img;
	private String text;

	public RowItem() {

	}

	public RowItem(int img, String text) {
		this.img = img;
		this.text = text;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
