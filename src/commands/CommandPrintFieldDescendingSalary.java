package commands;

import managing.NoArgsCommand;
import managing.PointCommand;
import managing.Vars;
import stored.Worker;

import java.util.ArrayList;
import java.util.Collections;

@PointCommand(name="print_field_descending_salary", description = "вывести значения поля " +
        "salary всех элементов в порядке убывания")
public class CommandPrintFieldDescendingSalary extends NoArgsCommand {
    public CommandPrintFieldDescendingSalary(String msg) {
        super(msg);
    }

    public CommandPrintFieldDescendingSalary() {
        super();
    }

    @Override
    public void execute() {
        ArrayList<Worker> tmp = (ArrayList<Worker>) Vars.curCol.getCollection().clone();
        Collections.sort(tmp);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            System.out.println(tmp.get(i).getSalary());
        }
    }
}
