package commands;

import managing.NoArgsCommand;
import managing.PointCommand;
import managing.Vars;
import stored.Worker;

@PointCommand(name="show", description = "вывести в стандартный поток вывода все " +
        "элементы коллекции в строковом представлении")
public class CommandShow extends NoArgsCommand {
    public CommandShow(String msg) {
        super(msg);
    }

    public CommandShow() {
        super();
    }

    @Override
    public void execute() {
        if (Vars.curCol.isEmpty())
            System.out.println("The collection is empty");
        for (Worker it : Vars.curCol)
            System.out.println(it);
    }
}
