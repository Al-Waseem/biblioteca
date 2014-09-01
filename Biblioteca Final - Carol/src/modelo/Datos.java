package modelo;

import java.sql.*;
import java.util.ArrayList;

import oracle.jdbc.driver.*;

public class Datos {
	// Atributos
	protected Connection conexion;
	protected Statement stmt;
	private Biblioteca biblioteca;
	private Libro libro;
	private Socio socio;
	private ArrayList<Libro> libros;
	private ArrayList<Socio> socios;

	public Datos() {
		conexion = null;
		stmt = null;
		libros = new ArrayList<Libro>();
		socios = new ArrayList<Socio>();
	}

	/*
	 * METODO PARA REALIZAR LA CONEXION CON UN USUARIO Y CLAVE DETERMINADOS
	 */
	public void conectar(String usuario, String clave) throws SQLException {
		System.out.println(usuario);
		System.out.println(clave);
		DriverManager.registerDriver(new OracleDriver());

		/*conexion = DriverManager.getConnection(
		"jdbc:oracle:thin:@boa.cesbur:1521:a2t10", usuario, clave);*/
		

		conexion = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:base", usuario, clave);
	}

	/*
	 * METODO QUE DEVUELVE LA CONEXION
	 */
	public Connection conexion() {
		return conexion;
	}

	/*
	 * METODO QUE COMPRUEBA SI EXISTE UNA TABLA
	 */
	public boolean existeTabla(String nombreTabla) {
		boolean existe = false;
		String cadena = "";
		try {
			stmt = conexion.createStatement();
			String sentencia = "SELECT table_name FROM user_tables WHERE  "
					+ "table_name='" + nombreTabla + "'";
			ResultSet resultado = stmt.executeQuery(sentencia);

			// Sino ha obtenido resultado que no haga nada, as� no da error de
			// Juego de resultados agotado
			if (resultado.next() == true) {
				cadena = resultado.getString("table_name");
			}

			if (cadena != "") {
				existe = true;
			}
		} catch (SQLException ex) {
			muestraSQLException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return existe;
	}

	/* METODO QUE CREA LAS TABLAS */
	public void crearTabla(String tabla) {
		try {
			stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String sentencia = "";

			switch (tabla) {
			case "BIBLIOTECA":
				sentencia = "CREATE TABLE Biblioteca (nombre VARCHAR(20),path VARCHAR(20))";
				break;
			case "LIBRO":
				sentencia = "CREATE TABLE Libro (codigo VARCHAR2(20),"
						+ " titulo VARCHAR2(20)," + " autor VARCHAR2(20),"
						+ "CONSTRAINT PK_CODIGO PRIMARY KEY (codigo))";
				break;
			case "SOCIOS":
				sentencia = "CREATE TABLE Socios (dni VARCHAR2(20),"
						+ "nombre VARCHAR2(20)," + "apellidos VARCHAR2(20),"
						+ "direccion VARCHAR2(20), telefono VARCHAR2(20),"
						+ "CONSTRAINT PK_DNI PRIMARY KEY (dni))";
				break;
			case "PRESTAMOS":
				sentencia = "CREATE TABLE Prestamos ("
						+ "codigo VARCHAR2(20) REFERENCES Libro (codigo), "
						+ "dni VARCHAR2(20) REFERENCES Socios (dni), "
						+ "fecha VARCHAR2(20), "
						+ "CONSTRAINT PK_PRIMARIA PRIMARY KEY (codigo, dni))";
				break;
			}

			stmt.executeUpdate(sentencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * METODO QUE INSERTA DATOS EN LA TABLA BIBLIOTECA
	 */
	public void insertarDatosBiblioteca(Biblioteca biblioteca) {
		try {
			String sentencia = "INSERT INTO Biblioteca VALUES(?, ?)";
			PreparedStatement pstmt = conexion.prepareStatement(sentencia);

			pstmt.setString(1, biblioteca.getNombre());
			pstmt.setString(2, biblioteca.getRutaIcono());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* METODO PARA CONSULTAR LOS DATOS DE LA BIBLIOTECA */
	public Biblioteca consultarDatosBiblioteca() {
		String nombre;
		String rutaIcono;
		try {
			stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			String sentencia = "SELECT nombre, path FROM Biblioteca";
			ResultSet resultado = stmt.executeQuery(sentencia);
			while (resultado.next()) {
				nombre = resultado.getString("nombre");
				rutaIcono = resultado.getString("path");
				biblioteca = new Biblioteca(nombre, rutaIcono);
			}
		} catch (SQLException ex) {
			muestraSQLException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return biblioteca;
	}

	/*
	 * METODO QUE INSERTA FILAS EN LA TABLA LIBRO
	 */
	public void insertarDatosLibro(Libro libro) {
		try {
			String sentencia = "INSERT INTO Libro VALUES(?, ?, ?)";
			PreparedStatement pstmt = conexion.prepareStatement(sentencia);

			pstmt.setString(1, libro.getCodigo());
			pstmt.setString(2, libro.getTitulo());
			pstmt.setString(3, libro.getAutor());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * METODO QUE BOORA FILAS EN UNA TABLA
	 */
	public void borrarDatosLibro(String cod) {

		try {
			String sentencia = "DELETE FROM Libro WHERE codigo='" + cod + "'";
			Statement stmt = conexion.createStatement();

			stmt.executeUpdate(sentencia);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*METODO QUE MODIFICA DATOS DE LA TABLA LIBROS*/
	public void modificarLibros () {
		try {
			String sentencia = "";
			Statement stmt = conexion.createStatement();

			stmt.executeUpdate(sentencia);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * METODO QUE REALIZA LA CONSULTA RECUPERANDO TODAS LAS FILAS DE LA TABLA
	 * Libro Y DEVUELVE LOS DATOS COMO UN String
	 * 
	 * Opcion 1 => libros exsitentes en la biblioteca
	 * Opcion 2 => todos los libros de la biblioteca
	 * Opcion 3 => los libros en prestamo
	 */
	
	public ArrayList<Libro> consultarDatosLibro(int opcion) {
		String codigo;
		String titulo;
		String autor;
		String sentencia = "";
		try {
			stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			if (opcion == 1) {
				sentencia = "SELECT codigo, titulo, autor FROM Libro "
						+ "WHERE codigo NOT IN (SELECT codigo FROM Prestamos)";	
			}
			else if (opcion == 2){
				sentencia = "SELECT codigo, titulo, autor FROM Libro";
			}
			else if (opcion == 3) {
				sentencia = "SELECT codigo, titulo, autor FROM Libro "
						+ "WHERE codigo IN (SELECT codigo FROM Prestamos)";	
			}
			
			ResultSet resultado = stmt.executeQuery(sentencia);
			while (resultado.next()) {
				codigo = resultado.getString("codigo");
				titulo = resultado.getString("titulo");
				autor = resultado.getString("autor");
				libro = new Libro(codigo, titulo, autor);
				libros.add(libro);
			}
		} catch (SQLException ex) {
			muestraSQLException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return libros;
	}

	/*
	 * METODO QUE INSERTA FILAS EN LA TABLA Socio
	 */
	public void insertarDatosSocio(Socio socio) {
		try {
			String sentencia = "INSERT INTO Socios VALUES(?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conexion.prepareStatement(sentencia);

			pstmt.setString(1, socio.getDni());
			pstmt.setString(2, socio.getNombre());
			pstmt.setString(3, socio.getApellidos());
			pstmt.setString(4, socio.getDireccion());
			pstmt.setString(5, socio.getTelefono());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * METODO QUE BORRA FILAS EN UNA TABLA
	 */
	public void borrarDatosSocio(String dni) {

		try {
			String sentencia = "DELETE FROM Socios WHERE dni='" + dni + "'";
			Statement stmt = conexion.createStatement();

			stmt.executeUpdate(sentencia);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*METODO QUE MODIFICA FILAS EN LA TABLA SOCIOS*/
	public void modificarSocio (String direccion, String telefono, String nombre) {
		try {
			String sentencia = "UPDATE SOCIOS SET direccion = ?, telefono = ?"
					+ " WHERE nombre = ?";

			PreparedStatement pstmt = conexion.prepareStatement(sentencia);

			pstmt.setString(1, direccion);
			pstmt.setString(2, telefono);
			pstmt.setString(3, nombre);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* METODO PARA CONSULTAR LOS DATOS DE LOS SOCIOS */
	public ArrayList<Socio> consultarDatosSocio(int opcion) {
		String dni;
		String nombre;
		String apellidos;
		String direccion;
		String telefono;
		String sentencia = "";
		try {
			stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			if (opcion == 1) {
				sentencia = "SELECT dni, nombre, apellidos, direccion, telefono FROM Socios "
						+ "WHERE dni NOT IN (SELECT dni FROM Prestamos)";	
			}
			else if (opcion == 2){
				sentencia = "SELECT dni, nombre, apellidos, direccion, telefono FROM Socios";
			}
			else {
				sentencia = "SELECT dni, nombre, apellidos, direccion, telefono FROM Socios "
						+ "WHERE dni IN (SELECT dni FROM Prestamos)";
			}
			
			ResultSet resultado = stmt.executeQuery(sentencia);
			while (resultado.next()) {
				dni = resultado.getString("dni");
				nombre = resultado.getString("nombre");
				apellidos = resultado.getString("apellidos");
				direccion = resultado.getString("direccion");
				telefono = resultado.getString ("telefono");
				socio = new Socio(dni, nombre, apellidos, direccion, telefono);
				socios.add(socio);
			}

		} catch (SQLException ex) {
			muestraSQLException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return socios;
	}

	/*
	 * METODO QUE INSERTA FILAS EN LA TABLA Prestamos
	 */
	public void insertarDatosPrestamos(String codigo, String dni, String fecha) {
		try {
			String sentencia = "INSERT INTO Prestamos VALUES(?, ?, ?)";

			PreparedStatement pstmt = conexion.prepareStatement(sentencia);

			pstmt.setString(1, codigo);
			pstmt.setString(2, dni);
			pstmt.setString(3, fecha);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* METODO PARA CONSULTAR LOS DATOS DE LOS Prestamos */
	public String consultarDatosPrestamos() {
		String cadena = "";
		try {
			stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			String sentencia = "SELECT codigo, dni, fecha FROM Prestamos";
			ResultSet resultado = stmt.executeQuery(sentencia);
			while (resultado.next()) {
				cadena += (resultado.getString("codigo") + " "
						+ resultado.getString("dni") + " "
						+ resultado.getString("fecha") + "\n");
			}
		} catch (SQLException ex) {
			muestraSQLException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cadena;
	}
	
	/*METODO QUE BORRA DATOS DE LA TABLA PRESTAMOS*/
	public void borrarDatosPrestamos (String dni) {
		try {
			stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			String sentencia = "DELETE FROM Prestamos"
					+ " WHERE dni = '" +dni+ "'";
			stmt.executeQuery(sentencia);
		} catch (SQLException ex) {
			muestraSQLException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * METODO QUE OBTIENE LOS DATOS DE LA TABLA LIBRO PARA MOSTRAR EN EL PANEL
	 * LISTAR Libros
	 */
	public Object[][] obtenerDatosTablaLibro() {
		int cont = 0;
		try {
			stmt = conexion.createStatement();
			String sentencia = "SELECT codigo, titulo, autor FROM Libro";
			ResultSet resultado = stmt.executeQuery(sentencia);
			// Sino ha obtenido resultado que no haga nada, asi no da error de
			// Juego de resultados agotado
			while (resultado.next()) {
				cont++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object[][] libros = new Object[cont][3];
		int i = 0;
		try {
			stmt = conexion.createStatement();
			String sentencia = "SELECT codigo, titulo, autor FROM Libro";
			ResultSet resultado = stmt.executeQuery(sentencia);
			// Sino ha obtenido resultado que no haga nada, as� no da error de
			// Juego de resultados agotado
			while (resultado.next()) {
				libros[i][0] = resultado.getString("codigo");
				libros[i][1] = resultado.getString("titulo");
				libros[i][2] = resultado.getString("autor");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

	/*
	 * METODO QUE OBTIENE LOS DATOS DE LA TABLA LIBRO PARA MOSTRAR EN EL PANEL
	 * LISTAR Socios
	 */
	public Object[][] obtenerDatosTablaSocios() {
		int cont = 0;
		try {
			stmt = conexion.createStatement();
			String sentencia = "SELECT dni, nombre, apellidos, direccion, telefono FROM Socios";
			ResultSet resultado = stmt.executeQuery(sentencia);
			// Sino no ha obtenido resultado que no haga nada, as� no da error de
			// Juego de resultados agotado
			while (resultado.next()) {
				cont++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object[][] socios = new Object[cont][5];
		int i = 0;
		try {
			stmt = conexion.createStatement();
			String sentencia = "SELECT dni, nombre, apellidos, direccion, telefono FROM Socios";
			ResultSet resultado = stmt.executeQuery(sentencia);
			// Sino ha obtenido resultado que no haga nada, as� no da error de
			// Juego de resultados agotado
			while (resultado.next()) {
				socios[i][0] = resultado.getString("dni");
				socios[i][1] = resultado.getString("nombre");
				socios[i][2] = resultado.getString("apellidos");
				socios[i][3] = resultado.getString("direccion");
				socios[i][4] = resultado.getString("telefono");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return socios;
	}

	/*
	 * METODO QUE OBTIENE LOS DATOS DE LIBROS, SOCIOS Y PRESTAMOS PARA MOSTRAR EN EL PANEL
	 * LISTAR Prestamos
	 */
	public Object[][] obtenerDatosPrestamos() {
		int cont = 0;
		try {
			stmt = conexion.createStatement();
			String sentencia = "SELECT dni FROM Prestamos";
			ResultSet resultado = stmt.executeQuery(sentencia);
			// Sino no ha obtenido resultado que no haga nada, as� no da error de
			// Juego de resultados agotado
			while (resultado.next()) {
				cont++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object[][] socios = new Object[cont][5];
		int i = 0;
		try {
			stmt = conexion.createStatement();
			String sentencia = "SELECT Socios.nombre, Libro.autor, Libro.titulo, Socios.dni, Prestamos.fecha"
					+ " FROM Socios, Prestamos, Libro "
					+ "WHERE Prestamos.dni = Socios.dni AND Prestamos.codigo = Libro.Codigo";
			ResultSet resultado = stmt.executeQuery(sentencia);
			// Sino ha obtenido resultado que no haga nada, as� no da error de
			// Juego de resultados agotado
			while (resultado.next()) {
				socios[i][0] = resultado.getString("titulo");
				socios[i][1] = resultado.getString("autor");
				socios[i][2] = resultado.getString("nombre");
				socios[i][3] = resultado.getString("dni");
				socios[i][4] = resultado.getString("fecha");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return socios;
	}
	
	/*
	 * METODO PARA CERRAR TODAS LAS V�AS DE ACCESO QUE HEMOS ABIERTO PARA LA
	 * BASE DE DATOS
	 */
	public void cerrar() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conexion != null) {
				conexion.close();
			}

		} catch (SQLException e) {
			muestraSQLException(e);
		}
	}

	/*
	 * METODO QUE DEVUELVE LA CONEXI�N DEL USUARIO A LA BASE DE DATOS
	 */
	public Connection getConexion() {
		return conexion;
	}

	/*
	 * METODO PARA DETECTAR OTRAS POSIBLES EXCEPCIONES
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
}
