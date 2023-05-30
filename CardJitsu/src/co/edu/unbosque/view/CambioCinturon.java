package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CambioCinturon extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton btnMenu;
	private JLabel cinturon;
	
	public CambioCinturon(String pagina) {
		
		setTitle("Retro Card-Jitsu");
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InterfazWin panel = new InterfazWin("/co/edu/unbosque/assets/imagenesInterfaz/"+pagina+".png");
		
		ImageIcon iMen = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
		btnMenu = new JButton(iMen);
		btnMenu.setBounds(100, 85, 220, 75);
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorderPainted(false);
		
		cinturon = new JLabel();
		cinturon.setBounds(330, 300, 675, 125);
		Image temporal = new ImageIcon("src/co/edu/unbosque/assets/cinturones/NEGRO.png").getImage();
		ImageIcon imgRedimension = new ImageIcon(
				temporal.getScaledInstance(cinturon.getWidth(), cinturon.getHeight(), Image.SCALE_SMOOTH));
		cinturon.setIcon(imgRedimension);
		cinturon.setVisible(true);
		
		add(cinturon);
		add(btnMenu);
		add(panel);
		
	}
	private static class InterfazWin extends JPanel {
		private static final long serialVersionUID = 1L;
		private ImageIcon iCuenta;

		public InterfazWin(String name) {
			iCuenta = new ImageIcon(getClass().getResource(name));
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
	public void setCint(String cintColor) {
		Image temporal = new ImageIcon("src/co/edu/unbosque/assets/cinturones/" + cintColor + ".png").getImage();
		ImageIcon imgRedimension1 = new ImageIcon(
				temporal.getScaledInstance(this.cinturon.getWidth(), this.cinturon.getHeight(), Image.SCALE_SMOOTH));
		this.cinturon.setIcon(imgRedimension1);
	}
	public JButton getBtnMenu() {
		return btnMenu;
	}
	public void setBtnMenu(JButton btnMenu) {
		this.btnMenu = btnMenu;
	}
}