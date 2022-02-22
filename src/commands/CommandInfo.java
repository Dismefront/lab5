package commands;

import managing.NoArgsCommand;
import managing.PointCommand;
import managing.Vars;

@PointCommand(name="info", description="вывести в стандартный поток вывода информацию о коллекции " +
        "(тип, дата инициализации, количество элементов и т.д.)")
public class CommandInfo extends NoArgsCommand {

    public CommandInfo(String msg) {
        super(msg);
    }

    public CommandInfo() {
        super();
    }

    @Override
    public void execute() {
        System.out.println(Vars.curCol.getInfo());
    }
}
