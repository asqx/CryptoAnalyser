package ru.javarush.cryptoanalyser.rantsev.toplevel;

import ru.javarush.cryptoanalyser.rantsev.utility.FileGeneration;
import ru.javarush.cryptoanalyser.rantsev.utility.ShiftKey;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner console;
    private static Map<Integer, String> commands;
    private static String[] files;
    public Menu(Scanner console) {
        this.console = console;
    }

    public static void callMenu() {
        System.out.println(Message.DASH + Message.ANSI_PURPLE);
        System.out.println(Message.SELECT_MODE + Message.ANSI_CYAN);
        System.out.println(Message.CHOICE_ENCRYPT);
        System.out.println(Message.CHOICE_DECRYPT);
        System.out.println(Message.CHOICE_BRUTEFORCE);
        System.out.println(Message.CHOICE_ANALYSE);
        System.out.println(Message.CHOICE_EXIT + Message.ANSI_BLACK);
        System.out.println(Message.DASH);
    }

    public String[] getArgs() {
        int mode = getMode(console);
        if (mode == 4) {
            System.exit(0);
        }
        FileGeneration fileGeneration = new FileGeneration();
        ShiftKey shiftKey = new ShiftKey();
        addCommands();
        String[] args = new String[commands.size() - 1];
        for (Map.Entry<Integer, String> pair : commands.entrySet()) {
            Integer numberCommand = pair.getKey();
            String strCommand = pair.getValue();
            if (numberCommand == mode) {
                args[0] = strCommand;
            }
        }
        addFiles();
        System.out.println(Message.SOURCE_SELECTION + Message.ANSI_RED);
        System.out.println(Message.WARNING + Message.ANSI_GREEN);
        fileGeneration.getInputFile(args);
        System.out.println(Message.SUCCESSFULLY + Message.ANSI_BLACK);
        System.out.println();
        System.out.println(Message.SOURCE_DESTINATION + "\s" + files[mode] + ")" + Message.ANSI_RED);
        System.out.println(Message.WARNING + Message.ANSI_GREEN);
        fileGeneration.getOutputFiles(files, args, mode);
        System.out.print(Message.SUCCESSFULLY + Message.ANSI_BLACK);
        if (mode == 0 || mode == 1) {
            System.out.println(Message.SOURCE_KEY + Message.ANSI_RED);
            System.out.println(Message.KEY_WARNING + Message.ANSI_GREEN);
            shiftKey.getKey(args);
            System.out.println(Message.KEY_SUCCESSFULLY + Message.ANSI_BLACK);
        }
        return args;
    }

    public static int getMode(Scanner console) {
        callMenu();
        int mode;
        do {
            String input = console.nextLine();
            mode = switch (input) {
                case "1" -> 0;
                case "2" -> 1;
                case "3" -> 2;
                case "4" -> 3;
                case "5" -> 4;
                default -> {
                    System.err.println(Message.ERROR_COMMAND);
                    callMenu();
                    yield -1;
                }
            };
        } while (mode < 0);
        return mode;
    }

    public static void addCommands() {
        commands = new HashMap<>();
        commands.put(0, "encode");
        commands.put(1, "decode");
        commands.put(2, "bruteforce");
        commands.put(3, "analyse");
        commands.put(4, "exit");
    }

    public static void addFiles() {
        files = new String[commands.size() - 1];
        for (int i = 0; i < files.length; i++) {
            files[i] = commands.get(i) + Message.FILE_FORMAT;
        }
    }
    public static Map<Integer, String> getCommands() {
        return commands;
    }
}

