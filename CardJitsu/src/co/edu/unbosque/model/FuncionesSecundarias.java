package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesSecundarias {

	FuncionesPrincipales v1 = new FuncionesPrincipales();
    ArrayList<User> usuarios = new ArrayList<User>();;
    byte id;

    Scanner sc = new Scanner(System.in);
    
	public void asignarMazoAleatorio(String names) {
		this.usuarios=v1.getTemporalData();
		for(byte j=0;j<this.usuarios.size();j++){
			if(this.usuarios.get(j).getName().equals(names)) {
				this.id=j;
			}
		}
		Mazo mazo = new Mazo();
		this.usuarios.get(id).setMazo(mazo.crearMazoAl());
		System.out.println("Se ha asignado un mazo aleatorio al usuario " + this.usuarios.get(this.id).getName()+"\n"); 
		Data dat = new Data();
		dat.saveData(this.usuarios);
	}
	public void asignarMazoCustom(String names) {
		this.usuarios=v1.getTemporalData();
		for(byte j=0;j<this.usuarios.size();j++){
			if(this.usuarios.get(j).getName().equals(names)) {
				this.id=j;
			}
		}
		Mazo mazo = new Mazo();
		this.usuarios.get(id).setMazo(mazo.crearMazoCus((byte)1,(byte)1,(byte)1,(byte)1,this.usuarios.get(id).getMazo()));
		System.out.println("Se ha asignado un mazo custom al usuario " + this.usuarios.get(id).getName()+"\n"); 
		Data dat = new Data();
		dat.saveData(this.usuarios);
	}
	public void mostrarMazo() {	
        Carta baraja[]=new Carta[30];
        baraja = usuarios.get(id).getMazo();
		for(int i=0;i<30;i++){
			System.out.println(baraja[i].getElemento()+" - "+baraja[i].getColor()+" - "+baraja[i].getNumero());
		}
	}	
	public void jugarCPU() {
		User usuario = usuarios.get(id);
	    Gameplay match = new Gameplay(usuario); 
		match.partidaTEST();       
		match.partidaCPU();
		Data dat = new Data();
		dat.saveData(usuarios);
	}
}