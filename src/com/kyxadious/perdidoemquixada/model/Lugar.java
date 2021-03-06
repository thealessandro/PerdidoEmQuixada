package com.kyxadious.perdidoemquixada.model;

import java.io.Serializable;
import com.google.android.gms.maps.model.LatLng;

public class Lugar implements Serializable{

	private String nome;
	private int idImag;
	private Tipo tipo;
	private String descricao;
	private double lat;
	private double lng;
	private String endereco;

	public Lugar() {

	}

	public Lugar(String nome, int idImag, Tipo tipo, String descricao,
			double lat, double lng, String endereco) {
		this.nome = nome;
		this.idImag = idImag;
		this.tipo = tipo;
		this.descricao = descricao;
		this.lat = lat;
		this.lng = lng;
		this.endereco = endereco;
	}

	public LatLng getLocalizacao() {
		return new LatLng(lat, lng);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdImag() {
		return idImag;
	}

	public void setIdImag(int idImag) {
		this.idImag = idImag;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
