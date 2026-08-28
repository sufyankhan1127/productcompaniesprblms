//1,arhan,22,arhan@gmail.com,88786798675,CSE,CS,678
//2,ajith,22,ajith@gmail.com,85738927492,CSE,CS,567
//3,arsalan,21,arsalan@gmail.com,9876567566,CSE,CS,566


package pbp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
		System.out.println("== Enter any other number to end program ==");
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
			}
			
			else if(option==2) {
				System.out.println("Enter the Age to be updated");
				int updage=scan.nextInt();
				st.setAge(updage);
			}
			else if(option==3) {
				scan.nextLine();
				System.out.println("Enter the Email to be updated");
				String updemail=scan.nextLine();
				
				if(!isemailUniqueForUpd(updid, updemail, student)) {
					System.out.println("Email is already in use by another student");
					return;
				}
				else {
					
					st.setEmail(updemail);
				}
			}
			else if(option==4) {
				System.out.println("Enter the Updated phone number");
				long updphone=scan.nextLong();
				
				if(!isphoneUniqueForUpd(updid, updphone, student)) {
					System.out.println("Phone number already used by another student");
					return;
				}
				else {
					
					st.setPhone(updphone);
				}
			}
			else if(option==5) {
				scan.nextLine();
				System.out.println("Enter the course to be updated");
				String updcourse=scan.nextLine();
				st.setCourse(updcourse);
			}
			else if(option==6) {
				scan.nextLine();
				System.out.println("Enter the updated Dept ");
				String upddept=scan.nextLine();
				st.setDepartment(upddept);
			}
			else if(option==7) {
				System.out.println("Enter the marks that need to be updated");
				int updmarks=scan.nextInt();
				st.setMarks(updmarks);
				
			}
			else {
				System.out.println("Please enter valid option");
			}
			
			System.out.println("Student Updated successfully");
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
	
	public static boolean isemailUniqueForUpd(int currentid,String email,HashMap<Integer,Student> student) {
		for(Student s:student.values()) {
			if(s.getEmail().equalsIgnoreCase(email) && currentid!=s.getId()) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isphoneUniqueForUpd(int currentid,long phone,HashMap<Integer,Student> student) {
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
		return "Student "+", name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone
				+ ", course=" + course + ", department=" + department + ", marks=" + marks + "]";
	}
	
	
	
}




