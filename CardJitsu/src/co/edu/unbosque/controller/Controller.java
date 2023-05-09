package co.edu.unbosque.controller;
import co.edu.unbosque.model.Mazo;

public class Controller {
	public Controller() {
		//Mazo mz= new Mazo();
	}
	public void ejecutar() {
		Mazo mz= new Mazo();
		mz.crearMazo();
		mz.test();
	}
}
