package commands;

import managing.NoArgsCommand;
import managing.PointCommand;
import managing.Vars;

@PointCommand(name="clear", description = "очистить коллекцию")
public class CommandClear extends NoArgsCommand {
    public CommandClear(String msg) {
        super(msg);
    }

    public CommandClear() {
        super();
    }

    @Override
    public void execute() {
        Vars.curCol.clear();
    }
}
