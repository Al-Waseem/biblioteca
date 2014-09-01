package vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PanelListar extends JPanel {

	// Atributos
	private JTable tabla;
	private JLabel tituloTabla;
	private JScrollPane scroll;
	private BoxLayout gestorDise�o;
	private Font fuente;
	private JPanel panelTitulo, panelTabla;

	public PanelListar() {

		// Creo un panel para el t�tulo y otro para la tabla
		panelTitulo = new JPanel();
		panelTabla = new JPanel();

		// Estilo del t�tulo
		fuente = new Font("Calibri", Font.BOLD, 30);

		// Creo el gestor de dise�o y se le asigno a la ventana
		gestorDise�o = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(gestorDise�o);

		// Creo el t�tulo y le Añadir el estilo
		tituloTabla = new JLabel("LISTADO DE LIBROS");
		tituloTabla.setFont(fuente);
		// Añadir al panel de t�tulo el t�tulo de la tabla
		panelTitulo.add(tituloTabla);

		// Creo la tabla
		tabla = new JTable();
		// Creo el JSscrollPanel y le Añadir la tabla
		scroll = new JScrollPane(tabla);
		// Añadir el scroll al panel de tabla
		panelTabla.add(scroll);

		// Añadir ambos paneles a la ventana posicionados al norte y en el centro
		this.add(panelTitulo, BorderLayout.NORTH);
		this.add(panelTabla, BorderLayout.CENTER);
	}

	// Métodos get
	public JTable getTabla() {
		return tabla;
	}

}
