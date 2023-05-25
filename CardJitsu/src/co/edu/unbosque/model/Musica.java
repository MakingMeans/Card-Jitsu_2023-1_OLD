package co.edu.unbosque.model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Musica {
	private static Clip clipActual;
    private static float volumenOriginal;
    private static boolean mute=false;
    
    private void iniciarReproduccionMusica(String rutaArchivo) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audioFile = new File(rutaArchivo);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        clipActual = AudioSystem.getClip();
        clipActual.open(audioStream);
        clipActual.start(); // Inicia la reproducción de la música
    }
    public void reproducirMusica() {
        try {
            iniciarReproduccionMusica("src/co/edu/unbosque/assets/musica/Menu.wav");
            // Guardar volumen
            guardarVolumenOriginal();
            // Opcional: Reproducir en bucle continuo
            clipActual.loop(Clip.LOOP_CONTINUOUSLY);
            // Espera un tiempo para que la música se reproduzca antes de que el programa termine
            Thread.sleep(500000); // Por ejemplo, espera 5 segundos (5000 milisegundos)
            // Detener la reproducción y liberar recursos al finalizar
            clipActual.stop();
            clipActual.close();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void cambiarMusica(String rutaArchivo) {
        clipActual.stop();
        clipActual.close();
        try {
        	iniciarReproduccionMusica("src/co/edu/unbosque/assets/musica/"+rutaArchivo+".wav");
        	/*if(easterEgg==false)iniciarReproduccionMusica(rutaArchivo);
        	else iniciarReproduccionMusica("src/co/edu/unbosque/assets/musica/Roll.wav");*/
        	clipActual.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        if(mute==true) bajarVolumenACero();
    }
    //posible futuro sound effect
    public void soundEffect(String rutaArchivo) {
        try {
        	iniciarReproduccionMusica("src/co/edu/unbosque/assets/musica/"+rutaArchivo+".wav");
        	/*if(easterEgg==false)iniciarReproduccionMusica(rutaArchivo);
        	else iniciarReproduccionMusica("src/co/edu/unbosque/assets/musica/Roll.wav");*/
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        if(mute==true) bajarVolumenACero();
    }
    public void shutUp() {
    	clipActual.stop();
        clipActual.close();
    }
    
     public static void bajarVolumenACero() {
         FloatControl control = (FloatControl) clipActual.getControl(FloatControl.Type.MASTER_GAIN);
         control.setValue(control.getMinimum());
         mute=true;
     }
     public static void guardarVolumenOriginal() {
         FloatControl control = (FloatControl) clipActual.getControl(FloatControl.Type.MASTER_GAIN);
         volumenOriginal = control.getValue();
     }
     public static void restaurarVolumenOriginal() {
         FloatControl control = (FloatControl) clipActual.getControl(FloatControl.Type.MASTER_GAIN);
         control.setValue(volumenOriginal);
         mute=false;
     }
}
