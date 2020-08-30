package bob.parser;

import bob.commands.Command;
import bob.commands.DeadlineCommand;
import bob.commands.DeleteCommand;
import bob.commands.DoneCommand;
import bob.commands.EventCommand;
import bob.commands.ExitCommand;
import bob.commands.FindCommand;
import bob.commands.ListCommand;
import bob.commands.TodoCommand;
import bob.exceptions.BobEmptyFindException;
import bob.exceptions.BobEmptyTaskException;
import bob.exceptions.BobInvalidCommandException;

/**
 * Tool to parse user input into commands.
 */
public class Parser {
    /**
     * Handles user input which decides which command Bob executes.
     *
     * @param input User input.
     * @return Updated Bob.
     * @throws BobInvalidCommandException If user input is not recognised.
     * @throws BobEmptyTaskException If there is no task description.
     * @throws BobEmptyFindException If there is no input for the search.
     */
    public static Command parse(String input)
            throws BobInvalidCommandException, BobEmptyTaskException, BobEmptyFindException {
        if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.equals("list")) {
            return new ListCommand();
        } else if (input.length() >= 4 && input.startsWith("done")) {
            return new DoneCommand(input.substring(4));
        } else if (input.length() >= 6 && input.startsWith("delete")) {
            return new DeleteCommand(input.substring(6));
        } else if (input.length() >= 4 && input.startsWith("todo")) {
            return new TodoCommand(input.substring(4));
        } else if (input.length() >= 5 && input.startsWith("event")) {
            return new EventCommand(input.substring(5));
        } else if (input.length() >= 8 && input.startsWith("deadline")) {
            return new DeadlineCommand(input.substring(8));
        } else if (input.length() >= 4 && input.startsWith("find")) {
            return new FindCommand(input.substring((4)));
        // If user's command is invalid/not recognisable by Bob
        } else {
            throw new BobInvalidCommandException();
        }
    }
}
