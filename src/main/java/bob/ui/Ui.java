package bob.ui;

import bob.common.Messages;
import bob.data.task.Task;
import bob.data.task.Tasklist;
import bob.exceptions.BobException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * Represents the UI that interacts with the user.
 */
public class Ui {
    /** Divider to be display on UI */
    public static final String DIVIDER =
            "====================================================================="
                    + "========================================================\n";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private final Scanner in;
    private final PrintStream out;


    public Ui () {
        this(System.in, System.out);
    }

    public Ui (InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }


    /**
     * Reads user input.
     *
     * @return User input.
     */
    public String readCommand() {
        return in.nextLine();
    }

    /**
     * Shows Divider to user.
     */
    public void showDivider() {
        out.println(DIVIDER);
    }

    /**
     * Shows message(s) to user.
     *
     * @param message Message to be shown.
     */
    public void showToUser(String... message) {
        for (String m : message) {
            out.println(m.replace("\n", LS));
        }
    }

    /**
     * Shows introduction message to user.
     */
    public void showIntroMessage() {
        showToUser(
                DIVIDER,
                Messages.INTRO,
                DIVIDER
        );
    }

    /**
     * Shows exit message to user.
     */
    public void showExitMessage() {
        showToUser(
                Messages.OUTRO
        );
    }

    /**
     * Shows error message to user.
     *
     * @param e Exception caught.
     */
    public void showError(BobException e) {
        showToUser(e.toString());
    }

    /**
     * Shows add message to user.
     *
     * @param task Task to include in the message.
     * @param tasks Tasklist of Bob.
     */
    public void showAddMessage(Task task, Tasklist tasks) {
        // Starting line
        String start = Messages.ADD_MSG;
        // Task
        String taskMsg = task + "\n";
        // Ending line
        String end = "Currently you have " + tasks.getListSize() + " tasks in your list.\n";
        showToUser(start, taskMsg, end);
    }

    /**
     * Shows done message to user.
     *
     * @param task Task to include in the message.
     */
    public void showDoneMessage(Task task) {
        String taskMsg = task + "\n";
        showToUser(Messages.DONE_MSG, taskMsg);
    }

    /**
     * Shows delete message to user.
     * 
     * @param task
     */
    public void showDeleteMessage(Task task) {
        String taskMsg = "Deleted: " + task + "\n";
        showToUser(Messages.DELETE_MSG, taskMsg);
    }

    /**
     * Shows loading error to user.
     */
    public void showLoadingError() {
        showToUser(Messages.LOADING_ERROR);
    }

    /**
     * Shows updating error to user.
     */
    public void showUpdatingError() {
        showToUser(Messages.UPDATE_ERROR);
    }

    public void showTasksFoundMessage(String input, String tasksFound) {
        showToUser(Messages.findMessage(input), tasksFound);
    }

    public void showNoTaskFoundMessage(String input) {
        showToUser(Messages.noTaskFoundMessage(input));
    }


}
