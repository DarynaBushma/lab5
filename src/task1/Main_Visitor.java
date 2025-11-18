package task1;

/**
 * Client class demonstrating the use of the Visitor pattern (Variant 3).
 * Creates the University structure and applies various visitors (operations) to it.
 */
public class Main_Visitor {
    /**
     * Main method to run the demonstration.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // 1. Create Hierarchical University Structure
        University university = new University("National Technical University of Ukraine");

        Department csDept = new Department("Computer Science");
        csDept.addElement(new Teacher("Ivanov V.", 15000.0));
        csDept.addElement(new Teacher("Petrova O.", 14500.0));
        csDept.addElement(new Student("Taras S.", 1001));
        csDept.addElement(new Student("Anna M.", 1002));

        Department mathDept = new Department("Applied Mathematics");
        mathDept.addElement(new Teacher("Sidorov K.", 16000.0));
        mathDept.addElement(new Student("Yurii P.", 2001));

        university.addElement(csDept);
        university.addElement(mathDept);

        // --- Demonstrate Operations via Visitors ---

        // 2. Execute Student Counting Operation
        System.out.println("--- Operation 1: Student Counter ---");
        StudentCounterVisitor counter = new StudentCounterVisitor();
        university.accept(counter);
        System.out.println("Total students in the university: " + counter.getStudentCount());

        // 3. Execute Salary Sum Operation (New Operation without modifying Element classes)
        System.out.println("\n--- Operation 2: Teacher Salary Sum ---");
        SalarySumVisitor salarySum = new SalarySumVisitor();
        university.accept(salarySum);
        System.out.println("Total monthly salary for teachers: " + salarySum.getTotalSalary() + " UAH");

        // 4. Execute Display Structure Operation (Another New Operation)
        System.out.println("\n--- Operation 3: Display Structure ---");
        DisplayStructureVisitor display = new DisplayStructureVisitor();
        university.accept(display);

        // Demonstrate placeholder business logic
        System.out.println("\n--- Placeholder Business Logic Demo ---");
        university.coreBusinessOperation();
    }
}