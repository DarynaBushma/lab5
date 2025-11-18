package task1;

/**
 * The Visitor interface (UniversityVisitor).
 * Declares a visit method for each concrete element type in the University structure.
 */
public interface UniversityVisitor {
    /**
     * Visits a Student element.
     * @param student The Student object to be visited.
     */
    void visitStudent(Student student);

    /**
     * Visits a Teacher element.
     * @param teacher The Teacher object to be visited.
     */
    void visitTeacher(Teacher teacher);

    /**
     * Visits a Department element.
     * @param department The Department object to be visited.
     */
    void visitDepartment(Department department);

    /**
     * Visits a University element.
     * @param university The University object to be visited.
     */
    void visitUniversity(University university);
}