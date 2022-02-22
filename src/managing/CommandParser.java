package managing;

import exceptions.CommandIsEmptyException;
import exceptions.CommandIsNullException;
import exceptions.WrongCommandException;
import maintain.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandParser {

    public static void checkCommandCorrectness(String msg) throws WrongCommandException {
        if (isNull(msg))
            throw new CommandIsNullException();
        if (msg.isBlank())
            throw new CommandIsEmptyException();
    }

    private static boolean isNull(String msg) {
        return msg == null;
    }

    public static Pair<String, ArrayList<String>> getSplit(String command) {
        String[] parsed = command.strip().split(" ");
        String c = parsed[0];
        ArrayList<String> na = new ArrayList<>();
        for (int i = 1; i < parsed.length; i++)
            na.add(parsed[i]);
        return new Pair<>(parsed[0], na);
    }

}
