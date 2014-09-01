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
public class PanelModificarLibro extends JPanel {

	private JLabel titulo, textoCodigo, textoAutor, textoTitulo2;
	private JTextArea areaCodigo, areaAutor, areaTitulo2;
	private JComboBox<String> elegirTitulo;
	private JButton botonModificar;
	private String[] cadena;

	// Constructor
	PanelModificarLibro() {
		setLayout(null);

		// T�tulo de la ventana a�adir
		titulo = new JLabel("MODIFICAR LIBRO");
		titulo.setBounds(230, 51, 200, 20);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// A�ado el t�tulo a la ventana
		this.add(titulo);

		// Creo la etiqueta T�tulo
		textoCodigo = new JLabel("Código");
		textoCodigo.setBounds(100, 127, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoCodigo);

		// Creo la etiqueta Autor
		textoAutor = new JLabel("Autor: ");
		textoAutor.setBounds(100, 169, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoAutor);

		// Creo la etiqueta Titulo 2
		textoTitulo2 = new JLabel("Titulo: ");
		textoTitulo2.setBounds(100, 211, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoTitulo2);

		// Creo el �rea de texto para el c�digo
		areaCodigo = new JTextArea(1, 20);
		areaCodigo.setBounds(220, 122, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaCodigo);

		// Creo el �rea de texto para el autor
		areaAutor = new JTextArea(1, 20);
		areaAutor.setBounds(220, 164, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaAutor);

		// Creo el �rea de texto para el titulo 2
		areaTitulo2 = new JTextArea(1, 20);
		areaTitulo2.setBounds(220, 206, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaTitulo2);

		// Creo el bot�n
		botonModificar = new JButton("Guardar Cambios");
		botonModificar.setBounds(290, 270, 120, 23);
		// A�ado el bot�n a la ventana
		this.add(botonModificar);

		// Creo el ComboBox para el t�tulo del libro
		elegirTitulo = new JComboBox<String>();
		elegirTitulo.setBounds(220, 81, 250, 22);
		add(elegirTitulo);
	}

	/*
	 * M�TODO QUE CREA EL COMBOBOX
	 */
	public void crearComboBox(String[] cadena) {
		elegirTitulo.setModel(new DefaultComboBoxModel<String>(cadena));
		elegirTitulo.setBounds(220, 81, 250, 22);
		add(elegirTitulo);
	}

	/*
	 * M�todo que devuelve el item seleccionado
	 */
	public String getTituloSeleccionado() {
		String titulo = (String) elegirTitulo.getSelectedItem();
		return titulo;
	}

	// M�todos get
	public JTextArea getAreaCodigo() {
		return areaCodigo;
	}

	public JTextArea getAreaAutor() {
		return areaAutor;
	}

	public JButton getBoton() {
		return botonModificar;
	}

	public void setAreaCodigo(String codigo) {
		areaCodigo.setText(codigo);
	}

	public void setAreaAutor(String autor) {
		areaAutor.setText(autor);
	}

	public String[] getCadena() {
		return cadena;
	}

	public JComboBox<String> getElegirTitulo() {
		return elegirTitulo;
	}

	public JTextArea getAreaTitulo2() {
		return areaTitulo2;
	}

	public void setAreaTitulo2(String titulo2) {
		areaTitulo2.setText(titulo2);
	}
}
