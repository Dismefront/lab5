package main;

import commands.CommandExecuteScript;
import csv.FileHelper;
import managing.*;
import stored.*;

import java.io.File;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Dismefront(Erik Romaikin)
 */

public class Main {

    public static void main(String ... args) {

        if (args.length != 0) {
            String filename = args[0];
            try {
                FileHelper.addFromCsvFile(filename);
            }
            catch (Exception ex) {
                System.out.println("Couldn't find input file");
            }
        }
        System.out.println(Vars.saveFile);

        while (true) {
            CommandReflectionProcessor.launchInput(Vars.globalScanner);
        }

    }

}
