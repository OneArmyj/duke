import commands.Command;

import exceptions.DukeException;

import oop.Parser;
import oop.Storage;
import oop.Ui;

import tasks.TaskList;

/**
 * Duke is the main class of the app, where the execution command exists.
 */
public class Duke {
    /**
     * A Storage attribute to deal with reading data from files or writing data
     to files.
     */
    private Storage storage;

    /**
     * A TaskList attribute to keep a list of all the tasks the user inputs.
     */
    private TaskList tasks;

    /**
     * A Ui attribute to deal with all display and print showed to the user.
     */
    private Ui ui;

    /**
     * Constructs and initializes the attributes of a new Duke object.
     */
    public Duke() {
        this.storage = new Storage("data\\duke.txt");
        this.ui = new Ui();
        try {
            this.tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError(e);
            tasks = new TaskList();
        }
    }

    /**
    * A method to begin the application.
    */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.checkExit();
            } catch (DukeException e) {
                ui.showError(e);
            }
        }
    }

    /**
     * A method to retrieve the necessary String output after the Application parses the user's input.
     * @param input The input by the user.
     * @return
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (DukeException e) {
            return ui.showError(e);
        }
    }

    /**
     * main method for the program to execute.
     * @param args Takes in an array of Strings as arguments.
     */
    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.run();
    }
}
