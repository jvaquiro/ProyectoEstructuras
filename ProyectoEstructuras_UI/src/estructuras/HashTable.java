package estructuras;

public class HashTable<K, V> {
	LinkedList<K>[] array;
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
			array[i] = (LinkedList<K>) new LinkedList<HashNode<K, V>>();
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
	
	public int hashFunction(K x) {
		int value = x.hashCode();
		value = value % array.length;
		if(value < 0) {
			value = value + array.length;
		}
		return value;
	}
	
	private void rehash() {
        LinkedList<HashNode<K,V>>[] aux = (LinkedList<HashNode<K, V>>[]) array;
        array = new LinkedList[nextPrime(2 * array.length)];
        for (int i = 0; i < array.length; i++) {
            array[i] = (LinkedList<K>) new LinkedList<HashNode<K,V>>();
        }
        for (LinkedList<HashNode<K,V>> e : aux) {
            if (e.getHead() != null) {
                Node<HashNode<K,V>> iterator = e.getHead();
                insert((K) iterator.getData().getKey(), (V) iterator.getData().getValue());
                while (iterator.getNext() != null) {
                    iterator = iterator.getNext();
                    insert((K) iterator.getData().getKey(), (V) iterator.getData().getValue());
                }
            }
        }
    }
	
	public void insert(K key, V value) {
		LinkedList<HashNode<K, V>> r = (LinkedList<HashNode<K, V>>) array[hashFunction(key)];
		r.pushBack(new Node<HashNode<K,V>>(new HashNode<K, V>(key, value)));
		if (++size < (array.length * 5)) {
			rehash();
		}
	}
	
	
	public boolean find(K key) {
        V value = null;
        return array[hashFunction(key)].find((K) new HashNode<K,V>(key, value));
    }
	
	public void remove(K key){
        LinkedList<HashNode<K, V>> aux= (LinkedList<HashNode<K, V>>) array[hashFunction(key)];
        aux.delete((HashNode<K, V>) key);
        size--;
    }
}
