package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import estructuras.DinamicArray;

public class Login {
	
	
	public DinamicArray<Usuario> Usuarios = new DinamicArray<>();
	Scanner scan = new Scanner(System.in);
	
	public void registrarUsuarioTXT(String[] datos) {
		Usuario registro;
		registro = new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
		Usuarios.push(registro);
	}

	public String registrarUsuario(String[] datos) {
		Usuario registro;
		registro = new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
		Usuarios.push(registro);
		//Usuarios.print();
		guardarUsuariosTXT();
		return registro.getUsername();
	}
	
	public void guardarUsuariosTXT() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt"));
			bw.write("");
			bw.close();
			File archivo = new File("usuarios.txt");
			FileWriter escribir = new FileWriter(archivo, true);
			for (int i = 0; i < Usuarios.sizeData(); i++) {
				escribir.append(Usuarios.iterar(i));
				escribir.append("\n");
			}
			escribir.close();
		} catch (Exception e) {
			System.out.println("Error al escribir");

		}
		
	}
	
	public void cargarUsuariosTXT() {
		try {
			Scanner input = new Scanner(new File("usuarios.txt"));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] part = line.split(",");
				registrarUsuarioTXT(part);
			}
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean CorroborarCredenciales(String username, String password) {
		for(int i = 0; i < Usuarios.sizeData(); i++) {
			Usuario current_user;
			current_user = Usuarios.getArray(i);
			String current_username = current_user.getUsername();
			//System.out.println(current_username);
			String current_password = current_user.getPassword();
			//System.out.println(current_password);
			if (username.equals(current_username) && password.equals(current_password)) {
				return true;
			}			
		}
		return false;
		
	}
	
	public void LoginMenu() {
		cargarUsuariosTXT();
		boolean acceder = false;
		while (acceder != true) {
		System.out.println(" --- Ingreso al sistema  --- "
				+ "\nSeleccione la opcion que desea utilizar");
		System.out.println(" ");
		System.out.println("1. Registar un nuevo usuario");
		System.out.println("2. Ingresar al sistema");
		System.out.println("3. Salir del programa");
		int opcion;
		opcion = Integer.parseInt(scan.nextLine());
		if((opcion)== 1) {
			 String assigned_userame = registrarUsuario(agregarUsuario());
			 System.out.println("El usuario asignado es: "+ assigned_userame);
		}else if ((opcion)== 2){
			if (ingresar()) {
				acceder = true;
			}
		}else if ((opcion)== 3) {
			System.exit(0);
		}
		}
	}
	
	
	public boolean ingresar() {
		String etd_user = scan.nextLine();
		String etd_password = scan.nextLine();
		if (CorroborarCredenciales(etd_user, etd_password)) {
			System.out.println("Ingreso exitoso");
			return true;
		}else {
			System.out.println("Credenciales incorrectas");
			return false;
		}
	}

	public String[] agregarUsuario() {
		String[] datos = new String[6];
		System.out.println("Ingrese su nombre");
		datos[0] = scan.nextLine();
		System.out.println("Ingrese su apellido");
		datos[1] = scan.nextLine();
		System.out.println("Ingrese su contraseña");
		datos[2] = scan.nextLine();
		System.out.println("Ingrese su cedula");
		datos[3] = scan.nextLine();
		System.out.println("Ingrese su genero");
		datos[4] = scan.nextLine();
		System.out.println("Ingrese su fecha de nacimiento");
		datos[5] = scan.nextLine();

		return datos;

	}
	
	public void imprimirtodo() {
		Usuarios.print();
	}
}
