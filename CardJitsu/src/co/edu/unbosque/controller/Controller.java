package co.edu.unbosque.controller;
import co.edu.unbosque.model.Mazo;
import co.edu.unbosque.model.User;
import java.util.Scanner;
public class Controller {
	public Controller() {
		
	}
	public void ejecutar() {
	    boolean seguirEjecutando = true;
	    while(seguirEjecutando) {
	    	 System.out.println("---!Card-Jitsu!---");
	         System.out.println("Digite la opcion deseada: ");
	         System.out.println("1. Crear usuario");
	         System.out.println("2. Log in");
	         System.out.println("3. Salir");
	        byte x = sc.nextByte();
	        switch(x) {
	            case 1:
	                crearUsuario();
	                break;
	            case 2:
	                ingresarUsuario();
	                ejecutar1();
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

	public void ejecutar1() {
		
		boolean seguirEjecutando = true;
	    while(seguirEjecutando) {
		System.out.println("Digite la opcion deseada: ");
       	System.out.println("1. Estatus");
        System.out.println("2. Asignar mazo aleatorio");
        System.out.println("3. Mostrar mazo aleatorio");
        System.out.println("4. Log out");
        	byte y = sc.nextByte();

        switch(y) {
        
        case 1:
            datosUsuario();
            ejecutar1();
            break;
        case 2:
        	asignarMazoAleatorio();
        	ejecutar1();
        	break;
        case 3:
        	mostrarMazo();
        	ejecutar1();
        	break;
        case 4:
        	ejecutar();
        	
        }
		
	}
	}
	
	
	byte id;
	String name,cinturon;
    int puntaje;
	boolean stock = true;
	Mazo baraja;
	
	Scanner sc = new Scanner(System.in);
	private User usuarios[] = new User[5];
	
	
	
	public void crearUsuario(){
        System.out.print("Digite el nombre de usuario --> ");
        System.out.println("");
        name = sc.next();
        puntaje=0;
        for(byte i=0;i<5;i++){
            if(usuarios[i]==null) {
                usuarios[i]=new User(name, puntaje, i);
                stock=true;
                System.out.println("Se ha creado un usuario con exito");
                System.out.println("");
                break;
            } else stock=false;
        }
		if(stock==false) System.out.println("ERROR --> No ha espacio para mas usuarios.");
		
    }
	public void ingresarUsuario(){
		if(usuarios[id]==null) {
			
			System.out.println("No hay usuarios registrados");
			ejecutar();
		}
		System.out.print("Digite su nombre de usuario --> ");
		System.out.println("");
        name = sc.next();
        
        for(byte i=0;i<5;i++){
        	if(usuarios[i]!=null) {
	            if(usuarios[i].getName().equals(name)) {
	            	System.out.println("Bienvenido "+name);
	            	System.out.println("");
	            	id=i;
	            }
				else System.out.println("Su usuario es incorrecto");
        	}
        }
    }
	public void datosUsuario(){
		if(usuarios[id]==null) {
			
			System.out.println("No hay usuarios regristrados");
			ejecutar();
		}
		
		System.out.println("");
		System.out.println("Su usuario: "+usuarios[id].getName());
		System.out.println("Su cinturon: "+usuarios[id].getCinturon());
		System.out.println("Su puntaje: "+usuarios[id].getPuntaje());
		System.out.println("Puntos necesarios para siguiente cinturon: "+usuarios[id].getNextLv());
		System.out.println("");
		   
	}
	public void asignarMazoAleatorio() {
		if(usuarios[id]==null) {			
			System.out.println("No hay usuarios regristrados");
			ejecutar();
		}
		Mazo mazo = new Mazo();
		mazo.crearMazo();
		usuarios[id].setMazo(mazo);
		System.out.println("Se ha asignado un mazo aleatorio al usuario " + usuarios[id].getName()); 
		System.out.println(""); 
	}
	public void mostrarMazo() {
		if(usuarios[id]==null) {			
			System.out.println("No hay usuarios regristrados");
			ejecutar();
		}		
		if(usuarios[id].getMazo()==null) {			
			System.out.println("No se ha asignado mazo");
			ejecutar();
		}        
        baraja = usuarios[id].getMazo();
    	baraja.test();
    	System.out.println("");
	}	
}
