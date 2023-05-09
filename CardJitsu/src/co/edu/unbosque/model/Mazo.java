package co.edu.unbosque.model;
import java.util.Random;

public class Mazo {

	private Carta card[] = new Carta[30];
	private byte[] barajaN = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	private String[] barajaC = {"Amaraillo","Azul","Verde","Rojo","Violeta","Naranja"};
	private String[] barajaE = {"Fuego","Nieve","Agua"};
	private byte randomN;
	String randomE,randomC;
	
	public void crearCarta(byte id) {
		
		Random rand = new Random();
		randomN = barajaN[rand.nextInt(barajaN.length)];
		randomC = barajaC[rand.nextInt(barajaC.length)];
		randomE = barajaE[rand.nextInt(barajaE.length)];
		
		//1111
		
	}
	
}