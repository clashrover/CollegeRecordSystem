import java.lang.Math;
//class NotFoundException extends Exception {} 
public class seperateChain<K extends Comparable<K>,T> implements MyHashTable_<K,T> {
   	// Insert new object with given key 
   	BST<K,T>[] array;
   	int size=0;
   	public seperateChain(int size_given){
   		this.size = size_given;
   		array = new BST[size];
   		for(int i=0;i<size;i++){
   			array[i]=null;
   		}
   	}
   
   	public int insert(K key, T obj){
   		String y=key.toString();
   		int index = (int)djb2(y,size);
   		//System.out.println(size);
   		if(array[index]==null){
   			array[index] = new BST<K,T>(key,obj);
   			return 1;
   		}
   		Node<K,T> p = new Node<K,T>(key,obj);
   		int x = array[index].treePut(key,obj);
   		return x;
   	}
 
	// Update object for given key 
	public int update(K key, T obj){
		if(contains(key)==false){
			return -1;
		}
   		String y=key.toString();
   		int index = (int)djb2(y,size);
   		return array[index].treeUpdate(key,obj);
	}
 
   	// Delete object for given key 
 	public int delete(K key){
 		if(contains(key)==false){
 			return -1;
 		}
 		String y=key.toString();
   		int index = (int)djb2(y,size);
   		return array[index].treeRemove(key);
 	}
 
 	// Does an object with this key exist? 
	public boolean contains(K key){
   		String y=key.toString();
   		int index = (int)djb2(y,size);
   		return array[index].treeContains(key);
	}
 
   	// Return the object with given key 
	public T get(K key) throws NotFoundException{
		if(contains(key)==false){
			throw new NotFoundException();
		}
   		String y=key.toString();
   		int index = (int)djb2(y,size);
   		return array[index].treeGet(key);
	}
 
	   // ”Address” of object with given key (explained below) 
	public String address(K key) throws NotFoundException{
		if(contains(key)==false){
			throw new NotFoundException();
		}
   		String y=key.toString();
   		int index = (int)djb2(y,size);
   		String ans = String.valueOf(index);
   		ans = ans+"-";
   		ans = ans + array[index].treeAddress(key);
   		return ans;
	}
   
    
	public static long djb2(String str, int hashtableSize) { 
		long hash = 5381; 
		for (int i = 0; i < str.length(); i++) { 
			hash = ((hash << 5) + hash) + str.charAt(i); 
		} 
		return Math.abs(hash) % hashtableSize; 
	}
	
	
}
