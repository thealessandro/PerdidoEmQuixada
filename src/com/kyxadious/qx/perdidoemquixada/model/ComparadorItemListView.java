package com.kyxadious.qx.perdidoemquixada.model;

import java.util.Comparator;

public class ComparadorItemListView implements Comparator<ItemListView>{

	@Override
	public int compare(ItemListView primeiro, ItemListView segundo) {
		return  primeiro.getTexto().compareTo(segundo.getTexto());
	}

}
