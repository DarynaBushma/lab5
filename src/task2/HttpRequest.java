package task2;

/**
 * Represents an HTTP request object within the queue.
 * Stores request information (URL, method, priority, ID).
 */
public class HttpRequest {
    private final int id;
    public final String url; // Made public for deep copy in Memento
    public final String method; // Made public for deep copy in Memento
    private int priority;

    /**
     * Constructs an HttpRequest.
     * @param id The unique identifier of the request.
     * @param url The target URL.
     * @param priority The processing priority (higher value means higher priority).
     * @param method The HTTP method (GET, POST, etc.).
     */
    public HttpRequest(int id, String url, int priority, String method) {
        this.id = id;
        this.url = url;
        this.priority = priority;
        this.method = method;
    }

    /**
     * Gets the request ID.
     * @return The ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the current priority.
     * @return The priority value.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets a new priority for the request.
     * @param priority The new priority value.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Prio: " + priority + ", URL: " + url + ", Method: " + method;
    }
}