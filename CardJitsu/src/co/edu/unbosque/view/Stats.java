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

public class Stats extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnSal;
	private JLabel name;
	private JLabel id;
	private JLabel cinturon;
	private JLabel puntaje;
	private JLabel restante;
	private JLabel rank;
	private String cintColor;

	public Stats() {
		setTitle("Retro Card-Jitsu");
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InterfazPanel panel = new InterfazPanel();

		ImageIcon iSal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnSal = new JButton(iSal);
		btnSal.setBounds(528, 630, 131, 102);
		btnSal.setContentAreaFilled(false);
		btnSal.setBorderPainted(false);
		Font customFont = new Font("Arial", Font.PLAIN, 45);
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Pixellari.ttf"))
					.deriveFont(Font.PLAIN, 45);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		Font customFont2 = new Font("Arial", Font.PLAIN, 35);
		try {
			customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Daydream.ttf"))
					.deriveFont(Font.PLAIN, 40);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		Font customFont3 = new Font("Arial", Font.PLAIN, 40);
		try {
			customFont3 = Font
					.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Mario-Kart-DS.ttf"))
					.deriveFont(Font.PLAIN, 72);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		name = new JLabel("Default!");
		name.setBounds(320, 61, 400, 50);
		name.setForeground(Color.WHITE);
		name.setFont(customFont);

		id = new JLabel("Default!");
		id.setBounds(920, 61, 400, 50);
		id.setForeground(Color.WHITE);
		id.setFont(customFont);

		cinturon = new JLabel();
		cinturon.setBounds(390, 178, 675, 125);
		Image temporal = new ImageIcon("src/co/edu/unbosque/assets/cinturones/" + cintColor + ".png").getImage();
		ImageIcon imgRedimension1 = new ImageIcon(
				temporal.getScaledInstance(cinturon.getWidth(), cinturon.getHeight(), Image.SCALE_SMOOTH));
		cinturon.setIcon(imgRedimension1);

		puntaje = new JLabel("Default!");
		puntaje.setBounds(565, 495, 400, 50);
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(customFont2);

		restante = new JLabel("Default!");
		restante.setBounds(725, 341, 400, 50);
		restante.setForeground(Color.WHITE);
		restante.setFont(customFont2);

		JLabel ranking = new JLabel("RANK");
		ranking.setBounds(900, 555, 400, 50);
		ranking.setForeground(Color.WHITE);
		ranking.setFont(customFont3);

		rank = new JLabel("Default!");
		rank.setBounds(830, 555, 400, 50);
		rank.setForeground(Color.WHITE);
		rank.setFont(customFont3);

		add(btnSal);
		add(name);
		add(id);
		add(cinturon);
		add(puntaje);
		add(restante);
		add(ranking);
		add(rank);
		add(panel);
	}

	private static class InterfazPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private ImageIcon iCuenta;

		public InterfazPanel() {
			iCuenta = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/UserStats.png"));
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

	public JButton getBtnSal() {
		return btnSal;
	}

	public void setBtnSal(JButton btnSal) {
		this.btnSal = btnSal;
	}

	public void setUserStats(String user, byte id, String cinturon, int puntaje, int nextLv) {
		this.name.setText(user);
		this.id.setText(String.valueOf(id));
		this.cintColor = cinturon;
		this.puntaje.setText(String.valueOf(puntaje));
		this.restante.setText(String.valueOf(nextLv));
		if (puntaje >= 90)
			this.restante.setText("COMPLETE!");
		if (cinturon == "NINGUNO")
			this.puntaje.setForeground(new Color(239,239,239));
		;
		if (cinturon == "BLANCO")
			this.puntaje.setForeground(new Color(239,239,239));
		;
		if (cinturon == "AMARILLO")
			this.puntaje.setForeground(new Color(252,249,56));
		;
		if (cinturon == "NARANJA")
			this.puntaje.setForeground(new Color(255,123,71));
		;
		if (cinturon == "VERDE")
			this.puntaje.setForeground(new Color(62,237,149));
		;
		if (cinturon == "AZUL")
			this.puntaje.setForeground(new Color(62,214,237));
		;
		if (cinturon == "ROJO")
			this.puntaje.setForeground(new Color(235,86,75));
		;
		if (cinturon == "VIOLETA")
			this.puntaje.setForeground(new Color(171,91,245));
		;
		if (cinturon == "MARRON")
			this.puntaje.setForeground(new Color(155,130,48));
		;
		if (cinturon == "NEGRO")
			this.puntaje.setForeground(new Color(76,69,69));
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
		Image temporal = new ImageIcon("src/co/edu/unbosque/assets/cinturones/" + cintColor + ".png").getImage();
		ImageIcon imgRedimension1 = new ImageIcon(
				temporal.getScaledInstance(this.cinturon.getWidth(), this.cinturon.getHeight(), Image.SCALE_SMOOTH));
		this.cinturon.setIcon(imgRedimension1);
	}
}