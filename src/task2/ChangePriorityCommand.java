package task2;

/**
 * Concrete Command to change the priority of an HTTP request in the queue.
 * Saves the state before execution (Memento) to enable undo functionality.
 */
public class ChangePriorityCommand implements Action {
    private final RequestQueue receiver;
    private RequestQueueMemento beforeState;
    private final int requestId;
    private final int newPriority;

    /**
     * Constructs the command.
     * @param receiver The RequestQueue instance (Receiver).
     * @param requestId The ID of the request whose priority to change.
     * @param newPriority The new priority value.
     */
    public ChangePriorityCommand(RequestQueue receiver, int requestId, int newPriority) {
        this.receiver = receiver;
        this.requestId = requestId;
        this.newPriority = newPriority;
    }

    /**
     * {@inheritDoc}
     * Saves the Memento and calls the Receiver's changePriority method.
     */
    @Override
    public void execute() {
        beforeState = receiver.createMemento(); // 1. Save Memento (Originator)
        receiver.changePriority(requestId, newPriority); // 2. Execute operation (Receiver)
        System.out.println("[EXECUTE] Command: Change priority of request ID: " + requestId + " to " + newPriority);
    }

    /**
     * {@inheritDoc}
     * Restores the Receiver's state using the saved Memento.
     */
    @Override
    public void undo() {
        if (beforeState != null) {
            receiver.restoreMemento(beforeState); // 3. Restore previous state
            System.out.println("[UNDO] Command: Restored state (Undo Change Priority ID: " + requestId + ").");
        } else {
            System.out.println("[UNDO] Cannot undo Change Priority Command: Memento not available.");
        }
    }
}