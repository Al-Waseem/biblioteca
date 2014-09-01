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
public class PanelBorrarSocio extends JPanel {

	private JLabel titulo, textoNombre, textoApellidos, textoDni, textoDireccion;
	private JTextArea areaNombre, areaApellidos, areaDireccion;
	private JComboBox<String> elegirDni;
	private JButton botonBorrar;
	private String[] cadena;
	
	// Constructor
	PanelBorrarSocio() {
		setLayout(null);

		// T�tulo de la ventana a�adir
		titulo = new JLabel("BORRAR SOCIO");
		titulo.setBounds(236, 32, 200, 20);
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
		textoNombre = new JLabel("Nombre");
		textoNombre.setBounds(100, 127, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoNombre);

		// Creo la etiqueta Apellidos
		textoApellidos = new JLabel("Apellidos");
		textoApellidos.setBounds(100, 169, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoApellidos);

		// Creo la etiqueta Direccion
		textoDireccion = new JLabel("Direccion");
		textoDireccion.setBounds(100, 211, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoDireccion);

		// Creo el �rea de texto para el Nombre
		areaNombre = new JTextArea(1, 20);
		areaNombre.setEditable(false);
		areaNombre.setBounds(220, 122, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaNombre);

		// Creo el �rea de texto para los Apellidos
		areaApellidos = new JTextArea(1, 20);
		areaApellidos.setEditable(false);
		areaApellidos.setBounds(220, 164, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaApellidos);

		// Creo el �rea de texto para la Direccion
		areaDireccion = new JTextArea(1, 20);
		areaDireccion.setEditable(false);
		areaDireccion.setBounds(220, 206, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaDireccion);

		// Creo el bot�n
		botonBorrar = new JButton("Borrar");
		botonBorrar.setBounds(290, 270, 89, 23);
		// A�ado el bot�n a la ventana
		this.add(botonBorrar);

		// Creo el ComboBox para el t�tulo del libro
		elegirDni = new JComboBox<String>();
		elegirDni.setBounds(220, 81, 250, 22);
		add(elegirDni);
	}

	/*
	 * M�TODO QUE CREA EL COMBOBOX
	 */
	public void crearComboBox(String[] cadena) {
		elegirDni.setModel(new DefaultComboBoxModel<String>(cadena));
		elegirDni.setBounds(220, 81, 250, 22);
		add(elegirDni);
	}

	/*
	 * M�todo que devuelve el item seleccionado
	 */
	public String getDniSeleccionado() {
		String dni = (String) elegirDni.getSelectedItem();
		return dni;
	}

	// M�todos get y set
	public JTextArea getAreaNombre() {
		return areaNombre;
	}

	public void setAreaNombre(String nombre) {
		areaNombre.setText(nombre);
	}

	public JTextArea getAreaApellidos() {
		return areaApellidos;
	}

	public void setAreaApellidos(String apellidos) {
		areaApellidos.setText(apellidos);
	}

	public JTextArea getAreaDireccion() {
		return areaDireccion;
	}

	public void setAreaDireccion(String direccion) {
		areaDireccion.setText(direccion);
	}

	public JComboBox<String> getElegirDni() {
		return elegirDni;
	}

	public JButton getBotonBorrar() {
		return botonBorrar;
	}

	public String[] getCadena() {
		return cadena;
	}	
}
