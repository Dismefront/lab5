package managing;

import exceptions.WrongCommandException;

public class NoArgsCommand extends Command {

    public NoArgsCommand(String msg) {
        super(msg);
    }

    public NoArgsCommand() {
        super();
    }

    @Override
    public void execute() {
        throw new WrongCommandException();
    }

}
