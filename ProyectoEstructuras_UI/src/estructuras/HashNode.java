package estructuras;

public class HashNode<K, V> {
	K key;
	V value;

	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public boolean equals(Object o) {
		HashNode<K,V> node=(HashNode)o;
		if (this.key.equals(node.key)) {
			return true;
		}
		return false;
	}
	
	public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
