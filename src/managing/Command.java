package managing;

import exceptions.WrongCommandException;

public abstract class Command implements CommandExecutable {

    protected String command;
    protected boolean isExecutable;

    public Command() {
        this(null);
    }

    public Command(String command) {
        this.isExecutable = setCommand(command);
    }

    private boolean setCommand(String cm) {
        try {
            CommandParser.checkCommandCorrectness(cm);
        }
        catch (WrongCommandException e) {
            System.out.println("Wrong command (" + e.getMessage() + ")");
            return false;
        }
        this.command = cm;
        return true;
    }

    /**
     * The execution method
     */
    public abstract void execute();

}
