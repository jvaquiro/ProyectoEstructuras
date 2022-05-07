package estructuras;

public class LinkedList<T> {
	private Node<T> head, tail;
	
	//Constructors
	
	public LinkedList() {
		this.head = this.tail = null;
		
	}
	public LinkedList(Node<T> head) {
		this.head = this.tail = head;
	}
	
	//Getters
	
	public Node<T> getHead() {
		return head;
	}
	
	public Node<T> getTail() {
		return tail;
	}
	
	//Methods
	
	public boolean check() {
		//Check if the list is empty
		if (head == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void pushFront(Node<T> newNode) {
		//if is empty create a new node
		if (check()) {
			this.head = this.tail = newNode;
		//if is not empty next node will be the head
		}else {
			newNode.next = this.head;
			this.head = newNode;
		}
	}
	
	public void popFront() {
		//if is empty print List is empty
		if(check()){
			System.out.println("List is empty");
		}else {
		//if is not empty head will point to next node
			this.head = this.head.next;
		}
	}
	
	public void pushBack(Node<T> newNode) {
		//if is empty print List is empty
		if(check()){
			this.head = this.tail = newNode;
		}else {
		//if is not empty head will point to next node
			this.tail.next = newNode;
			this.tail = newNode;
		}	
	}
	
	public void popBack(){
		if (check()){
            System.out.println("List is empty");
        }else {
            Node<T> last = head;
            while (last.next.next != null) {
                last = last.next;
            }
            last.next = null;
            tail = last;
        }
	}
	
    public void print() {
        if (this.head != null) {
            Node<T> iterator = head;
            while (iterator.next != null) {
                System.out.print(iterator.data + " ");
                iterator = iterator.next;
            }
            System.out.println(iterator.data);
        } else {
            System.out.println();
        }
    }
    
    public T finds( Node node) {
    	if (check()) {
    		System.out.println("null chec");
			return null;
		}else {
			Node<T> temp ;
			temp=head;
			while (temp!=null) {
				if (temp.data == node.data) {
					System.out.println(temp.data + "la encontro");
					return temp.data;
				}
				temp = temp.next;
			}			
			return null ;
		}
    	
    }
	

}
