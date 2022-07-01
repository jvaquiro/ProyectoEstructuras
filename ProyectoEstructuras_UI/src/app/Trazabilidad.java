package app;

import interfaz.*;
import estructuras.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Trazabilidad {
	public Stack<Bovinos> s = new Stack<>();
	public Queue<Bovinos> q = new Queue<>();
	public LinkedList<Bovinos> l = new LinkedList<>();
	public DinamicArray<Bovinos> d = new DinamicArray<>();
	public AVLTree<Bovinos> a = new AVLTree<>();
	public HashTable<Bovinos> ht = new HashTable<>();
	public Map<String, Bovinos> map = new Map<>();
	
	

	// Metodos
	/*public void registrarBovinoLL(String[] datos) {
		Bovinos vaquita;
		vaquita = new Bovinos(datos[0], datos[1], datos[2], datos[3]);
		l.pushFront(new Node<Bovinos>(vaquita));
	}*/

	public void registrarBovinoLL(String[] datos) {
		Bovinos vaquita;
		clasificar(vaquita = new Bovinos(datos[0], datos[1], datos[2], datos[3]));
	}
	public void registrarBovinoQ(String[] datos) {
		Bovinos vaquita;
		vaquita = new Bovinos(datos[0], datos[1], datos[2], datos[3]);
		q.enqueue(new Node<Bovinos>(vaquita));
	}

	public void registrarBovinoS(String[] datos) {
		Bovinos vaquita;
		vaquita = new Bovinos(datos[0], datos[1], datos[2], datos[3]);
		s.push(new Node<Bovinos>(vaquita));
	}

	public void registrarBovinoD(String[] datos) {
		Bovinos vaquita;
		vaquita = new Bovinos(datos[0], datos[1], datos[2], datos[3]);
		d.push(vaquita);
	}
	
	public void registrarBovinoHT(String[] datos) {
		Bovinos vaquita;
		vaquita = new Bovinos(datos[0], datos[1], datos[2], datos[3]);
		ht.insert(vaquita);
	}
	
	public void registrarBovinoMap(String[] datos) {
		Bovinos vaquita;
		vaquita = new Bovinos(datos[0], datos[1], datos[2], datos[3]);
		String codigo = datos[0];
		map.add(codigo, vaquita);
	}


	public void guardarBovinoTXT(int t) {
		Node<Bovinos> f ;
		if(t==1) {
			f = l.getHead();

		}else if(t==2){
			f = q.getHead();
		}
		else {
			
			f = s.getHead();
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
			bw.write("");
			bw.close();
			File archivo = new File("test.txt");
			FileWriter escribir = new FileWriter(archivo, true);
			while (f != null) {
				escribir.write(f.data.toString());
				f = f.next;
			}
			escribir.close();
		} catch (Exception e) {
			System.out.println("Error al escribir");

		}
	}
	
	public void guardarBovinoTXT_D() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
			bw.write("");
			bw.close();
			File archivo = new File("test.txt");
			FileWriter escribir = new FileWriter(archivo, true);
			for (int i = 0; i < d.sizeData(); i++) {
				escribir.write(d.iterar(i));
			}
			escribir.close();
		} catch (Exception e) {
			System.out.println("Error al escribir");

		}
		
	}
	
	public void guardarFaenados() {
		a.guardarPreorder();
		
	}

	public void cargarBovinoTxT() {
		try {
			Scanner input = new Scanner(new File("Bovinos_10k.txt"));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] part = line.split(" ");
				//registrarBovinoLL(part);
				//registrarBovinoQ(part);
				//registrarBovinoS(part);
				//registrarBovinoD(part);
				//registrarBovinoHT(part);
				registrarBovinoMap(part);
				//d.print();

			}
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int BuscarBovinoLL(String code, String fecha, String raza, String sexo) {
		Bovinos p1 = new Bovinos(code,fecha,raza,sexo);
 //		System.out.println(l.finds(new Node (p1))); 
		return l.finds(new Node (p1));
	}
	public String BuscarBovinoFaenado(String code ) {
		Bovinos p1 = new Bovinos(code,null,null,null);
		return (a.find(p1)==true)?"En faenacion :c":"El registro No existe";
//		System.out.println((a.find(p1)==true)?"En faenacion :c":"El registro No existe"); 
	}
	public void BuscarBovinoD(String code, String fecha, String raza, String sexo) {
		Bovinos p1 = new Bovinos(code,fecha,raza,sexo);
		d.find(new Node (p1));
	}
	
	public void BuscarBovinoHT(String code, String fecha, String raza, String sexo) {
		Bovinos p1 = new Bovinos(code,fecha,raza,sexo);
		ht.find(p1);
	}
	public void BuscarBovinoMap(String code) {
		System.out.println(map.get(code));
	}
	
	public void print() {
		a.printPreorder();
	}
	
	public void clasificar(Bovinos o) {
		
		String fechaDeNacimiento = o.getFechaNacimiento();
		String fechaActual = "2022-05-28";
			
		LocalDate nacimiento = LocalDate.parse(fechaDeNacimiento);
		LocalDate actual = LocalDate.parse(fechaActual);
		long edad = ChronoUnit.DAYS.between(nacimiento, actual);
		if(edad>1000) {
			Faenar(o);
		}else { 
			l.pushFront(new Node<Bovinos>(o));
		}	
	}
	public void Faenar(Bovinos o) {
		a.insert(o);

	}


}
