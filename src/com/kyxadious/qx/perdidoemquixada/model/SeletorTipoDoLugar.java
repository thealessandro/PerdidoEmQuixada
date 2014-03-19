package com.kyxadious.qx.perdidoemquixada.model;

import java.util.HashMap;

public class SeletorTipoDoLugar {

	private HashMap<CategoriaLugar, String> nomeDoLugar;
	private HashMap<String, CategoriaLugar> tipoDoLugar;
	
	public SeletorTipoDoLugar() {
		
		nomeDoLugar = new HashMap<CategoriaLugar, String>();
		nomeDoLugar.put(CategoriaLugar.BANCO, "Banco");
		nomeDoLugar.put(CategoriaLugar.BAR, "Bar");
		nomeDoLugar.put(CategoriaLugar.CINEMA, "Cinema");
		nomeDoLugar.put(CategoriaLugar.DETRAN, "Detran");
		nomeDoLugar.put(CategoriaLugar.FACULDADE, "Faculdade");
		nomeDoLugar.put(CategoriaLugar.FARMACIA, "Farmácia");
		nomeDoLugar.put(CategoriaLugar.HOSPITAL, "Hospital");
		nomeDoLugar.put(CategoriaLugar.HOTEL, "Hotel");
		nomeDoLugar.put(CategoriaLugar.LANCHONETE, "Lanchonete");
		nomeDoLugar.put(CategoriaLugar.LOJA_DE_DEPARTAMENTO, "Loja de departamento");
		nomeDoLugar.put(CategoriaLugar.PADARIA, "Padaria");
		nomeDoLugar.put(CategoriaLugar.PIZZARIA, "Pizzaria");
		nomeDoLugar.put(CategoriaLugar.POLICIA, "Polícia");
		nomeDoLugar.put(CategoriaLugar.RESTAURANTE, "Restaurante");
		nomeDoLugar.put(CategoriaLugar.SORVETERIA, "Sorveteria");
		nomeDoLugar.put(CategoriaLugar.SUPERMERCADO, "Supermercado");
		
		tipoDoLugar = new HashMap<String, CategoriaLugar>();
		tipoDoLugar.put("Banco", CategoriaLugar.BANCO);
		tipoDoLugar.put("Bar", CategoriaLugar.BAR);
		tipoDoLugar.put("Cinema", CategoriaLugar.CINEMA);
		tipoDoLugar.put("Detran", CategoriaLugar.DETRAN);
		tipoDoLugar.put("Faculdade", CategoriaLugar.FACULDADE);
		tipoDoLugar.put("Farmácia", CategoriaLugar.FARMACIA);
		tipoDoLugar.put("Hospital", CategoriaLugar.HOSPITAL);
		tipoDoLugar.put("Hotel", CategoriaLugar.HOTEL);
		tipoDoLugar.put("Lanchonete", CategoriaLugar.LANCHONETE);
		tipoDoLugar.put("Loja de departamento", CategoriaLugar.LOJA_DE_DEPARTAMENTO);
		tipoDoLugar.put("Padaria", CategoriaLugar.PADARIA);
		tipoDoLugar.put("Pizzaria", CategoriaLugar.PIZZARIA);
		tipoDoLugar.put("Polícia", CategoriaLugar.POLICIA);
		tipoDoLugar.put("Restaurante", CategoriaLugar.RESTAURANTE);
		tipoDoLugar.put("Sorveteria", CategoriaLugar.SORVETERIA);
		tipoDoLugar.put("Supermercado", CategoriaLugar.SUPERMERCADO);
		
	}
	
	public String getNomeTipoDoLugar(CategoriaLugar meuTipo){
		return nomeDoLugar.get(meuTipo);
	}
	
	public CategoriaLugar getCategoriaDoLugar(String meuLugar){
		return tipoDoLugar.get(meuLugar);
	}

}
