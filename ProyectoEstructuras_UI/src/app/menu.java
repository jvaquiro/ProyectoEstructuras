package app;
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
			System.out.println(String.format( "***Sistema de trazabilidad de ganado***"
					+ "\nSeleccione la opcion que desea utilizar"));
			System.out.println("1. Agregar una Vaquita");
			System.out.println("2. Mostrar todas las Vaquitas");
			System.out.println("3. Vaquita Faenada :c");
			System.out.println("4. Cargar datos");
			System.out.println("5. Guardar Cambios y salir del programa");
			System.out.println("6. Buscar Vaquita");
			System.out.println("7. Eliminar Vaquita");
			int input;
			input = s.nextInt();
			try {
				if((input)== 1) {
					long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
					TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
					//t.registrarBovinoLL(agregar());
					//t.registrarBovinoQ(agregar());
					//t.registrarBovinoS(agregar());
					//t.registrarBovinoD(agregar());
					//t.registrarBovinoHT(agregar());
					t.registrarBovinoMap(agregar());
					TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
					tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia

					System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos


				}else if ((input)== 2){
					long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
					TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
					t.l.print();
					//t.q.print();
					//t.s.print();
					//t.d.print();
					System.out.println(String.format( " " ));
					TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
					tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia

					System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundo

				}else if ((input)== 3) {
					long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
					TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
					t.l.popBack();
					//t.q.dequeue();
					//t.s.pop();
					//t.d.pop();
					TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
					tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia

					System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundo

				}
				else if ((input)== 4) {
					long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
					TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
					t.cargarBovinoTxT();	
					System.out.println(t.map.size());
					TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
					tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia

					System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundo

				}
				else if ((input)== 5) {
					t.guardarBovinoTXT(1);
					//t.guardarBovinoTXT(2);
					//t.guardarBovinoTXT(3);
					loop = true;

				}
				else if ((input)== 6) {

					System.out.println("Ingrese el codigo del animal");
					String code = s.next();
					long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
					TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
					/*System.out.println("Ingrese el fecha de nacimiento del animal");
					String fecha = s.next();
					System.out.println("Ingrese la raza del animal");
					String raza = s.next();
					System.out.println("Ingrese el sexo del animal");
					String sexo = s.next();*/
					//t.BuscarBovinoLL(code,fecha,raza,sexo);
					//t.BuscarBovinoD(code, fecha, raza, sexo);
					//t.BuscarBovinoHT(code, fecha, raza, sexo);
					//t.BuscarBovinoFaenado(code);
					t.BuscarBovinoMap(code);
					TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
					tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia

					System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundo



				}else if ((input)== 7) {
					System.out.println("Ingrese el codigo del animal");
					String code = s.next();
					long TInicio, TFin, tiempo ; //Variables para determinar el tiempo de ejecución
					TInicio = System.currentTimeMillis();//Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
					t.EliminarVaquitaMap(code);
					TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
					tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia

					System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundo

					
				}
			}catch (Exception e) {
				System.out.println("error");
			}
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
