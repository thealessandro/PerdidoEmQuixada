package com.kyxadious.qx.perdidoemquixada.model;

import java.util.ArrayList;
import java.util.Collections;

import com.kyxadious.qx.perdidoemquixada.R;

public class ListaMenuClassificacaoLugares {
	
	private ArrayList<ItemListView> items;
	
	public ListaMenuClassificacaoLugares() {
		items = new ArrayList<ItemListView>();
		items.add(new ItemListView(R.drawable.ic_banco, "Banco"));
		items.add(new ItemListView(R.drawable.ic_bar, "Bar"));
		items.add(new ItemListView(R.drawable.ic_cinema, "Cinema"));
		items.add(new ItemListView(R.drawable.ic_detran, "Detran"));
		items.add(new ItemListView(R.drawable.ic_faculdade, "Faculdade"));
		items.add(new ItemListView(R.drawable.ic_farmacia, "Farmácia"));
		items.add(new ItemListView(R.drawable.ic_hospital, "Hospital"));
		items.add(new ItemListView(R.drawable.ic_hotel, "Hotel"));
		items.add(new ItemListView(R.drawable.ic_lanchonete, "Lanchonete"));
		items.add(new ItemListView(R.drawable.ic_loja_departamento, "Loja de departamento"));
		items.add(new ItemListView(R.drawable.ic_padaria, "Padaria"));
		items.add(new ItemListView(R.drawable.ic_pizzaria, "Pizzaria"));
		items.add(new ItemListView(R.drawable.ic_policia, "Polícia"));
		items.add(new ItemListView(R.drawable.ic_restaurante, "Restaurante"));
		items.add(new ItemListView(R.drawable.ic_sorveteria, "Sorveteria"));
		items.add(new ItemListView(R.drawable.ic_supermercado, "Supermercado"));
	}
	
	public ArrayList<ItemListView> getLista(){
		Collections.sort(items, new ComparadorItemListView());
		return items;
	}

}
