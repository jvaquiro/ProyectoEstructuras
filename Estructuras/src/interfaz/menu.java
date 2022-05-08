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
			System.out.println(" --- Sistema de trazabilidad de ganado --- "
					+ "\nSeleccione la opcion que desea utilizar");
			System.out.println(" ");
			System.out.println("1. Agregar una Vaquita");
			System.out.println("2. Mostrar todas las Vaquitas");
			System.out.println("3. Vaquita Faenada :c");
			System.out.println("4. Buscar Vaquita");
			System.out.println("5. Cargar datos");
			System.out.println("6. Guardar Cambios y salir del programa");
			int input;
			input = s.nextInt();
			//try {
			if((input)== 1) {
				//t.registrarBovinoLL(agregar());
				//t.registrarBovinoQ(agregar());
				//t.registrarBovinoS(agregar());
				t.registrarBovinoD(agregar());


			}else if ((input)== 2){
				//t.l.print();
				//t.q.print();
				//t.s.print();
				t.d.print();

			}else if ((input)== 3) {
				//t.l.popBack();
				//t.q.dequeue();
				//t.s.pop();
				t.d.pop();
			}
			else if ((input)== 4) {
				busqueda();
			}
			else if ((input)== 5) {
				t.cargarBovinoTxT();
			}
			else if ((input)== 6) {
				//t.guardarBovinoTXT(1);
				//t.guardarBovinoTXT(2);
				t.guardarBovinoTXT(3);

				loop = true;


			}
			/*	}catch (Exception e) {
				System.out.println("error");
			}*/
		}
	}
	public static void busqueda() {
		System.out.println("Ingrese los datos de la Vaquita");
		System.out.println("Codigo");
		String code = s.next();
		System.out.println("Fecha de Nacimiento");
		String fecha = s.next();
		System.out.println("Raza");
		String raza = s.next();
		System.out.println("Sexo");
		String sexo = s.next();
		//t.BuscarBovinoLL(code,fecha,raza,sexo);
		t.BuscarBovinoD(code, fecha, raza, sexo);
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