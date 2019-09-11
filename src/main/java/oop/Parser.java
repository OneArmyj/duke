package oop;

import commands.AddCommand;
import commands.Command;
import commands.DeleteCommand;
import commands.DoneCommand;
import commands.ExitCommand;
import commands.FindCommand;
import commands.PrintCommand;

import exceptions.DukeException;
import exceptions.InvalidCommandException;

/**
 * The Parser class makes sense of the user command taken in, it
 * decides the next methods executed by the application.
 */
public class Parser {
    /**
     * A static method used for reading in user command and deciding
     * the next method to be executed.
     * @param commandText The command text entered by a user.
     * @return Returns the corresponding type of Command to be executed.
     * @throws DukeException Possibility of throwing a DukeException due to
     *      an exception occurring in the running of the application.
     */
    public static Command parse(String commandText) throws DukeException {
        String[] arr = commandText.split(" ", 2);
        String command = arr[0];

        switch (command) {
        case "list":
            return new PrintCommand();

        case "done":
            return new DoneCommand(commandText);

        case "delete":
            System.out.println(arr[1]);
            return new DeleteCommand(arr[1]);

        case "todo":
            return new AddCommand(arr[0], arr[1]);

        case "deadline":
            return new AddCommand(arr[0], arr[1]);

        case "event":
            return new AddCommand(arr[0], arr[1]);

        case "bye":
            return new ExitCommand();

        case "find":
            return new FindCommand(arr[1]);

        default :
            throw new InvalidCommandException("I'm sorry, but I don't know what that means :-(");
        }
    }
}

