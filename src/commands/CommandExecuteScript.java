package commands;

import managing.ArgsCommand;
import managing.CommandReflectionProcessor;
import managing.PointCommand;
import managing.Vars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
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

    private static HashMap<File, Boolean> files = new HashMap<>();

    @Override
    public void execute() {
        try {
            File file = new File(System.getProperty("user.dir")
                    + "/src/" + Vars.currentFilePath + "/" + args.get(0));
            if (files.containsKey(file)) {
                System.out.println("Recursion found.");
                return;
            }
            System.out.println(file + " started executing...");
            files.put(file, Boolean.TRUE);
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                CommandReflectionProcessor.launchInput(sc);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Couldn't find file");
            return;
        }
        files.clear();
        System.out.println("Script finished executing");
    }
}
