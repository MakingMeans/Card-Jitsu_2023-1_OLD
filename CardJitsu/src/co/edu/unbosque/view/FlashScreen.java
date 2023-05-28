package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlashScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel label;

    public FlashScreen() {
        initialize();
    }

    private void initialize() {
        label = new JLabel("Flash Screen", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);

        getContentPane().add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setUndecorated(true); // Quita los bordes de la ventana

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                try {
                    Thread.sleep(3000); // Duración en milisegundos (3 segundos)
                    dispose(); // Cierra la ventana después del tiempo especificado
                    // Aquí puedes abrir la siguiente ventana principal de tu aplicación
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}