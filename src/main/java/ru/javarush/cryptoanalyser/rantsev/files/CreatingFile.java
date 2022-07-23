package ru.javarush.cryptoanalyser.rantsev.files;

import ru.javarush.cryptoanalyser.rantsev.exception.ConsoleAppException;
import static ru.javarush.cryptoanalyser.rantsev.console.Messages.*;
import ru.javarush.cryptoanalyser.rantsev.utility.PathFinder;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreatingFile extends CreatingPath {
    private String args;
    private String[] files;
    private int mode;
    String root = PathFinder.getRoot();

    public CreatingFile(String args) {
        this.args = args;
    }

    public CreatingFile(String args, String[] files, int mode) {
        this.args = args;
        this.files = files;
        this.mode = mode;
    }

    @Override
    String reviewingPath(String args) {
        return super.reviewingPath(args);
    }

    String createTxt (){
        Scanner scanner = new Scanner(System.in);
        String console = scanner.nextLine();

        try {
            if (console.isEmpty()) {
                File fileTxt = new File(root + "text.txt");
                if (fileTxt.createNewFile() || fileTxt.isFile()) {
                    args = fileTxt.getName();
                    return args;
                    }
                }
            if (!console.isEmpty()) {
                File fileTxt = new File(root + console);
                if (fileTxt.isFile()) {
                    args = fileTxt.getName();
                } else {
                    reviewingPath(console);
                }
                return args;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        throw new ConsoleAppException(FILE_PROCESS);
    }

    String createStandardFile() {
        Scanner scanner = new Scanner(System.in);
        String console = scanner.nextLine();
        try {
            if (console.isEmpty()) {
                File fileStandard = new File(root + files[mode]);
                if (fileStandard.createNewFile() || fileStandard.isFile()) {
                    args = fileStandard.getName();
                    return args;
                }
            }
            if (!console.isEmpty()) {
                File fileStandard = new File(root + console);
                if (fileStandard.isFile()) {
                    args = fileStandard.getName();
                } else {
                    reviewingPath(console);
                }
                return args;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        throw new ConsoleAppException(FILE_PROCESS);
    }
}
