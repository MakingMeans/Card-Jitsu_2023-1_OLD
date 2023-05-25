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
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.unbosque.model.Carta;

public class SeleccionMazo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel[] cards;
    private JLabel[] ids;
    private Carta[] mazo;
	
    public SeleccionMazo() {
        setTitle("Retro Card-Jitsu");
        setSize(1200, 832);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InterfazPanel panel = new InterfazPanel();
        
        cards = new JLabel[30];
        for(int i=0;i<3;i++) {
        	for(int j=0;j<10;j++) {
        		cards[(i*10)+j] = new JLabel();
            	//cinturon[(i*10)+j].setBounds(12+(j*120),12+(i*120),162,192);
        		cards[(i*10)+j].setBounds(12+(j*117),12+(i*140),108,128);
        		Image temporal= new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png").getImage();
        		ImageIcon imgRedimension1=new ImageIcon(
        				temporal.getScaledInstance(cards[(i*10)+j].getWidth(), cards[(i*10)+j].getHeight(), Image.SCALE_SMOOTH));
        		cards[(i*10)+j].setIcon(imgRedimension1);
        	}
        }
        
        Font customFont= new Font("Arial", Font.PLAIN, 50);
        try {
        	customFont = Font.createFont(Font.TRUETYPE_FONT, 
            		new File("src/co/edu/unbosque/assets/fonts/Daydream.ttf")).deriveFont(Font.PLAIN, 35);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        ids = new JLabel[30];
        for(int i=0;i<3;i++) {
        	for(int j=0;j<10;j++) {
        		ids[(i*10)+j] = new JLabel(String.valueOf((i*10)+j+1));
        		ids[(i*10)+j].setBounds(8+(j*117),60+(i*140),108,128);
        		ids[(i*10)+j].setForeground(Color.WHITE);
        		ids[(i*10)+j].setFont(customFont);
        	}
        }
        for(int i=0;i<cards.length;i++) {
        	add(ids[i]);
        	add(cards[i]);
		}
        add(panel);
    }
    private static class InterfazPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private ImageIcon iMenu;
        public InterfazPanel() {
            iMenu = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/UserStats.png"));
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
        		this.cards[(i*10)+j].setBounds(12+(j*117),12+(i*140),108,128);
        		Image temporal= new ImageIcon("src/co/edu/unbosque/assets/cards"+this.mazo[(i*10)+j].getElemento()+
            			"/C"+this.mazo[(i*10)+j].getNumero()+this.mazo[(i*10)+j].getColor()+this.mazo[(i*10)+j].getElemento()+".png").getImage();
        		ImageIcon imgRedimension1=new ImageIcon(
        				temporal.getScaledInstance(this.cards[(i*10)+j].getWidth(), this.cards[(i*10)+j].getHeight(), Image.SCALE_SMOOTH));
        		this.cards[(i*10)+j].setIcon(imgRedimension1);
        	}
        }
    }
}