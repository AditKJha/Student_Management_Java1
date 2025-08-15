import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch(choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while(choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter ID: "); int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Age: "); int age = sc.nextInt();
        System.out.print("Enter Marks: "); double marks = sc.nextDouble();
        students.add(new Student(id, name, age, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        System.out.println("\nID | Name | Age | Marks");
        for(Student s : students) {
            System.out.println(s);
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: "); int id = sc.nextInt();
        for(Student s : students) {
            if(s.getId() == id) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: "); int id = sc.nextInt();
        sc.nextLine();
        for(Student s : students) {
            if(s.getId() == id) {
                System.out.print("Enter new Name: "); s.setName(sc.nextLine());
                System.out.print("Enter new Age: "); s.setAge(sc.nextInt());
                System.out.print("Enter new Marks: "); s.setMarks(sc.nextDouble());
                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: "); int id = sc.nextInt();
        for(Student s : students) {
            if(s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
