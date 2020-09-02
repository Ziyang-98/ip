package bob.commands;

import java.io.IOException;

import bob.common.MsgGenerator;
import bob.data.task.Task;
import bob.data.task.Tasklist;
import bob.exceptions.BobEmptyTaskException;
import bob.storage.Storage;

/**
 * Adds a task to Bob's tasklist.
 */
public class TodoCommand extends Command {
    private final String input;

    /**
     * Creates a todo command.
     *
     * @param input User input.
     * @throws BobEmptyTaskException If there is no description for task.
     */
    public TodoCommand(String input) throws BobEmptyTaskException {
        if (input.trim().length() == 0) {
            throw new BobEmptyTaskException();
        }

        this.input = input.startsWith(" ")
                    ? input.substring(1)
                    : input;
    }


    @Override
    public boolean isExited() {
        return false;
    }

    /**
     * Executes todo command.
     *
     * @param tasks Bob's tasklist.
     * @param storage Bob's storage.
     * @throws IOException If an error occurs while updating file.
     */
    @Override
    public String execute(Tasklist tasks, Storage storage) throws IOException {
        Task task = new Task(this.input);
        tasks.addTask(task);
        tasks.updateData(storage);
        return MsgGenerator.generateAddMessage(task, tasks);
    }
}
