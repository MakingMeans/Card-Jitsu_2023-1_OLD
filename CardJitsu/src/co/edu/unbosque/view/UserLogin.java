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
import javax.swing.JPanel;
import javax.swing.JTextField;
public class UserLogin extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField digD;
    private JButton btnConf;
	private JButton btnVol;
	public UserLogin() {
        setTitle("Retro Card-Jitsu");
        setSize(350, 225);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InterfazDigitacionPanel panel = new InterfazDigitacionPanel();
        digD = new JTextFieldConTextoDeFondo("Digite su usuario.");
        digD.setBounds(16, 18, 304, 58);
        digD.setEditable(true);
        digD.setEnabled(true);
        Font customFont= new Font("Arial", Font.PLAIN, 50);
        try {
        	customFont = Font.createFont(Font.TRUETYPE_FONT, 
            		new File("src/co/edu/unbosque/assets/fonts/Pixels.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        digD.setFont(customFont);
        digD.setBackground(new Color(159, 108, 63));
        digD.setForeground(Color.white);
        digD.setHorizontalAlignment(JTextField.CENTER);
        ImageIcon iConf = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnConf = new JButton(iConf);
        btnConf.setBounds(168, 100, 158, 71);
        btnConf.setContentAreaFilled(false);
        btnConf.setBorderPainted(true);
        ImageIcon iVol = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnVol = new JButton(iVol);
        btnVol.setBounds(10, 100, 158, 71);
        btnVol.setContentAreaFilled(false);
        btnVol.setBorderPainted(true);
        add(digD);
        add(btnConf);
        add(btnVol);
        add(panel);
    }
    private static class InterfazDigitacionPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private ImageIcon iVenIniSes;
        public InterfazDigitacionPanel() {
            iVenIniSes = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/DigitacionU.png"));
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
	public JTextField getDigD() {
		return digD;
	}
	public void setDigD(JTextField digD) {
		this.digD = digD;
	}
}