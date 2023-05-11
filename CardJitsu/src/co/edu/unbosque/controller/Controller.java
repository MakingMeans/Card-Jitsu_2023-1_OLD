package co.edu.unbosque.controller;
//import co.edu.unbosque.model.Mazo;
import co.edu.unbosque.model.User;
import java.util.Scanner;
public class Controller {
	public Controller() {
		//Mazo mz= new Mazo();
	}
	public void ejecutar() {
		/*Mazo mz= new Mazo();
		mz.crearMazo();
		mz.test();*/
		crearUsuario();
		ingresarUsuario();
		datosUsuario();
	}
	
	byte id;
	String name,cinturon;
    int puntaje;
	boolean stock = true;
	
	Scanner sc = new Scanner(System.in);
	private User usuarios[] = new User[5];
	
	public void crearUsuario(){
        System.out.print("Digite su nombre de usuario --> ");
        name = sc.next();
        puntaje=0;
        for(byte i=0;i<5;i++){
            if(usuarios[i]==null) {
                usuarios[i]=new User(name, puntaje, i);
                break;
            } else stock=false;
        }
		if(stock==false) System.out.println("ERROR --> No ha espacio para mas usuarios.");
		/*id=0;
		puntaje=0;
        nextLv=0;
		name = "null";
		cinturon = "Ninguno";*/
    }
	public void ingresarUsuario(){
		System.out.print("Digite su nombre de usuario --> ");
        name = sc.next();
        for(byte i=0;i<5;i++){
        	if(usuarios[i]!=null) {
	            if(usuarios[i].getName().equals(name)) id=i;
				else System.out.println("Su usuario es incorrecto");
        	}
        }
    }
	public void datosUsuario(){
		usuarios[id].setPuntaje(54);
		System.out.println(usuarios[id].getName());
		System.out.println(usuarios[id].getCinturon());
		System.out.println(usuarios[id].getPuntaje());
		System.out.println(usuarios[id].getNextLv());
	}
}
