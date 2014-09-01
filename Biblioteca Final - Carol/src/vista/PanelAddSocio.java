package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelAddSocio extends JPanel {

	private JLabel titulo, textoDni, textoNombre, textoApellidos,
			textoDireccion, textoTelefono;
	private JTextArea areaDni, areaNombre, areaApellidos, areaDireccion,
			areaTelefono;
	private JButton boton;

	// Constructor
	PanelAddSocio() {
		setLayout(null);

		// T�tulo de la ventana a�adir
		titulo = new JLabel("AÑADIR SOCIO");
		titulo.setBounds(230, 51, 200, 20);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// A�ado el t�tulo a la ventana
		this.add(titulo);

		// Creo la etiqueta DNI
		textoDni = new JLabel("DNI");
		textoDni.setBounds(100, 85, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoDni);

		// Creo la etiqueta Nombre
		textoNombre = new JLabel("Nombre: ");
		textoNombre.setBounds(100, 127, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoNombre);

		// Creo la etiqueta Apellidos
		textoApellidos = new JLabel("Apellidos: ");
		textoApellidos.setBounds(100, 169, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoApellidos);

		// Creo la etiqueta Direccion
		textoDireccion = new JLabel("Direccion: ");
		textoDireccion.setBounds(100, 215, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoDireccion);

		// Creo la etiqueta Telefono
		textoTelefono = new JLabel("Telefono: ");
		textoTelefono.setBounds(100, 257, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoTelefono);

		// Creo el �rea de texto para el DNI
		areaDni = new JTextArea(1, 20);
		areaDni.setBounds(220, 80, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaDni);

		// Creo el �rea de texto para el Nombre
		areaNombre = new JTextArea(1, 20);
		areaNombre.setBounds(220, 122, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaNombre);

		// Creo el �rea de texto para el Apellidos
		areaApellidos = new JTextArea(1, 20);
		areaApellidos.setBounds(220, 164, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaApellidos);

		// Creo el �rea de texto para la Direccion
		areaDireccion = new JTextArea(1, 20);
		areaDireccion.setBounds(220, 210, 250, 22);
		this.add(areaDireccion);

		// Creo el �rea de texto para el Telefono
		areaTelefono= new JTextArea(1, 20);
		areaTelefono.setBounds(220, 257, 250, 22);
		this.add(areaTelefono);

		// Creo el bot�n
		boton = new JButton("Guardar Socio");
		boton.setBounds(290, 270, 111, 23);
		// A�ado el bot�n a la ventana
		this.add(boton);
	}

	// M�todos get
	public JTextArea getAreaDni() {
		return areaDni;
	}

	public JTextArea getAreaNombre() {
		return areaNombre;
	}

	public JTextArea getAreaApellidos() {
		return areaApellidos;
	}

	public JTextArea getAreaDireccion() {
		return areaDireccion;
	}

	public JButton getBoton() {
		return boton;
	}

	public JTextArea getAreaTelefono() {
		return areaTelefono;
	}
	
}
