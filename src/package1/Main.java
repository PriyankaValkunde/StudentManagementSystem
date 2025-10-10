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
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent(students, sc);
                case 2 -> viewStudents(students);
                case 3 -> updateStudent(students, sc);
                case 4 -> System.out.println("\nThank you for using the Student Management System. Goodbye!");
                default -> System.out.println("\nInvalid choice! Please try again.");
            }

        } while (choice != 4);

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
        System.out.println("  3. Update Student");
        System.out.println("  4. Exit");
        System.out.println("----------------------------------------------");
    }

    // --- Add Student Feature
    public static void addStudent(ArrayList<Student> students, Scanner sc) {
        System.out.println("\nEnter Student Details Below:");
        System.out.print("  ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        
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

    // --- Update Student Feature
    public static void updateStudent(ArrayList<Student> students, Scanner sc) {
        if (students.isEmpty()) {
            System.out.println("\nNo students available to update.");
            return;
        }

        System.out.print("\nEnter the ID of the student to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                found = true;
                System.out.println("\nCurrent Details:");
                System.out.printf("  Name: %s%n  Department: %s%n  Age: %d%n",
                        s.getName(), s.getDept(), s.getAge());

                System.out.println("\nEnter New Details (press Enter to skip):");

                System.out.print("  New Name: ");
                String name = sc.nextLine();
                if (!name.trim().isEmpty()) s.setName(name);

                System.out.print("  New Department: ");
                String dept = sc.nextLine();
                if (!dept.trim().isEmpty()) s.setDept(dept);

                System.out.print("  New Age: ");
                String ageInput = sc.nextLine();
                if (!ageInput.trim().isEmpty()) s.setAge(Integer.parseInt(ageInput));

                System.out.println("\nStudent details updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("\nNo student found with ID " + id);
        }
    }
}
