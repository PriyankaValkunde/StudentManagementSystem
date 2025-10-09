package package1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        printTitle();

        do {
            printMenu();
            System.out.print("➤ Enter your choice → ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent(students, sc);
                case 2 -> viewStudents(students);
                case 3 -> System.out.println("\nThank you for using the Student Management System. Goodbye!");
                default -> System.out.println("\nInvalid choice! Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }

    // --- Print Header / Title
    public static void printTitle() {
        System.out.println("\n──────────────────────────────────────────────");
        System.out.println("▶           STUDENT MANAGEMENT SYSTEM        ◀");
        System.out.println("──────────────────────────────────────────────");
    }

    // --- Print Menu Options
    public static void printMenu() {
        System.out.println("\n----------------------------------------------");
        System.out.println("  1. Add Student");
        System.out.println("  2. View Students");
        System.out.println("  3. Exit");
        System.out.println("----------------------------------------------");
    }

    // --- Add Student Feature
    public static void addStudent(ArrayList<Student> students, Scanner sc) {
        System.out.println("\nEnter Student Details Below:");
        System.out.print("  ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("  Name: ");
        String name = sc.nextLine();

        System.out.print("  Department: ");
        String dept = sc.nextLine();

        System.out.print("  Age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, dept, age));
        System.out.println("\nStudent added successfully!");
    }

    // --- View Students Feature
    public static void viewStudents(ArrayList<Student> students) {
        System.out.println("\nStudent List:");
        System.out.println("──────────────────────────────────────────────");

        if (students.isEmpty()) {
            System.out.println("No students added yet. Try adding one first!");
        } else {
            System.out.printf("%-5s %-20s %-15s %-5s%n", "ID", "NAME", "DEPARTMENT", "AGE");
            System.out.println("----------------------------------------------");
            for (Student s : students) {
                System.out.printf("%-5d %-20s %-15s %-5d%n",
                        s.getId(), s.getName(), s.getDept(), s.getAge());
            }
        }

        System.out.println("──────────────────────────────────────────────");
    }
}
