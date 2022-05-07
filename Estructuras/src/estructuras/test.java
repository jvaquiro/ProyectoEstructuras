package estructuras;
import app.Bovinos;
public class test {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Queue<Integer> q = new Queue<>();
		LinkedList<Bovinos> l = new LinkedList<>();
		DinamicArray<Bovinos> d = new DinamicArray<>();
		Bovinos v = new Bovinos("3242", "sfsdfs", "null", "null");
		Bovinos t = new Bovinos("null", "null", "null", "null");
		Bovinos p = new Bovinos("nu5l", "null", "null", "null");
		//Bovinos p1 = new Bovinos("3242", "sfsdfs", "null", "null");
		
		l.pushFront(new Node (t));
		l.pushFront(new Node (p));
		l.pushFront(new Node (v));
		//l.pushFront(new Node<Integer>(55));
		//l.pushFront(new Node<Integer>(65));
		/*d.push(v);
		d.push(t);
		
		d.push(p);
		d.pop();
		*/
		
		Bovinos p1 = new Bovinos("null", "null", "null", "null");
		System.out.println(l.finds(new Node (p1))); 
		//d.print();
		
		



	}

}
