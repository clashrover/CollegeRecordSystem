import java.lang.Math;
//class NotFoundException extends Exception {} 
// Hash table using Double Hashing
public class doubleHash<K, T> implements MyHashTable_<K,T>{
   // make an array to store value; 
   private int size =0;
   private int currentSize=0;
   private Position<K,T>[] array;
   private Position<K,T> flag = new Position<K,T>();
   // make the constructor to make an array with 1.5 times the estimated size
   public doubleHash(int estimate_size){
      size = makePrime(estimate_size);
      //System.out.println(size);
      array = new Position[size];
      for(int i=0;i<size ; i++){
      	array[i]=null;
      }
   }
   // check if array is full
   boolean isFull(){
      if(currentSize==size){
         return true;
      }
      return false;
   }
   // check if array is empty
   boolean isEmpty(){
      if(currentSize==0){
         return true;
      }
      return false;
   }
   // Insert new object with given key 
   public int insert(K key, T obj){
      Position<K,T> p = new Position<K,T>(key,obj);
      if(isFull()==true){
         //System.out.println("Array is full");
         return -1;
      }
      int i=0;
      String str = key.toString();
      int index = 0;
      while(true){
         index =(int) (djb2(str,size) + i*sdbm(str,size))%size;
         //System.out.println("in the loop");
         i++;
         if(array[index]==null || array[index]==flag){
         	break;
         }
         K key1 = array[index].getKey();
         if(key.equals(key1)==true){
         	break;
         }
      }
      array[index] = p;
      //System.out.println("out the loop " + index );
      currentSize++;
      return i;
   } 
 
   // Update object for given key 
   
   
   ////// MAKE USE OF FLAG Pending
   public int update(K key, T obj){
      Position<K,T> p = new Position<K,T>(key,obj);
      if(this.contains(key) == false){
      	//System.out.println("Object with this key not found");
      	return -1;
      }
      String str = key.toString();
      int index = 0;
      int i=0;
      while(true){
         index = (int)(djb2(str,size) + i*sdbm(str,size))%size;
         i++;
         if(array[index]==flag){
         	continue;
         }
         
         K key1 = array[index].getKey();
         ////key.toString().compareTo(key1.toString())==0
         if(key.equals(key1)==true){
            array[index] = p;
            break;
         }
      }
      return i;
   }
 
   // Delete object for given key 
   public int delete(K key){
      if(this.contains(key) == false){
      	//System.out.println("Object with this key not found");
      	return -1;
      }
      String str = key.toString();
      int index = 0;
      int i=0;
      while(true){
         index = (int)(djb2(str,size) + i*sdbm(str,size))%size;
         i++;
         if(array[index]==flag){
         	continue;
         }
         K key1 = array[index].getKey();
         if(key.equals(key1)==true){
            array[index] = flag;
            break;
         }
      }
      currentSize--;
      return i;
   } 
 
   // Does an object with this key exist? 
   public boolean contains(K key){
      if(this.isEmpty()==true){
         //System.out.println("array is empty");
         return false;
      }
      String str = key.toString();
      int index = 0;
      int i=0;
      boolean x =false;
      while(true){
         index = (int)(djb2(str,size) + i*sdbm(str,size))%size;
         i++;
         if(array[index]==flag){
         	continue;
         }
         if(array[index]==null){
         	x=false;
         	break;
         }
         K key1 = array[index].getKey();
         if(key.equals(key1)==true){
            x=true;
            break;
         }
      }
      return x;
   } 
 
   // Return the object with given key 
   public T get(K key) throws NotFoundException{
      if(this.contains(key)==false){
      	throw new NotFoundException();
      }
      String str = key.toString();
      int index = 0;
      int i=0;
      while(true){
         index = (int)(djb2(str,size) + i*sdbm(str,size))%size;
         i++;
         if(array[index]==flag){
         	continue;
         }
         
         K key1 = array[index].getKey();
         if(key.equals(key1) == true){
            break;
         }
      }
    
      return array[index].getObj();
     
   } 
 
   // ”Address” of object with given key (explained below) 
   public String address(K key) throws NotFoundException{
      if(this.contains(key) == false){
      	throw new NotFoundException();
      }
      String str = key.toString();
      int index = 0;
      int i=0;
      
      while(true){
         index = (int) (djb2(str,size) + i*sdbm(str,size))%size;
         i++;
         if(array[index]==flag){
         	continue;
         }
         K key1 = array[index].getKey();
         if(key.equals(key1)==true){
            break;
         }
      }
      String ans = String.valueOf(index);
      return ans;
   } 

   
public static long djb2(String str, int hashtableSize) { 
    long hash = 5381; 
    for (int i = 0; i < str.length(); i++) { 
        hash = ((hash << 5) + hash) + str.charAt(i); 
    } 
    return Math.abs(hash) % hashtableSize; 
}

public static long sdbm(String str, int hashtableSize) { 
    long hash = 0; 
    for (int i = 0; i < str.length(); i++) { 
        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
    } 
    return Math.abs(hash) % (hashtableSize - 1) + 1; 
} 

   public int makePrime(int n){
      while(checkPrime(n)!=true){
         n++;
      }
      return n;
   }
   public boolean checkPrime(int n){
      for(int i=2 ; i<=Math.sqrt(n) ; i++){
         if(n%i==0){
            return false;
         }
      }
      return true;
   }
}
