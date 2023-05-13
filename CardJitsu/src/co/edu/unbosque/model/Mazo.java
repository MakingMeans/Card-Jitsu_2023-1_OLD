package co.edu.unbosque.model;
import java.util.Random;
import java.util.Scanner;

public class Mazo {

	private Carta card[] = new Carta[30];
	private Carta cartaActual[] = new Carta[1];
	Scanner sc = new Scanner(System.in);
	//private Carta preCard;
	private byte[] barajaN = {2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	private String[] barajaC = {"Amaraillo","Azul","Verde","Rojo","Violeta","Naranja"};
	private String[] barajaE = {"Fuego","Nieve","Agua"};
	private byte randomN,customN;
	private String randomE,randomC,customE,customC;
	String elemento, color;
	byte numero;
	int select;
	int random1,random2,random3,random4,random5;
	int playerScore = 0,senseiScore = 0;
	Random rand = new Random();
	public void crearMazoAl() {
		
		for(int i=0;i<30;i++) {
			randomN = barajaN[rand.nextInt(barajaN.length)];
			randomC = barajaC[rand.nextInt(barajaC.length)];
			randomE = barajaE[rand.nextInt(barajaE.length)];
			card[i]=new Carta(randomE, randomN, randomC);
		}
	}

	public void crearMazoCus() {
		
		for(int i=0;i<30;i++) {
			boolean repetida=false;
			System.out.println("Digite el numero de la carta "+(i+1)+":");
			select = sc.nextByte();
			customN = barajaN[select-2];
			System.out.println("Seleccione el elemento de la carta: "+(i+1)+":");
			System.out.println("1. Fuego");
			System.out.println("2. Nieve");
			System.out.println("3. Agua");
			select = sc.nextByte();
			customE = barajaE[select-1];
			System.out.println("Selecione el color de la carta: "+(i+1)+":");
			System.out.println("1. Amarillo");
			System.out.println("2. Azul");
			System.out.println("3. Verde");
			System.out.println("4. Rojo");
			System.out.println("5. Violeta");
			System.out.println("6. Naranja");
			select = sc.nextByte();
			customC = barajaC[select-1];
			Carta preCard=new Carta(customE, customN, customC);
			for(int j=0;j<i;j++){
				if(card[j].getElemento().equals(preCard.getElemento())&&
				card[j].getColor().equals(preCard.getColor())&&
				card[j].getNumero()==preCard.getNumero()) repetida=true;
			}
			if(repetida==false) {
				card[i]=preCard; System.out.println("No se repite");
			}
			else {
				i--; System.out.println("Carta repetida, vuelva a ingresar el la carta");
			}
		}
		
	}

	public void mostrarMazo() {
		for(int i=0;i<30;i++) {
		System.out.println(card[i].getElemento()+" - "+card[i].getColor()+" - "+card[i].getNumero());
		}
	}
	
	/* Edit Jorge: Funcion para jugar una partida, no es como la partida del pdf pero se comprueba
	que se almacenan las cartas, se pueden seleccionar 5 aleatoreas del mazo ya sea custom o ramdom, Falta llevar
	el puntaje y que no se repitan las cartas a seleccionar*/
	
	
	public void partidaCPU() {
		
		while (playerScore < 5 && senseiScore < 5) {
		random1 = rand.nextInt(card.length);
		random2 = rand.nextInt(card.length);
		random3 = rand.nextInt(card.length);
		random4 = rand.nextInt(card.length);
		random5 = rand.nextInt(card.length);
		
		System.out.println("-----------Partida contra sensei-----------");
		System.out.println("");
		System.out.println("---Elija su carta---");
		System.out.println("1. "+card[random1].getElemento()+" - "+card[random1].getColor()+" - "+card[random1].getNumero());
		System.out.println("2. "+card[random2].getElemento()+" - "+card[random2].getColor()+" - "+card[random2].getNumero());
		System.out.println("3. "+card[random3].getElemento()+" - "+card[random3].getColor()+" - "+card[random3].getNumero());
		System.out.println("4. "+card[random4].getElemento()+" - "+card[random4].getColor()+" - "+card[random4].getNumero());
		System.out.println("5. "+card[random5].getElemento()+" - "+card[random5].getColor()+" - "+card[random5].getNumero());
		System.out.println();
		System.out.println("----->");
		int opc = sc.nextInt();
		switch(opc) {
		
		case 1: cartaActual[0]=new Carta(card[random1].getElemento(), card[random1].getNumero(), card[random1].getColor());
		break;
		case 2: cartaActual[0]=new Carta(card[random2].getElemento(), card[random2].getNumero(), card[random2].getColor());
		break;
		case 3: cartaActual[0]=new Carta(card[random3].getElemento(), card[random3].getNumero(), card[random3].getColor());
		break;
		case 4: cartaActual[0]=new Carta(card[random4].getElemento(), card[random4].getNumero(), card[random4].getColor());
		break;
		case 5: cartaActual[0]=new Carta(card[random5].getElemento(), card[random5].getNumero(), card[random5].getColor());
		break;
		}System.out.println("Tu carta: "+cartaActual[0].getElemento()+" - "+cartaActual[0].getColor()+" - "+cartaActual[0].getNumero());
		System.out.println("");
		String playerElement = cartaActual[0].getElemento(), playerColor = cartaActual[0].getColor();
		int playerNumber = cartaActual[0].getNumero();
		String senseiElement = barajaE[rand.nextInt(barajaE.length)], senseiColor = barajaC[rand.nextInt(barajaC.length)];
		int senseiNumber = barajaN[rand.nextInt(barajaN.length)];
		System.out.println("Carta del sensei: "+senseiElement+" - "+senseiColor+" - "+senseiNumber);
		System.out.println("");
		
		 if (playerElement.equals(senseiElement)) {
	            if (playerNumber > senseiNumber) {
	                playerScore++;
	                System.out.println("Ganaste la ronda!");
	               
	            } else if (playerNumber < senseiNumber) {
	                senseiScore++;
	                System.out.println("Perdiste la ronda!");
	            } else {
	                System.out.println("Empate!");
	            }
	        } else if ((playerElement.equals("Fuego") && senseiElement.equals("Nieve"))
	                || (playerElement.equals("Agua") && senseiElement.equals("Fuego"))
	                || (playerElement.equals("Nieve") && senseiElement.equals("Agua"))) {
	            playerScore++;
	            System.out.println("Ganaste la ronda!");
	            System.out.println();
	            //
	        } else {
	            senseiScore++;
	            System.out.println("Perdiste la ronda!");
	            System.out.println();
	        }
		 	System.out.println("Tu puntaje: " + playerScore);
	        System.out.println("Puntaje del rival: " + senseiScore);
	        System.out.println();
		}
		if (playerScore > senseiScore) {
            System.out.println("¡Felicidades, ganaste el juego!");
        } else if (playerScore < senseiScore) {
            System.out.println("Lo siento, perdiste el juego.");
        }
		
		
		
		
	    }
		
	}
	
	
	
