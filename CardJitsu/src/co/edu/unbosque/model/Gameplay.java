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
	Set<String> fuegoWinP = new HashSet<>();
	Set<String> aguaWinP = new HashSet<>();
	Set<String> nieveWinP = new HashSet<>();
	Set<String> allWinP = new HashSet<>();

	Set<String> fuegoWinR = new HashSet<>();
	Set<String> aguaWinR = new HashSet<>();
	Set<String> nieveWinR = new HashSet<>();
	Set<String> allWinR = new HashSet<>();
	
	String[][] allWins = new String[4][3];
	/*fila 1: playerDD
	fila 2: playerSD
	fila 3: rivalDD
	fila 4: rivalSD*/
	Scanner sc = new Scanner(System.in);

    public Gameplay(User usuario) {
		this.usuario = usuario;
	}
    public void partidaTEST(){
        System.out.println("Usuario: " + usuario.getName());
    }
    public void partidaCPU() {
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
					fuegoWinP.add(playerColor);
				}
				if(playerElement.equals("Agua")) {
					aguaWinP.add(playerColor);
				}
				if(playerElement.equals("Nieve")) {
					nieveWinP.add(playerColor);
				}
			} else if (playerNumber < rivalNumber) {
				System.out.println("Perdiste la ronda!");
				if(rivalElement.equals("Fuego")) {
					fuegoWinR.add(rivalColor);
				}
				if(rivalElement.equals("Agua")) {
					aguaWinR.add(rivalColor);
				}
				if(rivalElement.equals("Nieve")) {
					nieveWinR.add(rivalColor);
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
				fuegoWinP.add(playerColor);
			}
			if(playerElement.equals("Agua")) {
				aguaWinP.add(playerColor);
			}
			if(playerElement.equals("Nieve")) {
				nieveWinP.add(playerColor);
			}
		} else {
			System.out.println("Perdiste la ronda!");
			System.out.println();
			if(rivalElement.equals("Fuego")) {
				fuegoWinR.add(rivalColor);
			}
			if(rivalElement.equals("Agua")) {
				aguaWinR.add(rivalColor);
			}
			if(rivalElement.equals("Nieve")) {
				nieveWinR.add(rivalColor);
			}
		}
		boolean victory = false;
		for (String colorF : fuegoWinP) {
			for (String colorA : aguaWinP) {
				for (String colorN : nieveWinP) {
					if (allWinP.add(colorF)){
						allWins[0][0]=colorF;
						allWinP.add(colorF);
					}
					System.out.println("FIRE FOR="+allWinP+allWins[0][0]); 
					if (allWinP.add(colorA)){
						allWins[0][1]=colorA;
						allWinP.add(colorA);
					}
					System.out.println("WATER FOR="+allWinP+allWins[0][1]); 
					if (allWinP.add(colorN)){
						allWins[0][2]=colorN;
						allWinP.add(colorN);
					}
					System.out.println("WINTER FOR="+allWinP+allWins[0][2]); 
					if(allWinP.size()>=3) victory = true;
					if(victory)break;
					else allWinP.remove(colorN);
				}
				if(victory)break;
				else allWinP.remove(colorA);
			}
			if(victory)break;
			else {
				allWinP.remove(colorF); 
				allWinP.clear();
			}
		}
		for (String colorF : fuegoWinR) {
			for (String colorA : aguaWinR) {
				for (String colorN : nieveWinR) {
					if (allWinR.add(colorF)){
						allWins[2][0]=colorF;
						allWinR.add(colorF);
					}
					if (allWinR.add(colorA)){
						allWins[2][1]=colorA;
						allWinR.add(colorA);
					}
					if (allWinR.add(colorN)){
						allWins[2][2]=colorN;
						allWinR.add(colorN);
					}
					if(allWinR.size()>=3) victory = true;
					if(victory)break;
					else allWinR.remove(colorN);
				}
				if(victory)break;
				else allWinR.remove(colorA);
			}
			if(victory)break;
			else {
				allWinR.remove(colorF); 
				allWinR.clear();
			}
		}
		if(fuegoWinP.size()>=3){
			fuegoWinP.toArray(allWins[1]);
		}
		if(aguaWinP.size()>=3){
			aguaWinP.toArray(allWins[1]);
		}
		if(allWinP.size()>=3){
			nieveWinP.toArray(allWins[1]);
		}
		if(fuegoWinR.size()>=3){
			fuegoWinR.toArray(allWins[3]);
		}
		if(aguaWinR.size()>=3){
			aguaWinR.toArray(allWins[3]);
		}
		if(allWinR.size()>=3){
			nieveWinR.toArray(allWins[3]);
		}
	}
	public boolean terminarPartida(boolean hayGanador){
		if(fuegoWinP.size()>=3 ||aguaWinP.size()>=3 || nieveWinP.size()>=3 || allWinP.size()>=3) {
			System.out.println("¡Felicidades, ganaste el juego!");
			System.out.println();
			int puntaje = usuario.getPuntaje()+5;
			usuario.setPuntaje(puntaje);
			hayGanador = true;
		}
		if(fuegoWinR.size()>=3 ||aguaWinR.size()>=3 || nieveWinR.size()>=3 || allWinR.size()>=3) {
			System.out.println("¡Lo sentimos, perdiste el juego!");
			System.out.println();
			int puntaje = usuario.getPuntaje()-2;
			usuario.setPuntaje(puntaje);
			hayGanador = true;
		}
		/*
		si <elemento>Win.size()>=3 entonces se gano con cartas del mismo elemento
		si allWin.size()>=3 entonces se gano con cartas de diferentes elementos
		 */
		return hayGanador;
	}
}