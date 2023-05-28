package co.edu.unbosque.model;

import java.util.Random;

public class GameplayLogic {
	public GameplayLogic() {
	}
	//private User usuario;
	//private Carta cartasMazo[];
	//private Carta cartasCinco[];
	private int[] randomCards;
	private int seleccion;
	private Carta rivalSelection;
	
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
	
	public Carta getRivalSelection() {
		Mazo mz = new Mazo();
		this.rivalSelection = mz.rivalCard();
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
	
}
