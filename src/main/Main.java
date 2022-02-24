package main;

import commands.CommandExecuteScript;
import csv.FileHelper;
import managing.*;
import stored.*;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Samnier(Erik Romaikin)
 */

public class Main {

    public static void main(String ... args) {

        if (args.length != 0) {
            String filename = args[0];
            FileHelper.addFromCsvFile(filename);
        }

        while (true) {
            CommandReflectionProcessor.launchInput();
        }

    }

}
