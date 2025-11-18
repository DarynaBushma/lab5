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

        // Initial setup: Create HTTP requests and add them (sorted by priority)
        System.out.println("--- Initial Setup ---");
        queue.addRequest(new HttpRequest(101, "/data/report", 3, "GET"));
        queue.addRequest(new HttpRequest(102, "/users/new", 1, "POST"));
        queue.addRequest(new HttpRequest(103, "/logs/recent", 5, "GET"));
        queue.displayState();

        // 1. Execute a command to remove a request (Saves Memento before action)
        Action removeCmd = new RemoveRequestCommand(queue, 102);
        manager.executeCommand(removeCmd);
        queue.displayState();

        // 2. Execute a command to change priority (Saves Memento before action)
        Action changePrioCmd = new ChangePriorityCommand(queue, 101, 7);
        manager.executeCommand(changePrioCmd);
        queue.displayState();

        // --- Demonstrate Undo (Restoring previous states) ---

        // 3. Undo the Change Priority command (restores state before priority change)
        manager.undoLastCommand();
        queue.displayState(); // Queue state is restored to Prio 3 for 101

        // 4. Undo the Remove command (restores state before removal)
        manager.undoLastCommand();
        queue.displayState(); // Queue state is restored to having all 3 initial requests

        manager.undoLastCommand(); // Should print "Command History is empty..."
    }
}