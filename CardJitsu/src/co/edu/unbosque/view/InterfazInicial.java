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

public class InterfazInicial extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton btnNueU;
	private JButton btnIniS;
    private JButton btnSal;
    private JLabel textSign;
    private JLabel textLog;
    private JLabel textExit;
    public InterfazInicial() {
        setTitle("Retro Card-Jitsu");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InterfazInicialPanel panel = new InterfazInicialPanel();
        ImageIcon iNueU = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnNueU = new JButton(iNueU);
        btnNueU.setBounds(22, 168, 643, 98);
        btnNueU.setContentAreaFilled(false);
        btnNueU.setBorderPainted(false);
        
        ImageIcon iIniS = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnIniS = new JButton(iIniS);
        btnIniS.setBounds(22, 280, 643, 98);
        btnIniS.setContentAreaFilled(false);
        btnIniS.setBorderPainted(false);
        
        ImageIcon iSal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnSal = new JButton(iSal);
        btnSal.setBounds(22, 392, 643, 98);
        btnSal.setContentAreaFilled(false);
        btnSal.setBorderPainted(false);
        
        Font customFont = new Font("Arial", Font.PLAIN, 45);
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/co/edu/unbosque/assets/fonts/Mario-Kart-DS.ttf"))
					.deriveFont(Font.PLAIN, 60);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		textSign = new JLabel("crear cuenta");
		textSign.setBounds(145, 190, 400, 50);
		textSign.setForeground(new Color(57,36,12));
		textSign.setFont(customFont);
		
		textLog = new JLabel("iniciar sesion");
		textLog.setBounds(140, 301, 400, 50);
		textLog.setForeground(new Color(57,36,12));
		textLog.setFont(customFont);
		
		textExit = new JLabel("salir");
		textExit.setBounds(260, 413, 400, 50);
		textExit.setForeground(new Color(57,36,12));
		textExit.setFont(customFont);
		
        add(btnNueU);
        add(btnIniS);
        add(btnSal);
        add(textSign);
        add(textLog);
        add(textExit);
        add(panel);
    }
    private static class InterfazInicialPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private ImageIcon iVenIniSes;
        public InterfazInicialPanel() {
            iVenIniSes = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/VentanaIS.png"));
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int screenWidth = getWidth();
            int screenHeight = getHeight();
            Image iVenIS = iVenIniSes.getImage();
            // Calcular las proporciones de escalado
            double scaleX = (double) screenWidth / iVenIS.getWidth(this);
            double scaleY = (double) screenHeight / iVenIS.getHeight(this);
            // Calcular las nuevas dimensiones de la imagen
            int newWidth = (int) (iVenIS.getWidth(this) * scaleX);
            int newHeight = (int) (iVenIS.getHeight(this) * scaleY);
            // Dibujar la imagen en las nuevas dimensiones
            g.drawImage(iVenIS, 0, 0, newWidth, newHeight, this);
        }
    }
    public JButton getBtnNueU() {
		return btnNueU;
	}
	public void setBtnNueU(JButton btnNueU) {
		this.btnNueU = btnNueU;
	}
	public JButton getBtnIniS() {
		return btnIniS;
	}
	public void setBtnIniS(JButton btnIniS) {
		this.btnIniS = btnIniS;
	}
	public JButton getBtnSal() {
		return btnSal;
	}
	public void setBtnSal(JButton btnSal) {
		this.btnSal = btnSal;
	}
}