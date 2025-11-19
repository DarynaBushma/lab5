package task1;

/**
 * The main Composite Element (University).
 * Extends Department to hold the top-level structure.
 */
public class University extends Department {

    /**
     * Constructs a University.
     * @param name The university's name.
     */
    public University(String name) {
        super(name);
    }

    /**
     * {@inheritDoc}
     * Overrides accept to call the specific visitUniversity method.
     */
    @Override
    public void accept(UniversityVisitor visitor) {
        visitor.visitUniversity(this);
        for (UniversityElement element : getElements()) {
            element.accept(visitor);
        }
    }
}