package co.edu.unbosque.model;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesPrincipales {
    private byte id;
    private ArrayList<User> usuarios = new ArrayList<User>();
    private static Clip clip;
    private static float volumenOriginal;
	String name;

    Scanner sc = new Scanner(System.in);
    public void temporalData(){
        Data dat = new Data();
        this.usuarios = dat.loadData();
        System.out.println("DATA USUARIO ENTRA V2= "+usuarios);
        //test user ranking
        //this.usuarios.get(1).setPuntaje(this.usuarios.get(1).getPuntaje()+68);
    }
    public byte loginId(){
        return this.id;
    }
    
    public void reproducirMusica() {
    	
    	 try {
             File audioFile = new File("src/co/edu/unbosque/assets/musica/Menu.wav");
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
             clip = AudioSystem.getClip();
             clip.open(audioStream);
             clip.start(); // Inicia la reproducción de la música

             // Guardar volumen
             guardarVolumenOriginal();

             // Opcional: Reproducir en bucle continuo
             clip.loop(Clip.LOOP_CONTINUOUSLY);

             // Espera un tiempo para que la música se reproduzca antes de que el programa termine
             Thread.sleep(500000); // Por ejemplo, espera 5 segundos (5000 milisegundos)

             // Detener la reproducción y liberar recursos al finalizar
             clip.stop();
             clip.close();

         } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
             e.printStackTrace();
         }
     }

     public static void bajarVolumenACero() {
         FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         control.setValue(control.getMinimum());
     }
     public static void guardarVolumenOriginal() {
         FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         volumenOriginal = control.getValue();
     }
     public static void restaurarVolumenOriginal() {
         FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         control.setValue(volumenOriginal);
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
		if(this.usuarios.size()>0){
			for(int j=0;j<this.usuarios.size();j++){
				if(this.usuarios.get(j).getName().equals(name)) {
					System.out.println("ERROR-->USUARIOS REPETIDOS");
					stop = true;
				}
			}
		}
		if(stop==true) return stop=true;
		if(name=="") return stop=true;
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
		dat.saveData(usuarios);
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
	        	this.id=i;
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
		User user=this.usuarios.get(id);
		return user;
    }
}