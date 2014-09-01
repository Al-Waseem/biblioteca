package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ventana extends JFrame {

	// Atributos
	private JPanel panelBase, panelAutor;
	private BarraMenu barraMenu;
	private PanelImagen panelImagen;
	private PanelAddLibro panelAddLibro;
	private PanelListar panelListar;
	private PanelBorrarLibro panelBorrarLibro;
	private PanelModificarLibro panelModificarLibro;
	private PanelAddSocio panelAddSocio;
	private PanelBorrarSocio panelBorrarSocio;
	private PanelListarSocios panelListarSocios;
	private PanelModificarSocio panelModificarSocio;
	private PanelPrestar panelPrestar;
	private PanelDevolver panelDevolver;
	private PanelListarPrestamos panelListarPrestamos;
	private CardLayout gestorVentana;
	private CuadroLogin cuadroLogin;

	public CardLayout getGestorVentana() {
		return gestorVentana;
	}

	public Ventana() {
		super("Gesti�n de la Biblioteca");
		setTitle("Gestión de la Biblioteca");

		Container contenedor = getContentPane();
		BorderLayout gestorDise�o = new BorderLayout();
		contenedor.setLayout(gestorDise�o);

		// Creo la barra de men�
		barraMenu = new BarraMenu();
		// Añado a la ventana el men�
		this.setJMenuBar(barraMenu);

		JLabel autor = new JLabel("Autor: Carolina Colina Zamorano");
		contenedor.add(autor, BorderLayout.SOUTH);

		// Creo el panel principal
		panelBase = new JPanel();

		// Establezco el gestor de la zona centro, es decir, donde aparece la
		// imagen en primera instancia y donde luego se ver� el formulario para
		// insertar libros y la tabla con la lista de libros
		gestorVentana = new CardLayout();
		panelBase.setLayout(gestorVentana);

		// Creo el panel donde va la imagen
		panelImagen = new PanelImagen();

		// Creo el panel donde va el formulario
		panelAddLibro = new PanelAddLibro();

		// Creo el panel donde va a ir la tabla
		panelListar = new PanelListar();
		
		// Creao el panel para borrar libros
		panelBorrarLibro = new PanelBorrarLibro();
		 
		// Creo el panel para a�adir socios
		panelAddSocio = new PanelAddSocio();
		
		// creo el panel para borrar socios
		panelBorrarSocio = new PanelBorrarSocio();
		
		// Creo el panel para modificar Libro
		panelModificarLibro = new PanelModificarLibro();
		
		// Creo el panel para listar los Socios
		panelListarSocios = new PanelListarSocios();
		
		// Creo el panel para modificar Socios
		panelModificarSocio = new PanelModificarSocio();
		
		// Creo el panel para prestar Libros
		panelPrestar = new PanelPrestar();
		
		// Creo el panel para devolver libros
		panelDevolver = new PanelDevolver();
		
		// Creo el panel para listar los prestamos
		panelListarPrestamos = new PanelListarPrestamos();

		// A�ado la imagen al panel base
		panelBase.add(panelImagen, "PanelImagen");
		panelBase.add(panelAddLibro, "PanelAñadir");
		panelBase.add(panelListar, "PanelListar");
		panelBase.add(panelBorrarLibro, "PanelBorrarLibro");
		panelBase.add(panelAddSocio, "PanelSocio");
		panelBase.add(panelBorrarSocio, "PanelBorrarSocio");
		panelBase.add(panelListarSocios, "PanelListarSocios");
		panelBase.add(panelPrestar, "PanelPrestar");
		panelBase.add(panelDevolver, "PanelDevolver");
		panelBase.add(panelModificarLibro, "PanelModificarLibro");
		panelBase.add(panelModificarSocio, "PanelModificarSocio");
		panelBase.add(panelListarPrestamos, "PanelListarPrestamos");
		
		// Creo el cuadro de login
		cuadroLogin = new CuadroLogin();
		cuadroLogin.setVisible(false);
		
		// Añado el panel base al contenedor
		contenedor.add(panelBase, BorderLayout.CENTER);

	}
	
	/*
	 * M�todo para mostrar el cuadro login
	 */
	public void mostrarLogin(){
		cuadroLogin.setLocationRelativeTo(this);
		cuadroLogin.iniciarLogin();
		cuadroLogin.setVisible(true);
	}
	/*
	 * M�todo para ocultar el cuadro login
	 */
	public void ocultarLogin(){
		cuadroLogin.dispose();
	}
	
	/*
	 * M�todo para obtener el cuadro de login
	 */
	public CuadroLogin getCuadroLogin() {
		return cuadroLogin;
	}

	/*M�todo para mostrar los paneles*/
	public void mostrarPanel(String cadena) {
		gestorVentana.show(panelBase, cadena);
	}
	
	// M�todos get y set
	public JPanel getPanelBase() {
		return panelBase;
	}

	public JPanel getPanelAutor() {
		return panelAutor;
	}

	public BarraMenu getBarraMenu() {
		return barraMenu;
	}

	public PanelImagen getPanelImagen() {
		return panelImagen;
	}

	public PanelAddLibro getPanelAddLibro() {
		return panelAddLibro;
	}

	public PanelListar getPanelListar() {
		return panelListar;
	}
	public PanelBorrarLibro getPanelBorrarLibro() {
		return panelBorrarLibro;
	}

	public PanelModificarLibro getPanelModificarLibro () {
		return panelModificarLibro;
	}
	public PanelAddSocio getPanelAddSocio() {
		return panelAddSocio;
	}
	
	public PanelBorrarSocio getPanelBorrarSocio() {
		return panelBorrarSocio;
	}

	public PanelListarSocios getPanelListarSocios() {
		return panelListarSocios;
	}

	public PanelPrestar getPanelPrestar() {
		return panelPrestar;
	}

	public PanelDevolver getPanelDevolver() {
		return panelDevolver;
	}
	public PanelModificarSocio getPanelModificarSocio() {
		return panelModificarSocio;
	}

	public PanelListarPrestamos getPanelListarPrestamos() {
		return panelListarPrestamos;
	}	
}
