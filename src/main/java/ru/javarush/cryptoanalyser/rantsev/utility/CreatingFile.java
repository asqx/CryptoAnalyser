package ru.javarush.cryptoanalyser.rantsev.utility;

import ru.javarush.cryptoanalyser.rantsev.toplevel.Message;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreatingFile {
    private static String consoleReader;
    boolean createTxt (Scanner console, String[] args){
        consoleReader = console.nextLine();
        try {
            if (consoleReader.isEmpty()) {
                File fileTxt = new File(PathFinder.getRoot());
                if (fileTxt.createNewFile() || fileTxt.isFile()) {
                    args[1] = fileTxt.getName();
                    return true;
                } else {
                    return false;
                }
            }
        } catch (IOException e) {
            System.err.println(Message.FILE_CREATED);
        }
        return false;
    }

    boolean createStandardFile(Scanner console, String[] args, String[] files, int mode) {
        consoleReader = console.nextLine();
        try {
            if (consoleReader.isEmpty()) {
                File fileStandard = new File(PathFinder.getRoot(mode, files));
                if (fileStandard.createNewFile() || fileStandard.isFile()) {
                    args[2] = fileStandard.getName();
                    return true;
                } else {
                    return false;
                }
            }
        } catch (IOException e) {
            System.err.println(Message.FILE_CREATED);
        }
        return false;
    }
    public static String getConsoleReader() {
        return consoleReader;
    }
}
