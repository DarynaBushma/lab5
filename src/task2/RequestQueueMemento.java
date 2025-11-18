package task2;

import java.util.List;
import java.util.ArrayList;

/**
 * The Memento object that stores the internal state of the RequestQueue (Originator).
 * It holds a snapshot of the requests list, preserving encapsulation.
 */
public class RequestQueueMemento {
    // Stores a deep copy of the requests list at a certain point in time.
    private final List<HttpRequest> state;

    /**
     * Creates a Memento, taking a snapshot of the current requests list.
     * @param state The list of requests to save.
     */
    public RequestQueueMemento(List<HttpRequest> state) {
        this.state = state; // The list passed in the constructor should already be a deep copy
    }

    /**
     * Gets the saved state (requests list).
     * Access is implicitly restricted to the Originator (RequestQueue) conceptually.
     * @return The saved state.
     */
    public List<HttpRequest> getSavedState() {
        return state;
    }
}