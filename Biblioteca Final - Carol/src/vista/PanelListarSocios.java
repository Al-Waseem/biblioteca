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
	private BoxLayout gestorDiseño;
	private Font fuente;
	private JPanel panelTitulo, panelTabla;

	public PanelListarSocios() {

		// Creo un panel para el tï¿½tulo y otro para la tabla
		panelTitulo = new JPanel();
		panelTabla = new JPanel();

		// Estilo del tï¿½tulo
		fuente = new Font("Calibri", Font.BOLD, 30);

		// Creo el gestor de diseï¿½o y se le asigno a la ventana
		gestorDiseño = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(gestorDiseño);

		// Creo el tï¿½tulo y le aï¿½ado el estilo
		tituloTabla = new JLabel("LISTADO DE SOCIOS");
		tituloTabla.setFont(fuente);
		// Aï¿½ado al panel de tï¿½tulo el tï¿½tulo de la tabla
		panelTitulo.add(tituloTabla);

		// Creo la tabla
		tabla = new JTable();
		// Creo el JSscrollPanel y le aï¿½ado la tabla
		scroll = new JScrollPane(tabla);
		// Aï¿½ado el scroll al panel de tabla
		panelTabla.add(scroll);

		// Aï¿½ado ambos paneles a la ventana posicionados al norte y en el centro
		this.add(panelTitulo, BorderLayout.NORTH);
		this.add(panelTabla, BorderLayout.CENTER);
	}

	// Mï¿½todo get
	public JTable getTabla() {
		return tabla;
	}

}
