package task1;

/**
 * A Concrete Element (Student).
 * Implements the accept operation to call the appropriate visit method on the visitor.
 */
public class Student implements UniversityElement {
    public final int studentID; // Made public for visitor access
    private final String name;

    /**
     * Constructs a Student.
     * @param name The student's name.
     * @param studentID The student's ID.
     */
    public Student(String name, int studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    /**
     * Gets the student's name.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(UniversityVisitor visitor) {
        visitor.visitStudent(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void coreBusinessOperation() {
        // Implementation of business logic (stub)
        System.out.println("Method 'coreBusinessOperation' of Student '" + name + "' called.");
    }
}