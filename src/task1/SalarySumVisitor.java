package task1;

/**
 * A Concrete Visitor (SalarySumVisitor).
 * Implements the logic to calculate the total salary of all Teacher elements.
 */
public class SalarySumVisitor implements UniversityVisitor {
    private double totalSalary = 0.0;

    /**
     * {@inheritDoc}
     * Adds the teacher's salary to the total sum.
     */
    @Override
    public void visitTeacher(Teacher teacher) {
        totalSalary += teacher.getSalary();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitStudent(Student student) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitDepartment(Department department) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitUniversity(University university) {
    }

    /**
     * Gets the calculated total salary.
     * @return The total salary.
     */
    public double getTotalSalary() {
        return totalSalary;
    }
}