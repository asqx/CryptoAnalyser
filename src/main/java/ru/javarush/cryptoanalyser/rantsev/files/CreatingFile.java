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
    private final String root = PathFinder.getRoot();
    private File file;

    public CreatingFile(String args) {
        this.args = args;
    }

    public CreatingFile(String args, String[] files, int mode) {
        this.args = args;
        this.files = files;
        this.mode = mode;
    }
    @Override
    String reviewingPath(String console) {
        return super.reviewingPath(console);
    }
    public String createTxt (){
        Scanner scanner = new Scanner(System.in);
        String console = scanner.nextLine();
        try {
            if (console.isEmpty()) {
                file = new File(root + "text.txt");
                if (file.createNewFile() || file.isFile()) {
                    args = file.getName();
                    return args;
                    }
                }
            if (!console.isEmpty()) {
                return reviewingPath(console);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        throw new ConsoleAppException(FILE_PROCESS);
    }

    public String createStandardFile() {
        Scanner scanner = new Scanner(System.in);
        String console = scanner.nextLine();
        System.out.println(root);
        try {
            if (console.isEmpty()) {
                file = new File(root + files[mode]);
                if (file.createNewFile() || file.isFile()) {
                    args = file.getName();
                    return args;
                }
            }
            if (!console.isEmpty()) {
                return reviewingPath(console);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        throw new ConsoleAppException(FILE_PROCESS);
    }
}
