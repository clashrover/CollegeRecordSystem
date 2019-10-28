public class BST <K extends Comparable<K> ,T>{
	private Node<K,T> root;
	public int treeSize=0;
	public BST(K key,T obj){
		Node<K,T> init = new Node<K,T>(key,obj);
		root = init;
		root.setParent(null);
		treeSize++;
	}
	public Node<K,T> getRoot(){
		return this.root;
	}
	public void setRoot(Node<K,T> r){
		this.root = r;
	}
	public int treePut(K key, T obj){
		Node<K,T> parent = treeSearch(key,root);
		Node<K,T> child = new Node<K,T>(key,obj);
		if(parent.getKey().compareTo(key)==0){
			if(parent.getKey().toString().compareTo(key.toString()) == 0){
				return -1;
			}
		}
		child.setParent(parent);
		K parent_key = parent.getKey();
		if(key.compareTo(parent_key) < 0){
			parent.setLeft(child);
		}else if(key.compareTo(parent_key)>0){
			parent.setRight(child);
		}else if(key.compareTo(parent_key)==0){
			parent.setRight(child);
		}
		treeSize++;
		return treeFind(child,root);
	}
	public int treeRemove(K key){
		if(treeContains(key)==false){
			return -1;
		}
		Node <K,T> p = treeSearch(key,root);
		Node <K,T> parent = p.getParent();
		int x=treeFind(p,root);
		if(p.getLeft()==null && p.getRight()==null){
			if(parent ==null){
				root =null;
			}else{
				if(p.getKey().compareTo(parent.getKey())<0){
					parent.setLeft(null);
				}else{
					parent.setRight(null);
				}
			}
			p.setParent(null);
		}
		else if(p.getLeft()== null && p.getRight()!=null){
			//System.out.println("to remove this key node in the right!=null case:  " + p.getKey().toString());
			if(parent == null){
				Node rx = root.getRight();
				rx.setParent(null);
				root.setRight(null);
				root = rx;
			}else{
				if(p.getKey().compareTo(parent.getKey())<0){
					Node rx = p.getRight();
					rx.setParent(parent);
					p.setRight(null);
					p.setParent(null);
					parent.setLeft(rx);
				}else{
					Node rx = p.getRight();
					rx.setParent(parent);
					p.setRight(null);
					p.setParent(null);
					parent.setRight(rx);
				}
			}
			x++;
		}
		else if(p.getLeft()!= null && p.getRight()==null){
			if(parent == null){
				Node rx = root.getLeft();
				rx.setParent(null);
				root.setLeft(null);
				root = rx;
			}else{
				if(p.getKey().compareTo(parent.getKey())<0){
					Node rx = p.getLeft();
					rx.setParent(parent);
					p.setLeft(null);
					p.setParent(null);
					parent.setLeft(rx);
				}
				else{
					Node rx = p.getLeft();
					rx.setParent(parent);
					parent.setRight(rx);
					p.setLeft(null);
					p.setParent(null);
					parent.setRight(rx);
				}
			}
			x++;
		}
		else if(p.getLeft()!=null && p.getRight()!=null){
			if(parent==null){
				Node <K,T> successor = getSuccessor(key);
				x=treeFind(successor,root);
				Node parent_successor = successor.getParent();
				parent_successor.setLeft(successor.getRight());
				Node s = successor.getRight();
				if(s!=null){
					s.setParent(parent_successor);
					x++;		
				}
				successor.setParent(null);
				successor.setRight(null);
				successor.setLeft(p.getLeft());
				successor.setRight(p.getRight());
				Node l = p.getLeft();
				Node r = p.getRight();
				l.setParent(successor);
				r.setParent(successor);
				p.setLeft(null);
				p.setRight(null);
				p.setParent(null);
				root = successor;
			}
			else{
				Node <K,T> successor = getSuccessor(key);
				x=treeFind(successor,root);
				Node parent_successor = successor.getParent();
				parent_successor.setLeft(successor.getRight());
				Node s = successor.getRight();
				if(s!=null){
					s.setParent(parent_successor);
					x++;		
				}
				successor.setParent(null);
				successor.setRight(null);
				successor.setLeft(p.getLeft());
				successor.setRight(p.getRight());
				successor.setParent(parent);
				Node l = p.getLeft();
				Node r = p.getRight();
				l.setParent(successor);
				r.setParent(successor);
				if(p.getKey().compareTo(parent.getKey())<0){
					parent.setLeft(successor);
				}else{ ///even if their first name are same still correct
					parent.setRight(successor);
				}
				p.setLeft(null);
				p.setRight(null);
				p.setParent(null);
				//p=null; //all reference to p set to null and hence pobject send to gc
			}
		}
		p=null;
		return x;
	}
	
	public Node<K,T> getSuccessor(K key){
		Node<K,T> p = treeSearch(key,root);
		return findMin(p.getRight());
	}
	
	public Node<K,T> findMin(Node p){
		if(p.getLeft()==null){
			return p;
		}
		return findMin(p.getLeft());
	}
	
	public int treeUpdate(K key,T obj){
		if(treeContains(key)==false){
			return -1;
		}
		Node<K,T> p = treeSearch(key,root);
		p.setValue(obj);
		return treeFind(p,root);
	}
	public boolean treeContains(K key){
		Node<K,T> p = treeSearch(key,root);
		//System.out.println(p.getKey().toString());
		if(p==null){
			return false;
		}
		if(key.compareTo(p.getKey())!=0){
			return false;
		}
		if(key.compareTo(p.getKey())==0){
			if(key.toString().compareTo(p.getKey().toString())!=0){
				return false;
			}
		}
		return true;
	}
	public T treeGet(K key) throws NotFoundException{
		if(treeContains(key)==false){
			throw new NotFoundException();
		}
		Node<K,T> p = treeSearch(key,root);
		T obj = p.getValue();
		return obj;
	}
	public String treeAddress(K key) throws NotFoundException{
		if(treeContains(key)==false){
			throw new NotFoundException();
		}
		String Address = findAddress(key,root);
		return Address;
	}
	
	public String findAddress(K key, Node<K,T> r){
		if(r==null){
			return "";
		}
		K r_key = r.getKey();
		String s = "" ;
		if(key.compareTo(r_key) <0){
			s = s+"L";
			s = s + findAddress(key,r.getLeft());
		}else if(key.compareTo(r_key)>0){
			s = s+"R";
			s = s + findAddress(key,r.getRight());
		}
		else if(key.compareTo(r_key)==0){
			if(key.toString().compareTo(r.getKey().toString())==0){
				return "";
			}
			s=s+"R";
			s = s + findAddress(key,r.getRight()); 
		}
		return s;
	}
	
	public Node<K,T> treeSearch(K key,Node<K,T> r){
		if(r==null){
			return null;
		}
		K r_key = r.getKey();
		if(key.compareTo(r_key)==0){
			if(r.getKey().toString().compareTo(key.toString()) == 0){
				return r;
			}
			if(r.getRight()==null){
				return r;
			}else{
				return treeSearch(key,r.getRight());
			}
			
		}
		else if(key.compareTo(r_key)<0){
			if(r.getLeft()==null){
				return r;
			}else{
				return treeSearch(key,r.getLeft());
			}	
		}
		else if(key.compareTo(r_key)>0){
			if(r.getRight()==null){
				return r;
			}else{
				return treeSearch(key,r.getRight());
			}	
		}
		return null;
	}
	
	public int treeFind(Node<K,T> p ,Node<K,T> r){
		if(r==null){
			return -1;
		}
		K p_key = p.getKey();
		K r_key = r.getKey();
		if(p_key.compareTo(r_key)==0){
			if(p_key.toString().compareTo(r_key.toString()) == 0){
				return 1;
			}else{
				return 1+treeFind(p,r.getRight());
			}
			
		}
		else if(p_key.compareTo(r_key)<0){
			return 1+treeFind(p,r.getLeft());
		}
		else if(p_key.compareTo(r_key)>0){
			return 1+treeFind(p,r.getRight());
		}
		return -1;
	}
}
