package co.edu.unbosque.view;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Saludo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel[] frame;
	
	public Saludo() {
        setTitle("Retro Card-Jitsu");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame = new JLabel[5];
        for(int i=0; i<5; i++) {
        	frame[i] = new JLabel();
            frame[i].setBounds(0, 0, 1200, 800);
    		Image temporal = new ImageIcon("src/co/edu/unbosque/assets/animaciones/Saludo" + i + ".png").getImage();
    		ImageIcon imgRedimension1 = new ImageIcon(
    				temporal.getScaledInstance(frame[i].getWidth(), frame[i].getHeight(), Image.SCALE_SMOOTH));
    		frame[i].setIcon(imgRedimension1);
        }
        for(int i=1; i<5; i++) {
        	frame[i].setVisible(false);
        }
        for(int i=4; i>-1; i--) {
    		add(frame[i]);
        }
        frame[0].setVisible(true);
    }
	public void reset() {
		for(int i=0; i<5; i++) {
			this.frame[i].setVisible(false);
        }
	}
    public void getReady(Runnable callback) {
    	Timer timer = new Timer();
    	TimerTask anim1 = new TimerTask() {
                @Override
             public void run() {
                frame[1].setVisible(true);
             }
        };
        TimerTask anim2 = new TimerTask() {
            @Override
	         public void run() {
            	frame[2].setVisible(true);
	         }
        };
        TimerTask anim3 = new TimerTask() {
            @Override
	         public void run() {
            	frame[3].setVisible(true);
	         }
	    };
	    TimerTask anim4 = new TimerTask() {
            @Override
	         public void run() {
            	frame[4].setVisible(true);
	         }
	    };
        timer.schedule(anim1, 200);
        timer.schedule(anim2, 400);
        timer.schedule(anim3, 600);
        timer.schedule(anim4, 800);
        TimerTask start = new TimerTask() {
            @Override
            public void run() {
            	reset();
            	callback.run();
            }
        };
        timer.schedule(start, 2000);
    }
}