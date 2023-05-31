package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Random;

public class GameplayLogic {
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
	
	private int[] randomCards;
	private int seleccion;
	private Carta rivalSelection;
	private Carta[] cinco;
	private boolean ganador,perdedor, winRound, loseRound;
	private String[] colorsWins = {"0","0","0"};
	private String wayToWin = "No";

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
	
	public void ronda(Carta[] cartasCinco, Carta getRivalSelection) {
		this.winRound=false;
		this.loseRound=false;
		int i = getSeleccion()-1;
		String playerElement = cartasCinco[i].getElemento();
		byte playerNumber = cartasCinco[i].getNumero();
		String rivalElement = getRivalSelection.getElemento();
		byte rivalNumber = getRivalSelection.getNumero();
		//En caso que ambos jugadores sacaran mismo elemento
		if (playerElement.equals(rivalElement)) {
			if (playerNumber > rivalNumber) {
				this.winRound=true;
				winsPlayer.add(cartasCinco[i]);
			} else if (playerNumber < rivalNumber) {
				this.loseRound=true;
				winsRival.add(getRivalSelection);
			}
		//En caso que sean elementos diferentes
		} else if ((playerElement.equals("Fuego") && rivalElement.equals("Nieve"))
				|| (playerElement.equals("Agua") && rivalElement.equals("Fuego"))
				|| (playerElement.equals("Nieve") && rivalElement.equals("Agua"))) {
			this.winRound=true;
			winsPlayer.add(cartasCinco[i]);
		} else {
			this.loseRound=true;
			winsRival.add(getRivalSelection);
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
					if(playerFuego.size()>=3) {
						for(int i=0;i<3;i++) {
							colorsWins[i] = playerFuego.get(i);
							wayToWin = "Fuego";
						}
					}
					else if(playerAgua.size()>=3) {
						for(int i=0;i<3;i++) {
							colorsWins[i] = playerAgua.get(i);
							wayToWin = "Agua";
						}
					}
					else if(playerNieve.size()>=3) {
						for(int i=0;i<3;i++) {
							colorsWins[i] = playerNieve.get(i);
							wayToWin = "Nieve";
						}
					}
					else if(playerElementoDiferente.size()>=3) {
						for(int i=0;i<3;i++) {
							colorsWins[i] = playerElementoDiferente.get(i);
							wayToWin = "All";
						}
					}
					hayGanador = true;
					setGanador(true);
					winsPlayer.clear();
					winsRival.clear();
					
					playerFuego.clear();
					playerAgua.clear();
					playerNieve.clear();
					playerElementoDiferente.clear();

					rivalFuego.clear();
					rivalAgua.clear();
					rivalNieve.clear();
					rivalElementoDiferente.clear();
				}
				else if(rivalFuego.size()>=3 ||rivalAgua.size()>=3 || rivalNieve.size()>=3 || rivalElementoDiferente.size()>=3) {
					if(rivalFuego.size()>=3) {
						for(int i=0;i<3;i++) {
							colorsWins[i] = rivalFuego.get(i);
							wayToWin = "Fuego";
						}
					}
					else if(rivalAgua.size()>=3) {
						for(int i=0;i<3;i++) {
							colorsWins[i] = rivalAgua.get(i);
							wayToWin = "Agua";
						}
					}
					else if(rivalNieve.size()>=3) {
						for(int i=0;i<3;i++) {
							colorsWins[i] = rivalNieve.get(i);
							wayToWin = "Nieve";
						}
					}
					else if(rivalElementoDiferente.size()>=3) {
						for(int i=0;i<3;i++) {
							colorsWins[i] = rivalElementoDiferente.get(i);
							wayToWin = "All";
						}
					}
					hayGanador = true;
					setPerdedor(true);
					winsPlayer.clear();
					winsRival.clear();
					
					playerFuego.clear();
					playerAgua.clear();
					playerNieve.clear();
					playerElementoDiferente.clear();

					rivalFuego.clear();
					rivalAgua.clear();
					rivalNieve.clear();
					rivalElementoDiferente.clear();
				}
				return hayGanador;
	}
	public void partida(Carta[] cartasCinco, Carta getRivalSelection) {
		boolean hayGanador = false;
		ronda(getCinco(),getRivalSelection);
		hayGanador=ganador(hayGanador);
	}
	public Carta importRivalSelection() {
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
	public boolean getWinRound() {
		return winRound;
	}
	public void setWinRound(boolean winRound) {
		this.winRound = winRound;
	}
	public boolean getLoseRound() {
		return loseRound;
	}
	public void setLoseRound(boolean loseRound) {
		this.loseRound = loseRound;
	}
	public String[] getColorsWins() {
		return colorsWins;
	}
	public void setColorsWins(String[] colorsWins) {
		this.colorsWins = colorsWins;
	}
	public String getWayToWin() {
		return wayToWin;
	}
	public void setWayToWin(String wayToWin) {
		this.wayToWin = wayToWin;
	}
}