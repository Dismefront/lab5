package exceptions;

public class WrongCommandException extends RuntimeException {

    private static String msg = "Could not find the command";

    public WrongCommandException(String msg) {
        super(msg);
    }

    public WrongCommandException() {
        super(msg);
    }

}
