package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.controller.Controller;

public class VentanaPrincipal {
    private byte id;
    private ArrayList<User> usuarios = new ArrayList<User>();

	String name;

    Scanner sc = new Scanner(System.in);

    public ArrayList<User> temporalData(){
        Data dat = new Data();
        this.usuarios = dat.loadData();
        System.out.println("DATA USUARIO ENTRA V2= "+usuarios);
        return this.usuarios;
    }
    public byte loginId(){
        return this.id;
    }

    public void ejecutarPrincipal() {
	    boolean seguirEjecutando1 = true;
        VentanaSecundaria v2 = new VentanaSecundaria();

        this.usuarios = temporalData();
        System.out.println("DATA USUARIO ENTRA V1= "+usuarios);
	    while(seguirEjecutando1) {
	    	 System.out.println("---!Card-Jitsu!---");
	         System.out.println("Digite la opcion deseada: ");
	         System.out.println("1. Crear usuario");
	         System.out.println("2. Log in");
	         System.out.println("3. Salir");
	        byte seleccionPrincipal = sc.nextByte();
	        switch(seleccionPrincipal) {
	            case 1:
	                crearUsuario();
	                break;
	            case 2:
	                ingresarUsuario();
	                v2.ejecutarSecundaria();
	                break;
	            case 3:
	                seguirEjecutando1 = false;
	                break;
	            default:
	                System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
	                break;
	        }
			if (!seguirEjecutando1) {
				Controller c = new Controller();
				c.end();
			}
	    }
	}
    public void crearUsuario(){
        System.out.print("Digite el nombre de usuario --> ");
        name = sc.next();
        int puntaje=0;
		if(this.usuarios.size()>0){
			for(int j=0;j<this.usuarios.size();j++){
				if(this.usuarios.get(j).getName().equals(name)) {
					System.out.println("ERROR-->USUARIOS REPETIDOS");
					ejecutarPrincipal();
				}
			}
		}
		byte i= (byte)this.usuarios.size();
		this.usuarios.add(new User(name, puntaje, i));
		Mazo mazo = new Mazo();
		this.usuarios.get(i).setMazo(mazo.crearMazoAl());
        System.out.println("Se ha creado un usuario con exito\n");
		//BORRAR DESPUES
		System.out.println("----LISTA USUARIOS----");
		for(int j=0;j<this.usuarios.size();j++){
			System.out.println(this.usuarios.get(j).getName());
		}
    }
	public void ingresarUsuario(){
		if(this.usuarios.size()==0) {
			System.out.println("No hay usuarios registrados");
			ejecutarPrincipal();
		}
		System.out.print("Digite su nombre de usuario --> ");
        name = sc.next();
		boolean success = false;
        
        for(byte i=0;i<this.usuarios.size();i++){
	        if(this.usuarios.get(i).getName().equals(name)) {
	        	System.out.println("Bienvenido "+name+"\n");
	        	this.id=i;
				success = true;
				break;
	        }
        }
		if(!success){
			System.out.println("Su usuario es incorrecto");
			ejecutarPrincipal();
		}
    }
}
