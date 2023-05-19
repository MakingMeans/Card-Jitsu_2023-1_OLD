package co.edu.unbosque.view;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interfaz extends JFrame {
    private static final long serialVersionUID = 1L;

    public Interfaz() {
        setTitle("Retro Card-Jitsu");
        setSize(1180, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InterfazPanel panel = new InterfazPanel();
        add(panel);
    }

    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }

    private static class InterfazPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private ImageIcon iMenu;
        private ImageIcon iMaeFue;
        private ImageIcon iMaeAgu;
        private ImageIcon iMaeNie;

        public InterfazPanel() {
            iMenu = new ImageIcon(getClass().getResource("/co/edu/unbosque/view/imagenesInterfaz/Menu.png"));
            iMaeFue = new ImageIcon(getClass().getResource("/co/edu/unbosque/view/imagenesInterfaz/MaestroFuego.png"));
            iMaeAgu = new ImageIcon(getClass().getResource("/co/edu/unbosque/view/imagenesInterfaz/MaestroAgua.png"));
            iMaeNie = new ImageIcon(getClass().getResource("/co/edu/unbosque/view/imagenesInterfaz/MaestroNieve.png"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponents(g);
            Image iMen = iMenu.getImage();
            g.drawImage(iMen, 0, 0, 1180, 720 / 2, this);
            super.paintComponents(g);
            Image iMaeF = iMaeFue.getImage();
            g.drawImage(iMaeF, 0, 720 / 2, 1180 / 3, 720 / 2, this);
            super.paintComponents(g);
            Image iMaeA = iMaeAgu.getImage();
            g.drawImage(iMaeA, 1180 / 3, 720 / 2, 1180 / 3, 720 / 2, this);
            super.paintComponents(g);
            Image iMaeN = iMaeNie.getImage();
            g.drawImage(iMaeN, (1180 / 3) + (1180 / 3), 720 / 2, 1180 / 3, 720 / 2, this);
        }
    }
}