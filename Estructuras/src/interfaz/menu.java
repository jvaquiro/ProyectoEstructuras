package interfaz;
import app.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class menu {

	static Scanner s = new Scanner(System.in);
	static Trazabilidad t = new Trazabilidad();
	static Login lg = new Login();

	public static void main(String[] args) {
		lg.LoginMenu();
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
			System.out.println("3. Eliminar vaquita del sistema");
			System.out.println("4. Buscar Vaquita");
			System.out.println("5. Vaquitas listas para faenar :c");
			System.out.println("6. Cargar datos");
			System.out.println("7. Guardar Cambios y salir del programa");
			int input;
			input = s.nextInt();
			//try {
			if((input)== 1) {
				long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
				TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
				t.registrarBovinoLL(agregar());
				//t.registrarBovinoQ(agregar());
				//t.registrarBovinoS(agregar());
				//t.registrarBovinoD(agregar());
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia

				System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos


			}else if ((input)== 2){
				long TInicio, TFin, tiempo ; 
				TInicio = System.currentTimeMillis(); 


				t.l.print();

				//t.q.print();
				//t.s.print();
				//t.d.print();
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos

			}else if ((input)== 3) {
				long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
				TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio


				t.l.popBack();
				//t.q.dequeue();
				//t.s.pop();
				//t.d.pop();
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
			}
			else if ((input)== 4) {
				
				busqueda();
			//	System.out.println(TInicio);
			//	System.out.println(TFin);
			}
			else if ((input)== 5) {
				t.a.printPreorder();
				}
			else if((input)== 6) {
				long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
				TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
				t.cargarBovinoTxT();
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos

			}
			else if ((input)== 7) {
				long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
				TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio


				t.guardarBovinoTXT(1);
				t.guardarFaenados();
				//t.guardarBovinoTXT(2);
				//				t.guardarBovinoTXT(3);
				//t.guardarBovinoTXT_D();
				TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
				tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos

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
		System.out.println(t.BuscarBovinoLL(code,fecha,raza,sexo));
		long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
		TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
		if (t.BuscarBovinoLL(code,fecha,raza,sexo)==-1) {
			t.BuscarBovinoFaenado(code);			
		}else {
			
			System.out.println((t.BuscarBovinoLL(code,fecha,raza,sexo)!=-1)?"En trazabilidad":"El registro No existe"); 
		}
		TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
		tiempo = (TFin - TInicio); //Calculamos los milisegundos de diferencia
		System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
		//	t.BuscarBovinoD(code, fecha, raza, sexo);

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