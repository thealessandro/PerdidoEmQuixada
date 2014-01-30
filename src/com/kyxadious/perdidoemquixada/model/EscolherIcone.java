package com.kyxadious.perdidoemquixada.model;

import java.util.HashMap;

import com.kyxadious.perdidoemquixada.R;

public class EscolherIcone {

	private HashMap<Tipo, Integer> mapaIcone = new HashMap<Tipo, Integer>();

	public EscolherIcone() {
		mapaIcone.put(Tipo.TODOS, R.drawable.ic_launcher);
		mapaIcone.put(Tipo.BANCO, R.drawable.ic_banco);
		mapaIcone.put(Tipo.BAR, R.drawable.ic_bar);
		mapaIcone.put(Tipo.DETRAN, R.drawable.ic_detran);
		mapaIcone.put(Tipo.FACULDADE, R.drawable.ic_faculdade);
		mapaIcone.put(Tipo.FARMACIA, R.drawable.ic_farmacia);
		mapaIcone.put(Tipo.HOSPITAL, R.drawable.ic_hospital);
		mapaIcone.put(Tipo.HOTEL, R.drawable.ic_hotel);
		mapaIcone.put(Tipo.LANCHONETE, R.drawable.ic_lanchonete);
		mapaIcone.put(Tipo.LOJA_DE_DEPARTAMENTO, R.drawable.ic_loja_departamento);
		mapaIcone.put(Tipo.PADARIA, R.drawable.ic_padaria);
		mapaIcone.put(Tipo.PIZZARIA, R.drawable.ic_pizzaria);
		mapaIcone.put(Tipo.POLICIA, R.drawable.ic_policia);
		mapaIcone.put(Tipo.RESTAURANTE, R.drawable.ic_restaurante);
		mapaIcone.put(Tipo.SORVETERIA, R.drawable.ic_sorveteria);
		mapaIcone.put(Tipo.SUPERMERCADO, R.drawable.ic_supermercado);
	}

	public int getIcone(Tipo tipoDoLugar) {
		return mapaIcone.get(tipoDoLugar);
	}

}
