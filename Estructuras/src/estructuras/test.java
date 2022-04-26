package estructuras;

public class test {

	public static void main(String[] args) {
		Stack<Integer> test = new Stack<>();
		test.push(new Node<Integer>(34));
		test.push(new Node<Integer>(4));
		test.push(new Node<Integer>(2));
		test.pop();
		test.push(new Node<Integer>(23));
		test.push(new Node<Integer>(16));
		test.push(new Node<Integer>(45));
		test.pop();
		test.pop();

		test.print();


	}

}
