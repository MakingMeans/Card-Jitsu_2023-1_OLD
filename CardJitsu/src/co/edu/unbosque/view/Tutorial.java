package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tutorial extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnAtr;
	private JButton btnAde;
	private JButton btnMen;
	private boolean hide;

	public Tutorial(String pagina) {
		setTitle("Retro Card-Jitsu");
		setSize(1200, 832);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InterfazInicialPanel panel = new InterfazInicialPanel("/co/edu/unbosque/assets/tutorial/"+pagina+".png");
		ImageIcon iAtr = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnAtr = new JButton(iAtr);
		btnAtr.setBounds(802, 720, 150, 76);
		btnAtr.setContentAreaFilled(false);
		btnAtr.setBorderPainted(true);
		ImageIcon iAde = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnAde = new JButton(iAde);
		btnAde.setBounds(957, 720, 150, 76);
		btnAde.setContentAreaFilled(false);
		btnAde.setBorderPainted(true);
		ImageIcon iMen = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnMen = new JButton(iMen);
		btnMen.setBounds(1111, 720, 75, 76);
		btnMen.setContentAreaFilled(false);
		btnMen.setBorderPainted(true);
		add(btnAtr);
		add(btnAde);
		add(btnMen);
		add(panel);
	}

	private static class InterfazInicialPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private ImageIcon iTut1;

		public InterfazInicialPanel(String name) {
			iTut1 = new ImageIcon(getClass().getResource(name));
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int screenWidth = getWidth();
			int screenHeight = getHeight();
			Image iT1 = iTut1.getImage();
			double scaleX = (double) screenWidth / iT1.getWidth(this);
			double scaleY = (double) screenHeight / iT1.getHeight(this);
			int newWidth = (int) (iT1.getWidth(this) * scaleX);
			int newHeight = (int) (iT1.getHeight(this) * scaleY);
			g.drawImage(iT1, 0, 0, newWidth, newHeight, this);
		}
	}
	public JButton getBtnAtr() {
		return btnAtr;
	}
	public void setBtnAtr(JButton btnAtr) {
		this.btnAtr = btnAtr;
	}
	public JButton getBtnAde() {
		return btnAde;
	}
	public void setBtnAde(JButton btnAde) {
		this.btnAde = btnAde;
	}
	public JButton getBtnMen() {
		return btnMen;
	}
	public void setBtnMen(JButton btnMen) {
		this.btnMen = btnMen;
	}
	public void hideButton(boolean hide) {
		this.hide = hide;
		if(this.hide==true) btnAtr.setBorderPainted(false);
		else btnAtr.setBorderPainted(true);
	}
}