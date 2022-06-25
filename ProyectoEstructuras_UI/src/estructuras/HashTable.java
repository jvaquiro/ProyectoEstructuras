package estructuras;

public class HashTable<T> {
	LinkedList<T>[] array;
	int size;
	static final int default_capacity = 100;

	//CONSTRUCTOR

	public HashTable() {
		this(default_capacity);
	}

	public HashTable(int size) {
		// TODO Auto-generated constructor stub
		array = new LinkedList[nextPrime(size)];
		for (int i = 0; i < array.length; i++) {
			array[i] = new LinkedList<T>();
		}
	}

	//METHODS

	public boolean isPrime(int n) {
		int i = 2;
		if (n <=1 ) {
			return false;
		}

		while (i <= Math.sqrt(n)) {
			if (n % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}

	public int nextPrime(int n) {
		if (n % 2 == 0) {
			n = n + 1;
		}
		while (!isPrime(n)) {
			n = n + 2;
		}
		return n;
	}

	public int hashFunction(T x) {
		int value = x.hashCode();
		value = value % array.length;
		if(value < 0) {
			value = value + array.length;
		}
		return value;
	}

	private void rehash() {
		LinkedList<T>[] aux = array;
		array = new LinkedList[nextPrime(2 * array.length)];
		for (int i = 0; i < array.length; i++) {
		}
		for (LinkedList<T> e : aux) {
			if (e.getHead() != null) {
				Node<T> iterator = e.getHead();
				insert(iterator.getData());
				while (iterator.getNext() != null) {
					iterator = iterator.getNext();
					insert(iterator.getData());
				}
			}
		}
	}

	public void insert(T x) {
		LinkedList<T> r = array[hashFunction(x)];
		if(!r.find(x)) {
			r.pushBack(new Node<T>(x));
			if (++size > (array.length * 5)) 
				rehash();
		}
	}


	public boolean find(T x) {
		return array[hashFunction(x)].find(x);
	}

	public void delete(T x){
		LinkedList<T> aux =  array[hashFunction(x)];
		aux.delete(x);
		size--;
	}
}
