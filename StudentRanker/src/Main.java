import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement(10000); // Giới hạn 1000 sinh viên

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT MENU ===");
            System.out.println("1. Add Student");
            System.out.println("2. Generate Random Students");
            System.out.println("3. Display All Students");
             System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Search Student");
            System.out.println("7. Sort Students using Bubble Sort");
            System.out.println("8. Sort Students using Merge Sort");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    scanner.nextLine(); // consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    management.addStudent(new Student(id, name, marks));
                    break;
                case 2:
                    System.out.print("Enter number of students to generate: ");
                    int count = scanner.nextInt();
                    management.generateRandomStudents(count);
                    break;
                case 3:
                    management.displayAll();
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    id = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    marks = scanner.nextDouble();
                    management.updateStudent(id, name, marks);
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    id = scanner.nextInt();
                    management.deleteStudent(id);
                    break;
                case 6:
                    System.out.print("Enter ID to search: ");
                    id = scanner.nextInt();
                    management.searchStudent(id);
                    break;
                case 7:
                    management.sortStudentsBubbleSort();
                    break;
                case 8:
                    management.sortStudentsMergeSort();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Invalid option! Please choose again.");
            }
        }
    }
}
