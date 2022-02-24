package managing;

import maintain.Pair;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
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

    public static boolean launchInput() {
        Scanner scanner = Vars.globalScanner;
        String inp = scanner.nextLine();
        Pair<String, ArrayList<String>> command = CommandParser.getSplit(inp);

        String[] lst = listDeclaredCommands();
        for (String s : lst) {
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
