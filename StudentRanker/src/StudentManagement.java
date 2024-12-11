import java.util.Random;

public class StudentManagement {
    private Student[] students; // Mảng lưu trữ sinh viên
    private int studentCount;   // Số lượng sinh viên hiện tại

    public StudentManagement(int capacity) {
        this.students = new Student[capacity]; // Khởi tạo mảng với dung lượng cố định
        this.studentCount = 0;                 // Ban đầu số lượng sinh viên là 0
    }

    public void addStudent(Student student) {
        if (studentCount >= students.length) {
            System.out.println("❌ Cannot add more students. The array is full.");
            return;
        }
        students[studentCount++] = student;
        System.out.println("✅ Student added: " + student);
    }

    public void generateRandomStudents(int count) {
        Random random = new Random();
        String[] names = {"Nguyen Van A", "Tran Thi B", "Le Van C", "Pham Thi D", "Hoang Van E", "Dang Thi F"};

        for (int i = 1; i <= count; i++) {
            if (studentCount >= students.length) {
                System.out.println("❌ Cannot generate more students. The array is full.");
                return;
            }
            int id = studentCount + 1; // ID tăng dần từ 1
            String name = names[random.nextInt(names.length)] + " " + id; // Tên ngẫu nhiên
            double marks = 1 + (9 * random.nextDouble()); // Điểm từ 1.0 đến 10.0
            addStudent(new Student(id, name, Math.round(marks * 100.0) / 100.0)); // Làm tròn đến 2 chữ số
        }
        System.out.println("✅ Đã tạo ngẫu nhiên " + count + " sinh viên.");
    }

    public void displayAll() {
        if (studentCount == 0) {
            System.out.println("❌ The student list is empty! Nothing to display.");
            return;
        }
        System.out.println("✅ List of all students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }

    public void updateStudent(int id, String newName, double newMarks) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                students[i] = new Student(id, newName, newMarks);
                System.out.println("✅ Updated student with ID: " + id);
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1]; // Dịch các phần tử sau lên
                }
                students[--studentCount] = null; // Giảm số lượng sinh viên
                System.out.println("✅ Deleted student with ID: " + id);
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }

    public Student searchStudent(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                System.out.println("✅ Found student: " + students[i]);
                return students[i];
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
        return null;
    }

    public void sortStudentsBubbleSort() {
        if (studentCount == 0) {
            System.out.println("❌ The student list is empty! Cannot sort.");
            return;
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (students[j].getMarks() < students[j + 1].getMarks()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("✅ Students sorted by marks in descending order using Bubble Sort.");
        System.out.println("⏱ Time taken: " + (endTime - startTime) + " ns.");
    }

    public void sortStudentsMergeSort() {
        if (studentCount == 0) {
            System.out.println("❌ The student list is empty! Cannot sort.");
            return;
        }
        long startTime = System.nanoTime();
        mergeSort(students, 0, studentCount - 1);
        long endTime = System.nanoTime();
        System.out.println("✅ Students sorted by marks in descending order using Merge Sort.");
        System.out.println("⏱ Time taken: " + (endTime - startTime) + " ns.");
    }

    private void mergeSort(Student[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(Student[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        for (int i = 0; i < n1; i++) leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++) rightArray[j] = array[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getMarks() >= rightArray[j].getMarks()) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < n1) array[k++] = leftArray[i++];
        while (j < n2) array[k++] = rightArray[j++];
    }
}
