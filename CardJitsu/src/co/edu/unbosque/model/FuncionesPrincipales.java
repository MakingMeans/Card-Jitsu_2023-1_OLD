package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesPrincipales {
    private byte id;
    private ArrayList<User> usuarios = new ArrayList<User>();
	String name;

    Scanner sc = new Scanner(System.in);
    public void temporalData(){
        Data dat = new Data();
        this.usuarios = dat.loadData();
        //test user ranking
        //this.usuarios.get(1).setPuntaje(this.usuarios.get(1).getPuntaje()+50);
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
   
    public boolean crearUsuario(String name){
		temporalData();
        int puntaje=0;
        if(name.isEmpty()) return true;
		if(this.usuarios.size()>0){
			for(int j=0;j<this.usuarios.size();j++){
				if(this.usuarios.get(j).getName().equals(name)) {
					System.out.println("ERROR-->USUARIOS REPETIDOS");
					return true;
				}
			}
		}
		byte i= (byte)this.usuarios.size();
		this.usuarios.add(new User(name, puntaje, i));
		Mazo mazo = new Mazo();
		this.usuarios.get(i).setMazo(mazo.crearMazoAl());
		Data dat = new Data();
		dat.saveData(this.usuarios);
		return false;
    }
	public boolean ingresarUsuario(String name){
		temporalData();
		boolean stop = false;
		if(this.usuarios.size()==0) {
			stop = true;
		}
		if(stop==true) return stop=true;

		boolean success = false;
        for(byte i=0;i<this.usuarios.size();i++){
	        if(this.usuarios.get(i).getName().equals(name)) {
	        	System.out.println("Bienvenido "+name+"\n");
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
		return user;
    }
}