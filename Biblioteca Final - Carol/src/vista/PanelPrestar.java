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
public class PanelPrestar extends JPanel {

	private JLabel titulo, titSocio, titLibro, textoDni, textoNombre,
			textoApellidos, textoFecha, textoTitulo, textoAutor, textoCodigo;
	private JTextArea areaNombre, areaApellidos, areaFecha, areaCodigo,
			areaAutor;
	private JComboBox<String> elegirDni, elegirTitulo;
	private JButton botonPrestar;
	private String[] cadena;

	// Constructor
	PanelPrestar() {
		setLayout(null);

		// T�tulo de la ventana a�adir
		titulo = new JLabel("PRESTAR LIBRO");
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
		elegirDni.setBounds(113, 118, 159, 22);
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

		// Creo la etiqueta Apellidos
		textoApellidos = new JLabel("Apellidos");
		textoApellidos.setBounds(40, 202, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoApellidos);

		// Creo la etiqueta Autor
		textoFecha = new JLabel("Fecha");
		textoFecha.setBounds(40, 244, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoFecha);

		// Creo el �rea de texto para el Nombre
		areaNombre = new JTextArea(1, 20);
		areaNombre.setEditable(false);
		areaNombre.setBounds(113, 159, 159, 22);
		// A�ado el �rea a la ventana
		this.add(areaNombre);

		// Creo el �rea de texto para los apellidos
		areaApellidos = new JTextArea(1, 20);
		areaApellidos.setEditable(false);
		areaApellidos.setBounds(113, 201, 159, 22);
		// A�ado el �rea a la ventana
		this.add(areaApellidos);

		// Creo el �rea de texto para la fecha
		areaFecha = new JTextArea(1, 20);
		areaFecha.setEditable(false);
		areaFecha.setBounds(113, 243, 159, 22);
		// A�ado el �rea a la ventana
		this.add(areaFecha);

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

		// Creo la etiqueta Codigo
		textoAutor = new JLabel("Autor");
		textoAutor.setBounds(427, 159, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoAutor);

		// Creo la etiqueta Codigo
		textoCodigo = new JLabel("Codigo");
		textoCodigo.setBounds(427, 201, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoCodigo);

		// Creo el area para el Autor
		areaAutor = new JTextArea(1, 20);
		areaAutor.setEditable(false);
		areaAutor.setBounds(520, 201, 159, 22);
		//A�ado el area a la ventana
		this.add(areaAutor);
		
		// Creo el area para el codigo
		areaCodigo = new JTextArea(1, 20);
		areaCodigo.setEditable(false);
		areaCodigo.setBounds(520, 159, 159, 22);
		// A�ado el area a la ventana
		this.add(areaCodigo);

		// Creo el bot�n
		botonPrestar = new JButton("Prestar");
		botonPrestar.setBounds(291, 301, 89, 23);
		// A�ado el bot�n a la ventana
		this.add(botonPrestar);

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

	public String[] getCadena() {
		return cadena;
	}

	public JTextArea getAreaNombre() {
		return areaNombre;
	}

	public JTextArea getAreaApellidos() {
		return areaApellidos;
	}

	public JTextArea getAreaFecha() {
		return areaFecha;
	}

	public JTextArea getAreaAutor() {
		return areaCodigo;
	}

	public JTextArea getAreaCodigo() {
		return areaAutor;
	}

	public JComboBox<String> getElegirDni() {
		return elegirDni;
	}

	public JComboBox<String> getElegirTitulo() {
		return elegirTitulo;
	}

	public JButton getBotonPrestar() {
		return botonPrestar;
	}

	public void setAreaNombre(String nombre) {
		areaNombre.setText(nombre);
	}

	public void setAreaApellidos(String apellidos) {
		areaApellidos.setText(apellidos);
	}

	public void setAreaFecha(String fecha) {
		areaFecha.setText(fecha);
	}

	public void setAreaAutor(String autor) {
		areaCodigo.setText(autor);
	}

	public void setAreaCodigo(String codigo) {
		areaAutor.setText(codigo);
	}

}
