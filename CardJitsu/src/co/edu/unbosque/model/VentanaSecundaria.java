package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Scanner;

public class VentanaSecundaria {

    VentanaPrincipal v1 = new VentanaPrincipal();
    ArrayList<User> usuarios = new ArrayList<User>();;
    byte id;

    Scanner sc = new Scanner(System.in);
    
    public void ejecutarSecundaria() {
        boolean seguirEjecutando2 = true;
        VentanaPrincipal v1 = new VentanaPrincipal();
        usuarios = v1.temporalData();
        id = v1.loginId();

	    while(seguirEjecutando2) {
			System.out.println("Digite la opcion deseada: ");
	       	System.out.println("1. Estatus");
	        System.out.println("2. Asignar mazo custom");
			System.out.println("3. Asignar mazo aleatorio");
	        System.out.println("4. Mostrar mazo");
	        System.out.println("5. Partida CPU");
	        System.out.println("6. Log out");
	        byte seleccionSecundaria = sc.nextByte();
	
	        switch(seleccionSecundaria) {
		        case 1:
		            datosUsuario();
		            ejecutarSecundaria();
		            break;
		        case 2:
		        	asignarMazoCustom();
		        	ejecutarSecundaria();
		        	break;
				case 3:
		        	asignarMazoAleatorio();
		        	ejecutarSecundaria();
		        	break;
		        case 4:
		        	mostrarMazo();
		        	ejecutarSecundaria();
		        	break;
		        case 5:
		        	jugarCPU();
		        	ejecutarSecundaria();
		        	break;
		        case 6:
					seguirEjecutando2 = false;
		        	break;
		        default:
		        	System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
		        	ejecutarSecundaria();
	                break;
		    }
	    }
	}
    public void datosUsuario(){
		System.out.println("\nSu usuario: "+usuarios.get(id).getName());
		System.out.println("Su ID: "+usuarios.get(id).getId());
		System.out.println("Su cinturon: "+usuarios.get(id).getCinturon());
		System.out.println("Su puntaje: "+usuarios.get(id).getPuntaje());
		System.out.println("Puntos necesarios para siguiente cinturon: "+usuarios.get(id).getNextLv()+"\n");
	}
	public void asignarMazoAleatorio() {
		Mazo mazo = new Mazo();
		usuarios.get(id).setMazo(mazo.crearMazoAl());
		System.out.println("Se ha asignado un mazo aleatorio al usuario " + usuarios.get(id).getName()+"\n"); 
	}
	public void asignarMazoCustom() {
		Mazo mazo = new Mazo();
		usuarios.get(id).setMazo(mazo.crearMazoCus());
		System.out.println("Se ha asignado un mazo custom al usuario " + usuarios.get(id).getName()+"\n"); 
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
	}
}
