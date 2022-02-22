package commands;

import managing.NoArgsCommand;
import managing.PointCommand;
import managing.Vars;

@PointCommand(name="sort", description = "отсортировать коллекцию в естественном порядке")
public class CommandSort extends NoArgsCommand {
    public CommandSort(String msg) {
        super(msg);
    }

    public CommandSort() {
        super();
    }

    @Override
    public void execute() {
        Vars.curCol.sort();
    }
}
