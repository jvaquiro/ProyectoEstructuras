package app;

public class Bovinos {
	private String codigo;
	private String fechaNacimiento;
	private String raza;
	private String sexo;

	// constructor

	public Bovinos(String fechaNacimiento, String codigo, String raza, String sexo) {
		super();
		this.codigo = codigo;
		this.fechaNacimiento = fechaNacimiento;
		this.raza = raza;
		this.sexo = sexo;
	}

	// Metodos

	// Getter y setters
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		return codigo + " " + fechaNacimiento + " " + raza + " " + sexo + "\n";
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
