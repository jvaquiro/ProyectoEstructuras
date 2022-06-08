package app;

public class Usuario implements Comparable<Usuario>{
	
	private String name;
	private String lastname;
	private String username;
	private String password;
	private String cedula;
	private String gender;
	private String birthday;
	
	public Usuario(String name, String lastname, String username, String password, String cedula, String gender,
			String birthday) {
		//super();
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.cedula = cedula;
		this.gender = gender;
		this.birthday = birthday;
	}

	public Usuario(String name, String lastname, String password, String cedula, String gender,
			String birthday) {
		super();
		this.name = name;
		this.lastname = lastname;
		int index = lastname.indexOf(" ");
		this.username = name.substring(0,1).toLowerCase() + lastname.substring(0,index).toLowerCase();
		this.password = password;
		this.cedula = cedula;
		this.gender = gender;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return name + "," + lastname + "," + username + "," + password
				+ "," + cedula + "," + gender + "," + birthday;
	}

	@Override
	public int compareTo(Usuario o) {
		return this.name.compareTo(o.username);
	}
	
}
