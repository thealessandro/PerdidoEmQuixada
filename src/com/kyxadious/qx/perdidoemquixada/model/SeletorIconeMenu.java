package com.kyxadious.qx.perdidoemquixada.model;

import java.util.HashMap;

import com.kyxadious.qx.perdidoemquixada.R;

public class SeletorIconeMenu {

	private HashMap<CategoriaLugar, Integer> mapaIcone = new HashMap<CategoriaLugar, Integer>();

	public SeletorIconeMenu() {
		mapaIcone.put(CategoriaLugar.BANCO, R.drawable.ic_banco);
		mapaIcone.put(CategoriaLugar.BAR, R.drawable.ic_bar);
		mapaIcone.put(CategoriaLugar.CINEMA, R.drawable.ic_cinema);
		mapaIcone.put(CategoriaLugar.DETRAN, R.drawable.ic_detran);
		mapaIcone.put(CategoriaLugar.FACULDADE, R.drawable.ic_faculdade);
		mapaIcone.put(CategoriaLugar.FARMACIA, R.drawable.ic_farmacia);
		mapaIcone.put(CategoriaLugar.HOSPITAL, R.drawable.ic_hospital);
		mapaIcone.put(CategoriaLugar.HOTEL, R.drawable.ic_hotel);
		mapaIcone.put(CategoriaLugar.LANCHONETE, R.drawable.ic_lanchonete);
		mapaIcone.put(CategoriaLugar.LOJA_DE_DEPARTAMENTO, R.drawable.ic_loja_departamento);
		mapaIcone.put(CategoriaLugar.PADARIA, R.drawable.ic_padaria);
		mapaIcone.put(CategoriaLugar.PIZZARIA, R.drawable.ic_pizzaria);
		mapaIcone.put(CategoriaLugar.POLICIA, R.drawable.ic_policia);
		mapaIcone.put(CategoriaLugar.RESTAURANTE, R.drawable.ic_restaurante);
		mapaIcone.put(CategoriaLugar.SORVETERIA, R.drawable.ic_sorveteria);
		mapaIcone.put(CategoriaLugar.SUPERMERCADO, R.drawable.ic_supermercado);
	}

	public int getIcone(CategoriaLugar tipoDoLugar) {
		return mapaIcone.get(tipoDoLugar);
	}

}
