package commands;

import managing.ArgsCommand;
import managing.PointCommand;
import managing.Vars;
import stored.Worker;

@PointCommand(name="count_by_salary", description = "вывести количество элементов, " +
        "значение поля salary которых равно заданному")
public class CommandCountBySalary extends ArgsCommand {
    public CommandCountBySalary(String command) {
        super(command);
    }

    public CommandCountBySalary() {
        super();
    }

    @Override
    public void execute() {
        String q = this.args.get(0);
        Long r;
        try {
            r = Long.parseLong(q);
        }
        catch (Exception e) {
            System.out.println("Wrong command argument");
            return;
        }
        int cnt = 0;
        for (Worker it : Vars.curCol) {
            if (it.getSalary() == r)
                cnt++;
        }
        System.out.println("The number of elements with " + r + " salary: " + cnt);
    }
}
