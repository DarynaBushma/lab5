package task2;

import java.util.Stack;

/**
 * The Invoker and Caretaker class (CommandManager).
 * It stores and executes Command objects (Invoker).
 * It manages the history of Mementos for Undo (Caretaker).
 */
public class CommandManager {
    // Stores history of executed commands for Undo
    private final Stack<Action> history = new Stack<>();

    /**
     * Executes a command and adds it to the history stack.
     * @param command The command to execute.
     */
    public void executeCommand(Action command) {
        System.out.println("\n--- Executing Command: " + command.getClass().getSimpleName() + " ---");
        command.execute();
        history.push(command);
    }

    /**
     * Undoes the last executed command by calling its undo() method.
     * The command is popped from the history stack.
     */
    public void undoLastCommand() {
        if (!history.isEmpty()) {
            Action lastCommand = history.pop();
            System.out.println("\n--- Undoing Command: " + lastCommand.getClass().getSimpleName() + " ---");
            lastCommand.undo();
        } else {
            System.out.println("\n--- Command History is empty. Undo is not possible. ---");
        }
    }
}