package managing;

import collection.WorkerCollection;

import java.util.Scanner;

/**
 * Contains all global variables used everywhere
 */

public class Vars {
    public final static String currentFilePath;
    public final static String currentCommandFolderPath;
    public static WorkerCollection curCol;
    public static Scanner globalScanner;
    public static String saveFile;

    static {
        currentCommandFolderPath = "commands";
        currentFilePath = "files";
        curCol = new WorkerCollection();
        globalScanner = new Scanner(System.in);
        saveFile = "output.csv";
    }

}
