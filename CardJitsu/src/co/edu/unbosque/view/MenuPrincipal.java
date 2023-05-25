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
    private JLabel[] easter;
	
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
        btnMus.setBorderPainted(true); 
        
        ImageIcon iJug = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnJug = new JButton(iJug);
        btnJug.setBounds(850, 50, 195, 52);
        btnJug.setContentAreaFilled(false);
        btnJug.setBorderPainted(true);
        
        ImageIcon iMaz = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnMaz = new JButton(iMaz);
        btnMaz.setBounds(838, 112, 195, 52);
        btnMaz.setContentAreaFilled(false);
        btnMaz.setBorderPainted(true);
        
        ImageIcon iTut = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnTut = new JButton(iTut);
        btnTut.setBounds(850, 174, 195, 52);
        btnTut.setContentAreaFilled(false);
        btnTut.setBorderPainted(true);
        
        ImageIcon iCue = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnCue = new JButton(iCue);
        btnCue.setBounds(838, 237, 195, 52);
        btnCue.setContentAreaFilled(false);
        btnCue.setBorderPainted(true);
        
        ImageIcon iSal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnSal = new JButton(iSal);
        btnSal.setBounds(850, 300, 195, 52);
        btnSal.setContentAreaFilled(false);
        btnSal.setBorderPainted(true);
        
        Font customFont= new Font("Arial", Font.PLAIN, 50);
        try {
        	customFont = Font.createFont(Font.TRUETYPE_FONT, 
            		new File("src/co/edu/unbosque/assets/fonts/Daydream.ttf")).deriveFont(Font.PLAIN, 45);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        easter= new JLabel[4];
        easter[0] = new JLabel("Si puedes leerme, corre!");
        easter[1] = new JLabel(":(");
        easter[2] = new JLabel(":v");
        easter[3] = new JLabel(">:)");
		easter[0].setBounds(475,340,400,50);
		easter[1].setBounds(180,560,400,50);
		easter[2].setBounds(515,555,400,50);
		easter[3].setBounds(950,560,400,50);
		for(int i=0; i<easter.length;i++) {
			easter[i].setForeground(Color.BLACK);
			easter[i].setFont(customFont);
			easter[i].setVisible(false);
			easter[0].setForeground(Color.WHITE);
		}
        
        add(btnMus);
        add(btnJug);
        add(btnMaz);
        add(btnTut);
        add(btnCue);
        add(btnSal);
        for(int i=0; i<easter.length;i++) {
        	add(easter[i]);
		}
        add(panel);
    }

	 
    private static class InterfazPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private ImageIcon iMenu;
        private ImageIcon iMaeFue;
        private ImageIcon iMaeAgu;
        private ImageIcon iMaeNie;

        public InterfazPanel() {
            iMenu = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/Menu.png"));
            iMaeFue = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/MaestroFuego.png"));
            iMaeAgu = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/MaestroAgua.png"));
            iMaeNie = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/MaestroNieve.png"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponents(g);
            Image iMen = iMenu.getImage();
            g.drawImage(iMen, 0, 0, 1200, 400, this);
            super.paintComponents(g);
            Image iMaeF = iMaeFue.getImage();
            g.drawImage(iMaeF, 0, 400, 400, 400, this);
            super.paintComponents(g);
            Image iMaeA = iMaeAgu.getImage();
            g.drawImage(iMaeA, 400, 400, 400, 400, this);
            super.paintComponents(g);
            Image iMaeN = iMaeNie.getImage();
            g.drawImage(iMaeN, 800, 400, 400, 400, this);
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
	public void setEaster() {
		this.easter[0].setText("NO BRO...");
		for(int i=0; i<this.easter.length;i++) {
			this.easter[i].setVisible(true);
		}
	}
	public void hideEaster() {
		for(int i=0; i<this.easter.length;i++) {
			this.easter[i].setVisible(false);
		}
	}
}