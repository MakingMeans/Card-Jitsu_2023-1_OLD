package co.edu.unbosque.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
//import java.io.File;
//import java.io.IOException;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.Carta;

public class SeleccionMazo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton btnRand;
    private JButton btnCus;
    private JButton btnSal;
    private JLabel[] cards;
    private JLabel[] ids;
    private JLabel bigCard;
    private Carta[] mazo;
    private JButton btnAgua;
    private JButton btnNieve;
    private JButton btnFuego;
    private JTextField digID;
    private JTextField digNUM;
	private	JButton btnAmarillo;
    private JButton btnAzul;
    private JButton btnVerde;
    private JButton btnVioleta;
    private JButton btnRojo;
    private JButton btnNaranja;
    
    private byte num;
	private String element;
	private String color;
	private byte id;
    
    public SeleccionMazo() {
        setTitle("Retro Card-Jitsu");
        setSize(1200, 832); //1200,720
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InterfazPanel panel = new InterfazPanel();
        
        ImageIcon iRand = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnRand = new JButton(iRand);
        btnRand.setBounds(350, 740, 182, 58);
        btnRand.setContentAreaFilled(false);
        btnRand.setBorderPainted(true);
        ImageIcon iCus = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnCus = new JButton(iCus);
        btnCus.setBounds(670, 740, 182, 58);
        btnCus.setContentAreaFilled(false);
        btnCus.setBorderPainted(true);
        ImageIcon iSal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnSal = new JButton(iSal);
        btnSal.setBounds(560, 740, 81, 58);
        btnSal.setContentAreaFilled(false);
        btnSal.setBorderPainted(true);
        
        
        ImageIcon iAgu = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnAgua = new JButton(iAgu);
        btnAgua.setBounds(320, 445, 144, 78);
        btnAgua.setContentAreaFilled(false);
        btnAgua.setBorderPainted(true);
        ImageIcon iNie = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnNieve = new JButton(iNie);
        btnNieve.setBounds(318, 625, 150, 74);
        btnNieve.setContentAreaFilled(false);
        btnNieve.setBorderPainted(true);
        ImageIcon iFue = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnFuego = new JButton(iFue);
        btnFuego.setBounds(311, 530, 170, 85);
        btnFuego.setContentAreaFilled(false);
        btnFuego.setBorderPainted(true);
        
        
        ImageIcon iAma = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnAmarillo = new JButton(iAma);
        btnAmarillo.setBounds(720, 441, 202, 78);
        btnAmarillo.setContentAreaFilled(false);
        btnAmarillo.setBorderPainted(true);
        ImageIcon iAzu = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnAzul = new JButton(iAzu);
        btnAzul.setBounds(757, 520, 127, 70);
        btnAzul.setContentAreaFilled(false);
        btnAzul.setBorderPainted(true);
        ImageIcon iVer = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnVerde = new JButton(iVer);
        btnVerde.setBounds(975, 594, 150, 78);
        btnVerde.setContentAreaFilled(false);
        btnVerde.setBorderPainted(true);
        ImageIcon iVio = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnVioleta = new JButton(iVio);
        btnVioleta.setBounds(728, 594, 180, 78);
        btnVioleta.setContentAreaFilled(false);
        btnVioleta.setBorderPainted(true);
        ImageIcon iRoj = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnRojo = new JButton(iRoj);
        btnRojo.setBounds(980, 520, 127, 70);
        btnRojo.setContentAreaFilled(false);
        btnRojo.setBorderPainted(true);
        ImageIcon iNar = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnNaranja = new JButton(iNar);
        btnNaranja.setBounds(945, 441, 202, 78);
        btnNaranja.setContentAreaFilled(false);
        btnNaranja.setBorderPainted(true);
        
        
        digID = new JTextField();
        digID.setBounds(535, 480, 130, 70);
        digID.setEditable(true);
        digID.setEnabled(true);
        Font customFont1= new Font("Arial", Font.PLAIN, 50);
        try {
        	customFont1 = Font.createFont(Font.TRUETYPE_FONT, 
            		new File("src/co/edu/unbosque/assets/fonts/Pixellari.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        digID.setFont(customFont1);
        digID.setBackground(new Color(159, 108, 63));
        digID.setForeground(Color.white);
        digID.setHorizontalAlignment(JTextField.CENTER);
        
        digNUM = new JTextField();
        digNUM.setBounds(535, 620, 130, 70);
        digNUM.setEditable(true);
        digNUM.setEnabled(true);
        Font customFont2= new Font("Arial", Font.PLAIN, 50);
        try {
        	customFont2 = Font.createFont(Font.TRUETYPE_FONT, 
            		new File("src/co/edu/unbosque/assets/fonts/Pixellari.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        digNUM.setFont(customFont2);
        digNUM.setBackground(new Color(159, 108, 63));
        digNUM.setForeground(Color.white);
        digNUM.setHorizontalAlignment(JTextField.CENTER);
        
        
        
        bigCard = new JLabel();
		bigCard.setBounds(60,462,216,256);
		Image temporal0= new ImageIcon("src/co/edu/unbosque/assets/imagenesInterfaz/ReversoCartas.png").getImage();
		ImageIcon imgRedimension0=new ImageIcon(
				temporal0.getScaledInstance(bigCard.getWidth(), bigCard.getHeight(), Image.SCALE_SMOOTH));
		bigCard.setIcon(imgRedimension0);
        
        cards = new JLabel[30];
        for(int i=0;i<3;i++) {
        	for(int j=0;j<10;j++) {
        		cards[(i*10)+j] = new JLabel();
            	//cinturon[(i*10)+j].setBounds(12+(j*120),12+(i*120),162,192);
        		cards[(i*10)+j].setBounds(12+(j*117),12+(i*135),80,100);
        		Image temporal= new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png").getImage();
        		ImageIcon imgRedimension1=new ImageIcon(
        				temporal.getScaledInstance(cards[(i*10)+j].getWidth(), cards[(i*10)+j].getHeight(), Image.SCALE_SMOOTH));
        		cards[(i*10)+j].setIcon(imgRedimension1);
        	}
        }
        
        Font customFont= new Font("Arial", Font.PLAIN, 50);
        try {
        	customFont = Font.createFont(Font.TRUETYPE_FONT, 
            		new File("src/co/edu/unbosque/assets/fonts/Daydream.ttf")).deriveFont(Font.PLAIN, 30);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        ids = new JLabel[30];
        for(int i=0;i<3;i++) {
        	for(int j=0;j<10;j++) {
        		ids[(i*10)+j] = new JLabel(String.valueOf((i*10)+j+1));
        		ids[(i*10)+j].setBounds(28+((j*115)),(66+(i*130)),92,122);
        		ids[(i*10)+j].setForeground(Color.WHITE);
        		ids[(i*10)+j].setFont(customFont);
        	}
        }
        for(int i=0;i<cards.length;i++) {
        	add(ids[i]);
        	add(cards[i]);
		}
        add(digNUM);
        add(digID);
        add(btnRand);
        add(btnCus);
        add(btnSal);
        add(bigCard);
        add(btnAgua);
        add(btnNieve);
        add(btnFuego);
        add(btnAmarillo);
        add(btnNaranja);
        add(btnVioleta);
        add(btnVerde);
        add(btnRojo);
        add(btnAzul);
        add(panel);
    }
    private static class InterfazPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private ImageIcon iMenu;
        public InterfazPanel() {
            iMenu = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/Mazo.png"));
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponents(g);
            Image iMen = iMenu.getImage();
            g.drawImage(iMen, 0, 0, 1200, 832, this);
        }
	}
    public void setCurrentMazo(Carta[] mazo){
    	this.mazo = mazo;
    	for(int i=0;i<3;i++) {
        	for(int j=0;j<10;j++) {
        		this.cards[(i*10)+j].setBounds(36+((j*115)),(18+(i*130)),92,122);
        		Image temporal= new ImageIcon("src/co/edu/unbosque/assets/cards"+this.mazo[(i*10)+j].getElemento()+
            			"/C"+this.mazo[(i*10)+j].getNumero()+this.mazo[(i*10)+j].getColor()+this.mazo[(i*10)+j].getElemento()+".png").getImage();
        		ImageIcon imgRedimension1=new ImageIcon(
        				temporal.getScaledInstance(this.cards[(i*10)+j].getWidth(), this.cards[(i*10)+j].getHeight(), Image.SCALE_SMOOTH));
        		this.cards[(i*10)+j].setIcon(imgRedimension1);
        	}
        }
    }
    public void setBigCard(String num, String elemento, String color) {
    	Image temporal= new ImageIcon("src/co/edu/unbosque/assets/cards"+elemento+
    			"/C"+num+color+elemento+".png").getImage();
		ImageIcon imgRedimension1=new ImageIcon(
				temporal.getScaledInstance(this.bigCard.getWidth(), this.bigCard.getHeight(), Image.SCALE_SMOOTH));
		this.bigCard.setIcon(imgRedimension1);
    }
    public void resetBigCard() {
    	Image temporal= new ImageIcon("src/co/edu/unbosque/assets/imagenesInterfaz/ReversoCartas.png").getImage();
		ImageIcon imgRedimension1=new ImageIcon(
				temporal.getScaledInstance(this.bigCard.getWidth(), this.bigCard.getHeight(), Image.SCALE_SMOOTH));
		this.bigCard.setIcon(imgRedimension1);
    }
	public JButton getBtnRand() {
		return btnRand;
	}
	public void setBtnRand(JButton btnRand) {
		this.btnRand = btnRand;
	}
	public JButton getBtnCus() {
		return btnCus;
	}
	public void setBtnCus(JButton btnCus) {
		this.btnCus = btnCus;
	}
	public JButton getBtnSal() {
		return btnSal;
	}
	public void setBtnSal(JButton btnSal) {
		this.btnSal = btnSal;
	}
	public JButton getBtnAgua() {
		return btnAgua;
	}
	public void setBtnAgua(JButton btnAgua) {
		this.btnAgua = btnAgua;
	}
	public JButton getBtnNieve() {
		return btnNieve;
	}
	public void setBtnNieve(JButton btnNieve) {
		this.btnNieve = btnNieve;
	}
	public JButton getBtnFuego() {
		return btnFuego;
	}
	public void setBtnFuego(JButton btnFuego) {
		this.btnFuego = btnFuego;
	}
	public JTextField getDigID() {
		return digID;
	}
	public void setDigID(JTextField digID) {
		this.digID = digID;
	}
	public JTextField getDigNUM() {
		return digNUM;
	}
	public void setDigNUM(JTextField digNUM) {
		this.digNUM = digNUM;
	}
	public JButton getBtnAmarillo() {
		return btnAmarillo;
	}
	public void setBtnAmarillo(JButton btnAmarillo) {
		this.btnAmarillo = btnAmarillo;
	}
	public JButton getBtnAzul() {
		return btnAzul;
	}
	public void setBtnAzul(JButton btnAzul) {
		this.btnAzul = btnAzul;
	}
	public JButton getBtnVerde() {
		return btnVerde;
	}
	public void setBtnVerde(JButton btnVerde) {
		this.btnVerde = btnVerde;
	}
	public JButton getBtnVioleta() {
		return btnVioleta;
	}
	public void setBtnVioleta(JButton btnVioleta) {
		this.btnVioleta = btnVioleta;
	}
	public JButton getBtnRojo() {
		return btnRojo;
	}
	public void setBtnRojo(JButton btnRojo) {
		this.btnRojo = btnRojo;
	}
	public JButton getBtnNaranja() {
		return btnNaranja;
	}
	public void setBtnNaranja(JButton btnNaranja) {
		this.btnNaranja = btnNaranja;
	}
	public byte getNum() {
		return num;
	}
	public void setNum(byte num) {
		this.num = num;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public byte getId() {
		return id;
	}
	public void setId(byte id) {
		this.id = id;
	}
}