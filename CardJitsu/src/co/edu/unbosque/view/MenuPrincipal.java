package co.edu.unbosque.view;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        
        //Declaracion de boton de musica
        ImageIcon iMus = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnMus = new JButton(iMus);
        btnMus.setBounds(0, 0, 70, 75);
        btnMus.setContentAreaFilled(false); //Contenido
        btnMus.setBorderPainted(true); //Borde
        add(btnMus);
        
        ImageIcon iJug = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnJug = new JButton(iJug);
        btnJug.setBounds(850, 50, 195, 52);
        btnJug.setContentAreaFilled(false);
        btnJug.setBorderPainted(true);
        add(btnJug);
        
        ImageIcon iMaz = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnMaz = new JButton(iMaz);
        btnMaz.setBounds(838, 112, 195, 52);
        btnMaz.setContentAreaFilled(false);
        btnMaz.setBorderPainted(true);
        add(btnMaz);
        
        ImageIcon iTut = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnTut = new JButton(iTut);
        btnTut.setBounds(850, 174, 195, 52);
        btnTut.setContentAreaFilled(false);
        btnTut.setBorderPainted(true);
        add(btnTut);
        
        ImageIcon iCue = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnCue = new JButton(iCue);
        btnCue.setBounds(838, 237, 195, 52);
        btnCue.setContentAreaFilled(false);
        btnCue.setBorderPainted(true);
        add(btnCue);
        
        ImageIcon iSal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnSal = new JButton(iSal);
        btnSal.setBounds(850, 300, 195, 52);
        btnSal.setContentAreaFilled(false);
        btnSal.setBorderPainted(true);
        add(btnSal);
        
        add(panel);
        
        //Crear clase ll
        /*btnMus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!musicaActiva) {
                    // Iniciar la reproducción de la música
                    reproducirMusica();
                    musicaActiva = true;
                } else {
                    // Detener la reproducción de la música
                    detenerMusica();
                    musicaActiva = false;
                }
            }¨*/
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
}