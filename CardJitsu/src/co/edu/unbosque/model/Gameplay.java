package co.edu.unbosque.model;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Gameplay {
    //hay que separar distintas caracteristicas del gameplay por funciones
	private User usuario;
	private int seleccion;
	//HashSet son listas que no pueden tener elementos repetidas
	Set<String> fuegoWin = new HashSet<>();
	Set<String> aguaWin = new HashSet<>();
	Set<String> nieveWin = new HashSet<>();
	Set<String> allWin = new HashSet<>();
	Set<String> fuegoWinS = new HashSet<>();
	Set<String> aguaWinS = new HashSet<>();
	Set<String> nieveWinS = new HashSet<>();
	Set<String> allWinS = new HashSet<>();

    public Gameplay(User usuario) {
		this.usuario = usuario;
	}
    public void partidaTEST(){
        System.out.println("Usuario: " + usuario.getName());
    }
    public void partidaCPU() {
		Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        Mazo mazo = new Mazo();
        Carta card[] = usuario.getMazo();

        for(int i=0;i<30;i++){
			System.out.println(card[i].getElemento()+" - "+card[i].getColor()+" - "+card[i].getNumero());
		}
        int randomCarta[];
		boolean hayGanador = false;
		while (hayGanador == false) {
			Carta cartaJugador, cartaRival = mazo.senseiCard();
			randomCarta = mazo.cincoCartas(seleccion);
			System.out.println("-----------Partida contra sensei-----------\n");
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
			System.out.println("Tu carta: "+cartaJugador.getElemento()+" - "+cartaJugador.getColor()+" - "+cartaJugador.getNumero()+"\n");
			System.out.println("Carta del sensei: "+cartaRival.getElemento()+" - "+cartaRival.getColor()+" - "+cartaRival.getNumero()+"\n");

			cartaGanadora(cartaJugador,cartaRival);
			System.out.println("Fuego: -> Jugador: "+fuegoWin+" <-  ---------------  -> Sensei: "+fuegoWinS);
			System.out.println("Agua: -> Jugador: "+aguaWin+" <-  ---------------  -> Sensei: "+aguaWinS);
			System.out.println("Nieve: -> Jugador: "+nieveWin+" <-  ---------------  -> Sensei: "+nieveWinS);
			System.out.println("ALLWIN PLAYER="+allWin);
			System.out.println("ALLWIN SENSEI="+allWinS);
			System.out.println();
			hayGanador=terminarPartida(hayGanador);
		}
		
	}
	public void cartaGanadora(Carta cartaJugador, Carta cartaRival){
		String playerElement = cartaJugador.getElemento(), playerColor = cartaJugador.getColor();
		byte playerNumber = cartaJugador.getNumero();
		String rivalElement = cartaRival.getElemento(), rivalColor = cartaRival.getColor();
		byte rivalNumber = cartaRival.getNumero();
		if (playerElement.equals(rivalElement)) {
			if (playerNumber > rivalNumber) {
				System.out.println("Ganaste la ronda!");
			    if(playerElement.equals("Fuego")) {
					fuegoWin.add(playerColor);
				}
				if(playerElement.equals("Agua")) {
					aguaWin.add(playerColor);
				}
				if(playerElement.equals("Nieve")) {
					nieveWin.add(playerColor);
				}
			} else if (playerNumber < rivalNumber) {
				System.out.println("Perdiste la ronda!");
				if(rivalElement.equals("Fuego")) {
					fuegoWinS.add(rivalColor);
				}
				if(rivalElement.equals("Agua")) {
					aguaWinS.add(rivalColor);
				}
				if(rivalElement.equals("Nieve")) {
					nieveWinS.add(rivalColor);
				}
			} else {
				System.out.println("Empate!");
			}
		} else if ((playerElement.equals("Fuego") && rivalElement.equals("Nieve"))
				|| (playerElement.equals("Agua") && rivalElement.equals("Fuego"))
				|| (playerElement.equals("Nieve") && rivalElement.equals("Agua"))) {
			System.out.println("Ganaste la ronda!");
			System.out.println();
			if(playerElement.equals("Fuego")) {
				fuegoWin.add(playerColor);
			}
			if(playerElement.equals("Agua")) {
				aguaWin.add(playerColor);
			}
			if(playerElement.equals("Nieve")) {
				nieveWin.add(playerColor);
			}
		} else {
			System.out.println("Perdiste la ronda!");
			System.out.println();
			if(rivalElement.equals("Fuego")) {
				fuegoWinS.add(rivalColor);
			}
			if(rivalElement.equals("Agua")) {
				aguaWinS.add(rivalColor);
			}
			if(rivalElement.equals("Nieve")) {
				nieveWinS.add(rivalColor);
			}
		}
		boolean victory = false;
		for (String colorF : fuegoWin) {
			for (String colorA : aguaWin) {
				for (String colorN : nieveWin) {
					allWin.add(colorF); 
					System.out.println("FIRE FOR="+allWin);
					allWin.add(colorA);
					System.out.println("WATER FOR="+allWin); 
					allWin.add(colorN); 
					System.out.println("WINTER FOR="+allWin);
					if(allWin.size()>=3) victory = true;
					if(victory)break;
					else allWin.remove(colorN);
				}
				if(victory)break;
				else allWin.remove(colorA);
			}
			if(victory)break;
			else {
				allWin.remove(colorF); 
				allWin.clear();
			}
		}
		for (String colorF : fuegoWinS) {
			for (String colorA : aguaWinS) {
				for (String colorN : nieveWinS) {
					allWinS.add(colorF); 
					allWinS.add(colorA);
					allWinS.add(colorN); 
					if(allWinS.size()>=3) victory = true;
					if(victory)break;
					else allWinS.remove(colorN);
				}
				if(victory)break;
				else allWinS.remove(colorA);
			}
			if(victory)break;
			else {
				allWin.remove(colorF); 
				allWinS.clear();
			}
		}
	}
	public boolean terminarPartida(boolean hayGanador){
		if(fuegoWin.size()>=3 ||aguaWin.size()>=3 || nieveWin.size()>=3 || allWin.size()>=3) {
			System.out.println("¡Felicidades, ganaste el juego!");
			System.out.println();
			int puntaje = usuario.getPuntaje()+5;
			usuario.setPuntaje(puntaje);
			hayGanador = true;
		}
		if(fuegoWinS.size()>=3 ||aguaWinS.size()>=3 || nieveWinS.size()>=3 || allWinS.size()>=3) {
			System.out.println("¡Lo sentimos, perdiste el juego!");
			System.out.println();
			int puntaje = usuario.getPuntaje()-2;
			usuario.setPuntaje(puntaje);
			hayGanador = true;
		}
		return hayGanador;
	}
}