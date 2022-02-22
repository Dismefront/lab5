package commands;

import managing.ArgsCommand;
import managing.InputParser;
import managing.PointCommand;
import managing.Vars;
import stored.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

@PointCommand(name="update", description = "обновить значение элемента " +
        "коллекции, id которого равен заданному")
public class CommandUpdateId extends ArgsCommand {
    public CommandUpdateId(String command) {
        super(command);
    }

    public CommandUpdateId() {
        super();
    }

    @Override
    public void execute() {
        String q = this.args.get(0);
        Long r;
        try {
            r = Long.parseLong(q);
        }
        catch (Exception e) {
            System.out.println("Wrong command argument");
            return;
        }
        Worker w = InputParser.getWorkerFromInput();
        w.setId(r);
        Vars.curCol.updateId(w);
    }

}
