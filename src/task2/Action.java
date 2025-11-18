package task2;

/**
 * The Command interface (Action).
 * Declares methods for executing and undoing an operation.
 */
public interface Action {
    /**
     * Executes the command, performing the specific operation on the Receiver.
     */
    void execute();

    /**
     * Undoes the effect of the previously executed command, restoring the state.
     */
    void undo();
}