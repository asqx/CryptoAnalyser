package ru.javarush.cryptoanalyser.rantsev.toplevel;

import ru.javarush.cryptoanalyser.rantsev.controller.Actions;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private final Scanner console;
    private String[] args;
    public Menu(Scanner console) {
        this.console = console;
    }
    public void callMenu() {
        System.out.println("-------------------" + Message.ANSI_PURPLE);
        System.out.println("Please select mode:" + Message.ANSI_CYAN);
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt" + Message.ANSI_BLACK);
        System.out.println("-------------------");
        while (console.hasNextInt()) {
            int numbers = console.nextInt();
            switch (numbers) {
                case 1 -> {
                    Actions.getCommand("encode");
                    return;
                }
                case 2 -> {
                    Actions.getCommand("decode");
                    return;
                }
            }
        }
    }
    public void getArgs(String[] args) {
            if (args[0].equals("encode") && args[0] != null) {
                this.args[0] = args[0];
            } else if (args[0].equals("decode") && args[0] != null) {
                this.args[0] = args[0];
            } else {
                System.err.println("Command not found");
            }
            if (args[1].endsWith(".txt") && args[2].endsWith(".txt")) {
                this.args[1] = args[1];
                this.args[2] = args[2];
            } else {
                System.err.println("Source/write file extension is incorrect");
            }
    }
}
