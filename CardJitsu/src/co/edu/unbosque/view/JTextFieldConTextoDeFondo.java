package co.edu.unbosque.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JTextField;

public class JTextFieldConTextoDeFondo extends JTextField {
    private static final long serialVersionUID = 1L;
    private String textoDeFondo;
    private Color colorDeTextoDeFondo;
    public JTextFieldConTextoDeFondo(String textoDeFondo) {
        this.textoDeFondo = textoDeFondo;
        this.setHorizontalAlignment(CENTER);
        this.colorDeTextoDeFondo = Color.GRAY;
    }
    public void setColorDeTextoDeFondo(Color colorDeTextoDeFondo) {
        this.colorDeTextoDeFondo = colorDeTextoDeFondo;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty()) {
            g.setColor(colorDeTextoDeFondo);
            g.setFont(getFont().deriveFont(Font.ITALIC));
            g.drawString(textoDeFondo, getInsets().left, g.getFontMetrics().getAscent() + getInsets().top);
        }
    }
}