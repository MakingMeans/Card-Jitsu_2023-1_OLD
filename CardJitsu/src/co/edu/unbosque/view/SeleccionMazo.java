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
        setSize(1200, 800); //1200,720
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InterfazPanel panel = new InterfazPanel();
        
        ImageIcon iRand = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnRand = new JButton(iRand);
		btnRand.setBounds(346, 679, 180, 85);
		btnRand.setContentAreaFilled(false);
		btnRand.setBorderPainted(false);
		
		ImageIcon iSal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnSal = new JButton(iSal);
		btnSal.setBounds(550, 679, 87, 85);
		btnSal.setContentAreaFilled(false);
		btnSal.setBorderPainted(false);

		ImageIcon iCus = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnCus = new JButton(iCus);
		btnCus.setBounds(661, 679, 180, 85);
		btnCus.setContentAreaFilled(false);
		btnCus.setBorderPainted(false);

		ImageIcon iAgu = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnAgua = new JButton(iAgu);
		btnAgua.setBounds(315, 399, 149, 85);
		btnAgua.setContentAreaFilled(false);
		btnAgua.setBorderPainted(false);
		
		ImageIcon iFue = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnFuego = new JButton(iFue);
		btnFuego.setBounds(303, 483, 174, 84);
		btnFuego.setContentAreaFilled(false);
		btnFuego.setBorderPainted(false);

		ImageIcon iNie = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnNieve = new JButton(iNie);
		btnNieve.setBounds(309, 566, 161, 73);
		btnNieve.setContentAreaFilled(false);
		btnNieve.setBorderPainted(false);

		ImageIcon iAma = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnAmarillo = new JButton(iAma);
		btnAmarillo.setBounds(710, 399, 205, 73);
		btnAmarillo.setContentAreaFilled(false);
		btnAmarillo.setBorderPainted(false);

		ImageIcon iAzu = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnAzul = new JButton(iAzu);
		btnAzul.setBounds(747, 471, 125, 73);
		btnAzul.setContentAreaFilled(false);
		btnAzul.setBorderPainted(false);

		ImageIcon iVio = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnVioleta = new JButton(iVio);
		btnVioleta.setBounds(716, 543, 186, 73);
		btnVioleta.setContentAreaFilled(false);
		btnVioleta.setBorderPainted(false);
		
		ImageIcon iNar = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnNaranja = new JButton(iNar);
		btnNaranja.setBounds(933, 399, 204, 73);
		btnNaranja.setContentAreaFilled(false);
		btnNaranja.setBorderPainted(false);

		ImageIcon iRoj = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnRojo = new JButton(iRoj);
		btnRojo.setBounds(970, 471, 130, 73);
		btnRojo.setContentAreaFilled(false);
		btnRojo.setBorderPainted(false);
		
		ImageIcon iVer = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnVerde = new JButton(iVer);
		btnVerde.setBounds(957, 543, 155, 73);
		btnVerde.setContentAreaFilled(false);
		btnVerde.setBorderPainted(false);

		digID = new JTextField();
		digID.setBounds(531, 435, 124, 72);
		digID.setEditable(true);
		digID.setEnabled(true);
		Font customFont1 = new Font("Arial", Font.PLAIN, 50);

		try {
			customFont1 = Font
					.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Pixellari.ttf"))
					.deriveFont(Font.PLAIN, 50);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		digID.setFont(customFont1);
		digID.setBackground(new Color(159, 108, 63));
		digID.setForeground(Color.white);
		digID.setHorizontalAlignment(JTextField.CENTER);

		digNUM = new JTextField();
		digNUM.setBounds(531, 560, 124, 72);
		digNUM.setEditable(true);
		digNUM.setEnabled(true);
		Font customFont2 = new Font("Arial", Font.PLAIN, 50);
		try {
			customFont2 = Font
					.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Pixellari.ttf"))
					.deriveFont(Font.PLAIN, 50);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		digNUM.setFont(customFont2);
		digNUM.setBackground(new Color(159, 108, 63));
		digNUM.setForeground(Color.white);
		digNUM.setHorizontalAlignment(JTextField.CENTER);

		bigCard = new JLabel();
		bigCard.setBounds(59, 418, 216, 256);
		Image temporal0 = new ImageIcon("src/co/edu/unbosque/assets/imagenesInterfaz/ReversoCartas.png").getImage();
		ImageIcon imgRedimension0 = new ImageIcon(
				temporal0.getScaledInstance(bigCard.getWidth(), bigCard.getHeight(), Image.SCALE_SMOOTH));
		bigCard.setIcon(imgRedimension0);

		cards = new JLabel[30];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				cards[(i * 10) + j] = new JLabel();
				cards[(i * 10) + j].setBounds(12 + (j * 117), 12 + (i * 135), 80, 100);
				Image temporal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png").getImage();
				ImageIcon imgRedimension1 = new ImageIcon(temporal.getScaledInstance(cards[(i * 10) + j].getWidth(),
						cards[(i * 10) + j].getHeight(), Image.SCALE_SMOOTH));
				cards[(i * 10) + j].setIcon(imgRedimension1);
			}
		}

		Font customFont = new Font("Arial", Font.PLAIN, 50);
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Daydream.ttf"))
					.deriveFont(Font.PLAIN, 22);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		ids = new JLabel[30];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				ids[(i * 10) + j] = new JLabel(String.valueOf((i * 10) + j + 1));
				ids[(i * 10) + j].setBounds(74 + ((j * 105)), (68 + (i * 114)), 81, 96);
				ids[(i * 10) + j].setForeground(Color.WHITE);
				ids[(i * 10) + j].setFont(customFont);
			}
		}
		for (int i = 0; i < cards.length; i++) {
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
        private ImageIcon iMazo;

        public InterfazPanel() {
            iMazo = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/Mazo.png"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            int screenWidth = getWidth();
            int screenHeight = getHeight();

            Image iMaz = iMazo.getImage();
            double xMaz = (double) screenWidth / iMaz.getWidth(this);
            double yMaz = (double) screenHeight / iMaz.getHeight(this);
            int nAnchoMaz = (int) (iMaz.getWidth(this) * xMaz);
            int nAltoMaz = (int) (iMaz.getHeight(this) * yMaz);
            g.drawImage(iMaz, 0, 0, nAnchoMaz, nAltoMaz, this);
            super.paintComponents(g);
        }
	}
    public void setCurrentMazo(Carta[] mazo) {
        this.mazo = mazo;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                this.cards[(i * 10) + j].setBounds(80 + ((j * 105)), (29 + (i * 114)), 81, 96);
                Image temporal = new ImageIcon("src/co/edu/unbosque/assets/cards"
                        + this.mazo[(i * 10) + j].getElemento() + "/C" + this.mazo[(i * 10) + j].getNumero()
                        + this.mazo[(i * 10) + j].getColor() + this.mazo[(i * 10) + j].getElemento() + ".png")
                        .getImage();
                ImageIcon imgRedimension1 = new ImageIcon(temporal.getScaledInstance(
                        this.cards[(i * 10) + j].getWidth(), this.cards[(i * 10) + j].getHeight(), Image.SCALE_SMOOTH));
                this.cards[(i * 10) + j].setIcon(imgRedimension1);
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