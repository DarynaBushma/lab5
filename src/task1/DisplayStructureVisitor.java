package task1;

/**
 * A Concrete Visitor (DisplayStructureVisitor).
 * Implements the logic to display the hierarchical structure of the university elements.
 */
public class DisplayStructureVisitor implements UniversityVisitor {
    private int depth = 0;

    /**
     * Helper method to print text with indentation based on the current depth.
     * @param text The text to print.
     */
    private void print(String text) {
        System.out.println("  ".repeat(depth) + text);
    }

    /**
     * {@inheritDoc}
     * Prints University, then increases depth for children.
     */
    @Override
    public void visitUniversity(University university) {
        print("[U] " + university.getName());
        depth++;
    }

    /**
     * {@inheritDoc}
     * Prints Department, then increases depth for children.
     */
    @Override
    public void visitDepartment(Department department) {
        depth--; // Decrease depth from previous composite's increase
        print("  - [D] " + department.getName() + " Department");
        depth++; // Increase depth for current composite's children
    }

    /**
     * {@inheritDoc}
     * Prints Teacher info.
     */
    @Override
    public void visitTeacher(Teacher teacher) {
        print("    - [T] Teacher: " + teacher.getName() + " (" + teacher.getSalary() + " UAH)");
    }

    /**
     * {@inheritDoc}
     * Prints Student info.
     */
    @Override
    public void visitStudent(Student student) {
        print("    - [S] Student: " + student.getName() + " (ID: " + student.studentID + ")");
    }
}