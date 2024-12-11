public class StudentStack {
    private Student[] stack;
    private int top;
    private int capacity;

    public StudentStack(int capacity) {
        this.capacity = capacity;
        this.stack = new Student[capacity];
        this.top = -1;
    }

    public void push(Student student) {
        if (top == capacity - 1) {
            System.out.println("❌ Stack is full! Cannot add more students.");
            return;
        }
        stack[++top] = student;
        System.out.println("✅ Student added to the stack.");
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("❌ Stack is empty! Nothing to remove.");
            return null;
        }
        System.out.println("✅ Student removed from the stack.");
        return stack[top--];
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("❌ Stack is empty! No student at the top.");
            return null;
        }
        System.out.println("✅ Student at the top of the stack: " + stack[top]);
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("❌ Stack is empty! No students to display.");
            return;
        }
        System.out.println("✅ Students in the stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
