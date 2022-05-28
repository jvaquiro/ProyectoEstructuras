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
				  long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecuci�n
				  TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
				//t.registrarBovinoLL(agregar());
				//t.registrarBovinoQ(agregar());
				//t.registrarBovinoS(agregar());
				t.registrarBovinoD(agregar());
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				
				System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecuci�n en milisegundos


			}else if ((input)== 2){
				  long TInicio, TFin, tiempo ; 
				  TInicio = System.currentTimeMillis(); 
				 

				//t.l.print();
				//t.q.print();
				//t.s.print();
				t.d.print();
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecuci�n en milisegundos

			}else if ((input)== 3) {
				  long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecuci�n
				  TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
				 

				t.l.popBack();
				//t.q.dequeue();
				//t.s.pop();
				//t.d.pop();
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecuci�n en milisegundos
			}
			else if ((input)== 4) {
				  long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecuci�n
				  TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
				busqueda();
				
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
				tiempo = (TFin - TInicio); //Calculamos los milisegundos de diferencia
				System.out.println(TInicio);
				System.out.println(TFin);
				System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecuci�n en milisegundos
			}
			else if ((input)== 5) {
				  long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecuci�n
				  TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
				t.cargarBovinoTxT();
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecuci�n en milisegundos
			}
			else if ((input)== 6) {
				  long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecuci�n
				  TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
				 

				t.guardarBovinoTXT(1);
				//t.guardarBovinoTXT(2);
//				t.guardarBovinoTXT(3);
				//t.guardarBovinoTXT_D();
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecuci�n en milisegundos

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
		t.BuscarBovinoLL(code,fecha,raza,sexo);
		//t.BuscarBovinoD(code, fecha, raza, sexo);
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