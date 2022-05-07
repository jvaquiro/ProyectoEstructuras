package estructuras;

public class Queue<T> extends LinkedList<T>{
	public Queue(){

	}

	public void enqueue(Node<T> node) {
		pushBack(node);
	}

	public Node<T> dequeue(){
		Node<T> item = getHead();
		popFront();
		return item;
	}

}
