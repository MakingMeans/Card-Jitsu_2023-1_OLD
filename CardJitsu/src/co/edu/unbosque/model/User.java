package co.edu.unbosque.model;

public class User {

    private String name,cinturon;
    private int puntaje, nextLv;
    private byte id;
    private Carta[] mazo;
    
    public User(String name, int puntaje, byte id) {
		this.name = name;
		this.puntaje = puntaje;
        this.id = id;
	}
    public void setMazo(Carta[] mazo) {
    	this.mazo = mazo;
    }
    public Carta[] getMazo() {
    	return this.mazo;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCinturon(String cinturon){
        this.cinturon = cinturon;
    }
    public String getCinturon(){
        if(this.puntaje<10)this.cinturon="NINGUNO";
        if(this.puntaje<20&&this.puntaje>=10)this.cinturon="BLANCO";
        if(this.puntaje<30&&this.puntaje>=20)this.cinturon="AMARILLO";
        if(this.puntaje<40&&this.puntaje>=30)this.cinturon="NARANJA";
        if(this.puntaje<50&&this.puntaje>=40)this.cinturon="VERDE";
        if(this.puntaje<60&&this.puntaje>=50)this.cinturon="AZUL";
        if(this.puntaje<70&&this.puntaje>=60)this.cinturon="ROJO";
        if(this.puntaje<80&&this.puntaje>=70)this.cinturon="VIOLETA";
        if(this.puntaje<90&&this.puntaje>=80)this.cinturon="MARRON";
        if(this.puntaje>=90)this.cinturon="NEGRO";
    	return this.cinturon;
    }
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    public int getPuntaje(){
        return this.puntaje;
    }
    public void setNextLv(int nextLv){
        this.nextLv = 10-(this.puntaje%10);
    }
    public int getNextLv(){
    	this.nextLv = 10-(this.puntaje%10);
    	return this.nextLv;
    }
    public void setId(byte id){
        this.id = id;
    }
    public byte getId(){
        return this.id;
    }
}
