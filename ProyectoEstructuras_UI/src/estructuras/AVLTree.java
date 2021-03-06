package estructuras;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.BufferUnderflowException;

public class AVLTree<T extends Comparable<? super T>>{
//CONSTRUCTOR
	public BinaryNode<T> root;
	public BinaryNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}
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

	public boolean find(T x) {
		return find(x, root);
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
		return balance(t);
	}

	private boolean find(T x, BinaryNode<T> t) {
		if (t == null)
			return false;
		int compareResult = x.compareTo(t.data);
		if (compareResult < 0)
			return find(x, t.left);
		else if (compareResult > 0)
			return find(x, t.right);
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
		return balance(t);
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

    //Preorder
    public void printPreorder() {
    	printPreorder(root);
    }
    
    public void printPreorder(BinaryNode<T> node) {
    	if(node != null) {
    	System.out.print(node.data);
		printPreorder(node.left);
		printPreorder(node.right);
    	}
	}
//guardar    
    public void guardarPreorder() {
    	guardarPreorder(root);
    }
    public void guardarPreorder(BinaryNode<T> node) {
    	if(node != null) {
    		File archivo;
    		FileWriter escribir;
    		PrintWriter linea;
    		archivo =new File("test.txt");
    		
    		
    		if (!archivo.exists()) {
    			try {
    				archivo.createNewFile();
    				escribir=new FileWriter(archivo,true);
    				linea=new PrintWriter(escribir);
    				//escribims archiv
    				linea.print(node.data);
    				linea.close();
    				escribir.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    		}else {
    			try {
    				escribir=new FileWriter(archivo,true);
    				linea=new PrintWriter(escribir);
    				//escribims archiv
    				linea.print(node.data);
    				linea.close();
    				escribir.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    		}
//    		System.out.print(node.data);
    		guardarPreorder(node.left);
    		guardarPreorder(node.right);
    	}
    
    
    }
    

}
