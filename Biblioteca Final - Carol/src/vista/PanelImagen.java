package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelImagen extends JPanel {

	// Atributos
	private ImageIcon fondo;
	private Image imagenFondo;

	// Constructor
	PanelImagen() {
		// Establecemos el fondo de la aplicaci�n
		fondo = new ImageIcon("imagenes/biblioteca.jpg");
		imagenFondo = fondo.getImage();
	}

	// Pintamos el fondo en la pantalla
	public void paint(Graphics g) {
		super.paint(g);
		//fondo.paintIcon(this, g, 10, 10);
		g.drawImage(imagenFondo, 10, 10, this.getWidth() - 20, this.getHeight(), this);
	}
}
