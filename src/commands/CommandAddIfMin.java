package commands;

import managing.InputParser;
import managing.NoArgsCommand;
import managing.PointCommand;
import managing.Vars;
import stored.Worker;

import java.util.ArrayList;
import java.util.Collections;

@PointCommand(name="add_if_min", description = "добавить новый элемент в коллекцию, " +
        "если его значение меньше, чем у наименьшего элемента этой коллекции")
public class CommandAddIfMin extends NoArgsCommand {
    public CommandAddIfMin(String msg) {
        super(msg);
    }

    public CommandAddIfMin() {
        super();
    }

    @Override
    public void execute() {
        Worker w = InputParser.getWorkerFromInput();
        ArrayList<Worker> tmp = (ArrayList<Worker>) Vars.curCol.getCollection().clone();
        Collections.sort(tmp);
        if (tmp.size() == 0 || tmp.get(0).getSalary() > w.getSalary()) {
            Vars.curCol.add(w);
            System.out.println("Added into the collection");
            return;
        }
        System.out.println("The element is not the smallest in the collection");
    }
}
