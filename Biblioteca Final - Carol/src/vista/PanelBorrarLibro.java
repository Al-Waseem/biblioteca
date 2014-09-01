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
public class PanelBorrarLibro extends JPanel {

	private JLabel titulo, textoCodigo, textoAutor, textoTitulo;
	private JTextArea areaCodigo, areaAutor;
	private JComboBox <String> elegirTitulo;
	private JButton botonBorrar;
	private String [] cadena;

	// Constructor
	PanelBorrarLibro() {
		setLayout(null);

		// T�tulo de la ventana a�adir
		titulo = new JLabel("BORRAR LIBRO");
		titulo.setBounds(230, 51, 200, 20);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// A�ado el t�tulo a la ventana
		this.add(titulo);
		
		// Creo la etiqueta C�digo
		textoTitulo = new JLabel("T�tulo");
		textoTitulo.setBounds(100, 85, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoTitulo);

		// Creo la etiqueta T�tulo
		textoCodigo = new JLabel("C�digo");
		textoCodigo.setBounds(100, 127, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoCodigo);
		
		// Creo la etiqueta Autor
		textoAutor = new JLabel("Autor: ");
		textoAutor.setBounds(100, 169, 50, 14);
		// A�ado la etiqueta a la ventana
		this.add(textoAutor);
		
		// Creo el �rea de texto para el c�digo 
		areaCodigo = new JTextArea(1, 20);
		areaCodigo.setEditable(false);
		areaCodigo.setBounds(220, 122, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaCodigo);
		
		// Creo el �rea de texto para el autor
		areaAutor = new JTextArea(1, 20);
		areaAutor.setEditable(false);
		areaAutor.setBounds(220, 164, 250, 22);
		// A�ado el �rea a la ventana
		this.add(areaAutor);
			
		// Creo el bot�n
		botonBorrar = new JButton("Borrar");
		botonBorrar.setBounds(290, 270, 89, 23);
		// A�ado el bot�n a la ventana
		this.add(botonBorrar);
		
		// Creo el ComboBox para el t�tulo del libro
		elegirTitulo = new JComboBox<String>();
		elegirTitulo.setBounds(220, 81, 250, 22);
		add(elegirTitulo);
	}
	
	/*
	 * M�TODO QUE CREA EL COMBOBOX
	 * */
	public void crearComboBox(String[] cadena) {
		elegirTitulo.setModel(new DefaultComboBoxModel<String>(cadena));
		elegirTitulo.setBounds(220, 81, 250, 22);
		add(elegirTitulo);
	}

	/*
	 * M�todo que devuelve el item seleccionado
	 * */
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
		return botonBorrar;
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
	
}
