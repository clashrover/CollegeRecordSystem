public class Node<K,T>{
	private K key = null;
	private T value = null;
	private Node<K,T> left =null;
	private Node<K,T> right = null;
	private Node<K,T> parent = null;
	public Node(K key,T value){
		this.key = key;
		this.value = value;
	}
	public void setParent(Node<K,T> n){
		this.parent = n;
	}
	public Node getParent(){
		return this.parent;
	}
	public void setRight(Node<K,T> r){
		this.right = r;
	}
	public Node getRight(){
		return right;
	}
	public void setLeft(Node<K,T> r){
		this.left = r;
	}
	public Node getLeft(){
		return left;
	}
	public K getKey(){
		return key;
	}
	public T getValue(){
		return value;
	}
	public void setValue(T obj){
		this.value = obj;
	}
	public void setKey(K key1){
		this.key = key1;
	}	
}
