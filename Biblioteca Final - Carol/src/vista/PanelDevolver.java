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
public class PanelDevolver extends JPanel {

	private JLabel titulo, titSocio, titLibro, textoDni, textoNombre,
			textoTitulo, textoAutor;
	private JTextArea areaNombre, areaAutor;
	private JComboBox<String> elegirDni, elegirTitulo;
	private JButton botonDevolver;
	private String[] cadena;

	// Constructor
	PanelDevolver() {
		setLayout(null);

		// T�tulo de la ventana a�adir
		titulo = new JLabel("DEVOLVER LIBRO");
		titulo.setBounds(240, 28, 200, 20);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		// A�ado el t�tulo a la ventana
		this.add(titulo);

		// T�tulo de SOCIO
		titSocio = new JLabel("SOCIO");
		titSocio.setFont(new Font("Tahoma", Font.BOLD, 14));
		titSocio.setBounds(40, 63, 50, 32);
		// A�ado la etiqueta de t�tulo SOCIO a la ventana
		this.add(titSocio);

		// Creo el ComboBox para el DNI del socio
		elegirDni = new JComboBox<String>();
		elegirDni.setBounds(100, 118, 159, 22);
		add(elegirDni);

		// Creo la etiqueta Dni
		textoDni = new JLabel("DNI");
		textoDni.setBounds(40, 118, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoDni);

		// Creo la etiqueta Nombre
		textoNombre = new JLabel("Nombre");
		textoNombre.setBounds(40, 159, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoNombre);

		// Creo el �rea de texto para el Nombre
		areaNombre = new JTextArea(1, 20);
		// areaCodigo.setEnabled(false);
		areaNombre.setBounds(100, 151, 159, 22);
		// A�ado el �rea a la ventana
		this.add(areaNombre);

		// T�tulo de LIBRO
		titLibro = new JLabel("LIBRO");
		titLibro.setFont(new Font("Tahoma", Font.BOLD, 14));
		titLibro.setBounds(427, 63, 50, 32);
		// A�ado la etiqueta de t�tulo SOCIO a la ventana
		this.add(titLibro);

		// Creo la etiqueta titulo
		textoTitulo = new JLabel("Titulo");
		textoTitulo.setBounds(427, 118, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoTitulo);

		// Creo el ComboBox para el titulo del LIBRO
		elegirTitulo = new JComboBox<String>();
		elegirTitulo.setBounds(520, 118, 159, 22);
		add(elegirTitulo);

		// Creo la etiqueta autor
		textoAutor = new JLabel("Autor");
		textoAutor.setBounds(427, 159, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoAutor);

		// Creo el �rea de texto para el autor
		areaAutor = new JTextArea(1, 20);
		// areaAutor.setEnabled(false);
		areaAutor.setBounds(520, 159, 159, 22);
		// A�ado el �rea a la ventana
		this.add(areaAutor);

		// Creo el bot�n
		botonDevolver = new JButton("Devolver");
		botonDevolver.setBounds(290, 300, 89, 23);
		// A�ado el bot�n a la ventana
		this.add(botonDevolver);

	}

	/*
	 * M�TODO QUE CREA EL COMBOBOX DNI
	 */
	public void crearComboBox(String[] cadena) {
		elegirDni.setModel(new DefaultComboBoxModel<String>(cadena));
		elegirDni.setBounds(113, 118, 159, 22);
		add(elegirDni);
	}

	/*
	 * M�todo que devuelve el item DNI seleccionado
	 */
	public String getDniSeleccionado() {
		String dni = (String) elegirDni.getSelectedItem();
		return dni;
	}
	
	/*
	 * M�TODO QUE CREA EL COMBOBOX TITULO
	 */
	public void crearComboBoxTitulo(String[] cadena) {
		elegirTitulo.setModel(new DefaultComboBoxModel<String>(cadena));
		elegirTitulo.setBounds(520, 118, 159, 22);
		add(elegirTitulo);
	}

	/*
	 * M�todo que devuelve el item TITULO seleccionado
	 */
	public String getTituloSeleccionado() {
		String titulo = (String) elegirTitulo.getSelectedItem();
		return titulo;
	}

	// M�todos get
	public JTextArea getAreaNombre() {
		return areaNombre;
	}

	public JTextArea getAreaAutor() {
		return areaAutor;
	}

	public JComboBox<String> getElegirDni() {
		return elegirDni;
	}

	public JComboBox<String> getElegirTitulo() {
		return elegirTitulo;
	}

	public JButton getBotonDevolver() {
		return botonDevolver;
	}

	public String[] getCadena() {
		return cadena;
	}
	public void setAreaNombre(String nombre) {
		areaNombre.setText(nombre);
	}
	public void setAreaAutor(String autor) {
		areaAutor.setText(autor);
	}
}
