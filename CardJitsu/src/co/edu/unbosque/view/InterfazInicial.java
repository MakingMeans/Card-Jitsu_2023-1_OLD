package co.edu.unbosque.view;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfazInicial extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton btnNueU;
	private JButton btnIniS;
    private JButton btnSal;
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
        add(btnNueU);
        add(btnIniS);
        add(btnSal);
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