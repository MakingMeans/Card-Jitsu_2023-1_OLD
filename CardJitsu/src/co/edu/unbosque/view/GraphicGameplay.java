package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

import co.edu.unbosque.model.Carta;

public class GraphicGameplay extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnMus;
	private JButton btnSal;
	private JButton btnC1;
	private JButton btnC2;
	private JButton btnC3;
	private JButton btnC4;
	private JButton btnC5;
	private JLabel penguins;
	private JLabel finish;
	private JLabel name;
	private JLabel cinturon;
	private JLabel puntaje;
	private JLabel rank;
	private JLabel selectedPlayer;
	private JLabel selectedRival;
	private ArrayList<JLabel> cardsPlayerList = new ArrayList<>();
	private ArrayList<JLabel> cardsRivalList = new ArrayList<>();
	byte cardsPfuego;
	byte cardsPagua;
	byte cardsPnieve;
	byte cardsRfuego;
	byte cardsRagua;
	byte cardsRnieve;
	
	private Carta[] cards;
	private boolean prohibited=false;

	public GraphicGameplay() {
		setTitle("Retro Card-Jitsu");
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InterfazPanel panel = new InterfazPanel();
		
		ImageIcon iSal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnSal = new JButton(iSal);
		btnSal.setBounds(1127+1/2, 0, 55, 50);
		btnSal.setContentAreaFilled(false);
		btnSal.setBorderPainted(false);
		
		ImageIcon iMus = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnMus = new JButton(iMus);
		btnMus.setBounds(2+1/2, 0, 55, 50);
		btnMus.setContentAreaFilled(false);
		btnMus.setBorderPainted(false);
		
		selectedPlayer = new JLabel();
		selectedPlayer.setBounds(350, 200, 162, 192);
		Image temporal0 = new ImageIcon("src/co/edu/unbosque/assets/imagenesInterfaz/ReversoCartas.png").getImage();
		ImageIcon imgRedimension0 = new ImageIcon(
				temporal0.getScaledInstance(selectedPlayer.getWidth(), selectedPlayer.getHeight(), Image.SCALE_SMOOTH));
		selectedPlayer.setIcon(imgRedimension0);
		selectedPlayer.setVisible(false);		
		
		selectedRival = new JLabel();
		selectedRival.setBounds(650, 200, 162, 192);
		selectedRival.setIcon(imgRedimension0);
		selectedRival.setVisible(false);
		
		penguins = new JLabel();
		penguins.setBounds(65, 30, 919, 739);
		Image temporal10 = new ImageIcon("src/co/edu/unbosque/assets/imagenesInterfaz/Pinguinos.png").getImage();
		ImageIcon imgRedimension10 = new ImageIcon(
				temporal10.getScaledInstance(penguins.getWidth(), penguins.getHeight(), Image.SCALE_SMOOTH));
		penguins.setIcon(imgRedimension10);
		penguins.setVisible(true);
		
		finish = new JLabel();
		finish.setBounds(375, 220, 450, 300);
		Image tempor1 = new ImageIcon("src/co/edu/unbosque/assets/imagenesInterfaz/FinJuego.png").getImage();
		ImageIcon imgRedim1 = new ImageIcon(
				tempor1.getScaledInstance(finish.getWidth(), finish.getHeight(), Image.SCALE_SMOOTH));
		finish.setIcon(imgRedim1);
		finish.setVisible(false);	
		
		ImageIcon iC = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnC1 = new JButton(iC);
		btnC1.setBounds(135, 585, 162, 162); //(883, 555, 162, 192);
		btnC1.setContentAreaFilled(false);
		btnC1.setBorderPainted(false);
		
		btnC2 = new JButton(iC);
		btnC2.setBounds(322, 585, 162, 162);
		btnC2.setContentAreaFilled(false);
		btnC2.setBorderPainted(false);
		
		btnC3 = new JButton(iC);
		btnC3.setBounds(509, 585, 162, 162);
		btnC3.setContentAreaFilled(false);
		btnC3.setBorderPainted(false);
		
		btnC4 = new JButton(iC);
		btnC4.setBounds(696, 585, 162, 162);
		btnC4.setContentAreaFilled(false);
		btnC4.setBorderPainted(false);
		
		btnC5 = new JButton(iC);
		btnC5.setBounds(883, 585, 162, 162);
		btnC5.setContentAreaFilled(false);
		btnC5.setBorderPainted(false);
		
		Font customFont = new Font("Arial", Font.PLAIN, 10);
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Pixellari.ttf"))
					.deriveFont(Font.BOLD, 20);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		Font customFont2 = new Font("Arial", Font.PLAIN, 10);
		try {
			customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Daydream.ttf"))
					.deriveFont(Font.PLAIN, 15);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		Font customFont3 = new Font("Arial", Font.PLAIN, 10);
		try {
			customFont3 = Font
					.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Mario-Kart-DS.ttf"))
					.deriveFont(Font.PLAIN, 65);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		Font customFont4 = new Font("Arial", Font.PLAIN, 10);
		try {
			customFont4 = Font
					.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Mario-Kart-DS.ttf"))
					.deriveFont(Font.PLAIN, 20);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		name = new JLabel("Default!");
		name.setBounds(100, 550, 400, 50);
		name.setForeground(Color.WHITE);
		name.setFont(customFont);
		
		cinturon = new JLabel("Default!");
		cinturon.setBounds(705, 547+1/2, 400, 50);
		cinturon.setForeground(Color.WHITE);
		cinturon.setFont(customFont2);

		puntaje = new JLabel("Default!");
		puntaje.setBounds(895, 547+1/2, 400, 50);
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(customFont2);
		
		JLabel ranking = new JLabel("RANK");
		ranking.setBounds(2+3/4, 725, 400, 50);
		ranking.setForeground(Color.WHITE);
		ranking.setFont(customFont4);

		rank = new JLabel("Default!");
		rank.setBounds(10, 687+1/2, 400, 50);
		rank.setForeground(Color.WHITE);
		rank.setFont(customFont3);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 100; j++) {
				cardsPlayerList.add(new JLabel());
				cardsPlayerList.get((i * 10) + j).setBounds(335 + (i * 70), 35 + (j * 40), 70, 70);
				Image tempor = new ImageIcon("src/co/edu/unbosque/assets/miniCards/Transparente.png").getImage();
				ImageIcon imgRedimen = new ImageIcon(tempor.getScaledInstance(cardsPlayerList.get((i * 10) + j).getWidth(),
						cardsPlayerList.get((i * 10) + j).getHeight(), Image.SCALE_SMOOTH));
				cardsPlayerList.get((i * 10) + j).setIcon(imgRedimen);
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 100; j++) {
				cardsRivalList.add(new JLabel());
				cardsRivalList.get((i * 10) + j).setBounds(637+1/2 + (i * 70), 35 + (j * 40), 70, 70);
				Image tempor = new ImageIcon("src/co/edu/unbosque/assets/miniCards/Transparente.png").getImage();
				ImageIcon imgRedimen = new ImageIcon(tempor.getScaledInstance(cardsRivalList.get((i * 10) + j).getWidth(),
						cardsRivalList.get((i * 10) + j).getHeight(), Image.SCALE_SMOOTH));
				cardsRivalList.get((i * 10) + j).setIcon(imgRedimen);
			}
		}
		add(finish);
		add(selectedPlayer);
		add(selectedRival);
		for (int i = 0; i < 300; i++) {
			add(cardsPlayerList.get(i));
			add(cardsRivalList.get(i));
		}
		add(btnSal);
		add(btnMus);
		add(btnC1);
		add(btnC2);
		add(btnC3);
		add(btnC4);
		add(btnC5);
		add(penguins);
		add(name);
		add(cinturon);
		add(puntaje);
		add(rank);
		add(ranking);
		add(panel);
	}

	private static class InterfazPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private ImageIcon iCuenta;

		public InterfazPanel() {
			iCuenta = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/DojoInGame.png"));
		}

		@Override
		protected void paintComponent(Graphics g) {
			int screenWidth = getWidth();
			int screenHeight = getHeight();

			Image iCue = iCuenta.getImage();
			double xCue = (double) screenWidth / iCue.getWidth(this);
			double yCue = (double) screenHeight / iCue.getHeight(this);
			int nAnchoCue = (int) (iCue.getWidth(this) * xCue);
			int nAltoCue = (int) (iCue.getHeight(this) * yCue);
			g.drawImage(iCue, 0, 0, nAnchoCue, nAltoCue, this);
			super.paintComponents(g);
		}
	}
	public void miniCard(Carta card, boolean win) {
		if(win) {
			byte i=0, j=0;
			if(card.getElemento().equals("Fuego")) {
				i=0;
				cardsPfuego++;
				j=(byte)(cardsPfuego-1);
			}
			else if(card.getElemento().equals("Agua")) {
				i=1;
				cardsPagua++;
				j=(byte)(cardsPagua-1);
			}
			else if(card.getElemento().equals("Nieve")) {
				i=2;
				cardsPnieve++;
				j=(byte)(cardsPnieve-1);
			}
	        Image temporal = new ImageIcon("src/co/edu/unbosque/assets/miniCards/C"+card.getElemento()+card.getColor()+".png")
	                  .getImage();
	        ImageIcon imgRedimension1 = new ImageIcon(temporal.getScaledInstance(
	                  this.cardsPlayerList.get((i * 10) + j).getWidth(), this.cardsPlayerList.get((i * 10) + j).getHeight(), Image.SCALE_SMOOTH));
	        this.cardsPlayerList.get((i * 10) + j).setIcon(imgRedimension1);
		}
		else {
			byte i=0, j=0;
			if(card.getElemento().equals("Fuego")) {
				i=0;
				cardsRfuego++;
				j=(byte)(cardsRfuego-1);
			}
			else if(card.getElemento().equals("Agua")) {
				i=1;
				cardsRagua++;
				j=(byte)(cardsRagua-1);
			}
			else if(card.getElemento().equals("Nieve")) {
				i=2;
				cardsRnieve++;
				j=(byte)(cardsRnieve-1);
			}
	        Image temporal = new ImageIcon("src/co/edu/unbosque/assets/miniCards/C"+card.getElemento()+card.getColor()+".png")
	                  .getImage();
	        ImageIcon imgRedimension1 = new ImageIcon(temporal.getScaledInstance(
	                  this.cardsRivalList.get((i * 10) + j).getWidth(), this.cardsRivalList.get((i * 10) + j).getHeight(), Image.SCALE_SMOOTH));
	        this.cardsRivalList.get((i * 10) + j).setIcon(imgRedimension1);
		}
	}
	public void visibleSelect(Carta cardRival, int seleccion, Runnable callback) {
		this.prohibited = true;
		Image temp= new ImageIcon("src/co/edu/unbosque/assets/imagenesInterfaz/ReversoCartas.png").getImage();
		ImageIcon imgRedimension=new ImageIcon(
				temp.getScaledInstance(btnC1.getWidth(), btnC1.getHeight(), Image.SCALE_SMOOTH));
		if(seleccion==0) {
			this.btnC1.setIcon(imgRedimension);
		}
		else if(seleccion==1) {
			this.btnC2.setIcon(imgRedimension);
		}
		else if(seleccion==2) {
			this.btnC3.setIcon(imgRedimension);
		}
		else if(seleccion==3) {
			this.btnC4.setIcon(imgRedimension);
		}
		else if(seleccion==4) {
			this.btnC5.setIcon(imgRedimension);
		}
		Carta cardPlayer = this.cards[seleccion];
		Image temporal= new ImageIcon("src/co/edu/unbosque/assets/cards"+cardPlayer.getElemento()+
    			"/C"+cardPlayer.getNumero()+cardPlayer.getColor()+cardPlayer.getElemento()+".png").getImage();
		ImageIcon imgRedimension1=new ImageIcon(
				temporal.getScaledInstance(selectedPlayer.getWidth(), selectedPlayer.getHeight(), Image.SCALE_SMOOTH));
		selectedPlayer.setIcon(imgRedimension1);
		selectedPlayer.setVisible(true);
		selectedRival.setVisible(true);
		
		Timer timer = new Timer();
        TimerTask revelacion = new TimerTask() {
            @Override
            public void run() {
            	Image temporal = new ImageIcon("src/co/edu/unbosque/assets/cards"+cardRival.getElemento()+
            			"/C"+cardRival.getNumero()+cardRival.getColor()+cardRival.getElemento()+".png").getImage();
        		ImageIcon imgRedimension1=new ImageIcon(
        				temporal.getScaledInstance(selectedRival.getWidth(), selectedRival.getHeight(), Image.SCALE_SMOOTH));
        		selectedRival.setIcon(imgRedimension1);
            }
        };
        TimerTask hide = new TimerTask() {
            @Override
            public void run() {
            	selectedPlayer.setVisible(false);
        		selectedRival.setVisible(false);
        		Image temporal = new ImageIcon("src/co/edu/unbosque/assets/imagenesInterfaz/ReversoCartas.png").getImage();
        		ImageIcon imgRedimension1=new ImageIcon(
        				temporal.getScaledInstance(selectedRival.getWidth(), selectedRival.getHeight(), Image.SCALE_SMOOTH));
        		selectedRival.setIcon(imgRedimension1);
        		selectedPlayer.setIcon(imgRedimension1);
        		//prohibited = false;
        		callback.run();
            }
        };

        // Programar la tarea para que se ejecute después de 5 segundos
        timer.schedule(revelacion, 2000);
        timer.schedule(hide, 4750);
        
	}
	public void coolDown(Runnable callback) {
		Timer timer = new Timer();
		TimerTask calm = new TimerTask() {
            @Override
            public void run() {
        		callback.run();
            }
        };
        timer.schedule(calm, 3500);
	}
	public void nonvisibleSelect() {
		selectedPlayer.setVisible(false);
		selectedRival.setVisible(false);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 100; j++) {
				Image tempor = new ImageIcon("src/co/edu/unbosque/assets/miniCards/Transparente.png").getImage();
				ImageIcon imgRedimen = new ImageIcon(tempor.getScaledInstance(cardsPlayerList.get((i * 10) + j).getWidth(),
						cardsPlayerList.get((i * 10) + j).getHeight(), Image.SCALE_SMOOTH));
				cardsPlayerList.get((i * 10) + j).setIcon(imgRedimen);
				cardsRivalList.get((i * 10) + j).setIcon(imgRedimen);
			}
		}
		cardsPfuego=0;
		cardsPagua=0;
		cardsPnieve=0;
		cardsRfuego=0;
		cardsRagua=0;
		cardsRnieve=0;
	}
	public void setCartasCinco(Carta[] cards) {
			//btnC1.setBounds(135, 555, 162, 192);
			this.cards = cards;
			Image[] temporal=new Image[5];
			ImageIcon[] imgRedimension=new ImageIcon[5];
			for(int i=0;i<cards.length;i++) {
				temporal[i] = new ImageIcon("src/co/edu/unbosque/assets/cards"
	                    + cards[i].getElemento() + "/C" + cards[i].getNumero()
	                    + cards[i].getColor() + cards[i].getElemento() + ".png")
	                    .getImage();
	            imgRedimension[i] = new ImageIcon(temporal[i].getScaledInstance(
	                    this.btnC1.getWidth(), this.btnC1.getHeight(), Image.SCALE_SMOOTH));
			}
            this.btnC1.setIcon(imgRedimension[0]);
            this.btnC2.setIcon(imgRedimension[1]);
            this.btnC3.setIcon(imgRedimension[2]);
            this.btnC4.setIcon(imgRedimension[3]);
            this.btnC5.setIcon(imgRedimension[4]);
	}
	public void setUserStats(String user, String cinturon, int puntaje) {
		this.name.setText("USUARIO: "+user);
		this.cinturon.setText("LV: "+cinturon);
		this.puntaje.setText(String.valueOf("XP: "+puntaje));
		if (cinturon == "NINGUNO")
			this.cinturon.setForeground(new Color(239,239,239));
		;
		if (cinturon == "BLANCO")
			this.cinturon.setForeground(new Color(239,239,239));
		;
		if (cinturon == "AMARILLO")
			this.cinturon.setForeground(new Color(252,249,56));
		;
		if (cinturon == "NARANJA")
			this.cinturon.setForeground(new Color(255,123,71));
		;
		if (cinturon == "VERDE")
			this.cinturon.setForeground(new Color(62,237,149));
		;
		if (cinturon == "AZUL")
			this.cinturon.setForeground(new Color(62,214,237));
		;
		if (cinturon == "ROJO")
			this.cinturon.setForeground(new Color(235,86,75));
		;
		if (cinturon == "VIOLETA")
			this.cinturon.setForeground(new Color(171,91,245));
		;
		if (cinturon == "MARRON")
			this.cinturon.setForeground(new Color(155,130,48));
		;
		if (cinturon == "NEGRO")
			this.cinturon.setForeground(new Color(76,69,69));
		;
		if (puntaje < 20) {
			this.rank.setText("D");
			this.rank.setForeground(new Color(0,0,0));
		}
		if (puntaje < 40 && puntaje >= 20) {
			this.rank.setText("C");
			this.rank.setForeground(new Color(85,186,0));
		}
		if (puntaje < 60 && puntaje >= 40) {
			this.rank.setText("B");
			this.rank.setForeground(new Color(48,168,248));
		}
		if (puntaje < 80 && puntaje >= 60) {
			this.rank.setText("A");
			this.rank.setForeground(new Color(248,0,0));
		}
		if (puntaje < 100 && puntaje >= 80) {
			this.rank.setText("S");
			this.rank.setForeground(new Color(224,144,0));
		}
		if (puntaje >= 100) {
			this.rank.setText("P");
			this.rank.setForeground(new Color(142,75,232));
		}
	}
	public void visualFinish(boolean visual) {
		this.finish.setVisible(visual);
	}
	public JButton getBtnSal() {
		return btnSal;
	}
	public void setBtnSal(JButton btnSal) {
		this.btnSal = btnSal;
	}
	public JButton getBtnMus() {
		return btnMus;
	}
	public void setBtnMus(JButton btnMus) {
		this.btnMus = btnMus;
	}
	public JButton getBtnC1() {
		return btnC1;
	}
	public void setBtnC1(JButton btnC1) {
		this.btnC1 = btnC1;
	}
	public JButton getBtnC2() {
		return btnC2;
	}
	public void setBtnC2(JButton btnC2) {
		this.btnC2 = btnC2;
	}
	public JButton getBtnC3() {
		return btnC3;
	}
	public void setBtnC3(JButton btnC3) {
		this.btnC3 = btnC3;
	}
	public JButton getBtnC4() {
		return btnC4;
	}
	public void setBtnC4(JButton btnC4) {
		this.btnC4 = btnC4;
	}
	public JButton getBtnC5() {
		return btnC5;
	}
	public void setBtnC5(JButton btnC5) {
		this.btnC5 = btnC5;
	}
	public boolean getProhibited() {
		return prohibited;
	}
	public void setProhibited(boolean prohibited) {
		this.prohibited = prohibited;
	}
}