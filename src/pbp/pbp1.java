//1,arhan,22,arhan@gmail.com,88786798675,CSE,CS,678
//2,ajith,22,ajith@gmail.com,85738927492,CSE,CS,567
//3,arsalan,21,arsalan@gmail.com,9876567566,CSE,CS,566
//4,rahul,23,rahul@gmail.com,9876543210,CSE,CS,745
//5,rohan,22,rohan@gmail.com,8765432109,ISE,IS,689
//6,amit,21,amit@gmail.com,9988776655,EEE,EE,612
//7,sahil,22,sahil@gmail.com,8899776655,MECH,ME,578
//8,aditya,23,aditya@gmail.com,7788990011,CSE,CS,812
//9,akash,21,akash@gmail.com,8877665544,ECE,EC,734
//10,vikas,22,vikas@gmail.com,9988665544,CSE,CS,645
//11,aman,23,aman@gmail.com,9098765432,ISE,IS,721
//12,karan,21,karan@gmail.com,8987654321,CSE,CS,598
//13,varun,22,varun@gmail.com,7898765432,ECE,EC,676
//14,harsh,23,harsh@gmail.com,9876123450,EEE,EE,632
//15,naveen,21,naveen@gmail.com,8765123490,CSE,CS,754
//16,manoj,22,manoj@gmail.com,7654981230,MECH,ME,589
//17,rohit,23,rohit@gmail.com,9988123456,CSE,CS,823
//18,suraj,21,suraj@gmail.com,8877123456,ISE,IS,667
//19,deepak,22,deepak@gmail.com,7766123456,ECE,EC,703
//20,pranav,23,pranav@gmail.com,9898989898,CSE,CS,789
//21,abhishek,21,abhishek@gmail.com,9090909090,EEE,EE,612
//22,nikhil,22,nikhil@gmail.com,8989898989,CSE,CS,698
//23,tarun,23,tarun@gmail.com,7878787878,ISE,IS,745
//24,sandeep,21,sandeep@gmail.com,6767676767,MECH,ME,567
//25,imran,22,imran@gmail.com,9898765432,CSE,CS,812
//26,faizan,23,faizan@gmail.com,8787654321,ECE,EC,634
//27,irfan,21,irfan@gmail.com,7676543210,CSE,CS,723
//28,zaid,22,zaid@gmail.com,6565432109,ISE,IS,687
//29,mohit,23,mohit@gmail.com,9456123780,CSE,CS,756
//30,dev,21,dev@gmail.com,8345672190,EEE,EE,645
//31,yash,22,yash@gmail.com,9234567810,CSE,CS,834
//32,ayush,23,ayush@gmail.com,8123456790,ECE,EC,712
//33,kunal,21,kunal@gmail.com,9012345678,ISE,IS,623
//34,raj,22,raj@gmail.com,7890123456,CSE,CS,678
//35,varad,23,varad@gmail.com,8901234567,MECH,ME,591
//36,tejas,21,tejas@gmail.com,9011223344,CSE,CS,769
//37,omkar,22,omkar@gmail.com,8122334455,ECE,EC,654
//38,shubham,23,shubham@gmail.com,9233445566,ISE,IS,738
//39,gaurav,21,gaurav@gmail.com,8344556677,CSE,CS,681
//40,kunal,22,kunal2@gmail.com,7455667788,EEE,EE,607
//41,abhay,23,abhay@gmail.com,9566778899,CSE,CS,795
//42,shivam,21,shivam@gmail.com,8677889900,ECE,EC,716
//43,manish,22,manish@gmail.com,9788990011,ISE,IS,644
//44,anurag,23,anurag@gmail.com,8899001122,CSE,CS,827
//45,rohit,21,rohit2@gmail.com,7900112233,MECH,ME,573
//46,atharv,22,atharv@gmail.com,9011223345,CSE,CS,752
//47,arjun,23,arjun@gmail.com,8122334456,ECE,EC,689
//48,lakshman,21,lakshman@gmail.com,9233445567,ISE,IS,734
//49,faheem,22,faheem@gmail.com,8344556678,CSE,CS,618
//50,sameer,23,sameer@gmail.com,7455667789,EEE,EE,701

package pbp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class pbp1 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String[] listcsv=takeinput(scan);
		HashMap<Integer,Student> student=buildStudentMap(listcsv);
		while(true) {
			displayoperations();
			
			int input=scan.nextInt();
			if(input==1) {
				for(Map.Entry<Integer, Student> m:student.entrySet()) {
					System.out.println(m.getKey()+","+m.getValue());
				}
			}
			else if(input==2) {
				addStudent(scan, student);
				
			}
			else if(input==3) {
				updateStudent(scan, student);
			}
			else if(input==4) {
				deleteStudent(scan, student);
			}
			else if(input==5) {
				searchStudent(scan,student);
			}
			else if(input==6) {
				searchByEmail(scan, student);
			}
			else if(input==7) {
				searchByPhone(scan, student);
			}
			else if(input==8) {
				ArrayList<Student> sortedmarks=sortOnMarks(student, scan);
				for(Student s:sortedmarks) {
					System.out.println(s);
				}
			}
			else if(input==10) {
				ArrayList<Student> sortedemail=sortOnEmail(student,scan);
				for(Student s:sortedemail) {
					System.out.println(s);
				}
			}
			else if(input==9) {
				ArrayList<Student> sortedname=sortOnName(student,scan);
				for(Student s:sortedname) {
					System.out.println(s);
				}
			}
			else if(input==11) {
				ArrayList<Student> sortedage=sortOnAge(student,scan);
				for(Student s:sortedage) {
					System.out.println(s);
				}
			}
			else if(input==12) {
				ArrayList<Student> Topk=topKstudents(student,scan);
				for(Student s:Topk) {
					System.out.println(s);
				}
			}
			else if(input==13) {
				ArrayList<Student> course=searchByCourse(student, scan);
				for(Student s:course) {
					System.out.println(s);
				}
			}
			else if(input==14) {
				ArrayList<Student> marks=searchByMarks(student, scan);
				for(Student s:marks) {
					System.out.println(s);
				}
			}
			else if(input==15) {
				HighestandLowest(student);
			}
			else if(input==16) {
				int result=countByCourse(student, scan);
				System.out.println("Students in this course="+result);
			}
			
			else {
				break;
			}
		}
	}
	
	public static void displayoperations() {
		System.out.println("===STUDENT MANAGEMENT SYSTEM===");
		System.out.println("Enter the operation you want to perform");
		System.out.println("1.Display Students (CSV Format inputs only;{id,name,age,email,phone.course,dept,marks})");
		System.out.println("2.Add another Student (CSV Format inputs only;{id,name,age,email,phone.course,dept,marks})");
		System.out.println("3.Update a Student");
		System.out.println("4.Delete a Student");
		System.out.println("5.Search a Student by Id");
		System.out.println("6.Search a Student by email");
		System.out.println("7.Search a Student by Phone");
		System.out.println("8.Sort the students based on max marks");
		System.out.println("9.Sort the students based on name of the student");
		System.out.println("10.Sort the students based on email");
		System.out.println("11.Sort the students based on Age");
		System.out.println("12.Top K students with max Marks");
		System.out.println("13.Get all students by particular Course name");
		System.out.println("14.Get all students whose marks is greater than N");
		System.out.println("15.Get Highest and Lowest in student list");
		System.out.println("16.Count the students in particular course");
		System.out.println("== Enter any other number to end program(Only Number) ==");
	}
	
	public static String[]  takeinput(Scanner scan) {
//		HashMap<Integer,Student> students=new HashMap<>();
		
		System.out.println("Enter how many students you want to add:");
		int noofstudent=scan.nextInt();
		scan.nextLine();
		String[] ar=new String[noofstudent];
		for(int i=0;i<noofstudent;i++) {
			System.out.println("Enter id,name,age,email,phone,course,dept,marks for Student"+(i+1));
			ar[i]=scan.nextLine();
			
		}
		
		
		return ar;
		
	}
	

	//another method ;using constructor not setters
	public static HashMap<Integer, Student> buildStudentMap(String[] listcsv) {

	    HashMap<Integer, Student> map = new HashMap<>();

	    for (int i = 0; i < listcsv.length; i++) {

	        String[] data = listcsv[i].split(",");

	        int id = Integer.parseInt(data[0]);
	        String name = data[1];
	        int age = Integer.parseInt(data[2]);
	        String email = data[3];
	        long phone = Long.parseLong(data[4]);
	        String course = data[5];
	        String dept = data[6];
	        int marks = Integer.parseInt(data[7]);
	        // ID validation
		    if (map.containsKey(id)) {
		        System.out.println("Student ID already exists.");
		        continue;
		    }

		    // Email validation
		    if (!isEmailUnique(email, map)) {
		        System.out.println("Email already exists.");
		        continue;
		    }

		    // Phone validation
		    if (!isPhoneUnique(phone, map)) {
		        System.out.println("Phone number already exists.");
		        continue;
		    }
	        Student st = new Student(
	                id,
	                name,
	                age,
	                email,
	                phone,
	                course,
	                dept,
	                marks
	        );
	        

	        map.put(id, st);
	    }

	    return map;
	}
	
	public static void addStudent(Scanner scan,HashMap<Integer,Student> student) {
		System.out.println("Enter id,name,age,email,phone,course,dept,marks for Student");
		scan.nextLine();
		String str=scan.nextLine();
		String data[]=str.split(",");
		int id=Integer.parseInt(data[0]);
		String name=data[1];
		int age=Integer.parseInt(data[2]);
		String email=data[3];
		long phone=Long.parseLong(data[4]);
		String course=data[5];
		String dept=data[6];
		int marks=Integer.parseInt(data[7]);
		
		 // ID validation
	    if (student.containsKey(id)) {
	        System.out.println("Student ID already exists.");
	        return;
	    }

	    // Email validation
	    if (!isEmailUnique(email, student)) {
	        System.out.println("Email already exists.");
	        return;
	    }

	    // Phone validation
	    if (!isPhoneUnique(phone, student)) {
	        System.out.println("Phone number already exists.");
	        return;
	    }
		
		Student st = new Student(
                id,
                name,
                age,
                email,
                phone,
                course,
                dept,
                marks
        );
		
		student.put(id,st);
	}

	
	
	public static void updateStudent(Scanner scan,HashMap<Integer,Student> student) {
		System.out.println("Enter the id to which you want to update:");
		int updid=scan.nextInt();
		boolean updated=false;
		if(student.containsKey(updid)) {
			System.out.println("Select what you want to update");
			System.out.println("1.Name");
			System.out.println("2.Age");
			System.out.println("3.Email");
			System.out.println("4.Phone");
			System.out.println("5.Course");
			System.out.println("6.Dept");
			System.out.println("7.Marks");
			
			int option=scan.nextInt();
			
			Student st=student.get(updid);
			if(option==1) {
				scan.nextLine();
				System.out.println("Enter the new Name");
				String updname=scan.nextLine();
				st.setName(updname);
				updated=true;
			}
			
			else if(option==2) {
				System.out.println("Enter the Age to be updated");
				int updage=scan.nextInt();
				if(updage<17 || updage>30) {
					System.out.println("Please enter valid age");
					return;
				}
				else {
					
					st.setAge(updage);
					updated=true;
				}
			}
			else if(option==3) {
				scan.nextLine();
				System.out.println("Enter the Email to be updated");
				String updemail=scan.nextLine();
				
				if(!isEmailUniqueForUpdate(updid, updemail, student)) {
					System.out.println("Email is already in use by another student");
					return;
				}
				else {
					
					st.setEmail(updemail);
					updated=true;
				}
			}
			else if(option==4) {
				System.out.println("Enter the Updated phone number");
				long updphone=scan.nextLong();
				
				if(!isPhoneUniqueForUpdate(updid, updphone, student)) {
					System.out.println("Phone number already used by another student");
					return;
				}
				else {
					
					st.setPhone(updphone);
					updated=true;
				}
			}
			else if(option==5) {
				scan.nextLine();
				System.out.println("Enter the course to be updated");
				String updcourse=scan.nextLine();
				st.setCourse(updcourse);
				updated=true;
			}
			else if(option==6) {
				scan.nextLine();
				System.out.println("Enter the updated Dept ");
				String upddept=scan.nextLine();
				st.setDepartment(upddept);
				updated=true;
			}
			else if(option==7) {
				System.out.println("Enter the marks that need to be updated");
				int updmarks=scan.nextInt();
				if(updmarks<0) {
					System.out.println("Enter Valid Marks");
					return;
				}
				else {
					
					st.setMarks(updmarks);
					updated=true;
				}
				
			}
			
			
			if(updated) {
				
				System.out.println("Student Updated successfully");
			}
			else {
				System.out.println("Please enter valid option");
			}
			
		}
		else {
			System.out.println("Student not found");
		}
	}
	
	public static void deleteStudent(Scanner scan,HashMap<Integer,Student> student) {
		System.out.println("Enter the id for deletion:");
		int delid=scan.nextInt();
		if(student.containsKey(delid)) {
			student.remove(delid);
			System.out.println("Student removed ");
		}
		else {
			System.out.println("Student not found ; Please enter valid id");
		}
	}
	
	public static boolean isEmailUniqueForUpdate(int currentid,String email,HashMap<Integer,Student> student) {
		for(Student s:student.values()) {
			if(s.getEmail().equalsIgnoreCase(email) && currentid!=s.getId()) {
				return false;
			}
		}
		
		return true;
	}
	

	public static boolean isPhoneUniqueForUpdate(int currentid,long phone,HashMap<Integer,Student> student) {
		for(Student s:student.values()) {
			if(s.getPhone()==phone && currentid!=s.getId()) {
				return false;
			}
		}
		return true;
	}
	
	public static void searchStudent(Scanner scan,HashMap<Integer,Student> student) {
		System.out.println("Enter the id for search:");
		int searchid=scan.nextInt();
		if(student.containsKey(searchid)) {
			System.out.println(searchid+","+student.get(searchid));
		}
		else {
			System.out.println("User Doesnot exist");
		}
	}
	
	public static void searchByEmail(Scanner scan,HashMap<Integer,Student> student) {
		scan.nextLine();
		System.out.println("Enter the email of  the student");
		String searchemail=scan.nextLine();
		
		for(Student s:student.values()) {
			if(s.getEmail().equalsIgnoreCase(searchemail)) {
				System.out.println(s);
				return;
			}
		}
		
		System.out.println("Student not Found");
	}
	
	public static boolean isEmailUnique(
	        String email,
	        HashMap<Integer, Student> students) {

	    for (Student s : students.values()) {

	        if (s.getEmail().equalsIgnoreCase(email)) {
	            return false;
	        }
	    }

	    return true;
	}
	
	public static boolean isPhoneUnique(
	        long phone,
	        HashMap<Integer, Student> students) {

	    for (Student s : students.values()) {

	        if (s.getPhone() == phone) {
	            return false;
	        }
	    }

	    return true;
	}
	
	public static void searchByPhone(Scanner scan,HashMap<Integer,Student> student) {
		scan.nextLine();
		System.out.println("Enter the phone no to find student");
		long searchphone=scan.nextLong();
		
		for(Student s:student.values()) {
			if(s.getPhone()==searchphone) {
				System.out.println(s);
				return;
			}
		}
		
		System.out.println("Student not found");
	}
	
	public static ArrayList<Student> sortOnMarks(HashMap<Integer,Student> student,Scanner scan){
		ArrayList<Student> list=new ArrayList();
		System.out.println("Enter the order of sorting :");
		System.out.println("1.Ascending");
		System.out.println("2.Descending");
		
		int order=scan.nextInt();
		
		if(order==1) {
			
			for(Map.Entry<Integer, Student> st:student.entrySet()) {
				list.add(st.getValue());
			}
			
			Collections.sort(list,new Comparator<Student>() {
				public int compare(Student s1,Student s2) {
					if(s1.getMarks()==s2.getMarks()) {
						return Integer.compare(s1.getMarks(), s2.getMarks());
					}
					return Integer.compare(s1.getMarks(), s2.getMarks());
				}
			});
			
			return list;
		}
		else if(order==2) {
			for(Map.Entry<Integer, Student> st:student.entrySet()) {
				list.add(st.getValue());
			}
			
			Collections.sort(list,new Comparator<Student>() {
				public int compare(Student s1,Student s2) {
					if(s1.getMarks()==s2.getMarks()) {
						return Integer.compare(s2.getMarks(), s1.getMarks());
					}
					return Integer.compare(s2.getMarks(), s1.getMarks());
				}
			});
			
			return list;
		}
		else {
			System.out.println("Invalid option");
		}
		return list;
	}
	
	
	public static ArrayList<Student> searchByCourse(HashMap<Integer,Student> student,Scanner scan){
		ArrayList<Student> list=new ArrayList();
		ArrayList<Student> list1=new ArrayList();
		scan.nextLine();
		System.out.println("Enter the course name:");
		String course=scan.nextLine();
		for(Map.Entry<Integer, Student> s:student.entrySet()) {
			list.add(s.getValue());
		}
		
		for(Student s:list) {
			if(s.getCourse().equalsIgnoreCase(course)) {
				list1.add(s);
			}
		}
		
		return list1;
	}
	
	public static int countByCourse(HashMap<Integer,Student> student,Scanner scan) {
		scan.nextLine();
		System.out.println("Enter the Course Name:");
		String course=scan.nextLine();
		
		ArrayList<Student> list=new ArrayList();
		int count=0;
		for(Map.Entry<Integer, Student> s:student.entrySet()) {
			list.add(s.getValue());
		}
		
		for(Student s:list) {
			if(s.getCourse().equalsIgnoreCase(course)) {
				count++;
			}
		}
		
		return count;
	}
	
	public static ArrayList<Student> searchByMarks(HashMap<Integer,Student> student,Scanner scan){
		ArrayList<Student> list=new ArrayList();
		ArrayList<Student> list1=new ArrayList();
		scan.nextLine();
		System.out.println("Enter the marks to display equal or greater than that marks");
		int marks=scan.nextInt();
		for(Map.Entry<Integer, Student> s:student.entrySet()) {
			list.add(s.getValue());
		}
		
		for(Student s:list) {
			if(s.getMarks()>=marks) {
				list1.add(s);
			}
		}
		
		return list1;
	}
	public static ArrayList<Student> sortOnEmail(HashMap<Integer,Student> student,Scanner scan){
		ArrayList<Student> list=new ArrayList();
		System.out.println("Enter the order of sorting :");
		System.out.println("1.Ascending");
		System.out.println("2.Descending");
		
		int order=scan.nextInt();
		if(order==1) 
		{
			
			for(Map.Entry<Integer, Student> s:student.entrySet()) {
				list.add(s.getValue());
				
				Collections.sort(list,new Comparator<Student>(){
					public int compare(Student s1,Student s2) {
						return s1.getEmail().compareTo(s2.getEmail());
					}
				});
			}
			return list;
		}
		else if(order==2) {
			for(Map.Entry<Integer, Student> s:student.entrySet()) {
				list.add(s.getValue());
				
				Collections.sort(list,new Comparator<Student>(){
					public int compare(Student s1,Student s2) {
						return s2.getEmail().compareTo(s1.getEmail());
					}
				});
			}
			return list;
		}
		else {
			System.out.println("Invalid option");
		}
		return list;
	}
	
	public static void HighestandLowest(HashMap<Integer,Student> student) {
		Student highest=null;
		Student lowest=null;
		
		if(student.isEmpty()) {
			System.out.println("No Student data found");
		}
		for(Student s:student.values()) {
			if(highest==null ||s.getMarks()>highest.getMarks()) {
				highest=s;
			}
		}
		for(Student s:student.values()) {
			if(lowest==null ||s.getMarks()<lowest.getMarks()) {
				lowest=s;
			}
		}
		
		System.out.println("Student with Highest Marks:");
		System.out.println(highest);
		System.out.println("Student with Lowest Marks:");
		System.out.println(lowest);
	}
	
	public static ArrayList<Student> sortOnName(HashMap<Integer,Student> student,Scanner scan){
		ArrayList<Student> list=new ArrayList();
		System.out.println("Enter the order of sorting :");
		System.out.println("1.Ascending");
		System.out.println("2.Descending");
		
		int order=scan.nextInt();
		if(order==1) 
		{
			for(Map.Entry<Integer, Student> s:student.entrySet()) {
				list.add(s.getValue());
				
				Collections.sort(list,new Comparator<Student>(){
					public int compare(Student s1,Student s2) {
						return s1.getName().compareTo(s2.getName());
					}
				});
			}
			return list;
		}
		else if(order==2) {
			for(Map.Entry<Integer, Student> s:student.entrySet()) {
				list.add(s.getValue());
				
				Collections.sort(list,new Comparator<Student>(){
					public int compare(Student s1,Student s2) {
						return s2.getName().compareTo(s1.getName());
					}
				});
			}
			return list;
		}
		else {
			System.out.println("Invalid Option");
		}
		return list;
		
	}
	
	public static ArrayList<Student> sortOnAge(HashMap<Integer,Student> student,Scanner scan){
		ArrayList<Student> list=new ArrayList();
		System.out.println("Enter the order of sorting :");
		System.out.println("1.Ascending");
		System.out.println("2.Descending");
		int order=scan.nextInt();
		if(order==1) {
			for(Map.Entry<Integer, Student> s:student.entrySet()) {
				list.add(s.getValue());
				
				Collections.sort(list,new Comparator<Student>(){
					public int compare(Student s1,Student s2) {
						if(s1.getAge()==s2.getAge()) {
							return Integer.compare(s2.getAge(), s1.getAge());
						}
						
						return Integer.compare(s1.getAge(), s2.getAge());
					}
				});
			}
		}
		else if(order==2) {
			for(Map.Entry<Integer, Student> s:student.entrySet()) {
				list.add(s.getValue());
				
				Collections.sort(list,new Comparator<Student>(){
					public int compare(Student s1,Student s2) {
						if(s1.getAge()==s2.getAge()) {
							return Integer.compare(s1.getAge(), s2.getAge());
						}
						
						return Integer.compare(s2.getAge(), s1.getAge());
					}
				});
			}
		}
		else {
			System.out.println("Invalid option");
		}
		
		return list;
	}
	
	public static ArrayList<Student> topKstudents(HashMap<Integer, Student> student , Scanner scan){
		ArrayList<Student> list=new ArrayList<Student>();
		
		System.out.println("Enter the k value: ");
		int k=scan.nextInt();
		for(Map.Entry<Integer,Student> s:student.entrySet()) {
			list.add(s.getValue());
			
			Collections.sort(list,new Comparator<Student>(){
				public int compare(Student s1,Student s2) {
					if(s1.getMarks()==s2.getMarks()) {
						return Integer.compare(s1.getMarks(), s2.getMarks());
					}
					
					return Integer.compare(s2.getMarks(), s1.getMarks());
				}
			});
		}
		
		ArrayList<Student> newlist=new ArrayList<Student>();
		for(int i=0;i<k && i<list.size();i++) {
			newlist.add(list.get(i));
		}
		
		return newlist;
		
	}
	
	
	

}

class Student{
	private int id;
	private String name;
	private int age;
	private String email;
	private long phone;
	private String course;
	private String department;
	private int marks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student(int id, String name, int age, String email, long phone, String course, String department,
			int marks) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.course = course;
		this.department = department;
		this.marks = marks;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student "+": name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone
				+ ", course=" + course + ", department=" + department + ", marks=" + marks + "]";
	}
	
	
	
}




