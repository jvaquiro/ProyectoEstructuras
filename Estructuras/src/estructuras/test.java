package estructuras;
import app.Bovinos;
public class test {
	
	

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Queue<Integer> q = new Queue<>();
		LinkedList<Integer> l = new LinkedList<>();
		DinamicArray<Bovinos> d = new DinamicArray<>();
		AVLTree<Bovinos> a = new AVLTree<>();
		Bovinos v = new Bovinos("3242", "sfsdfs", "null", "null");
		Bovinos t = new Bovinos("23434", "null", "null", "null");
		Bovinos p = new Bovinos("34324", "null", "null", "null");

		/*l.pushFront(new Node (t));
		l.pushFront(new Node (p));
		l.pushFront(new Node (v));*/
	/*	l.pushBack(new Node<Integer>(55));
		l.pushBack(new Node<Integer>(65));
		l.pushBack(new Node<Integer>(45));
		l.pushBack(new Node<Integer>(10));
		l.pushBack(new Node<Integer>(205));
		l.pushBack(new Node<Integer>(305));
		l.pushBack(new Node<Integer>(5));*/
		a.insert(v);
		a.insert(t);
		a.insert(p);
		//d.print();
		/*a.insert(10);
		a.insert(7);
		a.insert(6);
		a.insert(5);
		a.insert(4);
		a.insert(8);
		a.insert(9);*/


		
		

	}

}
