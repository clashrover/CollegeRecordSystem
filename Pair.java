public class Pair<A,B> implements Comparable<Pair<A,B>>{
	private A fname;
	private B lname;
	public Pair(A fname, B lname){
		this.fname = fname;
		this.lname = lname;
	}
	public A getFirst(){
		return fname;
	}
	public B getLast(){
		return lname;
	}
	public String toString(){
		String str = fname.toString() +  lname.toString();
		return str;
	}
	public boolean equals(Object p){
		if(p instanceof Pair<?,?>){
			if(((Pair<?,?>)p).getFirst().equals(this.getFirst())){
				if(((Pair<?,?>)p).getLast().equals(this.getLast())){
					return true;
				}
			}
		}
		return false;
	}
	
	public int compareTo(Pair p){
		String s0 = this.getFirst().toString();
		//String s1 = this.getLast().toString();
		String s2 = p.getFirst().toString();
		//String s3 = p.getLast().toString();
		return s0.compareTo(s2);
	}
}
