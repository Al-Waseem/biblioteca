package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelAddLibro extends JPanel {

	private JLabel titulo, textoLibro, textoAutor, textoCodigo;
	private JTextArea areaLibro, areaAutor, areaCodigo;
	private JButton boton;

	// Constructor
	PanelAddLibro() {
		setLayout(null);

		// T�tulo de la ventana a�adir
		titulo = new JLabel("AÑADIR LIBRO");
		titulo.setBounds(230, 51, 200, 20);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// A�ado el t�tulo a la ventana
		this.add(titulo);
		
		// Creo la etiqueta C�digo
		textoCodigo = new JLabel("Código");
		textoCodigo.setBounds(100, 85, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoCodigo);

		// Creo la etiqueta T�tulo
		textoLibro = new JLabel("Título: ");
		textoLibro.setBounds(100, 127, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoLibro);
		
		// Creo la etiqueta Autor
		textoAutor = new JLabel("Autor: ");
		textoAutor.setBounds(100, 169, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoAutor);
			
		// Creo el �rea de texto para el c�digo
		areaCodigo = new JTextArea(1, 20);
		areaCodigo.setBounds(220, 80, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaCodigo);
		
		// Creo el �rea de texto para el titulo 
		areaLibro = new JTextArea(1, 20);
		areaLibro.setBounds(220, 122, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaLibro);
		
		// Creo el �rea de texto para el autor
		areaAutor = new JTextArea(1, 20);
		areaAutor.setBounds(220, 164, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaAutor);
			
		// Creo el bot�n
		boton = new JButton("Guardar");
		boton.setBounds(290, 270, 89, 23);
		// A�ado el bot�n a la ventana
		this.add(boton);
	}

	// M�todos get
	public JLabel getTitulo() {
		return titulo;
	}

	public JLabel getTextoLibro() {
		return textoLibro;
	}

	public JLabel getTextoAutor() {
		return textoAutor;
	}

	public JTextArea getAreaLibro() {
		return areaLibro;
	}

	public JTextArea getAreaAutor() {
		return areaAutor;
	}

	public JButton getBoton() {
		return boton;
	}

	public JTextArea getAreaCodigo() {
		return areaCodigo;
	}
}
