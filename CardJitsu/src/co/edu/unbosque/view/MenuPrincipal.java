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

public class MenuPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton btnMus;
    private JButton btnJug;
    private JButton btnMaz;
    private JButton btnTut;
    private JButton btnCue;
    private JButton btnSal;
	
	public MenuPrincipal() {
        setTitle("Retro Card-Jitsu");
        setSize(1200, 832);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InterfazPanel panel = new InterfazPanel();
        
        ImageIcon iMus = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnMus = new JButton(iMus);
        btnMus.setBounds(0, 0, 70, 75);
        btnMus.setContentAreaFilled(false); 
        btnMus.setBorderPainted(false); 
        
        ImageIcon iJug = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnJug = new JButton(iJug);
        btnJug.setBounds(850, 50, 195, 52);
        btnJug.setContentAreaFilled(false);
        btnJug.setBorderPainted(false);
        
        ImageIcon iMaz = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnMaz = new JButton(iMaz);
        btnMaz.setBounds(838, 112, 195, 52);
        btnMaz.setContentAreaFilled(false);
        btnMaz.setBorderPainted(false);
        
        ImageIcon iTut = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnTut = new JButton(iTut);
        btnTut.setBounds(850, 174, 195, 52);
        btnTut.setContentAreaFilled(false);
        btnTut.setBorderPainted(false);
        
        ImageIcon iCue = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnCue = new JButton(iCue);
        btnCue.setBounds(838, 237, 195, 52);
        btnCue.setContentAreaFilled(false);
        btnCue.setBorderPainted(false);
        
        ImageIcon iSal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnSal = new JButton(iSal);
        btnSal.setBounds(850, 300, 195, 52);
        btnSal.setContentAreaFilled(false);
        btnSal.setBorderPainted(false);
        
        add(btnMus);
        add(btnJug);
        add(btnMaz);
        add(btnTut);
        add(btnCue);
        add(btnSal);
        add(panel);
    }

	 
    private static class InterfazPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private ImageIcon iMenu;
        private ImageIcon iMaeFue;
        private ImageIcon iMaeAgu;
        private ImageIcon iMaeNie;
        private JLabel textPlay;
        private JLabel textMazo;
        private JLabel textTut;
        private JLabel textCuen;
        private JLabel textExit;

        public InterfazPanel() {
            iMenu = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/MenuAnimation.gif"));
            iMaeFue = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/MaestroFuego.png"));
            iMaeAgu = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/MaestroAgua.png"));
            iMaeNie = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/MaestroNieve.png"));
            Font customFont = new Font("Arial", Font.PLAIN, 45);
    		try {
    			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Pixellari.ttf"))
    					.deriveFont(Font.PLAIN, 45);
    		} catch (IOException | FontFormatException e) {
    			e.printStackTrace();
    		}
    		textPlay = new JLabel("Jugar");
    		textPlay.setBounds(0, 0, 400, 50);
    		textPlay.setForeground(new Color(57,36,12));
    		textPlay.setFont(customFont);
    		add(textPlay);
    		textMazo = new JLabel("Mazo");
    		textMazo.setBounds(0, 0, 400, 50);
    		textMazo.setForeground(new Color(57,36,12));
    		textMazo.setFont(customFont);
    		add(textMazo);
    		textTut = new JLabel("Tutorial");
    		textTut.setBounds(0, 0, 400, 50);
    		textTut.setForeground(new Color(57,36,12));
    		textTut.setFont(customFont);
    		add(textTut);
    		textCuen = new JLabel("Cuenta");
    		textCuen.setBounds(0, 0, 400, 50);
    		textCuen.setForeground(new Color(57,36,12));
    		textCuen.setFont(customFont);
    		add(textCuen);
    		textExit = new JLabel("Salir");
    		textExit.setBounds(0, 0, 400, 50);
    		textExit.setForeground(new Color(57,36,12));
    		textExit.setFont(customFont);
    		add(textExit);
        }

        @Override
        protected void paintComponent(Graphics g) {
        	int screenWidth = getWidth();
			int screenHeight = getHeight();

			Image iMen = iMenu.getImage();
			double xMen = (double) screenWidth / iMen.getWidth(this);
			double yMen = (double) screenHeight / iMen.getHeight(this);
			int nAnchoMen = (int) (iMen.getWidth(this) * xMen);
			int nAltoMen = (int) (iMen.getHeight(this) * yMen);
			g.drawImage(iMen, 0, 0, nAnchoMen, nAltoMen / 2, this);
			super.paintComponents(g);

			Image iMaeF = iMaeFue.getImage();
			double xMaeF = (double) screenWidth / iMaeF.getWidth(this);
			double yMaeF = (double) screenHeight / iMaeF.getHeight(this);
			int nAnchoMaeF = (int) (iMaeF.getWidth(this) * xMaeF);
			int nAltoMaeF = (int) (iMaeF.getHeight(this) * yMaeF);
			g.drawImage(iMaeF, 0, nAltoMaeF / 2, nAnchoMaeF / 3, (nAltoMaeF / 2) + 2, this);
			super.paintComponents(g);

			Image iMaeA = iMaeAgu.getImage();
			double xMaeA = (double) screenWidth / iMaeA.getWidth(this);
			double yMaeA = (double) screenHeight / iMaeA.getHeight(this);
			int nAnchoMaeA = (int) (iMaeA.getWidth(this) * xMaeA);
			int nAltoMaeA = (int) (iMaeA.getHeight(this) * yMaeA);
			g.drawImage(iMaeA, nAnchoMaeA / 3, nAltoMaeA / 2, nAnchoMaeA / 3, (nAltoMaeA / 2) + 2, this);
			super.paintComponents(g);

			Image iMaeN = iMaeNie.getImage();
			double xMaeN = (double) screenWidth / iMaeN.getWidth(this);
			double yMaeN = (double) screenHeight / iMaeN.getHeight(this);
			int nAnchoMaeN = (int) (iMaeA.getWidth(this) * xMaeN);
			int nAltoMaeN = (int) (iMaeA.getHeight(this) * yMaeN);
			g.drawImage(iMaeN, nAnchoMaeN / 3 + nAnchoMaeN / 3, nAltoMaeN / 2, (nAnchoMaeN / 3) + 2,
					(nAltoMaeN / 2) + 2, this);
			super.paintComponents(g);
			textPlay.setBounds(870, 55, 400, 50);
			textMazo.setBounds(870, 118, 400, 50);
			textTut.setBounds(850, 181, 400, 50);
			textCuen.setBounds(860, 239, 400, 50);
			textExit.setBounds(880, 302, 400, 50);
        }
    }
    public JButton getBtnMus() {
		return btnMus;
	}
	public void setBtnMus(JButton btnMus) {
		this.btnMus = btnMus;
	}
	public JButton getBtnJug() {
		return btnJug;
	}
	public void setBtnJug(JButton btnJug) {
		this.btnJug = btnJug;
	}
	public JButton getBtnMaz() {
		return btnMaz;
	}
	public void setBtnMaz(JButton btnMaz) {
		this.btnMaz = btnMaz;
	}
	public JButton getBtnTut() {
		return btnTut;
	}
	public void setBtnTut(JButton btnTut) {
		this.btnTut = btnTut;
	}
	public JButton getBtnCue() {
		return btnCue;
	}
	public void setBtnCue(JButton btnCue) {
		this.btnCue = btnCue;
	}
	public JButton getBtnSal() {
		return btnSal;
	}
	public void setBtnSal(JButton btnSal) {
		this.btnSal = btnSal;
	}
}