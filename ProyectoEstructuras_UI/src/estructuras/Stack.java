package estructuras;

public class Stack<T> extends LinkedList<T>{
	public Stack() {

	}

	public void push(Node<T> node) {
		pushFront(node);
	}

	public Node<T> pop(){
		Node<T> item = getHead();
		popFront();
		return item;
	}

	public Node<T> peek(){
		Node<T> node=getHead();
		return node;
	}


}
