package co.edu.unbosque.model;

public class Carta {

	private byte numero;
	private String elemento, color;

	public Carta(String elemento, byte numero, String color) {
		this.numero = numero;
		this.color = color;
		this.elemento = elemento;
	}

	/*public Triple<String, Integer, String> getAtributos() {
        return new Triple<String, Integer, String>(elemento, numero, color);
    }*/

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
