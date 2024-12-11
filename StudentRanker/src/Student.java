public class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        String rank = getRank();
        return "Student [ID=" + id + ", Name=" + name + ", Marks=" + marks + ", Rank=" + rank + "]";
    }
    private String getRank() {
        if (marks < 5) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9) return "Very Good";
        return "Excellent";
    }
}