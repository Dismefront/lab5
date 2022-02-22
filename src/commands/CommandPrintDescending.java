package commands;

import managing.NoArgsCommand;
import managing.PointCommand;
import managing.Vars;
import stored.Worker;

import java.util.ArrayList;
import java.util.Collections;

@PointCommand(name="print_descending", description = "вывести элементы коллекции в порядке убывания")
public class CommandPrintDescending extends NoArgsCommand {
    public CommandPrintDescending(String msg) {
        super(msg);
    }

    public CommandPrintDescending() {
        super();
    }

    @Override
    public void execute() {
        ArrayList<Worker> tmp = (ArrayList<Worker>) Vars.curCol.getCollection().clone();
        Collections.sort(tmp);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            System.out.println(tmp.get(i));
        }
    }
}
