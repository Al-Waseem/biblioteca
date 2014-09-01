package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class PanelModificarSocio extends JPanel {

	private JLabel titulo, textoNombre, textoDireccion, textoTelefono;
	private JTextArea areaDireccion, areaTelefono;
	private JComboBox<String> elegirNombre;
	private JButton botonModificar;
	private String[] cadena;

	// Constructor
	PanelModificarSocio() {
		setLayout(null);

		// T�tulo de la ventana a�adir
		titulo = new JLabel("MODIFICAR SOCIO");
		titulo.setBounds(230, 51, 200, 20);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// A�ado el t�tulo a la ventana
		this.add(titulo);

		// Creo la etiqueta Nombre
		textoNombre = new JLabel("Nombre");
		textoNombre.setBounds(150, 127, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoNombre);

		// Creo la etiqueta Direccion
		textoDireccion = new JLabel("Direccion: ");
		textoDireccion.setBounds(150, 169, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoDireccion);

		// Creo la etiqueta Telefono
		textoTelefono = new JLabel("Telefono: ");
		textoTelefono.setBounds(150, 211, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoTelefono);

		// Creo el �rea de texto para la Direccion
		areaDireccion = new JTextArea(1, 20);
		areaDireccion.setBounds(280, 169, 200, 20);
		// A�ado el �rea a la ventana
		this.add(areaDireccion);

		// Creo el �rea de texto para el Telefono
		areaTelefono = new JTextArea(1, 20);
		areaTelefono.setBounds(280, 211, 200, 20);
		// A�ado el �rea a la ventana
		this.add(areaTelefono);

		// Creo el bot�n
		botonModificar = new JButton("Guardar Cambios");
		botonModificar.setBounds(290, 270, 120, 23);
		// A�ado el bot�n a la ventana
		this.add(botonModificar);

		// Creo el ComboBox para el t�tulo del libro
		elegirNombre = new JComboBox<String>();
		elegirNombre.setBounds(280, 127, 200, 20);
		add(elegirNombre);
	}

	/*
	 * M�TODO QUE CREA EL COMBOBOX
	 */
	public void crearComboBox(String[] cadena) {
		elegirNombre.setModel(new DefaultComboBoxModel<String>(cadena));
		elegirNombre.setBounds(280, 127, 200, 20);
		add(elegirNombre);
	}

	/*
	 * M�todo que devuelve el item seleccionado
	 */
	public String getNombreSeleccionado() {
		String nombre = (String) elegirNombre.getSelectedItem();
		return nombre;
	}

	// M�todos get

	public JButton getBoton() {
		return botonModificar;
	}

	public JTextArea getAreaDireccion() {
		return areaDireccion;
	}

	public JTextArea getAreaTelefono() {
		return areaTelefono;
	}

	public String[] getCadena() {
		return cadena;
	}

	public JComboBox<String> getElegirNombre() {
		return elegirNombre;
	}

	public void setAreaTelefono(String telefono) {
		areaTelefono.setText(telefono);;
	}

	public void setAreaDireccion(String direccion) {
		areaDireccion.setText(direccion);
	}
	
	
}
