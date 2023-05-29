package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Random;

public class GameplayLogic {
	public GameplayLogic() {
		
	}
	//private User usuario;
	//private Carta cartasMazo[];
	//private Carta cartasCinco[];
	ArrayList<Carta> winsPlayer = new ArrayList<Carta>();
	ArrayList<Carta> winsRival = new ArrayList<Carta>();
	
	ArrayList<String> fuegoWinP = new ArrayList<String>();
	ArrayList<String> aguaWinP = new ArrayList<String>();
	ArrayList<String> nieveWinP = new ArrayList<String>();
	ArrayList<String> allWinP = new ArrayList<String>();

	ArrayList<String> fuegoWinR = new ArrayList<String>();
	ArrayList<String> aguaWinR = new ArrayList<String>();
	ArrayList<String> nieveWinR = new ArrayList<String>();
	ArrayList<String> allWinR = new ArrayList<String>();
	
	ArrayList<String> playerFuego = new ArrayList<String>();
	ArrayList<String> playerAgua = new ArrayList<String>();
	ArrayList<String> playerNieve = new ArrayList<String>();
	ArrayList<String> playerElementoDiferente = new ArrayList<String>();

	ArrayList<String> rivalFuego = new ArrayList<String>();
	ArrayList<String> rivalAgua = new ArrayList<String>();
	ArrayList<String> rivalNieve = new ArrayList<String>();
	ArrayList<String> rivalElementoDiferente = new ArrayList<String>();
	private int[] randomCards;
	private int seleccion;
	private Carta rivalSelection;
	private Carta[] cinco;
	private boolean ganador,perdedor;

	Random rand = new Random();
	
	public Carta[] cincoCartas(User usuario){
		int randomCard;
		Carta cartasMazo[] = usuario.getMazo();
		if(randomCards==null){
			randomCards = new int[5];
			for(int i = 0; i < randomCards.length; i++){
				randomCard = rand.nextInt(cartasMazo.length);
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
				randomCard=rand.nextInt(cartasMazo.length);
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
		Carta[] cartasCinco=new Carta[5];
		for(int i = 0; i < randomCards.length; i++) {
			cartasCinco[i]=cartasMazo[randomCards[i]];
		}
		return cartasCinco;
	}
	
	public void Ronda(Carta[] cartasCinco, Carta getRivalSelection) {
		int i = getSeleccion()-1;
		String playerElement = cartasCinco[i].getElemento(), playerColor = cartasCinco[i].getColor();
		byte playerNumber = cartasCinco[i].getNumero();
		String rivalElement = getRivalSelection.getElemento(), rivalColor = getRivalSelection.getColor();
		byte rivalNumber = getRivalSelection.getNumero();
		//En caso que ambos jugadores sacaran mismo elemento
		if (playerElement.equals(rivalElement)) {
			if (playerNumber > rivalNumber) {
				System.out.println("Ganaste la ronda!");
			    if(playerElement.equals("Fuego")) {
					winsPlayer.add(cartasCinco[i]);
					fuegoWinP.add(playerColor);
				}
				if(playerElement.equals("Agua")) {
					winsPlayer.add(cartasCinco[i]);
					aguaWinP.add(playerColor);
				}
				if(playerElement.equals("Nieve")) {
					winsPlayer.add(cartasCinco[i]);
					nieveWinP.add(playerColor);
				}
			} else if (playerNumber < rivalNumber) {
				System.out.println("Perdiste la ronda!");
				if(rivalElement.equals("Fuego")) {
					winsRival.add(getRivalSelection);
					fuegoWinR.add(rivalColor);
				}
				if(rivalElement.equals("Agua")) {
					winsRival.add(getRivalSelection);
					aguaWinR.add(rivalColor);
				}
				if(rivalElement.equals("Nieve")) {
					winsRival.add(getRivalSelection);
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
				winsPlayer.add(cartasCinco[i]);
				fuegoWinP.add(playerColor);
			}
			if(playerElement.equals("Agua")) {
				winsPlayer.add(cartasCinco[i]);
				aguaWinP.add(playerColor);
			}
			if(playerElement.equals("Nieve")) {
				winsPlayer.add(cartasCinco[i]);
				nieveWinP.add(playerColor);
			}
		} else {
			System.out.println("Perdiste la ronda!");
			System.out.println();
			if(rivalElement.equals("Fuego")) {
				winsRival.add(getRivalSelection);
				fuegoWinR.add(rivalColor);
			}
			if(rivalElement.equals("Agua")) {
				winsRival.add(getRivalSelection);
				aguaWinR.add(rivalColor);
			}
			if(rivalElement.equals("Nieve")) {
				winsRival.add(getRivalSelection);
				nieveWinR.add(rivalColor);
			}
		}
	}
	public boolean ganador(boolean hayGanador) {
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
					setGanador(true);
					//int puntaje = usuario.getPuntaje()+5;
					//usuario.setPuntaje(puntaje);
					hayGanador = true;
				}
				if(rivalFuego.size()>=3 ||rivalAgua.size()>=3 || rivalNieve.size()>=3 || rivalElementoDiferente.size()>=3) {
					System.out.println("¡Lo sentimos, perdiste el juego!");
					System.out.println();
					//int puntaje = usuario.getPuntaje()-2;
					//usuario.setPuntaje(puntaje);
					hayGanador = true;
					setPerdedor(true);
				}
				return hayGanador;
	}
	public void partida(Carta[] cartasCinco, Carta getRivalSelection) {
		int i = getSeleccion()-1;
		boolean hayGanador = false;
		
			System.out.println("Tu carta: "+cartasCinco[i].getElemento()+" - "+cartasCinco[i].getColor()+" - "+cartasCinco[i].getNumero()+"\n");
			System.out.println("Carta del sensei: "+getRivalSelection.getElemento()+" - "+getRivalSelection.getColor()+" - "+getRivalSelection.getNumero()+"\n");

			Ronda(getCinco(),getRivalSelection);
			System.out.println("Fuego: -> Jugador: "+fuegoWinP+" <-  ---------------  -> Sensei: "+fuegoWinR);
			System.out.println("Agua: -> Jugador: "+aguaWinP+" <-  ---------------  -> Sensei: "+aguaWinR);
			System.out.println("Nieve: -> Jugador: "+nieveWinP+" <-  ---------------  -> Sensei: "+nieveWinR);
			System.out.println();
			hayGanador=ganador(hayGanador);
		
	}
	
	
	public Carta RivalSelection() {
		Mazo mz = new Mazo();
		this.rivalSelection = mz.rivalCard();
		return rivalSelection;
	}
	public Carta getRivalSelection() {
		return rivalSelection;
	}
	public void setRivalSelection(Carta rivalSelection) {
		this.rivalSelection = rivalSelection;
	}
	public int getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}
	public int[] getRandomCards() {
		return randomCards;
	}
	public void setRandomCards(int[] randomCards) {
		this.randomCards = randomCards;
	}
	public Carta[] getCinco() {
		return cinco;
	}
	public void setCinco(Carta[] cinco) {
		this.cinco = cinco;
	}

	public boolean getGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}
	public boolean getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(boolean perdedor) {
		this.perdedor = perdedor;
	}
	
}
