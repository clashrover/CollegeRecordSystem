import java.io.*;
public class Assignment3{
	public static void main(String[] args) throws Exception{
		int size = Integer.parseInt(args[0]);
		String choice = args[1];
		if(choice.equals("DH")){
			doubleHash<Pair<String,String>,Student> dh = new doubleHash<Pair<String,String>,Student>(size);
			File file = new File(args[2]); 
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st; 
 			while ((st = br.readLine()) != null) { 
 				String[] arr = st.split(" ");
 				if(arr[0].equals("insert")){
 					Student s = new Student(arr[1], arr[2],arr[3],arr[4],arr[5]);
 					Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 					int x=dh.insert(p,s);
 					if(x==-1){
 						System.out.println("E");
 					}else{
 						System.out.println(x);
 					}
 				}
 				if(arr[0].equals("update")){
 					Student s = new Student(arr[1], arr[2],arr[3],arr[4],arr[5]);
 					Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 					int x = dh.update(p,s);
 					if(x==-1){
 						System.out.println("E");
 					}else{
 					System.out.println(x);
 					}
 				}
 				if(arr[0].equals("delete")){
 					Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 					int x = dh.delete(p);
 					if(x==-1){
 						System.out.println("E");
 					}else{
 						System.out.println(x);
 					}
 				}
 				if(arr[0].equals("contains")){
 					Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 					if(dh.contains(p)==true){
 						System.out.println("T");
 					}else{
 						System.out.println("F");
 					}
 				}
 				if(arr[0].equals("address")){
 					try{
 						Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 						String x = dh.address(p);
 						System.out.println(x);
 					}catch(NotFoundException e){
 						System.out.println("E");
 					}
 				}
 				if(arr[0].equals("get")){
 					try{
 						Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 						Student x = dh.get(p);
 						x.display();
 					}catch(NotFoundException e){
 						System.out.println("E");
 					}
 				}
 			}
		}else{
			seperateChain<Pair<String,String>,Student> sc = new seperateChain<Pair<String,String>,Student>(size);
			File file = new File(args[2]); 
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st; 
 			while ((st = br.readLine()) != null) { 
 				String[] arr = st.split(" ");
 				if(arr[0].equals("insert")){
 					Student s = new Student(arr[1], arr[2],arr[3],arr[4],arr[5]);
 					Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 					int x=sc.insert(p,s);
 					if(x==-1){
 						System.out.println("E");
 					}else{
 						System.out.println(x);
 					}
 				}
 				if(arr[0].equals("update")){
 					Student s = new Student(arr[1], arr[2],arr[3],arr[4],arr[5]);
 					Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 					int x = sc.update(p,s);
 					if(x==-1){
 						System.out.println("E");
 					}else{
 						System.out.println(x);
 					}
 				}
 				if(arr[0].equals("delete")){
 					Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 					int x = sc.delete(p);
 					if(x==-1){
 						System.out.println("E");
 					}else{
 						System.out.println(x);
 					}
 				}
 				if(arr[0].equals("contains")){
 					Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 					if(sc.contains(p)==true){
 						System.out.println("T");
 					}else{
 						System.out.println("F");
 					}
 				}
 				if(arr[0].equals("address")){
 					try{
 						Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 						String x = sc.address(p);
 						System.out.println(x);
 					}catch(NotFoundException e){
 						System.out.println("E");
 					}
 				}
 				if(arr[0].equals("get")){
 					try{
 						Pair<String,String> p = new Pair<String,String>(arr[1],arr[2]);
 						Student x = sc.get(p);
 						x.display();
 					}catch(NotFoundException e){
 						System.out.println("E");
 					}
 				}
 			}
		}	
	}
}
