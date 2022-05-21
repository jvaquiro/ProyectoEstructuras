package estructuras;

public class BinaryNode<T> {

	public T data;
	public BinaryNode<T> left;
	public BinaryNode<T> right;
	int height;
	
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right ) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.height = 0;
	}
	
}
