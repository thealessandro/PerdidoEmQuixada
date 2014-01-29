package com.kyxadious.perdidoemquixada.model;

import java.util.ArrayList;

public class EscolherLugares {

	private ArrayList<Lugar> lugares;
	private ArrayList<Lugar> lugaresEscolhidos;

	public EscolherLugares(ArrayList<Lugar> lugares) {
		this.lugares = lugares;
	}

	public ArrayList<Lugar> getLugares(Tipo tipoDoLugar) {

		lugaresEscolhidos = new ArrayList<Lugar>();

		for (int i = 0; i < lugares.size(); i++) {
			if (lugares.get(i).getTipo() == tipoDoLugar) {
				lugaresEscolhidos.add(lugares.get(i));
			}
		}
		
		if (lugaresEscolhidos.isEmpty()) {
			return lugares;
		}

		return lugaresEscolhidos;
	}

}
