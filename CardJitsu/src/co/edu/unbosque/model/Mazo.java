package co.edu.unbosque.model;
import java.util.Random;
import java.util.Scanner;

public class Mazo {
	private Carta card[] = new Carta[30];
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	byte[] barajaN = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	String[] barajaC = {"Amarillo", "Azul", "Verde", "Rojo", "Morado", "Naranja"};
	String[] barajaE = {"Fuego", "Nieve", "Agua"};

	int randomCard;
	byte randomN, customN;
	String randomE, randomC, customE, customC;
	String elemento, color;
	byte numero;
	int select;
	
	public Carta[] crearMazoAl() {
		for(int i = 0; i < 30; i++) {
			boolean repetida = false;
			randomN = barajaN[rand.nextInt(barajaN.length)];
			randomC = barajaC[rand.nextInt(barajaC.length)];
			randomE = barajaE[rand.nextInt(barajaE.length)];
			Carta preCard = new Carta(randomE, randomN, randomC);
			for(int j = 0; j < i; j++){
				if(card[j].getElemento().equals(preCard.getElemento()) && 
				card[j].getColor().equals(preCard.getColor()) && 
				card[j].getNumero() == preCard.getNumero()) repetida = true;
			}
			if(repetida == false) {
				card[i] = preCard;
			}else {
				i--;
			}
		}
		return this.card;
	}
	public Carta rivalCard(){
		String senseiElement = barajaE[rand.nextInt(barajaE.length)];
		String senseiColor = barajaC[rand.nextInt(barajaC.length)];
		byte senseiNumber = barajaN[rand.nextInt(barajaN.length)];
		System.out.println();
		Carta sensei = new Carta(senseiElement, senseiNumber, senseiColor);
		return sensei;
	}
}