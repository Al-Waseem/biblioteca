package modelo;

public class Biblioteca {

	// Atributos
	private String nombre;
	private String rutaIcono;
	
	public Biblioteca(String nombre, String rutaIcono) {
		this.nombre = nombre;
		this.rutaIcono = rutaIcono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRutaIcono() {
		return rutaIcono;
	}

	public void setRutaIcono(String rutaIcono) {
		this.rutaIcono = rutaIcono;
	}
}
