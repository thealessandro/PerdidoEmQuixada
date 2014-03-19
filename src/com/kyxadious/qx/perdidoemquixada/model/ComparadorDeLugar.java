package com.kyxadious.qx.perdidoemquixada.model;

import java.util.Comparator;

public class ComparadorDeLugar implements Comparator<Lugar> {

	@Override
	public int compare(Lugar primeiroLugar, Lugar segundoLugar) {
		return primeiroLugar.getNome().compareTo(segundoLugar.getNome());
	}

}
