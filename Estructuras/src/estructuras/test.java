package estructuras;
import app.Bovinos;
public class test {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Queue<Integer> q = new Queue<>();
		LinkedList<Integer> l = new LinkedList<>();
		DinamicArray<Bovinos> d = new DinamicArray<>();
		Bovinos v = new Bovinos("3242", "sfsdfs", "null", "null");
		Bovinos t = new Bovinos("null", "null", "null", "null");
		Bovinos p = new Bovinos("nu5l", "null", "null", "null");

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
		d.push(v);
		d.push(t);
		d.push(p);
		//d.print();
		
		for (int i = 0; i < d.sizeData(); i++) {
			System.out.print(d.iterar(i));
			
		}







	}

}
