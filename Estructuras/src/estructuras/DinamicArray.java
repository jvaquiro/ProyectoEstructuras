package estructuras;

public class DinamicArray<T> {

	T[] array;
	int capacity;
	int current;
	

	public DinamicArray() {
		array = (T[])new Object[2];
		capacity = 2;
		current = 0;

	}

	public void push(T data) {
		if (current == capacity) {
			T[] clon = (T[])new Object[2*capacity];
			for(int x = 0; x < capacity; x++) {
				clon[x] = array[x];
			}
			capacity = capacity*2;
			array = clon;
		}
		array[current] =  data;
		current ++;
	}
	public void pop() {
		array[current-1] =  null;
		current--;
	}

	public void print() {
		for(int i = 0; i<current;i++) {
			System.out.print(array[i]);
		}
	}
	public int sizeData() {
		return current;
	}

	public String iterar(int i) {
		return array[i].toString();
	}
	public void find(Node<T> bovino) {
		for(int i = 0; i<current;i++) {
			if (bovino.data.toString().equals(array[i].toString())) {
				System.out.println("Lo encontro en el indice " + i);
				break;
			}
		}
		System.out.println("no lo encontro");
	}

	public T getArray(int i) {
		return array[i];
	}

}
