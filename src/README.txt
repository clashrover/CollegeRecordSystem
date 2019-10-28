README ASSIGNMENT 3
~ By Sagar Sharma
"Please Maximise"
"There are some assumptions please look into them marked by :::::::::"
"I have used toString() for generic classes as it is present for every class"
"I used compareTo() for K type of key after using K extends Comparable<K> "

class Pair<A,B> implements Comparable<Pair<A,B>>{
	int compareTo(Pair b){
		this function compares the A type objects of "this" object and the b;
	}
	boolean equals(Pair b){
		this function compares both the object A and B of "this" object and b object;
	}
} 
 
****** BST implementation **********

class seperateChaining{

	// Constructor of this class makes an array of BST<K,T> of size given ;
	// This class has all the functions of MyHashTable_ interface ;
	// They are trivial functions which call similar function of BST class after calculating index of BST in array using djb2 hashfunction 
	// concatenation of fname and lname. I found this concatenation of K key using to string function as mentioned ;

}

class BST<K,T>{
:::::::::::::::::::::::::: Convention taken Nodes with same first name inserted in right subtree. ::::::::::::::::::
/////Please see that here i have not used exact function names for eg i have use p.setchild() but not mentioned which child, i have taken 
     care of it in assignment and didn't want to make a bulky readme file. Although it became inevitable.
     
   	// This class has fields "root" and "treeSize".
	// Constructor of this class constructs a new "Node" object with given key,obj;
	// getRoot() ~ returns root of the tree ;
	// setRoot(Node r) ~ can set root of the tree ;
	
	// treePut(K key, T obj) {{{{{{{  a is lood factor number students/size of array
				    worst case 0(h) 0is theta and h is height of tree thus it is O(n) when tree is a chain and insert is of extreme key
				    best case 0(a) when insert take place at child of root.
				    avg case 0(loga) i.e O(logn)
			     }}}}}}} 
		~ this function inserts a new Node(key,obj) into the BST. {
		// this function first call treeSearch(K key, Node root) function 
		
		******* treeSearch is the most important function in my program. It has multiple applications ******
		 
		// treeSearch() function will return the exact Node with the same object if it is already present. Print E on console
		// if not present it will return the soon to be parent of this Node. this is a recursive function that compares given key with the node_key.
		// special case r==null return null; although i ve handeled it already using contains but still to be safe
		// first compare the given key with r_key
		// case 1: if they are equal then check if they full name is equal or the object is equal;
			 if equal return this object else the first name is same and according to convention treeearch in right subtree
		// case 2: if given_key<r_key
		// case 3: if given_key>r_key 
		
		// at the return treeFind that will find the no of node touched till we get to this newly inserted node. As insertion is
		// occurring at the leaves only no need to worry about children of the newly inserted node.
		
		// I have used compareTo() function to compare keys. I override this with compareTo function in Pair class. So in the end this function
		// compares the fname of two string first;
		
		// after finding the parent and i set parent's appropriate child reference to new Node(key,obj); 
	}
	
	// treeRemove(K key) {{{{{{{  a is lood factor number students/size of array
				    worst case 0(h) 0is theta and h is height of tree thus it is O(n) when tree is a chain and insert is of extreme key
				    best case 0(a) when insert take place at child of root.
				    avg case 0(loga) i.e O(logn)
			     }}}}}}} 
		 - this functions removes the node with given key if such node is present{
		// I broke this function into 3 cases which have further subcase
		Then first find the node to be deleted using treeSearch let it be p.
		Case 1: No children:
			Subcase 1 : p == root then set root=null in the tree
			Subcase 2 : p!=root then set p.parent().setchild(null);
					  also set p's parent referenct to null; 
					  set p==null so that object is sent to garbage collection
		Case 2: Exactly one child
			Subcase 1: parent is null : set child as root and child.setParent(null); p.setchild(null);
			Subcase 2: parent is not null: set parent.child(p.child)
				 p.parent(null) 
				 p.child.setParent(parent);
				 
		Case 3: 2 children             
			first find the successor in right subtree
			Subcase 1: parent is null (p and root are refernce to same object): root = successor ;
				 successor_parent.setchildren(successor children);
				 successor_children.setParent(successor parent);
				 successor.setchildren(p.children);
				 p.children.setParent(successor);
				 p.setchildren(null);
				 p=null;
			
			Subcase 2: parent is not null
				 same as above just set parent.child(successor)
				 p.parent(null);
	
	}
	
	// getSuccessor(K key) {{{{{{{  a is lood factor number students/size of array
				    worst case 0(h) 0is theta and h is height of tree thus it is O(n) when tree is a chain and insert is of extreme key
				    best case 0(1) when insert take place at child of root.
				    avg case 0(loga) i.e O(logn)
			     }}}}}}} 
	- this function return the successor node by finding minimum key in right subtree. Min might have same key.
	
	// findMin(Node p) - recursive this function only return a node when this node has no left child this means it return the minimum node in a tree
	
	// treeUpdate(K key, T obj) {{{{{{{  a is lood factor number students/size of array
				       worst case 0(h) 0is theta and h is height of tree thus it is O(n) when tree is a chain and insert is of extreme key
				       best case 0(1) when insert take place at child of root.
				       avg case 0(loga) i.e O(logn)
			        }}}}}}} 
			
	 - use treeSearch function to find this node and use node.setValue(obj);
	
	// treeContains(K key) {{{{{{{  a is lood factor number students/size of array
				       worst case 0(h) 0is theta and h is height of tree thus it is O(n) when tree is a chain and insert is of extreme key
				       best case 0(1) when insert take place at child of root.
				       avg case 0(loga) i.e O(logn)
			   }}}}}}} 
			     - use treeSearch function. If this key is present it will give the exact node with this key else it will 
	// 		     give us a leaf node (as the program terminates whenever you get null as child or get a null). We can check if the 
	// 		     given key match with returned node's key and say whether the object is present;
	
	// treeGet(K key)   {{{{{{{  a is lood factor number students/size of array
				       worst case 0(h) 0is theta and h is height of tree thus it is O(n) when tree is a chain and insert is of extreme key
				       best case 0(1) when insert take place at child of root.
				       avg case 0(loga) i.e O(logn)
			}}}}}}} 
	- first check if the tree contains this key then use treeSearch(key,root) to find the node with this key. return its node.Value()
	
	// treeAddress(K key) {{{{{{{same as above}}}}} - First check if this key is present.Then I call findAddress using which I traverse the tree using compareTo() method at each step if i go right I add 'R' to the string else I add 'L' 
	// 		    to the string and when the recurssion is finished i return this string. 
	
	// treeFind() {{{{{{{  a is lood factor number students/size of array
				    worst case 0(h) 0is theta and h is height of tree thus it is O(n) when tree is a chain and insert is of extreme key
				    best case 0(a) when insert take place at child of root.
				    avg case 0(loga) i.e O(logn)
	  	     }}}}}}} 
	 function is same as treeSearch(), it just that i had to find number of nodes visited using it.
	
}

class Node<K,T>{
	// all the functions in this class are trivial. 
	:::::::::I have maintained parent reference too.
}

********** Double Hashing Implementaton **********

:::::::: I have used toString() function for finding index from K class. I have defined same function in Pair class too.

class Position{
	//functions of this class are trivial
	This class contains key and value. 
}

class doubleHash{
	
	// In constructor I created an array Position class objects
	insert(K key, T obj)	{{{{{{{  a is lood factor number students/size of array
				    worst case is O(tableSize) when tree is a chain and insert is of extreme key
				    best case 0(1) when insert take place at child of root.
				    avg case 0(a) i.e O(1)
			     	}}}}}}} 
	{
		first check if array is full return -1 if it is;
		the start checking array[h1(key)+i*h2(key)] using while loop;
		if a flag or null is found insert the Position object there;
		increase currentSize by 1;
		return i;
	}
	
	update(K key, T obj) 	{{{{{{{  a is lood factor number students/size of array
				    worst case is O(tableSize) when tree is a chain and insert is of extreme key
				    best case 0(1) when insert take place at child of root.
				    avg case 0(a) i.e O(1)
			     	}}}}}}} 
	
	{
		first check if the array contains a Position object with given key if not return -1; use contains()
		find this key using h1(key)+i*h2(key);
		if you come across a flag object continue your serach.
		When found Position.setValue(obj);
		return i;
	}
	
	contains(K key)                {{{{{{{  a is lood factor number students/size of array
				    worst case is O(tableSize) when tree is a chain and insert is of extreme key
				    best case 0(1) when insert take place at child of root.
				    avg case 0(a) i.e O(1)
			     	}}}}}}} 
	
	{ 
		using a while loop, in each (i-1)th iterations calculate h1(key)+i*h2(key);
		if a flag object is found continue;
		If a null object is found then return false because the key should have been at that place;
		When found return true;
	}
	
	delete(K key)                  {{{{{{{  a is lood factor number students/size of array
				    worst case is O(tableSize) when tree is a chain and insert is of extreme key
				    best case 0(1) when insert take place at child of root.
				    avg case 0(a) i.e O(1)
			     	}}}}}}} 
	
	{
		First check if the key is present if not return -1;
		using a while loop, in each (i-1)th iterations calculate h1(key)+i*h2(key);
		if a flag object is found continue;
		when found set array[index]=null;
		return i;
	}
	get(K key)                     {{{{{{{  a is lood factor number students/size of array
				    worst case is O(tableSize) when tree is a chain and insert is of extreme key
				    best case 0(1) when insert take place at child of root.
				    avg case 0(a) i.e O(1)
			     	 }}}}}}} 
	
	{
		First check if the key is present if not then throw NotFoundException;
		using a while loop, in each (i-1)th iterations calculate h1(key)+i*h2(key);
		if a flag object is found continue;
		when found return array[index].getValue() ;
	}
	
	address(K key)                  {{{{{{{  a is lood factor number students/size of array
				    worst case is O(tableSize) when tree is a chain and insert is of extreme key
				    best case 0(1) when insert take place at child of root.
				    avg case 0(a) i.e O(1)
			     	}}}}}}} 
	
	{
		First check if the key is present if not then throw NotFoundException;
		using a while loop, in each (i-1)th iterations calculate h1(key)+i*h2(key);
		if a flag object is found continue;
		when found return index string representation;
	}
	
}

public Student{
	this class has trivial functions;
}
