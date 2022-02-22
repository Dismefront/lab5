package managing;
import exceptions.WrongCommandException;
import maintain.Pair;
import java.util.ArrayList;

public class ArgsCommand extends Command {

    protected String action;
    protected ArrayList<String> args;

    public ArgsCommand(String command) {
        super(command);
        this.distributeCommand();
    }

    public static String description() {
        return "Command with args";
    }

    public ArgsCommand() {
        super();
    }

    private void distributeCommand() {
        Pair<String, ArrayList<String>> p = CommandParser.getSplit(this.command);
        this.action = p.first();
        this.args = p.second();
    }

    @Override
    public void execute() {
        throw new WrongCommandException();
    }

}
