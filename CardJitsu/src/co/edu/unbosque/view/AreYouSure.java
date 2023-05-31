package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class AreYouSure extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel pregunta;
	private JLabel name;
	private JLabel yes;
	private JLabel no;
	private JButton btnConf;
	private JButton btnVol;

	public AreYouSure() {
		setTitle("Retro Card-Jitsu");
		setSize(350, 225);
		setLocationRelativeTo(null);
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InterfazDigitacionPanel panel = new InterfazDigitacionPanel();
		Font customFont = new Font("Arial", Font.PLAIN, 50);
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Pixellari.ttf"))
					.deriveFont(Font.PLAIN, 40);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		pregunta = new JLabel("Estas seguro");
		pregunta.setBounds(40, 10, 400, 50);
		pregunta.setForeground(new Color(68, 42, 20));
		pregunta.setFont(customFont);
		name = new JLabel("Default!");
		name.setBounds(55, 40, 400, 50);
		name.setForeground(Color.WHITE);
		name.setFont(customFont);
		yes = new JLabel("Si");
		yes.setBounds(225, 110, 400, 50);
		yes.setForeground(new Color(68, 42, 20));
		yes.setFont(customFont);
		no = new JLabel("No");
		no.setBounds(70, 110, 400, 50);
		no.setForeground(new Color(68, 42, 20));
		no.setFont(customFont);
		ImageIcon iConf = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnConf = new JButton(iConf);
		btnConf.setBounds(168, 100, 158, 71);
		btnConf.setContentAreaFilled(false);
		btnConf.setBorderPainted(false);
		ImageIcon iVol = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnVol = new JButton(iVol);
		btnVol.setBounds(10, 100, 158, 71);
		btnVol.setContentAreaFilled(false);
		btnVol.setBorderPainted(false);
		add(btnConf);
		add(btnVol);
		add(pregunta);
		add(name);
		add(yes);
		add(no);
		add(panel);
	}

	private static class InterfazDigitacionPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private ImageIcon iVenIniSes;

		public InterfazDigitacionPanel() {
			iVenIniSes = new ImageIcon(
					getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/DigitacionU.png"));
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int screenWidth = getWidth();
			int screenHeight = getHeight();
			Image iVenIS = iVenIniSes.getImage();
			double scaleX = (double) screenWidth / iVenIS.getWidth(this);
			double scaleY = (double) screenHeight / iVenIS.getHeight(this);
			int newWidth = (int) (iVenIS.getWidth(this) * scaleX);
			int newHeight = (int) (iVenIS.getHeight(this) * scaleY);
			g.drawImage(iVenIS, 0, 0, newWidth, newHeight, this);
		}
	}

	public JButton getBtnVol() {
		return btnVol;
	}

	public void setBtnVol(JButton btnVol) {
		this.btnVol = btnVol;
	}

	public JButton getBtnConf() {
		return btnConf;
	}

	public void setBtnConf(JButton btnConf) {
		this.btnConf = btnConf;
	}

	public void setPreguntaTxt(String txt, float size, int x, int y) {
		this.pregunta.setText(txt);
		Font font = this.pregunta.getFont();
		Font newFont = font.deriveFont((float) size);
		this.pregunta.setFont(newFont);
		this.pregunta.setLocation(x, y);
	}

	public void setYesTxt(String txt, float size, int x, int y) {
		this.yes.setText(txt);
		Font font = this.yes.getFont();
		Font newFont = font.deriveFont((float) size);
		this.yes.setFont(newFont);
		this.yes.setLocation(x, y);
	}

	public void setNoTxt(String txt, float size, int x, int y) {
		this.no.setText(txt);
		Font font = this.no.getFont();
		Font newFont = font.deriveFont((float) size);
		this.no.setFont(newFont);
		this.no.setLocation(x, y);
	}

	public void setUserName(String user) {
		this.name.setText(user);
	}
}