package managing;

import commands.CommandSave;
import maintain.Pair;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CommandReflectionProcessor {

    public static String[] listDeclaredCommands() {
        File folder = new File(System.getProperty("user.dir")
                + "/src/" + Vars.currentCommandFolderPath);
        File[] fileList = folder.listFiles();
        String[] result = new String[fileList.length];
        int counter = 0;
        for (File f : fileList) {
            String className = f.getName().split("\\.")[0];
            result[counter] = className;
            counter++;
        }
        return result;
    }

    public static String[] commands = {
            "CommandAdd",
            "CommandAddIfMin",
            "CommandClear",
            "CommandCountBySalary",
            "CommandExecuteScript",
            "CommandExit",
            "CommandHelp",
            "CommandInfo",
            "CommandPrintDescending",
            "CommandPrintFieldDescendingSalary",
            "CommandRemoveById",
            "CommandRemoveFirst",
            "CommandSave",
            "CommandShow",
            "CommandSort",
            "CommandUpdateId"
    };

    public static boolean launchInput(Scanner scanner) {
        String inp = "";
        try {
            inp = scanner.nextLine();
        }
        catch (Exception ex) {
            new CommandSave().execute();
            System.exit(0);
        }
        Pair<String, ArrayList<String>> command = CommandParser.getSplit(inp);

        //String[] lst = listDeclaredCommands();
        for (String s : commands) {
            Class<?> clazz;
            try {
                clazz = Class.forName(Vars.currentCommandFolderPath + "." + s);
            } catch (Exception e) {
                continue;
            }
            PointCommand annotation = clazz.getAnnotation(PointCommand.class);
            if (annotation != null && annotation.name().equals(command.first())) {

                try {
                    Command c = (Command)clazz.getConstructor(String.class).newInstance(inp);
                    c.execute();
                    return true;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println("Wrong command input");
        return false;
    }

}
