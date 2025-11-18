package task1;

/**
 * The Element interface (UniversityElement).
 * Declares the accept operation which takes a Visitor as an argument.
 */
public interface UniversityElement {
    /**
     * Accepts a visitor, allowing the visitor to operate on this element.
     * The method determines which visit method in the visitor to call.
     * @param visitor The visitor object to accept.
     */
    void accept(UniversityVisitor visitor);

    /**
     * Placeholder for the element's core business logic method.
     */
    void coreBusinessOperation();
}