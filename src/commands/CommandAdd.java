package commands;

import managing.*;
import stored.*;

import java.io.Console;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

@PointCommand(name = "add", description = "добавить новый элемент в коллекцию")
public class CommandAdd extends NoArgsCommand {

    public CommandAdd(String command) {
        super(command);
    }

    public CommandAdd() {
        super();
    }

    @Override
    public void execute() {
        Worker w = InputParser.getWorkerFromInput();
        Vars.curCol.add(w);
        System.out.println("Successfully added");
    }

}
