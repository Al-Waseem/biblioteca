package vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class BarraMenu extends JMenuBar {

	// Atributos
	private JMenu[] menu;
	private String[] etiquetasMenu = { "Archivo", "Libro", "Socio", "Prestamos" };
	private JMenuItem[] itemMenu;
	private String[] etiquetasItemMenu = { "Login", "Crear Biblioteca",
			"Acerca De...", "Salir", "Añadir", "Borrar", "Modificar", "Listar", "Añadir",
			"Borrar", "Modificar", "Listar", "Prestar", "Devolver", "Listado" };

	// Contructor
	public BarraMenu() {

		// Creo el array de menu
		menu = new JMenu[etiquetasMenu.length];
		// Creo los men�s con sus etiquetas
		for (int i = 0; i < etiquetasMenu.length; i++) {
			menu[i] = new JMenu(etiquetasMenu[i]);
		}

		// Creo el array de las opciones del men�
		itemMenu = new JMenuItem[etiquetasItemMenu.length];
		// Creo los item de men�
		for (int i = 0; i < itemMenu.length; i++) {
			itemMenu[i] = new JMenuItem(etiquetasItemMenu[i]);
		}

		// Añado los item al menú
		for (int i = 0; i < menu.length; i++) {
			if (i == 0) {
				for (int j = 0; j < 4; j++) {
					menu[i].add(itemMenu[j]);
					if (j < 3) {
						menu[i].addSeparator();
					}
				}
			} else if (i == 1) {
				for (int j = 4; j < itemMenu.length; j++) {
					menu[i].add(itemMenu[j]);
					if (j < 7) {
						menu[i].addSeparator();
					}
				}
			} else if (i == 2) {
				for (int j = 8; j < itemMenu.length; j++) {
					menu[i].add(itemMenu[j]);
					if (j < 11) {
						menu[i].addSeparator();
					}
				}

			} else if (i == 3) {
				for (int j = 12; j < itemMenu.length; j++) {
					menu[i].add(itemMenu[j]);
					if (j < 14) {
						menu[i].addSeparator();
					}
				}
			}
		}

		// Añadir los menús a la barra de menús
		for (int i = 0; i < menu.length; i++) {
			this.add(menu[i]);
		}
		/*
		 * Llamada al m�todo que activa y desactiva las opciones de men�
		 * necesarias cuando comienza la aplicación.
		 */
		iniciarBarra();
	}

	/*
	 * Método para poner las opciones en la situación de inicio de la aplicación
	 */
	public void iniciarBarra() {
		if (itemMenu[1].isEnabled() == true) {
			itemMenu[1].setEnabled(false);
		}
		if (itemMenu[4].isEnabled() == true) {
			itemMenu[4].setEnabled(false);
		}
		if (itemMenu[5].isEnabled() == true) {
			itemMenu[5].setEnabled(false);
		}
		if (itemMenu[6].isEnabled() == true) {
			itemMenu[6].setEnabled(false);
		}
		if (itemMenu[7].isEnabled() == true) {
			itemMenu[7].setEnabled(false);
		}
		if (itemMenu[8].isEnabled() == true) {
			itemMenu[8].setEnabled(false);
		}
		if (itemMenu[9].isEnabled() == true) {
			itemMenu[9].setEnabled(false);
		}
		if (itemMenu[10].isEnabled() == true) {
			itemMenu[10].setEnabled(false);
		}
		if (itemMenu[11].isEnabled() == true) {
			itemMenu[11].setEnabled(false);
		}
		if (itemMenu[12].isEnabled() == true) {
			itemMenu[12].setEnabled(false);
		}
		if (itemMenu[13].isEnabled() == true) {
			itemMenu[13].setEnabled(false);
		}
		if (itemMenu[14].isEnabled() == true) {
			itemMenu[14].setEnabled(false);
		}
	}

	/*
	 * Habilita Añadir Biblioteca y desactiva las demás opciones
	 */
	public void segundaBarra() {
		if (itemMenu[0].isEnabled() == true) {
			itemMenu[0].setEnabled(false);
		}
		if (itemMenu[1].isEnabled() == false) {
			itemMenu[1].setEnabled(true);
		}
	}

	/*
	 * Habilita Añadir Libro y Añadir Socio. Desactiva las demás opciones,
	 * incluída crear Biblioteca
	 */
	public void terceraBarra() {
		if (itemMenu[0].isEnabled() == true) {
			itemMenu[0].setEnabled(false);
		}
		if (itemMenu[1].isEnabled() == true) {
			itemMenu[1].setEnabled(false);
		}
		if (itemMenu[4].isEnabled() == false) {
			itemMenu[4].setEnabled(true);
		}
		if (itemMenu[8].isEnabled() == false) {
			itemMenu[8].setEnabled(true);
		}
	}

	/*
	 * Habilita añadir, borrar y listar de Libro. Habilita añadir listar de
	 * Socios. Desactiva borrar y listar de socios
	 */
	public void terceraBarraBis() {
		if (itemMenu[4].isEnabled() == false) {
			itemMenu[4].setEnabled(true);
		}
		if (itemMenu[5].isEnabled() == false) {
			itemMenu[5].setEnabled(true);
		}
		if (itemMenu[6].isEnabled() == false) {
			itemMenu[6].setEnabled(true);
		}
		if (itemMenu[7].isEnabled() == false) {
			itemMenu[7].setEnabled(true);
		}		
		if (itemMenu[8].isEnabled() == false) {
			itemMenu[8].setEnabled(true);
		}
	}

	/*
	 * Habilita añadir, borrar y listar de Socios. Habilita añadir listar de
	 * Libros. Desactiva borrar y listar de Libros
	 */
	public void cuartaBarra() {
		if (itemMenu[4].isEnabled() == false) {
			itemMenu[4].setEnabled(true);
		}
		if (itemMenu[5].isEnabled() == true) {
			itemMenu[5].setEnabled(false);
		}
		if (itemMenu[6].isEnabled() == true) {
			itemMenu[6].setEnabled(false);
		}
		if (itemMenu[7].isEnabled() == true) {
			itemMenu[7].setEnabled(false);
		}
		if (itemMenu[8].isEnabled() == false) {
			itemMenu[8].setEnabled(true);
		}
		if (itemMenu[9].isEnabled() == false) {
			itemMenu[9].setEnabled(true);
		}
		if (itemMenu[10].isEnabled() == false) {
			itemMenu[10].setEnabled(true);
		}
		if (itemMenu[11].isEnabled() == false) {
			itemMenu[11].setEnabled(true);
		}
		if (itemMenu[12].isEnabled() == false) {
			itemMenu[12].setEnabled(true);
		}
	}

	/*
	 * Habilita todas las opciones de Socios y Libros Desactiva la opción crear
	 * Biblioteca
	 */
	public void quintaBarra() {
		if (itemMenu[4].isEnabled() == false) {
			itemMenu[4].setEnabled(true);
		}
		if (itemMenu[5].isEnabled() == false) {
			itemMenu[5].setEnabled(true);
		}
		if (itemMenu[6].isEnabled() == false) {
			itemMenu[6].setEnabled(true);
		}
		if (itemMenu[7].isEnabled() == false) {
			itemMenu[7].setEnabled(true);
		}
		if (itemMenu[8].isEnabled() == false) {
			itemMenu[8].setEnabled(true);
		}
		if (itemMenu[9].isEnabled() == false) {
			itemMenu[9].setEnabled(true);
		}
		if (itemMenu[10].isEnabled() == false) {
			itemMenu[10].setEnabled(true);
		}
		if (itemMenu[11].isEnabled() == false) {
			itemMenu[11].setEnabled(true);
		}
		if (itemMenu[12].isEnabled() == false) {
			itemMenu[12].setEnabled(true);
		}
	}
	
	public void sextaBarra() {
		if (itemMenu[0].isEnabled() == true) {
			itemMenu[0].setEnabled(false);
		}
		if (itemMenu[4].isEnabled() == false) {
			itemMenu[4].setEnabled(true);
		}
		if (itemMenu[8].isEnabled() == false) {
			itemMenu[8].setEnabled(true);
		}
		if (itemMenu[12].isEnabled() == false) {
			itemMenu[12].setEnabled(true);
		}
		if (itemMenu[13].isEnabled() == true) {
			itemMenu[13].setEnabled(false);
		}
		if (itemMenu[14].isEnabled() == true) {
			itemMenu[14].setEnabled(false);
		}
	}
	
	public void septimaBarra() {
		if (itemMenu[0].isEnabled() == true) {
			itemMenu[0].setEnabled(false);
		}
		if (itemMenu[4].isEnabled() == false) {
			itemMenu[4].setEnabled(true);
		}
		if (itemMenu[8].isEnabled() == false) {
			itemMenu[8].setEnabled(true);
		}
		if (itemMenu[13].isEnabled() == false) {
			itemMenu[13].setEnabled(true);
		}
		if (itemMenu[14].isEnabled() == false) {
			itemMenu[14].setEnabled(true);
		}
	}

	// Métodos get
	public JMenuItem[] getItemMenu() {
		return itemMenu;
	}
}
