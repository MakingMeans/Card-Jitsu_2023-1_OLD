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
	        System.out.println("3. Estatus");
	        System.out.println("4. Asignar mazo aleatorio");
	        System.out.println("5. Mostrar mazo aleatorio");
	        System.out.println("6. Salir");
	        byte x = sc.nextByte();
	        switch(x) {
	            case 1:
	                crearUsuario();
	                
	                break;
	            case 2:
	                ingresarUsuario();
	                break;
	            case 3:
	                datosUsuario();
	                break;
	            case 4:
	            	asignarMazoAleatorio();
	            	break;
	            case 5:
	            	mostrarMazo();
	            	break;
	            case 6:
	                seguirEjecutando = false;
	                break;
	            default:
	                System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
	                break;
	        }
	    }
	}

	
	byte id;
	String name,cinturon;
    int puntaje;
	boolean stock = true,ExistenciaUser=true;
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
		System.out.print("Digite su nombre de usuario --> ");
		System.out.println("");
        name = sc.next();
        for(byte i=0;i<5;i++){
        	if(usuarios[i]!=null) {
	            if(usuarios[i].getName().equals(name)) {
	            	id=i;
	            	i=5;
	            	System.out.println("");
	        		System.out.println("Su usuario: "+usuarios[id].getName());
	        		System.out.println("Su cinturon: "+usuarios[id].getCinturon());
	        		System.out.println("Su puntaje: "+usuarios[id].getPuntaje());
	        		System.out.println("Puntos necesarios para siguiente cinturon: "+usuarios[id].getNextLv());
	        		System.out.println("");
	        		ExistenciaUser=true;
	            }
				else ExistenciaUser=false;
        	}
        	
        }if(ExistenciaUser==false)System.out.println("No existe ese usuario");
        
        
	}
	public void asignarMazoAleatorio() {
		if(usuarios[id]==null) {
			
			System.out.println("No hay usuarios regristrados");
			ejecutar();
		}
		System.out.print("Digite el nombre del usuario al que se le asignarà el mazo --> ");
		System.out.println("");
        name = sc.next();
        for(byte i=0;i<5;i++){
        	if(usuarios[i]!=null) {
	            if(usuarios[i].getName().equals(name)) {
	            	Mazo mazo = new Mazo();
	        		mazo.crearMazo();
	        		usuarios[i].setMazo(mazo);
	        		System.out.println("Se ha asignado un mazo aleatorio al usuario " + usuarios[i].getName()); 
	        		System.out.println("");
	        		ExistenciaUser=true;
	            }
				else ExistenciaUser=false;
        	}
        	
        }if(ExistenciaUser==false)System.out.println("No existe ese usuario");
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
		
		System.out.print("Digite el nombre del usuario propietario del mazo --> ");
		System.out.println("");
        name = sc.next();
        for(byte i=0;i<5;i++){
        	if(usuarios[i]!=null) {
	            if(usuarios[i].getName().equals(name)) {
	            	baraja = usuarios[i].getMazo();
	            	baraja.test();
	            	System.out.println("");
	            	ExistenciaUser=true;
	            }
				else ExistenciaUser=false;
        	}
        	
        }if(ExistenciaUser==false)System.out.println("No existe ese usuario");
        
		
	}
	
	
	
	
}
