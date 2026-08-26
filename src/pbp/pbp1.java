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
				updateStudent(scan, student);
			}
			else {
				break;
			}
				
			
		}
	}
	
	public static void displayoperations() {
		System.out.println("===STUDENT MANAGEMENT SYSTEM===");
		System.out.println("Enter the operation you want to perform");
		System.out.println("1.Add a Student (CSV Format inputs only)");
		System.out.println("1.Update a Student (CSV Format inputs only)");
		System.out.println("3.Delete a Student");
		System.out.println("4.Search a Student");
	}
	
	public static String[]  takeinput(Scanner scan) {
//		HashMap<Integer,Student> students=new HashMap<>();
		
		System.out.println("Enter how many students you want to add:");
		int noofstudent=scan.nextInt();
		scan.nextLine();
		String[] ar=new String[noofstudent];
		for(int i=0;i<noofstudent;i++) {
			ar[i]=scan.nextLine();
			
		}
		
		
		return ar;
		
	}
	
	
	public static HashMap<Integer, Student> buildStudentMap(String[] listcsv) {
		HashMap<Integer,Student> map=new HashMap();
		for(int i=0;i<listcsv.length;i++) {
			
			String[] student=listcsv[i].split(",");
			Student st=new Student();
			int id=Integer.parseInt(student[0]);
			String name=student[1];
			int age=Integer.parseInt(student[2]);
			String email=student[3];
			long phone=Long.parseLong(student[4]);
			String course=student[5];
			String dept=student[6];
			int marks=Integer.parseInt(student[7]);
			st.setId(id);
			st.setAge(age);
			st.setCourse(course);
			st.setDepartment(dept);
			st.setEmail(email);
			st.setMarks(marks);
			st.setName(name);
			st.setPhone(phone);
			
			map.put(id, st);
		}
		return map;
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
				System.out.println("Enter the Email to be updated");
				String updemail=scan.nextLine();
				st.setEmail(updemail);
			}
			else if(option==4) {
				System.out.println("Enter the Updated phone number");
				long updphone=scan.nextLong();
				st.setPhone(updphone);
			}
			else if(option==5) {
				System.out.println("Enter the course to be updated");
				String updcourse=scan.nextLine();
				st.setCourse(updcourse);
			}
			else if(option==6) {
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
		}
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
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone
				+ ", course=" + course + ", department=" + department + ", marks=" + marks + "]";
	}
	
	
	
}




