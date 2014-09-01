package vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PanelListarSocios extends JPanel {

	// Atributos
	private JTable tabla;
	private JLabel tituloTabla;
	private JScrollPane scroll;
	private BoxLayout gestorDise�o;
	private Font fuente;
	private JPanel panelTitulo, panelTabla;

	public PanelListarSocios() {

		// Creo un panel para el t�tulo y otro para la tabla
		panelTitulo = new JPanel();
		panelTabla = new JPanel();

		// Estilo del t�tulo
		fuente = new Font("Calibri", Font.BOLD, 30);

		// Creo el gestor de dise�o y se le asigno a la ventana
		gestorDise�o = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(gestorDise�o);

		// Creo el t�tulo y le a�ado el estilo
		tituloTabla = new JLabel("LISTADO DE SOCIOS");
		tituloTabla.setFont(fuente);
		// A�ado al panel de t�tulo el t�tulo de la tabla
		panelTitulo.add(tituloTabla);

		// Creo la tabla
		tabla = new JTable();
		// Creo el JSscrollPanel y le a�ado la tabla
		scroll = new JScrollPane(tabla);
		// A�ado el scroll al panel de tabla
		panelTabla.add(scroll);

		// A�ado ambos paneles a la ventana posicionados al norte y en el centro
		this.add(panelTitulo, BorderLayout.NORTH);
		this.add(panelTabla, BorderLayout.CENTER);
	}

	// M�todo get
	public JTable getTabla() {
		return tabla;
	}

}
