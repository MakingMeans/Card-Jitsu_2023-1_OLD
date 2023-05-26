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
	public byte asignarMazoCustom(String names, byte idC, byte numC, String elementC, String colorC) {
		this.usuarios=v1.getTemporalData();
		for(byte j=0;j<this.usuarios.size();j++){
			if(this.usuarios.get(j).getName().equals(names)) {
				this.id=j;
			}
		}
		byte cartaRemplazar = idC;
		byte cartaExistente = 0;
		Carta card[] = new Carta[30];
		card=this.usuarios.get(id).getMazo();
			boolean repetida = false;
			Carta preCard = new Carta(elementC, numC, colorC);
			for(byte j = 0; j < 30; j++){
				if(card[j].getElemento().equals(preCard.getElemento()) && 
				card[j].getColor().equals(preCard.getColor()) && 
				card[j].getNumero() == preCard.getNumero()) {
					repetida = true;
					cartaExistente=(byte)(j+1);
				}
			}
			if(repetida == false) {
				card[cartaRemplazar] = preCard;
			}
			else {
				return cartaExistente;
			}
		this.usuarios.get(id).setMazo(card);
		System.out.println("Se ha asignado un mazo custom al usuario " + this.usuarios.get(id).getName()+"\n"); 
		Data dat = new Data();
		dat.saveData(this.usuarios);
		return 0;
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