package com.ats.beans;

import java.io.Serializable;

public class AutoBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int targa;
	private String marca;
	private String modello;
	private double prezzo;

	public AutoBeans(){

	}

	public int getTarga() {
		return targa;
	}

	public void setTarga(int targa) {
		this.targa = targa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "AutoBeans [targa=" + targa + ", marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo + "]";
	}
	
	


}
