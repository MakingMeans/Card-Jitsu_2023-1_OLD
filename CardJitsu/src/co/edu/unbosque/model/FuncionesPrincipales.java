package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesPrincipales {
    private byte id;
    //private boolean alreadyLoad=false;
    private ArrayList<User> usuarios = new ArrayList<User>();
    //private boolean easterEgg=false;
	String name;

    Scanner sc = new Scanner(System.in);
    public void temporalData(){
        Data dat = new Data();
        this.usuarios = dat.loadData();
        System.out.println("YES BRO IS LOADED");
        System.out.println("DATA USUARIO ENTRA V2= "+this.usuarios);
        //test user ranking
        //this.usuarios.get(2).setPuntaje(this.usuarios.get(2).getPuntaje()+178);
    }
    public ArrayList<User> getTemporalData(){
    	temporalData();
    	System.out.println("Devuelve="+this.usuarios);
        return this.usuarios;
    }
    public byte loginId(){
    	temporalData();
    	System.out.println("Devuelve="+this.id);
        return this.id;
    }
   
    public void ejecutarPrincipal() {
	    boolean seguirEjecutando1 = true;

        //this.usuarios = temporalData();
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
	                //crearUsuario();
	                break;
	            case 2:
	                //ingresarUsuario();
	                break;
	            case 3:
	                seguirEjecutando1 = false;
	                break;
	            default:
	                System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
	                break;
	        }
	    }
	}
    public boolean crearUsuario(String name){
		temporalData();
    	boolean stop = false;
        //System.out.print("Digite el nombre de usuario --> ");
        //name = sc.next();
        int puntaje=0;
        if(name.isEmpty()) return stop=true;
		if(this.usuarios.size()>0){
			for(int j=0;j<this.usuarios.size();j++){
				if(this.usuarios.get(j).getName().equals(name)) {
					System.out.println("ERROR-->USUARIOS REPETIDOS");
					stop = true;
				}
			}
		}
		if(stop==true) return stop=true;
		byte i= (byte)this.usuarios.size();
		this.usuarios.add(new User(name, puntaje, i));
		Mazo mazo = new Mazo();
		this.usuarios.get(i).setMazo(mazo.crearMazoAl());
        //System.out.println("Se ha creado un usuario con exito\n");
		//BORRAR DESPUES
		/*System.out.println("----LISTA USUARIOS----");
		for(int j=0;j<this.usuarios.size();j++){
			System.out.println(this.usuarios.get(j).getName());
		}*/
		Data dat = new Data();
		dat.saveData(this.usuarios);
		return stop=false;
    }
	public boolean ingresarUsuario(String name){
		temporalData();
		boolean stop = false;
		//VentanaSecundaria v2 = new VentanaSecundaria();
		if(this.usuarios.size()==0) {
			//System.out.println("No hay usuarios registrados");
			stop = true;
		}
		if(stop==true) return stop=true;
		//System.out.print("Digite su nombre de usuario --> ");
        //name = sc.next();

		boolean success = false;
        for(byte i=0;i<this.usuarios.size();i++){
	        if(this.usuarios.get(i).getName().equals(name)) {
	        	System.out.println("Bienvenido "+name+"\n");
	        	/*if(name.equals("RickRoll")) easterEgg=true;
	        	else easterEgg=false;*/
	        	this.id=i;
	        	System.out.println("ID="+this.id);
	        	success = true;
				break;
	        }
        }
		if(!success){
			System.out.println("Su usuario es incorrecto");
			return stop=true;
		}else return stop=false;
    }
	public User currentUser(){
		temporalData();
		User user=this.usuarios.get(this.id);
		/*Carta baraja[]=new Carta[30];
        baraja = usuarios.get(id).getMazo();
		for(int i=0;i<30;i++){
			System.out.println(baraja[i].getElemento()+" - "+baraja[i].getColor()+" - "+baraja[i].getNumero());
		}*/
		return user;
    }
}