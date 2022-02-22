package commands;

import managing.ArgsCommand;
import managing.PointCommand;
import managing.Vars;

@PointCommand(name="remove_by_id", description = "удалить элемент из коллекции по его id")
public class CommandRemoveById extends ArgsCommand {

    public CommandRemoveById(String command) {
        super(command);
    }

    public CommandRemoveById() {
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
        Vars.curCol.removeById(r);
    }

}
