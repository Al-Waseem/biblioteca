package app;

import javax.swing.JFrame;


import vista.Ventana;
import controlador.Controlador;

public class Aplicacion {

	// Atributos
	private Controlador controlador;
	private Ventana ventana;

	// Constructor
	Aplicacion () {
		controlador = new Controlador();
		
		ventana = controlador.getVentana();
		ventana.setSize(750, 550);
		windows.Window.centrar(ventana);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true); // Siempre en �ltimo lugar!!
	}
	
	// Crear la aplicaci�n
	public static void main(String[] args) {
		// Crear el objeto aplicacion
		new Aplicacion();
	}
}
