public class Position<K,T>{
	private K key;
	private T obj;
	public Position(){
		key=null;
		obj=null;
	}
	public Position(K key , T obj){
		this.key = key;
		this.obj = obj;
	}
	public K getKey(){
		return key;
	}
	public T getObj(){
		return obj;
	}
}
