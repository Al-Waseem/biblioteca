package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class CuadroLogin extends JDialog {
	//Atributos
	private static final long serialVersionUID = 7214897498103866045L;
	private JTextField campoUsuario;
	private JPasswordField campoClave;
	private JLabel etiquetaUsuario;
	private JButton botonConectar;
	/*
	 * M�todo constructor de un cuadro de di�logo de tipo modal
	 * con medidas fijas.
	 */
	public CuadroLogin() {
		//Caracter�sticas generales del cuadro de di�logo
		setTitle("Login");
		this.setSize(200, 150);
		setResizable(false);
		//setModal(true);//El cuadro de di�logo es modal
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 0, 0, 0, 30};
		gridBagLayout.rowHeights = new int[] {30, 0, 0, 0, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		//A�adir la etiqueta para el campo usuario.
		etiquetaUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 1;
		getContentPane().add(etiquetaUsuario, gbc_lblUsuario);
		//A�adir el campo usuario.
		campoUsuario = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridwidth = 2;
		gbc_textField.anchor = GridBagConstraints.NORTHEAST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		getContentPane().add(campoUsuario, gbc_textField);
		campoUsuario.setColumns(10);
		//A�adir la etiqueta para el campo clave
		JLabel lblClave = new JLabel("Clave:");
		GridBagConstraints gbc_lblClave = new GridBagConstraints();
		gbc_lblClave.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblClave.insets = new Insets(0, 0, 5, 5);
		gbc_lblClave.gridx = 1;
		gbc_lblClave.gridy = 2;
		getContentPane().add(lblClave, gbc_lblClave);
		//A�adir el campo clave
		campoClave = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		getContentPane().add(campoClave, gbc_passwordField);
		//M�todo para a�adir el bot�n para realizar la conexi�n.
		botonConectar = new JButton("Conectar");
		GridBagConstraints gbc_btnConectar = new GridBagConstraints();
		gbc_btnConectar.gridwidth = 3;
		gbc_btnConectar.gridx = 1;
		gbc_btnConectar.gridy = 3;
		getContentPane().add(botonConectar, gbc_btnConectar);
	}
	//M�todo que devuelve el contenido del campo usuario.
	public String getCampoUsuario() {
		return campoUsuario.getText();
	}
	//M�todo que devuelve el contenido del campo clave como un String
	public String getCampoClave() {
		String clave = new String(campoClave.getPassword());
		return clave;
	}
	
	//M�todo para devolver el bot�n conectar
	public JButton getBotonConectar() {
		return botonConectar;
	}
	/*
	 * M�todo que limpia el contenido de los campos usuario y clave y pone
	 * el cursor en el campo usuario.
	 */
	public void iniciarLogin(){
		campoUsuario.setText("");
		campoClave.setText("");
		campoUsuario.requestFocus();
	}

}
