package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Results extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton btnMenu;
	
	public Results() {
		
		setTitle("Retro Card-Jitsu");
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InterfazWin panel = new InterfazWin();
		
		ImageIcon iMen = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnMenu = new JButton(iMen);
		btnMenu.setBounds(550, 300, 100, 60);
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorderPainted(true);
		
		add(btnMenu);
		add(panel);
		
	}
	private static class InterfazWin extends JPanel {
		private static final long serialVersionUID = 1L;
		private ImageIcon iCuenta;

		public InterfazWin() {
			iCuenta = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/PinguinoFeliz.png"));
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
	public JButton getBtnMenu() {
		return btnMenu;
	}
	public void setBtnMenu(JButton btnMenu) {
		this.btnMenu = btnMenu;
	}
	public void screenChange(boolean win) {
		
	}
}