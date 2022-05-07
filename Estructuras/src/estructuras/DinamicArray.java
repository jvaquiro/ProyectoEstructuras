package estructuras;

public class DinamicArray<T> {

	Object array[];
	int capacity;
	int current;

	public DinamicArray() {
		array = new Object[2];
		capacity = 2;
		current = 0;

	}

	public void push(T data) {
		if (current == capacity) {
			Object[] clon = new Object[2*capacity];
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

	public void find(Node<T> bovino) {
		for(int i = 0; i<current;i++) {
			if (bovino.data.toString().equals(array[i].toString())) {
				System.out.println("Lo encontro en el indice " + i);
				break;
			}
		}
	}

}
