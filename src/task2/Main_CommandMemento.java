package task2;

/**
 * Client class demonstrating the Command and Memento patterns (Variant 3).
 * Initializes the RequestQueue, uses CommandManager to execute operations, and performs Undo.
 */
public class Main_CommandMemento {
    /**
     * Main method to run the demonstration.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        CommandManager manager = new CommandManager();

        System.out.println("--- Initial Setup ---");
        queue.addRequest(new HttpRequest(101, "/data/report", 3, "GET"));
        queue.addRequest(new HttpRequest(102, "/users/new", 1, "POST"));
        queue.addRequest(new HttpRequest(103, "/logs/recent", 5, "GET"));
        queue.displayState();

        Action removeCmd = new RemoveRequestCommand(queue, 102);
        manager.executeCommand(removeCmd);
        queue.displayState();

        Action changePrioCmd = new ChangePriorityCommand(queue, 101, 7);
        manager.executeCommand(changePrioCmd);
        queue.displayState();

        manager.undoLastCommand();
        queue.displayState();

        manager.undoLastCommand();
        queue.displayState();

        manager.undoLastCommand();
    }
}