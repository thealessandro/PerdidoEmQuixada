package com.kyxadious.qx.perdidoemquixada.model;

public class ItemListView {

	private int imagem;
	private String texto;

	public ItemListView() {

	}

	public ItemListView(int imagem, String texto) {
		this.imagem = imagem;
		this.texto = texto;
	}

	public int getImagem() {
		return imagem;
	}

	public void setImagem(int imagem) {
		this.imagem = imagem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
