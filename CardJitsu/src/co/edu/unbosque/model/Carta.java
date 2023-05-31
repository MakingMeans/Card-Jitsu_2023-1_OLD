package co.edu.unbosque.model;

import java.io.Serializable;

public class Carta implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte numero;
	private String elemento, color;

	public Carta(String elemento, byte numero, String color) {
		this.numero = numero;
		this.color = color;
		this.elemento = elemento;
	}

	public byte getNumero() {
		return numero;
	}

	public void setNumero(byte numero) {
		this.numero = numero;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}