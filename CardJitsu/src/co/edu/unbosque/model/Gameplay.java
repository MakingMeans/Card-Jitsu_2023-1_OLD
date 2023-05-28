package co.edu.unbosque.model;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Gameplay {
    //hay que separar distintas caracteristicas del gameplay por funciones
	private User usuario;
	private int seleccion;
	//borrar al borrar los arraylist desde fuegoWinP hasta allWins
	ArrayList<String> fuegoWinP = new ArrayList<String>();
	ArrayList<String> aguaWinP = new ArrayList<String>();
	ArrayList<String> nieveWinP = new ArrayList<String>();
	ArrayList<String> allWinP = new ArrayList<String>();

	ArrayList<String> fuegoWinR = new ArrayList<String>();
	ArrayList<String> aguaWinR = new ArrayList<String>();
	ArrayList<String> nieveWinR = new ArrayList<String>();
	ArrayList<String> allWinR = new ArrayList<String>();
	
	String[][] allWins = new String[4][3];
	/*fila 1: playerDD
	fila 2: playerSD
	fila 3: rivalDD
	fila 4: rivalSD*/
	ArrayList<Carta> winsPlayer = new ArrayList<Carta>();
	ArrayList<Carta> winsRival = new ArrayList<Carta>();

	ArrayList<String> playerFuego = new ArrayList<String>();
	ArrayList<String> playerAgua = new ArrayList<String>();
	ArrayList<String> playerNieve = new ArrayList<String>();
	ArrayList<String> playerElementoDiferente = new ArrayList<String>();

	ArrayList<String> rivalFuego = new ArrayList<String>();
	ArrayList<String> rivalAgua = new ArrayList<String>();
	ArrayList<String> rivalNieve = new ArrayList<String>();
	ArrayList<String> rivalElementoDiferente = new ArrayList<String>();

	Scanner sc = new Scanner(System.in);
	
	private Carta cincoCards[] = new Carta[5];
	private Carta card[] = usuario.getMazo();

    public Gameplay(User usuario) {
		this.usuario = usuario;
	}
    public void partidaTEST(){
        System.out.println("Usuario: " + usuario.getName());
    }
    public void partidaCPU() {
        Random rand = new Random();

        Mazo mazo = new Mazo();

        for(int i=0;i<30;i++){
			System.out.println(card[i].getElemento()+" - "+card[i].getColor()+" - "+card[i].getNumero());
		}
        int randomCarta[];
		boolean hayGanador = false;
		while (hayGanador == false) {
			Carta cartaJugador, cartaRival = mazo.rivalCard();
			randomCarta = mazo.cincoCartas(seleccion);
			for(int i=0;i<cincoCards.length;i++) {
				cincoCards[i]=card[randomCarta[i]];
			}
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
			System.out.println("Seleccionaste: " + seleccion);
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

			rondaGanador(cartaJugador,cartaRival);
			System.out.println("Fuego: -> Jugador: "+fuegoWinP+" <-  ---------------  -> Sensei: "+fuegoWinR);
			System.out.println("Agua: -> Jugador: "+aguaWinP+" <-  ---------------  -> Sensei: "+aguaWinR);
			System.out.println("Nieve: -> Jugador: "+nieveWinP+" <-  ---------------  -> Sensei: "+nieveWinR);
			System.out.println("ALLWIN PLAYER="+allWinP);
			System.out.println("ALLWIN SENSEI="+allWinR);
			System.out.println("DD FINAL ALLWIN PLAYER="+allWins[0][0]+allWins[0][1]+allWins[0][2]);
			System.out.println("SD FINAL ALLWIN PLAYER="+allWins[1][0]+allWins[1][1]+allWins[1][2]);
			System.out.println("DD FINAL ALLWIN PLAYER="+allWins[2][0]+allWins[2][1]+allWins[2][2]);
			System.out.println("SD FINAL ALLWIN PLAYER="+allWins[3][0]+allWins[3][1]+allWins[3][2]);
			System.out.println();
			hayGanador=partidaGanador(hayGanador);
		}
	}
	public void rondaGanador(Carta cartaJugador, Carta cartaRival){
		String playerElement = cartaJugador.getElemento(), playerColor = cartaJugador.getColor();
		byte playerNumber = cartaJugador.getNumero();
		String rivalElement = cartaRival.getElemento(), rivalColor = cartaRival.getColor();
		byte rivalNumber = cartaRival.getNumero();
		//En caso que ambos jugadores sacaran mismo elemento
		if (playerElement.equals(rivalElement)) {
			if (playerNumber > rivalNumber) {
				System.out.println("Ganaste la ronda!");
			    if(playerElement.equals("Fuego")) {
					winsPlayer.add(cartaJugador);
					fuegoWinP.add(playerColor);
				}
				if(playerElement.equals("Agua")) {
					winsPlayer.add(cartaJugador);
					aguaWinP.add(playerColor);
				}
				if(playerElement.equals("Nieve")) {
					winsPlayer.add(cartaJugador);
					nieveWinP.add(playerColor);
				}
			} else if (playerNumber < rivalNumber) {
				System.out.println("Perdiste la ronda!");
				if(rivalElement.equals("Fuego")) {
					winsRival.add(cartaRival);
					fuegoWinR.add(rivalColor);
				}
				if(rivalElement.equals("Agua")) {
					winsRival.add(cartaRival);
					aguaWinR.add(rivalColor);
				}
				if(rivalElement.equals("Nieve")) {
					winsRival.add(cartaRival);
					nieveWinR.add(rivalColor);
				}
			} else {
				System.out.println("Empate!");
			}
		//En caso que sean elementos diferentes
		} else if ((playerElement.equals("Fuego") && rivalElement.equals("Nieve"))
				|| (playerElement.equals("Agua") && rivalElement.equals("Fuego"))
				|| (playerElement.equals("Nieve") && rivalElement.equals("Agua"))) {
			System.out.println("Ganaste la ronda!");
			System.out.println();
			if(playerElement.equals("Fuego")) {
				winsPlayer.add(cartaJugador);
				fuegoWinP.add(playerColor);
			}
			if(playerElement.equals("Agua")) {
				winsPlayer.add(cartaJugador);
				aguaWinP.add(playerColor);
			}
			if(playerElement.equals("Nieve")) {
				winsPlayer.add(cartaJugador);
				nieveWinP.add(playerColor);
			}
		} else {
			System.out.println("Perdiste la ronda!");
			System.out.println();
			if(rivalElement.equals("Fuego")) {
				winsRival.add(cartaRival);
				fuegoWinR.add(rivalColor);
			}
			if(rivalElement.equals("Agua")) {
				winsRival.add(cartaRival);
				aguaWinR.add(rivalColor);
			}
			if(rivalElement.equals("Nieve")) {
				winsRival.add(cartaRival);
				nieveWinR.add(rivalColor);
			}
		}
	}
	public boolean partidaGanador(boolean hayGanador){
		//mecanismo de alamacenamiento para victorias de elementos iguales con colores diferentes
		for(int i = 0; i < winsPlayer.size(); i++) {
			if (winsPlayer.get(i).getElemento().equals("Fuego") && !playerFuego.contains(winsPlayer.get(i).getColor())){
				playerFuego.add(winsPlayer.get(i).getColor());
			}
			else if (winsPlayer.get(i).getElemento().equals("Agua") && !playerAgua.contains(winsPlayer.get(i).getColor())){
				playerAgua.add(winsPlayer.get(i).getColor());
			}
			else if (winsPlayer.get(i).getElemento().equals("Nieve") && !playerNieve.contains(winsPlayer.get(i).getColor())){
				playerNieve.add(winsPlayer.get(i).getColor());
			}
		}
		for(int i = 0; i < winsRival.size(); i++) {
			if (winsRival.get(i).getElemento().equals("Fuego") && !rivalFuego.contains(winsRival.get(i).getColor())){
				rivalFuego.add(winsRival.get(i).getColor());
			}
			else if (winsRival.get(i).getElemento().equals("Agua") && !rivalAgua.contains(winsRival.get(i).getColor())){
				rivalAgua.add(winsRival.get(i).getColor());
			}
			else if (winsRival.get(i).getElemento().equals("Nieve") && !rivalNieve.contains(winsRival.get(i).getColor())){
				rivalNieve.add(winsRival.get(i).getColor());
			}
		}
		//mecanismo de combinaciones sin repeticion entre las cartas y sus colores, para mecanismo de vicotrias de elementos diferentes con colores diferentes
		for(int i = 0; i < playerFuego.size(); i++) {
			for(int j = 0; j < playerAgua.size(); j++) {
				for(int k = 0; k < playerNieve.size(); k++) {
					if (!playerFuego.get(i).equals(playerAgua.get(j)) && !playerFuego.get(i).equals(playerNieve.get(k)) && !playerAgua.get(j).equals(playerNieve.get(k))){
						playerElementoDiferente.add(playerFuego.get(i));
						playerElementoDiferente.add(playerAgua.get(j));
						playerElementoDiferente.add(playerNieve.get(k));
					}
				}
			}
		}
		for(int i = 0; i < rivalFuego.size(); i++) {
			for(int j = 0; j < rivalAgua.size(); j++) {
				for(int k = 0; k < rivalNieve.size(); k++) {
					if (!rivalFuego.get(i).equals(rivalAgua.get(j)) && !rivalFuego.get(i).equals(rivalNieve.get(k)) && !rivalAgua.get(j).equals(rivalNieve.get(k))){
						rivalElementoDiferente.add(rivalFuego.get(i));
						rivalElementoDiferente.add(rivalAgua.get(j));
						rivalElementoDiferente.add(rivalNieve.get(k));
					}
				}
			}
		}
		//verificar si ya hay alguna victoria
		if(playerFuego.size()>=3 ||playerAgua.size()>=3 || playerNieve.size()>=3 || playerElementoDiferente.size()>=3) {
			System.out.println("¡Felicidades, ganaste el juego!");
			System.out.println();
			int puntaje = usuario.getPuntaje()+5;
			usuario.setPuntaje(puntaje);
			hayGanador = true;
		}
		if(rivalFuego.size()>=3 ||rivalAgua.size()>=3 || rivalNieve.size()>=3 || rivalElementoDiferente.size()>=3) {
			System.out.println("¡Lo sentimos, perdiste el juego!");
			System.out.println();
			int puntaje = usuario.getPuntaje()-2;
			usuario.setPuntaje(puntaje);
			hayGanador = true;
		}
		return hayGanador;
	}
	public Carta[] cincoCartas() {
		Mazo mazo = new Mazo();
		int[] randomCarta;
		randomCarta = mazo.cincoCartas(seleccion);
		for(int i=0;i<cincoCards.length;i++) {
			cincoCards[i]=card[randomCarta[i]];
		}
		return cincoCards;
	}
}