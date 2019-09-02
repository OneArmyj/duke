/**
 * The Task class handles all types of tasks a user will input.
 */
public abstract class Task {
    /**
     * The description of the task.
     */
    protected String description;

    /**
     * A boolean to represent the status of the task, true if completed,
     false if not completed.
     */
    protected boolean isDone;

    /**
     * Constructs and initializes the attributes of a new Task object.
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    /**
     * Constructs and initializes the attributes of a new Task object.
     * @param description Description of the task.
     * @param checker Checks the status of the task recorded.
     */
    public Task(String description, String checker) {
        this.description = description;
        this.isDone = (checker.equals("1")) ? true : false;
    }

    /**
     * Marks the task as completed.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Returns the icon representing the status of the Task.
     * @return Returns 1 if done, 0 if not done.
     */
    protected String getStatusIcon() {
        return isDone ? "1" : "0";
    }

    /**
     * Prints the task in the desired format for storing in text file.
     * @return Returns formatted String representing Task.
     */
    public abstract String getFormattedString();

    /**
     * Overrides the underlying Object toString method to print Task in
     the desired format to show to users.
     * @return Returns formatted String representing Task.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), description);
    }
}
