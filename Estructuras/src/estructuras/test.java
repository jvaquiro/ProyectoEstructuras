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
		Bovinos p = new Bovinos("null", "null", "null", "null");
		
		l.pushFront(new Node<Integer>(25));
		l.pushFront(new Node<Integer>(35));
		l.pushFront(new Node<Integer>(45));
		l.pushFront(new Node<Integer>(55));
		l.pushFront(new Node<Integer>(65));
		d.push(v);
		d.push(t);
		d.push(p);
		d.pop();
		//l.finds(65); 
		d.print();
		
		



	}

}
