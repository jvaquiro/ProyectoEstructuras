package app;

import interfaz.*;
import estructuras.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Trazabilidad {
	Stack<Bovinos> s = new Stack<>();
	Queue<Bovinos> q = new Queue<>();
	LinkedList<Bovinos> l = new LinkedList<>();

	// Metodos
	public void registrarBovinoLL(String[] datos) {
		Bovinos vaquita;
		vaquita = new Bovinos(datos[0], datos[1], datos[2], datos[3]);
		l.pushFront(new Node<Bovinos>(vaquita));
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

	public void guardarBovinoTXT() {
		Node<Bovinos> f = l.getHead();

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

	public void cargarBovinoTxT() {
		try {
			Scanner input = new Scanner(new File("test.txt"));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] part = line.split(" ");
				registrarBovinoLL(part);

			}
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void buscarBovino(String id) {
		Bovinos vaquita = new Bovinos(id, null, null, null);
		l.finds(vaquita);
	}
	

}
