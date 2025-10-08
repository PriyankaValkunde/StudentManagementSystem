package package1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	ArrayList<Student> students = new ArrayList<>();
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("==== Welcome to Student Management System ====");
    	
    	System.out.println("Enter Student ID: ");
    	int id = sc.nextInt();
    	sc.nextLine();
    	
    	System.out.println("Enter Student Name: ");
    	String name = sc.nextLine();
    	
    	System.out.println("Enter Department: ");
    	String dept = sc.nextLine();
    	
    	System.out.println("Enter Age: ");
    	int age = sc.nextInt();
    	
    	Student s = new Student(id, name, dept, age);
    	
    	students.add(s);
    	
    	System.out.println("\n Student added successfully!");
    	System.out.println("\nStudent Details:");
    	
    	for (Student st : students) {
    		System.out.println(st);
    	}
    	sc.close();
    	 	
    }
    
}
 