package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.*;
import vista.*;

public class Controlador implements ActionListener {
	// Atributos
	private Ventana ventana;
	private JMenuItem[] itemMenu;
	private JButton conectar, botonGuardarLibro, botonBorrarLibro,
			botonGuardarSocio, botonBorrarSocio, botonPrestar, botonDevolver,
			botonModificarLibro, botonModificarSocio;
	private Datos datos;
	private boolean conexion = false;
	private String mensaje;
	private BarraMenu barra;
	@SuppressWarnings("rawtypes")
	private JComboBox itemBorrarLibro, itemBorrarSocio, itemDniPrestar,
			itemDniDevolver, itemTituloPrestar, itemTituloDevolver,
			itemSocioDevolver, itemLibroDevolver, itemModificarLibro;
	private Biblioteca biblioteca;

	private Libro libro;
	private ArrayList<Libro> libros;
	private Socio socio;
	private ArrayList<Socio> socios;

	@SuppressWarnings("rawtypes")
	public Controlador() {
		ventana = new Ventana();
		datos = new Datos();
		barra = new BarraMenu();
		itemBorrarLibro = new JComboBox();
		itemBorrarSocio = new JComboBox();
		itemDniPrestar = new JComboBox();
		itemDniDevolver = new JComboBox();
		itemTituloPrestar = new JComboBox();
		itemTituloDevolver = new JComboBox();
		itemModificarLibro = new JComboBox();
		itemSocioDevolver = new JComboBox();
		itemLibroDevolver = new JComboBox();
		biblioteca = new Biblioteca("", "");
		libros = new ArrayList<Libro>();
		socios = new ArrayList<Socio>();

		barra = ventana.getBarraMenu();

		itemMenu = new JMenuItem[ventana.getBarraMenu().getItemMenu().length];
		for (int i = 0; i < itemMenu.length; i++) {
			itemMenu[i] = ventana.getBarraMenu().getItemMenu()[i];
			itemMenu[i].addActionListener(this);
		}

		// Conectar
		conectar = ventana.getCuadroLogin().getBotonConectar();
		conectar.addActionListener(this);

		// Guardar Libro
		botonGuardarLibro = ventana.getPanelAddLibro().getBoton();
		botonGuardarLibro.addActionListener(this);

		// Borrar Libro
		botonBorrarLibro = ventana.getPanelBorrarLibro().getBoton();
		botonBorrarLibro.addActionListener(this);

		// Bot�n Modificar Libro
		botonModificarLibro = ventana.getPanelModificarLibro().getBoton();
		botonModificarLibro.addActionListener(this);

		// Guardar Socio
		botonGuardarSocio = ventana.getPanelAddSocio().getBoton();
		botonGuardarSocio.addActionListener(this);

		// Borrar Socio
		botonBorrarSocio = ventana.getPanelBorrarSocio().getBotonBorrar();
		botonBorrarSocio.addActionListener(this);

		// Bot�n Prestar Libro
		botonPrestar = ventana.getPanelPrestar().getBotonPrestar();
		botonPrestar.addActionListener(this);

		// Bot�n Devolver Libro
		botonDevolver = ventana.getPanelDevolver().getBotonDevolver();
		botonDevolver.addActionListener(this);

		// Item Borrar Libro
		itemBorrarLibro = ventana.getPanelBorrarLibro().getElegirTitulo();
		itemBorrarLibro.addActionListener(this);

		// Item Borrar Socio
		itemBorrarSocio = ventana.getPanelBorrarSocio().getElegirDni();
		itemBorrarSocio.addActionListener(this);

		// Item Boton Modificar Socio
		botonModificarSocio = ventana.getPanelModificarSocio().getBoton();
		botonModificarSocio.addActionListener(this);

		// Item DNI prestar libro
		itemDniPrestar = ventana.getPanelPrestar().getElegirDni();
		itemDniPrestar.addActionListener(this);

		// Item Titulo prestar libro
		itemTituloPrestar = ventana.getPanelPrestar().getElegirTitulo();
		itemTituloPrestar.addActionListener(this);

		// Item DNI devolver libro
		itemDniDevolver = ventana.getPanelDevolver().getElegirDni();
		itemDniDevolver.addActionListener(this);

		// Item titulo devolver libro
		itemTituloDevolver = ventana.getPanelDevolver().getElegirTitulo();
		itemTituloDevolver.addActionListener(this);

		// Item modificar libro
		itemModificarLibro = ventana.getPanelModificarLibro().getElegirTitulo();
		itemModificarLibro.addActionListener(this);

		// Item Socio Devolver
		itemSocioDevolver = ventana.getPanelDevolver().getElegirDni();
		itemSocioDevolver.addActionListener(this);

		// Item Libro Devolver
		itemLibroDevolver = ventana.getPanelDevolver().getElegirTitulo();
		itemLibroDevolver.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(itemMenu[3])) { // Salir
			System.exit(0);
		}
		if (e.getSource().equals(itemMenu[2])) { // Acerca de
			JOptionPane.showMessageDialog(null,
					"Aplicación que crea una biblioteca");
		}

		if (e.getSource().equals(itemMenu[0])) { // Login
			ventana.mostrarLogin();
		}

		if (e.getSource().equals(conectar)) {
			// Cuando se pulsa el botón para realizar la conexión
			crearConexion();
			// Si se ha hecho la conexi�n y no existe la biblioteca
			if (conexion == true) {
				if (!datos.existeTabla("BIBLIOTECA")) {
					barra.segundaBarra();
				} else {
					cambiarVentana();
					comprobarTablas();
				}
			}
		}

		if (e.getSource().equals(itemMenu[1])) {
			crearBiblioteca();
			comprobarTablas();
		}

		if (e.getSource().equals(itemMenu[4])) {
			ventana.mostrarPanel("PanelAñadir");
		}

		if (e.getSource().equals(botonGuardarLibro)) {
			guardarLibro();
			comprobarTablas();
		}

		if (e.getSource().equals(itemMenu[5])) {
			libros.clear();
			libros = datos.consultarDatosLibro(1);

			int i = 0;
			int c = 1;
			String[] cadena = new String[libros.size() + 1];
			cadena[0] = "Selecciona...";

			while (i < libros.size()) {
				cadena[c] = libros.get(i).getTitulo();
				i++;
				c++;
			}
			ventana.getPanelBorrarLibro().crearComboBox(cadena);
			ventana.mostrarPanel("PanelBorrarLibro");
		}

		if (e.getSource().equals(itemBorrarLibro)) {
			rellenarCamposLibro("borrar");
		}

		if (e.getSource().equals(botonBorrarLibro)) {
			String codigo = ventana.getPanelBorrarLibro().getAreaCodigo()
					.getText();
			// Borro el libro de la tabla
			datos.borrarDatosLibro(codigo);
			// Actualizo la colección de libros con los datos que hay ahora en
			// la tabla
			libros.clear();
			libros = datos.consultarDatosLibro(1);
			String[] cadena = new String[libros.size() + 1];
			cadena[0] = "Selecciona...";
			int i = 0;
			int c = 1;
			// Cargo el ComboBox con los datos que quedan ahora en la tabla
			while (i < libros.size()) {
				cadena[c] = libros.get(i).getTitulo();
				i++;
				c++;
			}
			ventana.getPanelBorrarLibro().crearComboBox(cadena);
			// Borro el contenido del c�digo y autor
			ventana.getPanelBorrarLibro().getAreaCodigo().setText("");
			ventana.getPanelBorrarLibro().getAreaAutor().setText("");
			// Que el item que se muestre sea el 0, es decir "Selecciona..."
			ventana.getPanelBorrarLibro().getElegirTitulo().setSelectedIndex(0);
		}
		if (e.getSource().equals(itemMenu[6])) {
			// No es necesario modificar libro
		}

		if (e.getSource().equals(itemMenu[7])) {
			// Tipos de datos que va a contener el modelo
			Object[][] libros;

			// Guardo los datos de la tabla libro en las variables
			libros = datos.obtenerDatosTablaLibro();
			String[] tituloTabla = { "CODIGO", "TITULO", "AUTOR" };

			// Creo el modelo de tabla
			DefaultTableModel modelo = new DefaultTableModel(libros,
					tituloTabla);

			// Le doy el modelo a mi tabla
			JTable tabla = ventana.getPanelListar().getTabla();
			tabla.setModel(modelo);
			ventana.mostrarPanel("PanelListar");
		}
		
		
		if (e.getSource().equals(itemMenu[8])) {
			ventana.mostrarPanel("PanelSocio");
		}

		if (e.getSource().equals(botonGuardarSocio)) {
			guardarSocio();
			comprobarTablas();
		}

		if (e.getSource().equals(itemMenu[9])) {
			socios.clear();
			socios = datos.consultarDatosSocio(1);

			int i = 0;
			int c = 1;
			String[] cadena = new String[socios.size() + 1];
			cadena[0] = "Selecciona...";

			while (i < socios.size()) {
				cadena[c] = socios.get(i).getDni();
				i++;
				c++;
			}
			ventana.getPanelBorrarSocio().crearComboBox(cadena);
			ventana.mostrarPanel("PanelBorrarSocio");
		}

		
		if (e.getSource().equals(itemBorrarSocio)) {
			rellenarCamposSocio("borrar");
		}
		
		
		if (e.getSource().equals(botonBorrarSocio)) {
			String dni = ventana.getPanelBorrarSocio().getDniSeleccionado();
			datos.borrarDatosSocio(dni);
			socios.clear();
			socios = datos.consultarDatosSocio(1);
			String[] cadena = new String[socios.size() + 1];
			cadena[0] = "Selecciona...";
			int i = 0;
			int c = 1;
			// Cargo los datos en el combobox
			while (i < socios.size()) {
				cadena[c] = socios.get(i).getDni();
				i++;
				c++;
			}
			ventana.getPanelBorrarSocio().crearComboBox(cadena);
			// Borro el contenido del c�digo y autor
			ventana.getPanelBorrarSocio().getAreaNombre().setText("");
			ventana.getPanelBorrarSocio().getAreaApellidos().setText("");
			ventana.getPanelBorrarSocio().getAreaDireccion().setText("");
			// Que el item que se muestre sea el 0, es decir "Selecciona..."
			ventana.getPanelBorrarSocio().getElegirDni().setSelectedIndex(0);
		}

		
		if (e.getSource().equals(itemMenu[10])) {
			socios.clear();
			socios = datos.consultarDatosSocio(1);

			int i = 0;
			int c = 1;
			String[] cadena = new String[socios.size() + 1];
			cadena[0] = "Selecciona...";

			while (i < socios.size()) {
				cadena[c] = socios.get(i).getNombre();
				i++;
				c++;
			}
			ventana.getPanelModificarSocio().crearComboBox(cadena);
			ventana.mostrarPanel("PanelModificarSocio");
		}

		
		if (e.getSource().equals(botonModificarSocio)) {
			String nombre = ventana.getPanelModificarSocio()
					.getNombreSeleccionado();
			String direccion = ventana.getPanelModificarSocio()
					.getAreaDireccion().getText();
			String telefono = ventana.getPanelModificarSocio()
					.getAreaTelefono().getText();

			datos.modificarSocio(direccion, telefono, nombre);

			ventana.getPanelModificarSocio().setAreaDireccion("");
			ventana.getPanelModificarSocio().setAreaTelefono("");
		}

		if (e.getSource().equals(itemMenu[11])) {
			// Tipos de datos que va a contener el modelo
			Object[][] socios;

			// Guardo los datos de la tabla libro en las variables
			socios = datos.obtenerDatosTablaSocios();
			String[] tituloTabla = { "DNI", "NOMBRE", "APELLIDOS", "DIRECCION",
					"TELEFONO" };

			// Creo el modelo de tabla
			DefaultTableModel modelo = new DefaultTableModel(socios,
					tituloTabla);

			// Le doy el modelo a mi tabla
			JTable tabla = ventana.getPanelListarSocios().getTabla();
			tabla.setModel(modelo);
			ventana.mostrarPanel("PanelListarSocios");
		}

		if (e.getSource().equals(itemMenu[12])) {
			libros.clear();
			socios.clear();
			libros = datos.consultarDatosLibro(1);
			socios = datos.consultarDatosSocio(1);
			// JOptionPane.showMessageDialog(null, socios.get(1).getDni());
			String[] cadenaTitulo = new String[libros.size() + 1];
			String[] cadenaDni = new String[socios.size() + 1];
			cadenaDni[0] = "Selecciona...";
			cadenaTitulo[0] = "Selecciona...";
			int i = 0;
			int c = 1;
			// Cargo el ComboBox con los datos que quedan ahora en la tabla
			while (i < libros.size()) {
				cadenaTitulo[c] = libros.get(i).getTitulo();
				i++;
				c++;
			}

			i = 0;
			c = 1;
			while (i < socios.size()) {
				cadenaDni[c] = socios.get(i).getDni();
				i++;
				c++;
			}
			ventana.getPanelPrestar().crearComboBoxTitulo(cadenaTitulo);
			ventana.getPanelPrestar().crearComboBox(cadenaDni);
			ventana.mostrarPanel("PanelPrestar");
		}

		if (e.getSource().equals(itemDniPrestar)) {
			rellenarCamposSocio("prestar");

		}

		if (e.getSource().equals(itemTituloPrestar)) {
			rellenarCamposLibro("prestar");
		}

		if (e.getSource().equals(botonPrestar)) {
			prestarLibro();
			comprobarTablas();
		}

		if (e.getSource().equals(itemMenu[13])) {
			libros.clear();
			socios.clear();
			libros = datos.consultarDatosLibro(3);
			socios = datos.consultarDatosSocio(3);
			// JOptionPane.showMessageDialog(null, socios.get(1).getDni());
			String[] cadenaTitulo = new String[libros.size() + 1];
			String[] cadenaDni = new String[socios.size() + 1];
			cadenaDni[0] = "Selecciona...";
			cadenaTitulo[0] = "Selecciona...";
			int i = 0;
			int c = 1;
			// Cargo el ComboBox con los datos que quedan ahora en la tabla
			while (i < libros.size()) {
				cadenaTitulo[c] = libros.get(i).getTitulo();
				i++;
				c++;
			}

			i = 0;
			c = 1;
			while (i < socios.size()) {
				cadenaDni[c] = socios.get(i).getDni();
				i++;
				c++;
			}
			
			ventana.getPanelDevolver().crearComboBoxTitulo(cadenaTitulo);
			ventana.getPanelDevolver().crearComboBox(cadenaDni);
			ventana.mostrarPanel("PanelDevolver");
		}
		if (e.getSource().equals(itemSocioDevolver)) {
			rellenarCamposSocio("devolver");
		}
		if (e.getSource().equals(itemLibroDevolver)) {
			rellenarCamposLibro("devolver");
		}
		if (e.getSource().equals(botonDevolver)) {
			String dni = ventana.getPanelDevolver().getDniSeleccionado();
			datos.borrarDatosPrestamos(dni);

			ventana.getPanelDevolver().setAreaNombre("");
			ventana.getPanelDevolver().setAreaAutor("");

			libros.clear();
			socios.clear();
			libros = datos.consultarDatosLibro(3);
			socios = datos.consultarDatosSocio(3);
			// JOptionPane.showMessageDialog(null, socios.get(1).getDni());
			String[] cadenaTitulo = new String[libros.size() + 1];
			String[] cadenaDni = new String[socios.size() + 1];
			cadenaDni[0] = "Selecciona...";
			cadenaTitulo[0] = "Selecciona...";
			int i = 0;
			int c = 1;
			// Cargo el ComboBox con los datos que quedan ahora en la tabla
			while (i < libros.size()) {
				cadenaTitulo[c] = libros.get(i).getTitulo();
				i++;
				c++;
			}

			i = 0;
			c = 1;
			while (i < socios.size()) {
				cadenaDni[c] = socios.get(i).getDni();
				i++;
				c++;
			}
			ventana.getPanelDevolver().crearComboBoxTitulo(cadenaTitulo);
			ventana.getPanelDevolver().crearComboBox(cadenaDni);
			comprobarTablas();
		}

		if (e.getSource().equals(itemMenu[14])) {
			// Tipos de datos que va a contener el modelo
			Object[][] socios;

			// Guardo los datos de la tabla libro en las variables
			socios = datos.obtenerDatosPrestamos();
			String[] tituloTabla = { "TITULO", "AUTOR", "NOMBRE", "DNI",
					"FECHA" };

			// Creo el modelo de tabla
			DefaultTableModel modelo = new DefaultTableModel(socios,
					tituloTabla);

			// Le doy el modelo a mi tabla
			JTable tabla = ventana.getPanelListarPrestamos().getTabla();
			tabla.setModel(modelo);
			ventana.mostrarPanel("PanelListarPrestamos");
		}
	}

	public Ventana getVentana() {
		return ventana;
	}

	public void mostrarLogin() {
		ventana.mostrarLogin();
	}

	/*
	 * Método que crea la tabla biblioteca
	 */
	public void crearBiblioteca() {
		String nombre = JOptionPane.showInputDialog("Nombre de la biblioteca");
		biblioteca = new Biblioteca(nombre, "imagenes/icono.gif");
		datos.crearTabla("BIBLIOTECA");
		datos.insertarDatosBiblioteca(biblioteca);
		cambiarVentana();
		// Creo el resto de tablas
		datos.crearTabla("LIBRO");
		datos.crearTabla("SOCIOS");
		datos.crearTabla("PRESTAMOS");
	}

	/*
	 * Método que cambia la ventana
	 */
	public void cambiarVentana() {
		biblioteca = datos.consultarDatosBiblioteca();
		// Cambiar nombre Ventana
		String nombre = biblioteca.getNombre();
		ventana.setTitle(nombre);
		String rutaIcono = biblioteca.getRutaIcono();
		ventana.setIconImage((new ImageIcon(rutaIcono)).getImage());
	}

	/*
	 * METODO QUE COMPRUEBA LA EXISTENCIA Y CONTENIDO DE LAS TABLAS PARA ACTIVAR
	 * O DESACTIVAR LAS OPCIONES DEL MENU
	 */
	public void comprobarTablas() {
		libros.clear();
		socios.clear();
		libros = datos.consultarDatosLibro(2);
		socios = datos.consultarDatosSocio(2);

		if (libros.isEmpty() && socios.isEmpty()) {
			barra.terceraBarra();
		} else if (!libros.isEmpty() && socios.isEmpty()) {
			barra.terceraBarraBis(); // Habilita a�adir, borrar y listar de
										// Libro y s�lo a�adir de Socio
		} else if (libros.isEmpty() && !socios.isEmpty()) {
			barra.cuartaBarra(); // Habilita a�adir, borrar y listar de
									// Socio y s�lo a�adir de Libro
		} else if (!libros.isEmpty() && !socios.isEmpty()) {
			barra.quintaBarra(); // Habilita todo de Socios y Libros
			// Sino existen datos en Libros ni en Socios, no se pueden hacer
			// pr�stamos, por lo que la barra no se activa hasta entonces

			if (datos.consultarDatosPrestamos().equals("")) {
				barra.sextaBarra();
			} else {
				barra.septimaBarra();
			}
		}
	}

	/*
	 * Método que añade un libro a la tabla Libro
	 */
	public void guardarLibro() {

		String codigo = ventana.getPanelAddLibro().getAreaCodigo().getText();
		String titulo = ventana.getPanelAddLibro().getAreaLibro().getText();
		String autor = ventana.getPanelAddLibro().getAreaAutor().getText();
		libro = new Libro(codigo, titulo, autor);
		datos.insertarDatosLibro(libro);
		JOptionPane.showMessageDialog(null, "Se ha guardado el libro correctamente");
		ventana.getPanelAddLibro().getAreaCodigo().setText("");
		ventana.getPanelAddLibro().getAreaLibro().setText("");
		ventana.getPanelAddLibro().getAreaAutor().setText("");
	}

	/*
	 * Método que borra un libro
	 */
	public void rellenarCamposLibro(String panel) {
		libros.clear();
		libros = datos.consultarDatosLibro(2);
		String titulo = "";
		String codigo = "";
		String autor = "";
		if (panel.equals("borrar")) {
			titulo = ventana.getPanelBorrarLibro().getTituloSeleccionado();
		} else if (panel.equals("prestar")) {
			titulo = ventana.getPanelPrestar().getTituloSeleccionado();
		} else {
			titulo = ventana.getPanelDevolver().getTituloSeleccionado();
		}
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getTitulo().equals(titulo)) {
				autor = libros.get(i).getAutor();
				codigo = libros.get(i).getCodigo();
			}
		}
		if (panel.equals("borrar")) {
			ventana.getPanelBorrarLibro().setAreaAutor(autor);
			ventana.getPanelBorrarLibro().setAreaCodigo(codigo);
		}

		if (panel.equals("prestar")) {
			ventana.getPanelPrestar().setAreaAutor(autor);
			ventana.getPanelPrestar().setAreaCodigo(codigo);
		}
		if (panel.equals("devolver")) {
			ventana.getPanelDevolver().setAreaAutor(autor);
		}
	}

	/*
	 * Método que añade un socio a la tabla socios
	 */
	public void guardarSocio() {

		String dni = ventana.getPanelAddSocio().getAreaDni().getText();
		String nombre = ventana.getPanelAddSocio().getAreaNombre().getText();
		String apellidos = ventana.getPanelAddSocio().getAreaApellidos()
				.getText();
		String direccion = ventana.getPanelAddSocio().getAreaDireccion()
				.getText();
		String telefono = ventana.getPanelAddSocio().getAreaTelefono()
				.getText();
		socio = new Socio(dni, nombre, apellidos, direccion, telefono);
		datos.insertarDatosSocio(socio);

		JOptionPane.showMessageDialog(null, "Se ha guardado el socio");
		ventana.getPanelAddSocio().getAreaDni().setText("");
		ventana.getPanelAddSocio().getAreaNombre().setText("");
		ventana.getPanelAddSocio().getAreaApellidos().setText("");
		ventana.getPanelAddSocio().getAreaDireccion().setText("");
		ventana.getPanelAddSocio().getAreaTelefono().setText("");
	}

	/*
	 * M�todo que rellena los campos
	 */
	public void rellenarCamposSocio(String panel) {
		socios.clear();
		socios = datos.consultarDatosSocio(2);
		String dni = "";
		String nombre = "";
		String apellidos = "";
		String direccion = "";
		if (panel.equals("borrar")) {
			dni = ventana.getPanelBorrarSocio().getDniSeleccionado();
		} else if (panel.equals("prestar")) {
			dni = ventana.getPanelPrestar().getDniSeleccionado();
		} else if (panel.equals("devolver")) {
			dni = ventana.getPanelDevolver().getDniSeleccionado();
		}
		for (int i = 0; i < socios.size(); i++) {
			if (socios.get(i).getDni().equals(dni)) {
				nombre = socios.get(i).getNombre();
				apellidos = socios.get(i).getApellidos();
				direccion = socios.get(i).getDireccion();
			}
		}
		if (panel.equals("borrar")) {
			ventana.getPanelBorrarSocio().setAreaNombre(nombre);
			ventana.getPanelBorrarSocio().setAreaApellidos(apellidos);
			ventana.getPanelBorrarSocio().setAreaDireccion(direccion);
		}

		if (panel.equals("prestar")) {
			ventana.getPanelPrestar().setAreaNombre(nombre);
			ventana.getPanelPrestar().setAreaApellidos(apellidos);
			ventana.getPanelPrestar().setAreaFecha("Fecha");
		}
		if (panel.equals("devolver")) {
			ventana.getPanelDevolver().setAreaNombre(nombre);
		}
	}

	/*
	 * M�todo que presta un libro
	 */
	public void prestarLibro() {

		String dni = ventana.getPanelPrestar().getDniSeleccionado();
		String codigo = ventana.getPanelPrestar().getAreaCodigo().getText();
		String fecha = ventana.getPanelPrestar().getAreaFecha().getText();

		datos.insertarDatosPrestamos(codigo, dni, fecha);

		JOptionPane.showMessageDialog(null, "Se ha prestado el libro");
		ventana.getPanelPrestar().getAreaCodigo().setText("");
		ventana.getPanelPrestar().getAreaFecha().setText("");
		ventana.getPanelPrestar().getElegirDni().setSelectedIndex(0);
		ventana.getPanelPrestar().getElegirTitulo().setSelectedIndex(0);
	}

	/*
	 * M�todo para crear la conexi�n
	 */
	public void crearConexion() {
		try {
			String usuario = ventana.getCuadroLogin().getCampoUsuario();
			String clave = ventana.getCuadroLogin().getCampoClave();
			datos.conectar(usuario, clave);
			ventana.ocultarLogin();
			conexion = true;
		} catch (SQLException e) {
			if (e.getErrorCode() == 1017) {
				mensaje = "Usuario o clave no válidos";
				mostrarMensaje(mensaje);
				mostrarLogin();
			} else {
				muestraSQLException(e);
			}
		}
	}

	/*
	 * M�todo para obtener otras excepciones no controladas
	 */
	public static void muestraSQLException(SQLException ex) {
		System.out.println("Se han dado excepciones SQLException\n");
		System.out.println("========================\n");
		// Pueden existir varias SQLException encadenadas
		while (ex != null) {
			System.out.println("SQLState :" + ex.getSQLState() + "\n");
			System.out.println("Mensaje :" + ex.getMessage() + "\n");
			System.out.println("C�digo de error :" + ex.getErrorCode() + "\n");
			ex = ex.getNextException();
			System.out.println("\n");
		}
	}

	/*
	 * M�todo para mostrar los mensajes
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(ventana, mensaje, "Error de conexión", 0);
	}
}
