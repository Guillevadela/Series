package model.pojo;

public class Serie {

	private int id;
	private String nombre;

	public Serie() {
		super();
		this.id = 0;
		this.nombre = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", nombre=" + nombre + "]";
	}

}
