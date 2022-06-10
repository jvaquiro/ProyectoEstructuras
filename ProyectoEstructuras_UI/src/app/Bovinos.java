package app;

public class Bovinos implements Comparable<Bovinos>{
	private String codigo;
	private String fechaNacimiento;
	private String raza;
	private String sexo;

	// constructor

	public Bovinos ( String codigo, String fechaNacimiento, String raza, String sexo) {
		//super();
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

	public String codigo () {
		return codigo;
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

	@Override
	public int compareTo(Bovinos o) {
		if (Integer.parseInt(this.codigo)>Integer.parseInt(o.codigo)) {
			return 1;
		}else if (Integer.parseInt(this.codigo)<Integer.parseInt(o.codigo)) {
			return -1;
		}else {
			return 0;
		}
	}

}
