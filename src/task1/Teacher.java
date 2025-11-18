package task1;

/**
 * A Concrete Element (Teacher).
 * Implements the accept operation to call the appropriate visit method on the visitor.
 */
public class Teacher implements UniversityElement {
    private final String name;
    private final double salary;

    /**
     * Constructs a Teacher.
     * @param name The teacher's name.
     * @param salary The teacher's monthly salary.
     */
    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * Gets the teacher's name.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the teacher's salary.
     * @return The salary amount.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(UniversityVisitor visitor) {
        visitor.visitTeacher(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void coreBusinessOperation() {
        // Implementation of business logic (stub)
        System.out.println("Method 'coreBusinessOperation' of Teacher '" + name + "' called. Salary: " + salary);
    }
}