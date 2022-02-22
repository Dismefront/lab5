package commands;

import managing.ArgsCommand;
import managing.CommandReflectionProcessor;
import managing.PointCommand;
import managing.Vars;

import java.io.File;
import java.util.Scanner;

@PointCommand(name="execute_script", description = "считать и исполнить скрипт из указанного файла. " +
        "В скрипте содержатся команды в таком же виде, " +
        "в котором их вводит пользователь в интерактивном режиме")
public class CommandExecuteScript extends ArgsCommand {
    public CommandExecuteScript(String command) {
        super(command);
    }

    public CommandExecuteScript() {
        super();
    }

    @Override
    public void execute() {
        try {
            File file = new File(System.getProperty("user.dir")
                    + "/src/" + Vars.currentFilePath + "/" + args.get(0));
            Vars.globalScanner = new Scanner(file);
            while (Vars.globalScanner.hasNext()) {
                CommandReflectionProcessor.launchInput();
            }
            Vars.globalScanner = new Scanner(System.in);
        }
        catch (Exception e) {
            System.out.println("Couldn't find file");
            return;
        }
        System.out.println("Script finished executing");
    }
}
