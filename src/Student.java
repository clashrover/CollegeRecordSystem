public class Student implements Student_ { 
	private String fname;
	private String lname;
	private String hostel;
	private String department;
	private String cgpa;
	
   public Student(String fname,String lname , String hostel,String department,String cgpa){
   		this.fname =fname;
   		this.lname =lname;
   		this.hostel = hostel;
   		this.department = department;
   		this.cgpa = cgpa;
   }			
   public String fname(){
   		return fname;
   }      // Return student’s first name 
   public String lname(){
   	return lname;
   }      // Return student’s last name 
   public String hostel(){
   	return hostel;
   }     // Return student’s hostel name 
   public String department(){
   	return department;
   } // Return student’s department name 
   public String cgpa(){
   	return cgpa;
   }       // Return student’s cgpa 
   public void display(){
   	System.out.println(fname +" " + lname + " " +hostel + " " + department + " " +cgpa);
   }
} 
