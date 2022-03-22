package commands;

import managing.*;

@PointCommand(name = "help", description = "вывести справку по доступным командам")
public class CommandHelp extends NoArgsCommand {

    public CommandHelp(String command) {
        super(command);
    }

    public CommandHelp() {
        super();
    }

    @Override
    public void execute() {
        //String[] lst = CommandReflectionProcessor.listDeclaredCommands();
        System.out.println("The list of allowed commands: ");
        for (String s : CommandReflectionProcessor.commands) {
            Class<?> clazz;
            try {
                clazz = Class.forName(Vars.currentCommandFolderPath + "." + s);
            } catch (Exception e) {
                continue;
            }
            PointCommand annotation = clazz.getAnnotation(PointCommand.class);
            if (annotation != null) {
                try {
                    System.out.println("\t" + annotation.name() + ": " + annotation.description());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
