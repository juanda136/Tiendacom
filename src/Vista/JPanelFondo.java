
package Vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class JPanelFondo extends JPanel {

    private Image Imagen;

    public JPanelFondo() {
        // Constructor, puedes agregar inicializaciones aquí si es necesario
    }

    public void setFoto(Image foto) {
        this.Imagen = foto;
        repaint();  // Solicitar que el panel se repinte con la nueva imagen
    }
   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el panel si está presente
        if (Imagen != null) {
            g.drawImage(Imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}