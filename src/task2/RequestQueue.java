package task2;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

/**
 * The Originator and Receiver class (RequestQueue).
 * It holds the state (requests) and executes the core business logic (Receiver methods).
 * It creates and restores Mementos (Originator methods).
 */
public class RequestQueue {
    private List<HttpRequest> requests = new ArrayList<>();

    /**
     * Adds a request to the queue and re-sorts by priority.
     * @param request The request to add.
     */
    public void addRequest(HttpRequest request) {
        requests.add(request);
        requests.sort(Comparator.comparingInt(HttpRequest::getPriority).reversed());
    }

    /**
     * Removes a request from the queue by ID. (Receiver method)
     * @param id The ID of the request to remove.
     */
    public void removeRequest(int id) {
        requests.removeIf(r -> r.getId() == id);
    }

    /**
     * Changes the priority of a request by ID and re-sorts the queue. (Receiver method)
     * @param id The ID of the request.
     * @param newPriority The new priority value.
     */
    public void changePriority(int id, int newPriority) {
        Optional<HttpRequest> requestOpt = requests.stream()
                .filter(r -> r.getId() == id)
                .findFirst();

        requestOpt.ifPresent(r -> {
            r.setPriority(newPriority);
            requests.sort(Comparator.comparingInt(HttpRequest::getPriority).reversed());
        });
    }

    /**
     * Creates a Memento to save the current state of the queue. (Originator method)
     * @return A new RequestQueueMemento object with a deep copy of the state.
     */
    public RequestQueueMemento createMemento() {
        // Create a deep copy of the list for the memento state
        List<HttpRequest> stateCopy = new ArrayList<>();
        for (HttpRequest req : requests) {
            stateCopy.add(new HttpRequest(req.getId(), req.url, req.getPriority(), req.method));
        }
        return new RequestQueueMemento(stateCopy);
    }

    /**
     * Restores the queue state from a Memento. (Originator method)
     * @param memento The memento to restore from.
     */
    public void restoreMemento(RequestQueueMemento memento) {
        this.requests = memento.getSavedState();
    }

    /**
     * Displays the current state of the request queue.
     */
    public void displayState() {
        System.out.println("Current Queue State (" + requests.size() + " requests):");
        requests.forEach(r -> System.out.println("  " + r));
    }
}