package co.edu.unbosque.model;
import java.util.Random;
import java.util.Scanner;

public class Gameplay {
    private User usuario;
	private int seleccion;

    public Gameplay(User usuario) {
		this.usuario = usuario;
	}
    public void partidaTEST(){
        System.out.println("usuario: " + usuario.getName());
    }
    public void partidaCPU() {
		Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        Mazo mazo = new Mazo();
        Carta card[] = usuario.getMazo();
        Carta cartaJugador, cartaSensei = mazo.senseiCard();

        for(int i=0;i<30;i++){
			System.out.println(card[i].getElemento()+" - "+card[i].getColor()+" - "+card[i].getNumero());
		}
        int randomCarta[];
		int playerScore = 0,senseiScore = 0;
		while (playerScore < 5 && senseiScore < 5) {
			
		randomCarta = mazo.cincoCartas(seleccion);
		System.out.println("-----------Partida contra sensei-----------");
		System.out.println("");
		System.out.println("---Mano---");
		System.out.println("1. "+card[randomCarta[0]].getElemento()+" - "+card[randomCarta[0]].getColor()+" - "+card[randomCarta[0]].getNumero());
		System.out.println("2. "+card[randomCarta[1]].getElemento()+" - "+card[randomCarta[1]].getColor()+" - "+card[randomCarta[1]].getNumero());
		System.out.println("3. "+card[randomCarta[2]].getElemento()+" - "+card[randomCarta[2]].getColor()+" - "+card[randomCarta[2]].getNumero());
		System.out.println("4. "+card[randomCarta[3]].getElemento()+" - "+card[randomCarta[3]].getColor()+" - "+card[randomCarta[3]].getNumero());
		System.out.println("5. "+card[randomCarta[4]].getElemento()+" - "+card[randomCarta[4]].getColor()+" - "+card[randomCarta[4]].getNumero());
		System.out.println();
		System.out.println("Elige tu carta ----->");
		seleccion = sc.nextInt();
		int xCarta = seleccion;
		switch(seleccion) {
		
		case 1: cartaJugador=new Carta(card[randomCarta[0]].getElemento(), card[randomCarta[0]].getNumero(), card[randomCarta[0]].getColor());
		break;
		case 2: cartaJugador=new Carta(card[randomCarta[1]].getElemento(), card[randomCarta[1]].getNumero(), card[randomCarta[1]].getColor());
		break;
		case 3: cartaJugador=new Carta(card[randomCarta[2]].getElemento(), card[randomCarta[2]].getNumero(), card[randomCarta[2]].getColor());
		break;
		case 4: cartaJugador=new Carta(card[randomCarta[3]].getElemento(), card[randomCarta[3]].getNumero(), card[randomCarta[3]].getColor());
		break;
		case 5: cartaJugador=new Carta(card[randomCarta[4]].getElemento(), card[randomCarta[4]].getNumero(), card[randomCarta[4]].getColor());
		break;
		default: 
			xCarta = rand.nextInt(5);
			cartaJugador=new Carta(card[randomCarta[xCarta]].getElemento(), card[randomCarta[xCarta]].getNumero(), 
			card[randomCarta[xCarta]].getColor());
			xCarta++;
		break;
		}
		seleccion = xCarta;
		System.out.println("Tu carta: "+cartaJugador.getElemento()+" - "+cartaJugador.getColor()+" - "+cartaJugador.getNumero());
		System.out.println("");
		System.out.println("Carta del sensei: "+cartaSensei.getElemento()+" - "+cartaSensei.getColor()+" - "+cartaSensei.getNumero());
		System.out.println("");

	    boolean playerWon = cartaGanadora(cartaJugador,cartaSensei);
		if(playerWon == true) playerScore++;
		else senseiScore++;
		System.out.println("Tu puntaje: " + playerScore);
		System.out.println("Puntaje del rival: " + senseiScore);
		System.out.println();
		}
		if (playerScore > senseiScore) {
            System.out.println("¡Felicidades, ganaste el juego!");
        } else if (playerScore < senseiScore) {
            System.out.println("Lo siento, perdiste el juego.");
        }
        sc.close();
	}
	public boolean cartaGanadora(Carta cartaJugador, Carta cartaSensei){
		
		boolean playerWon=false;
		String playerElement = cartaJugador.getElemento(), playerColor = cartaJugador.getColor();
		int playerNumber = cartaJugador.getNumero();
		String senseiElement = cartaSensei.getElemento(), senseiColor = cartaSensei.getColor();
		int senseiNumber = cartaSensei.getNumero();
		if (playerElement.equals(senseiElement)) {
			if (playerNumber > senseiNumber) {
				playerWon = true;
				System.out.println("Ganaste la ronda!");
			   
			} else if (playerNumber < senseiNumber) {
				playerWon = false;
				System.out.println("Perdiste la ronda!");
			} else {
				System.out.println("Empate!");
			}
		} else if ((playerElement.equals("Fuego") && senseiElement.equals("Nieve"))
				|| (playerElement.equals("Agua") && senseiElement.equals("Fuego"))
				|| (playerElement.equals("Nieve") && senseiElement.equals("Agua"))) {
			playerWon = true;
			System.out.println("Ganaste la ronda!");
			System.out.println();
			//
		} else {
			playerWon = false;
			System.out.println("Perdiste la ronda!");
			System.out.println();
		}
		return playerWon;
	}
}