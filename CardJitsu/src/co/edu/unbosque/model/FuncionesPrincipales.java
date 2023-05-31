package co.edu.unbosque.model;

import java.util.ArrayList;

public class FuncionesPrincipales {
    private byte id;
    private ArrayList<User> usuarios = new ArrayList<User>();
	String name;

    public void temporalData(){
        Data dat = new Data();
        this.usuarios = dat.loadData();
    }
    public ArrayList<User> getTemporalData(){
    	temporalData();
        return this.usuarios;
    }
    public byte loginId(){
    	temporalData();
        return this.id;
    }
    public boolean crearUsuario(String name){
		temporalData();
        int puntaje=0;
        if(name.isEmpty()) return true;
		if(this.usuarios.size()>0){
			for(int j=0;j<this.usuarios.size();j++){
				if(this.usuarios.get(j).getName().equals(name)) {
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
	        	this.id=i;
	        	success = true;
				break;
	        }
        }
		if(!success){
			return stop=true;
		}else return stop=false;
    }
	public User currentUser(){
		temporalData();
		User user=this.usuarios.get(this.id);
		return user;
    }
	public boolean finishedGame(boolean win){
		temporalData();
		User user=this.usuarios.get(this.id);
		int puntaje;
		int puntajeAntes=user.getPuntaje();
		if(!win) puntaje = user.getPuntaje()-2;
		else puntaje = user.getPuntaje()+5;
		user.setPuntaje(puntaje);
		Data dat = new Data();
		dat.saveData(this.usuarios);
		if(puntaje<100&&puntajeAntes<100) {
			if(puntaje/10>puntajeAntes/10) return true;
			else if(puntaje/10<puntajeAntes/10) return true;
			else return false;
		}
		else return false;
    }
}