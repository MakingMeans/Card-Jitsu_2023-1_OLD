package co.edu.unbosque.model;
import java.util.Random;
import java.util.Scanner;

public class Mazo {

	private Carta card[] = new Carta[30];
	Scanner sc = new Scanner(System.in);
	//private Carta preCard;
	private byte[] barajaN = {2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	private String[] barajaC = {"Amaraillo","Azul","Verde","Rojo","Violeta","Naranja"};
	private String[] barajaE = {"Fuego","Nieve","Agua"};
	private byte randomN;
	private String randomE,randomC;
	String elemento, color;
	byte numero;
	
	public void crearMazoAl() {
		Random rand = new Random();
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
			System.out.println("CARTA #"+(i+1));
			System.out.print("Numero-->");
			randomN = sc.nextByte();
			System.out.print("Color-->");
			randomC = sc.next();
			System.out.print("Elemento-->");
			randomE = sc.next();
			Carta preCard=new Carta(randomE, randomN, randomC);
			for(int j=0;j<i;j++){
				if(card[j].getElemento().equals(preCard.getElemento())&&
				card[j].getColor().equals(preCard.getColor())&&
				card[j].getNumero()==preCard.getNumero()) repetida=true;
			}
			if(repetida==false) {
				card[i]=preCard; System.out.println("No se repite");
			}
			else {
				i--; System.out.println("SE RESTA PORQUE SE REPITE");
			}
		}
		
	}

	public void mostrarMazo() {
		for(int i=0;i<30;i++) {
		System.out.println(card[i].getElemento()+" - "+card[i].getColor()+" - "+card[i].getNumero());
		}
	}
}
