package exceptions;

public class CommandIsNullException extends WrongCommandException {

    private static String msg = "The command entered leads to the null pointer";

    public CommandIsNullException() {
        super(msg);
    }

}
