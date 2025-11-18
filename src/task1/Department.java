package task1;

import java.util.List;
import java.util.ArrayList;

/**
 * A Composite Element (Department).
 * Implements the accept operation and iterates over its children to call their accept methods.
 */
public class Department implements UniversityElement {
    private final String name;
    private final List<UniversityElement> elements = new ArrayList<>();

    /**
     * Constructs a Department.
     * @param name The department's name.
     */
    public Department(String name) {
        this.name = name;
    }

    /**
     * Adds an element (Student, Teacher, or another Department) to the department.
     * @param element The element to add.
     */
    public void addElement(UniversityElement element) {
        elements.add(element);
    }

    /**
     * Gets the department's name.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of elements within the department.
     * @return The list of elements.
     */
    public List<UniversityElement> getElements() {
        return elements;
    }

    /**
     * {@inheritDoc}
     * Calls visitDepartment on the visitor, then recursively calls accept on all child elements.
     */
    @Override
    public void accept(UniversityVisitor visitor) {
        visitor.visitDepartment(this);
        for (UniversityElement element : elements) {
            element.accept(visitor);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void coreBusinessOperation() {
        // Implementation of business logic (stub)
        System.out.println("Method 'coreBusinessOperation' of Department '" + name + "' called.");
        for (UniversityElement element : elements) {
            element.coreBusinessOperation();
        }
    }
}