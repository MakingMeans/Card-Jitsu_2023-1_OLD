package co.edu.unbosque.controller;
import co.edu.unbosque.model.Mazo;
import co.edu.unbosque.model.User;
import co.edu.unbosque.model.Carta;
import co.edu.unbosque.model.Gameplay;

//usuarios shit
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.Scanner;
public class Controller {
	public Controller() {
	}
	//funciones y variables de usuario
	byte id;
	String name,cinturon;
    int puntaje;
	
	Scanner sc = new Scanner(System.in);
	Carta baraja[]=new Carta[30];
	ArrayList<User> usuarios = new ArrayList<User>();
	//usuarios shit
	public void saveData(){
		try {
			FileOutputStream fileOut = new FileOutputStream("usersData.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(usuarios);
			out.close();
			fileOut.close();
			System.out.println("Los datos de los usuarios se han guardado correctamente.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ejecutarPrincipal() {
	    boolean seguirEjecutando = true;
		//usuarios shit
		try {
			FileInputStream fileIn = new FileInputStream("usersData.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			usuarios = (ArrayList<User>) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Los datos de los usuarios se han cargado correctamente.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}		
	    while(seguirEjecutando) {
	    	 System.out.println("---!Card-Jitsu!---");
	         System.out.println("Digite la opcion deseada: ");
	         System.out.println("1. Crear usuario");
	         System.out.println("2. Log in");
	         System.out.println("3. Salir");
	        byte seleccionPrincipal = sc.nextByte();
	        switch(seleccionPrincipal) {
	            case 1:
	                crearUsuario();
					saveData();
	                break;
	            case 2:
	                ingresarUsuario();
	                ejecutarSecundaria();
	                System.out.println("Digite la opcion deseada: ");
	                break;
	            case 3:
	                seguirEjecutando = false;
	                break;
	            default:
	                System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
	                break;
	        }
	    }
	}

	public void ejecutarSecundaria() {
		boolean seguirEjecutando = true;
	    while(seguirEjecutando) {
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
		        	ejecutarPrincipal();
		        	break;
		        default:
		        	System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
		        	ejecutarSecundaria();
	                break;
		    }
	    }
	}
	
	public void crearUsuario(){
        System.out.print("Digite el nombre de usuario --> ");
        name = sc.next();
        puntaje=0;
		if(usuarios.size()>0){
			for(int j=0;j<usuarios.size();j++){
				if(usuarios.get(j).getName().equals(name)) {
					System.out.println("ERROR-->USUARIOS REPETIDOS");
					ejecutarPrincipal();
				}
			}
		}
		byte i= (byte)usuarios.size();
		usuarios.add(new User(name, puntaje, i));
		Mazo mazo = new Mazo();
		usuarios.get(i).setMazo(mazo.crearMazoAl());
        System.out.println("Se ha creado un usuario con exito\n");
		//BORRAR DESPUES
		System.out.println("----LISTA USUARIOS----");
		for(int j=0;j<usuarios.size();j++){
			System.out.println(usuarios.get(j).getName());
		}
    }
	public void ingresarUsuario(){
		if(usuarios.size()==0) {
			System.out.println("No hay usuarios registrados");
			ejecutarPrincipal();
		}
		System.out.print("Digite su nombre de usuario --> ");
        name = sc.next();
		boolean success = false;
        
        for(byte i=0;i<usuarios.size();i++){
	        if(usuarios.get(i).getName().equals(name)) {
	        	System.out.println("Bienvenido "+name+"\n");
	        	id=i;
				success = true;
				break;
	        }
        }
		if(!success){
			System.out.println("Su usuario es incorrecto");
			ejecutarPrincipal();
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