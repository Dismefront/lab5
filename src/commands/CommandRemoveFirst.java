package commands;

import managing.NoArgsCommand;
import managing.PointCommand;
import managing.Vars;

@PointCommand(name="remove_first", description = "удалить первый элемент из коллекции")
public class CommandRemoveFirst extends NoArgsCommand {
    public CommandRemoveFirst(String msg) {
        super(msg);
    }

    public CommandRemoveFirst() {
        super();
    }

    @Override
    public void execute() {
        Vars.curCol.removeFirst();
        System.out.println("First element has been removed");
    }
}
