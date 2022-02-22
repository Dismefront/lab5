package commands;

import managing.NoArgsCommand;
import managing.PointCommand;

@PointCommand(name = "exit", description = "завершить программу (без сохранения в файл)")
public class CommandExit extends NoArgsCommand {

    public CommandExit(String msg) {
        super(msg);
    }

    public CommandExit() {
        super();
    }

    @Override
    public void execute() {
        System.exit(0);
    }

}
