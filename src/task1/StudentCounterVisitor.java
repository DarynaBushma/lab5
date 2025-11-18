package task1;

/**
 * A Concrete Visitor (StudentCounterVisitor).
 * Implements the logic to count the total number of Student elements.
 */
public class StudentCounterVisitor implements UniversityVisitor {
    private int studentCount = 0;

    /**
     * {@inheritDoc}
     * Increments the student count.
     */
    @Override
    public void visitStudent(Student student) {
        studentCount++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitTeacher(Teacher teacher) {
        // No action for Teacher
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitDepartment(Department department) {
        // No action for Department count
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitUniversity(University university) {
        // No action for University count
    }

    /**
     * Gets the total number of students counted.
     * @return The student count.
     */
    public int getStudentCount() {
        return studentCount;
    }
}