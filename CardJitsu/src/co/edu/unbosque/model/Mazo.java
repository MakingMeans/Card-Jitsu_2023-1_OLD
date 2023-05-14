package co.edu.unbosque.model;
import java.util.Random;
import java.util.Scanner;

public class Mazo {
	private Carta card[] = new Carta[30];
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	byte[] barajaN = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	String[] barajaC = {"Amaraillo", "Azul", "Verde", "Rojo", "Violeta", "Naranja"};
	String[] barajaE = {"Fuego", "Nieve", "Agua"};

	private int[] randomCards;
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

	public Carta[] crearMazoCus() {
		for(int i = 0 ; i < 30; i++) {
			boolean repetida = false;
			System.out.print("Digite el numero de la carta " + (i + 1) + ": ");
			select = sc.nextByte();
			customN = barajaN[select - 2];
			System.out.print("Seleccione el elemento de la carta " + (i + 1) + ": ");
			System.out.println("1. Fuego.");
			System.out.println("2. Nieve.");
			System.out.println("3. Agua.");
			select = sc.nextByte();
			customE = barajaE[select - 1];
			System.out.print("Selecione el color de la carta " + (i + 1) + ": ");
			System.out.println("1. Amarillo.");
			System.out.println("2. Azul.");
			System.out.println("3. Verde.");
			System.out.println("4. Rojo.");
			System.out.println("5. Violeta.");
			System.out.println("6. Naranja.");
			select = sc.nextByte();
			customC = barajaC[select - 1];
			Carta preCard = new Carta(customE, customN, customC);
			for(int j = 0; j < i; j++){
				if(card[j].getElemento().equals(preCard.getElemento()) && 
				card[j].getColor().equals(preCard.getColor()) && 
				card[j].getNumero() == preCard.getNumero()) repetida = true;
			}
			if(repetida == false) {
				card[i] = preCard; System.out.println("No se repite.");
			}
			else {
				i--; 
				System.out.println("Carta repetida, vuelva a ingresar el la carta.");
			}
		}
		return this.card;
	}

	public int[] cincoCartas(int seleccion){
		//if(seleccion>5||seleccion<1) seleccion = rand.nextInt(5)+1;
		if(randomCards==null){
			randomCards = new int[5];
			for(int i = 0; i < randomCards.length; i++){
				randomCard = rand.nextInt(card.length);
				boolean repetida = false;
				for(int j = 0; j < i; j++){
					if(randomCards[j] == randomCard){
						repetida = true;
						break;
					}
				}
				if(repetida) i--;
				else randomCards[i] = randomCard;
			}
		}else{
			boolean done = false;
			while(done==false){
				randomCard=rand.nextInt(card.length);
				boolean repetida = false;
				for(int j = 0; j < randomCards.length; j++){
					if(randomCards[j] == randomCard){
						repetida = true;
						break;
					}
				}
				if(!repetida){
					randomCards[seleccion-1]=randomCard;
					done = true;
				}
			}
		}
		return randomCards;
	}
	public Carta senseiCard(){
		String senseiElement = barajaE[rand.nextInt(barajaE.length)];
		String senseiColor = barajaC[rand.nextInt(barajaC.length)];
		byte senseiNumber = barajaN[rand.nextInt(barajaN.length)];
		System.out.println();
		Carta sensei = new Carta(senseiElement, senseiNumber, senseiColor);
		return sensei;
	}
}