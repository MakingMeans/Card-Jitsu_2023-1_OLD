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

public class Stats extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton btnSal;
    private JLabel name;
    private JLabel id;
    private JLabel cinturon;
    private JLabel puntaje;
    private JLabel restante;
    private JLabel rank;
    private String cintColor;
	
    public Stats() {
        setTitle("Retro Card-Jitsu");
        setSize(1200, 832);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InterfazPanel panel = new InterfazPanel();
        
        //Declaracion de boton de musica
        ImageIcon iSal = new ImageIcon("/co/edu/unbosque/assets/imagenesInterfaz/Transparente.png");
        btnSal = new JButton(iSal);
        btnSal.setBounds(140, 673, 195, 52);
        btnSal.setContentAreaFilled(false);
        btnSal.setBorderPainted(true);
        
        Font customFont= new Font("Arial", Font.PLAIN, 50);
        try {
        	customFont = Font.createFont(Font.TRUETYPE_FONT, 
            		new File("src/co/edu/unbosque/assets/fonts/Pixellari.ttf")).deriveFont(Font.PLAIN, 55);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        Font customFont2= new Font("Arial", Font.PLAIN, 50);
        try {
        	customFont2 = Font.createFont(Font.TRUETYPE_FONT, 
            		new File("src/co/edu/unbosque/assets/fonts/Daydream.ttf")).deriveFont(Font.PLAIN, 45);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        Font customFont3= new Font("Arial", Font.PLAIN, 50);
        try {
        	customFont3 = Font.createFont(Font.TRUETYPE_FONT, 
            		new File("src/co/edu/unbosque/assets/fonts/Mario-Kart-DS.ttf")).deriveFont(Font.PLAIN, 72);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        name = new JLabel("Default!");
		name.setBounds(360,60,400,50);
		name.setForeground(Color.WHITE);
		name.setFont(customFont);
		id = new JLabel("Default!");
		id.setBounds(930,60,400,50);
		id.setForeground(Color.WHITE);
		id.setFont(customFont);
		cinturon =new JLabel();
		cinturon.setBounds(500,140,675,125);
		Image temporal= new ImageIcon("src/co/edu/unbosque/assets/cinturones/"+cintColor+".png").getImage();
		ImageIcon imgRedimension1=new ImageIcon(
				temporal.getScaledInstance(cinturon.getWidth(), cinturon.getHeight(), Image.SCALE_SMOOTH));
		cinturon.setIcon(imgRedimension1);
		puntaje = new JLabel("Default!");
		puntaje.setBounds(475,340,400,50);
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(customFont2);
		restante = new JLabel("Default!");
		restante.setBounds(555,510,400,50);
		restante.setForeground(Color.WHITE);
		restante.setFont(customFont2);
		JLabel ranking = new JLabel("RANK");
		ranking.setBounds(540,670,400,50);
		ranking.setForeground(Color.WHITE);
		ranking.setFont(customFont3);
		rank = new JLabel("Default!");
		rank.setBounds(760,670,400,50);
		rank.setForeground(Color.WHITE);
		rank.setFont(customFont3);
        
        add(btnSal);
        add(name);
        add(id);
        add(cinturon);
        add(puntaje);
        add(restante);
        add(ranking);
        add(rank);
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

        public InterfazPanel() {
            iMenu = new ImageIcon(getClass().getResource("/co/edu/unbosque/assets/imagenesInterfaz/UserStats.png"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponents(g);
            Image iMen = iMenu.getImage();
            g.drawImage(iMen, 0, 0, 1200, 832, this);
        }
    }
	public JButton getBtnSal() {
		return btnSal;
	}
	public void setBtnSal(JButton btnSal) {
		this.btnSal = btnSal;
	}
	public void setUserName(String user, byte id, String cinturon, int puntaje, int nextLv) {
		this.name.setText(user);
		this.id.setText(String.valueOf(id));
		this.cintColor=cinturon;
		this.puntaje.setText(String.valueOf(puntaje));
		this.restante.setText(String.valueOf(nextLv));
		if(puntaje>=90) this.restante.setText("COMPLETE!");
		if(cinturon=="NINGUNO") this.puntaje.setForeground(Color.WHITE);;
		if(cinturon=="BLANCO") this.puntaje.setForeground(Color.WHITE);;
		if(cinturon=="AMARILLO") this.puntaje.setForeground(Color.YELLOW);;
		if(cinturon=="NARANJA") this.puntaje.setForeground(Color.ORANGE);;
		if(cinturon=="VERDE") this.puntaje.setForeground(Color.GREEN);;
		if(cinturon=="AZUL") this.puntaje.setForeground(Color.BLUE);;
		if(cinturon=="ROJO") this.puntaje.setForeground(Color.RED);;
		if(cinturon=="VIOLETA") this.puntaje.setForeground(Color.MAGENTA);;
		if(cinturon=="MARRON") this.puntaje.setForeground(Color.LIGHT_GRAY);;
		if(cinturon=="NEGRO") this.puntaje.setForeground(Color.BLACK);;
		if(puntaje<20) {
			this.rank.setText("D");
			this.rank.setForeground(Color.BLACK);
		}
        if(puntaje<40&&puntaje>=20) {
        	this.rank.setText("C");
    		this.rank.setForeground(Color.GREEN);
        }
        if(puntaje<60&&puntaje>=40) {
        	this.rank.setText("B");
    		this.rank.setForeground(Color.BLUE);
        }
        if(puntaje<80&&puntaje>=60) {
        	this.rank.setText("A");
    		this.rank.setForeground(Color.RED);
        }
        if(puntaje<100&&puntaje>=80) {
        	this.rank.setText("S");
    		this.rank.setForeground(Color.YELLOW);
        }
        if(puntaje>=100) {
        	this.rank.setText("P");
    		this.rank.setForeground(Color.MAGENTA);
        }
		Image temporal= new ImageIcon("src/co/edu/unbosque/assets/cinturones/"+cintColor+".png").getImage();
		ImageIcon imgRedimension1=new ImageIcon(
				temporal.getScaledInstance(this.cinturon.getWidth(), this.cinturon.getHeight(), Image.SCALE_SMOOTH));
		this.cinturon.setIcon(imgRedimension1);

	}
}