package estructuras;

import java.nio.BufferUnderflowException;

public class AVLTree<T extends Comparable<? super T>>{
//CONSTRUCTOR
	public BinaryNode<T> root;
	public static int balanced = 1;
	
	public AVLTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	//METHODS
	public void insert(T x) {
		root = insert(x, root);
	}

	public boolean contains(T x) {
		return contains(x, root);
	}

	public T findMin() {
		if (isEmpty())
			throw new BufferUnderflowException();
		return findMin(root).data;
	}

	private BinaryNode<T> findMin(BinaryNode<T> t) {
		if (t == null)
			return null;
		else if (t.left == null)
			return t;
		return findMin(t.left);

	}

	public void remove(T x) {
		root = remove(x, root);
	}
	
	private int height(BinaryNode<T> t) {
		if (t == null)
			return -1;
		else
			return 1 + Math.max(height(t.left), height(t.right));
	}

	//RECURSIVE METHODS

	private BinaryNode<T> insert(T x, BinaryNode<T> t) {
		if (t == null)
			return new BinaryNode<>(x, null, null);
		int compareResult = x.compareTo(t.data);
		if (compareResult < 0)
			t.left = insert(x, t.left);
		if (compareResult > 0)
			t.right = insert(x, t.right);
		return t;
	}

	private boolean contains(T x, BinaryNode<T> t) {
		if (t == null)
			return false;
		int compareResult = x.compareTo(t.data);
		if (compareResult < 0)
			return contains(x, t.left);
		else if (compareResult > 0)
			return contains(x, t.right);
		else
			return true;
		// Match
	}

	private BinaryNode<T> remove(T x, BinaryNode<T> t) {
		if (t == null)
			return t;
		// Item not found; do nothing
		int compareResult = x.compareTo(t.data);
		if (compareResult < 0)
			t.left = remove(x, t.left);
		else if (compareResult > 0)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) // Two children
		{
			t.data = findMin(t.right).data;
			t.right = remove(t.data, t.right);
		} else
			t = (t.left != null) ? t.left : t.right;
		return t;
	}
	
	//AVLMethods

    private BinaryNode<T> balance(BinaryNode<T> node){
        if(node==null){
            return node;
        }
        //Check left balance
        if( height( node.left ) - height( node.right ) > balanced){
            //Check ll or lr
            if(height( node.left.left ) >= height( node.left.right ) ){
                node=rotateLL(node);
            }else{
                node=rotateLR(node);
            }
        }else{
            //Check right balance
           if( height( node.right ) - height( node.left ) > balanced ){
                //Check rr o rl
               if ( height( node.right.right ) >= height( node.right.left ) ) {
                   node=rotateRR(node);
               } else {
                   node=rotateRL(node);
               }
           }
        }
        node.height = Math.max( height( node.left ), height( node.right ) ) + 1;
        return node;
    }
    
    //Rotation Left-Left
    private BinaryNode<T> rotateLL(BinaryNode<T> node){
        BinaryNode<T> aux = node.left;
        node.left = aux.right;
        aux.right = node;
        node.height = Math.max( height( node.left ), height( node.right ) ) + 1;
        aux.height=Math.max(height(aux.left), height(aux.right))+1;
        return aux;
    }
    
    //Rotation Left-Right
    private BinaryNode<T> rotateLR(BinaryNode<T> node){
        node.left=rotateRR(node.left);
        return rotateLL(node);
    }
    
    //Rotation Right-Right
    private BinaryNode<T> rotateRR(BinaryNode<T> node){
        BinaryNode<T> aux = node.right;
        node.right = aux.left;
        aux.left = node;
        node.height = Math.max( height( node.left ), height( node.right ) ) + 1;
        aux.height=Math.max(height(aux.left), height(aux.right))+1;
        return aux;
    }
   
    //Rotation Right-Left
    private BinaryNode<T> rotateRL(BinaryNode<T> node){
        node.right=rotateLL(node.right);
        return rotateRR(node);
    }


}
