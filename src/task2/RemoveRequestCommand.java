package task2;

/**
 * Concrete Command to remove an HTTP request from the queue.
 * Saves the state before execution (Memento) to enable undo functionality.
 */
public class RemoveRequestCommand implements Action {
    private final RequestQueue receiver;
    private RequestQueueMemento beforeState;
    private final int requestId;

    /**
     * Constructs the command.
     * @param receiver The RequestQueue instance (Receiver).
     * @param requestId The ID of the request to remove.
     */
    public RemoveRequestCommand(RequestQueue receiver, int requestId) {
        this.receiver = receiver;
        this.requestId = requestId;
    }

    /**
     * {@inheritDoc}
     * Saves the Memento and calls the Receiver's remove method.
     */
    @Override
    public void execute() {
        beforeState = receiver.createMemento();
        receiver.removeRequest(requestId);
        System.out.println("[EXECUTE] Command: Remove request with ID: " + requestId);
    }

    /**
     * {@inheritDoc}
     * Restores the Receiver's state using the saved Memento.
     */
    @Override
    public void undo() {
        if (beforeState != null) {
            receiver.restoreMemento(beforeState);
            System.out.println("[UNDO] Command: Restored state (Undo Remove ID: " + requestId + ").");
        } else {
            System.out.println("[UNDO] Cannot undo Remove Command: Memento not available.");
        }
    }
}