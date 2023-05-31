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
	private static Clip clipFondo;
	private static boolean mute = false;
	@SuppressWarnings("unused")
	private boolean preMute;

	private void iniciarReproduccionMusica(String rutaArchivo)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File audioFile = new File(rutaArchivo);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
		clipActual = AudioSystem.getClip();
		clipActual.open(audioStream);
		clipActual.start(); // Inicia la reproducción de la música
	}

	private void iniciarReproduccionSonido(String rutaArchivo)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File audioFile = new File(rutaArchivo);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
		clipFondo = AudioSystem.getClip();
		clipFondo.open(audioStream);
		clipFondo.start(); // Inicia la reproducción de efectos
	}

	public void reproducirMusica(String rutaArchivo) {
		try {
			iniciarReproduccionMusica("src/co/edu/unbosque/assets/musica/" + rutaArchivo + ".wav");
			establecerVolumenInicial(0.7f);
			// Opcional: Reproducir en bucle continuo
			clipActual.loop(Clip.LOOP_CONTINUOUSLY);
			// Espera un tiempo para que la música se reproduzca antes de que el programa
			// termine
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
			iniciarReproduccionMusica("src/co/edu/unbosque/assets/musica/" + rutaArchivo + ".wav");
			if (mute == false)
				establecerVolumenInicial(0.7f);
			else
				establecerVolumenInicial(-1000f);
			clipActual.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
	}

	public void soundEffect(String rutaArchivo) {
		try {
			iniciarReproduccionSonido("src/co/edu/unbosque/assets/soundEffects/" + rutaArchivo + ".wav");
			if (mute == false)
				establecerVolumenInicialSound(0.7f);
			else
				establecerVolumenInicial(-1000f);
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
	}

	public void shutUp() {
		clipActual.stop();
		clipActual.close();
	}

	public void shutUpSound() {
		clipFondo.stop();
		clipFondo.close();
	}

	public static void establecerVolumenInicial(float volumen) {
		if (clipActual.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
			FloatControl control = (FloatControl) clipActual.getControl(FloatControl.Type.MASTER_GAIN);
			float gainRange = control.getMaximum() - control.getMinimum();
			float desiredGain = gainRange * volumen + control.getMinimum();
			control.setValue(desiredGain);
			if (volumen >= 0)
				mute = false;
			else if (volumen < 0)
				mute = true;
		}
	}

	public static void establecerVolumenInicialSound(float volumen) {
		if (clipFondo.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
			FloatControl control = (FloatControl) clipFondo.getControl(FloatControl.Type.MASTER_GAIN);
			float gainRange = control.getMaximum() - control.getMinimum();
			float desiredGain = gainRange * volumen + control.getMinimum();
			control.setValue(desiredGain);
			if (volumen >= 0)
				mute = false;
			else if (volumen < 0)
				mute = true;
		}
	}

	public boolean getPreMute() {
		if (mute)
			return true;
		else
			return false;
	}

	public void setPreMute(boolean preMute) {
		this.preMute = preMute;
	}
}