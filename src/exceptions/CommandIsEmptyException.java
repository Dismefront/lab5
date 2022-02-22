package exceptions;

public class CommandIsEmptyException extends WrongCommandException {

    private static String msg = "The command entered is empty";

    public CommandIsEmptyException() {
        super(msg);
    }

}
