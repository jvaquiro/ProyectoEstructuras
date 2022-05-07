package interfaz;
import app.*;
import java.util.Scanner;

public class menu {

	static Scanner s = new Scanner(System.in);
	static Trazabilidad t = new Trazabilidad();

	public static void main(String[] args) {
		menuPrincipal();


	}

	public static void menuPrincipal () {
		boolean loop = false;

		while (loop != true) {
			System.out.println("1. para agregar Vaquitas");
			System.out.println("2. para mostrar Vaquitas");
			System.out.println("3. para eliminar vaquitas");
			System.out.println("4. Guardar Cambios y salir del programa");
			int input;
			input = s.nextInt();
			//try {
			if((input)== 1) {
				t.registrarBovinoLL(agregar());
				//loop = true;

			}else if ((input)== 2){


			}else if ((input)== 3) {

			}
			else if ((input)== 4) {
				//t.guardarBovinoTXT();
				loop = true;

			}
			/*}catch (Exception e) {
				System.out.println("error");
			}*/
		}
	}

	public static String[] agregar() {
		String[] datos = new String[4];
		System.out.println("Ingrese el codigo del animal");
		datos[0] = s.next();
		System.out.println("Ingrese el fecha de nacimiento del animal");
		datos[1] = s.next();
		System.out.println("Ingrese la raza del animal");
		datos[2] = s.next();
		System.out.println("Ingrese el sexo del animal");
		datos[3] = s.next();

		return datos;
	}

}
