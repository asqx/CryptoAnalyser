package ru.javarush.cryptoanalyser.rantsev.console;

import ru.javarush.cryptoanalyser.rantsev.files.FileGeneration;
import ru.javarush.cryptoanalyser.rantsev.utility.ShiftKey;
import static ru.javarush.cryptoanalyser.rantsev.console.Messages.*;

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
        System.out.println("\n" +ANSI_BLUE + WELCOME + ANSI_BLACK + "\n");
        System.out.println(DASH + Messages.ANSI_PURPLE);
        System.out.println(SELECT_MODE + Messages.ANSI_CYAN);
        System.out.println(CHOICE_ENCRYPT);
        System.out.println(CHOICE_DECRYPT);
        System.out.println(CHOICE_BRUTEFORCE);
        System.out.println(CHOICE_ANALYSE);
        System.out.println(CHOICE_EXIT + ANSI_BLACK);
        System.out.println(DASH);
    }

    public String[] getArgs() {
        int mode = getMode(console);
        //If we choose exit, then immediately close the program
        if (mode == 4) {
            System.exit(0);
        }
        ShiftKey shiftKey = new ShiftKey();
        //We add standard commands, that is, in the future it will be possible to add them without breaking the logic
        addCommands();
        String[] args = new String[commands.size() - 1];
        for (Map.Entry<Integer, String> pair : commands.entrySet()) {
            Integer numberCommand = pair.getKey();
            String strCommand = pair.getValue();
            if (numberCommand == mode) {
                args[0] = strCommand;
            }
        }
        //We add standard files, that is, in the future it will be possible to add them without breaking the logic
        addFiles();
        if (mode == 3) {
            System.out.println("\n" + ANSI_RED + WARNING + ANSI_BLACK + "\n");
            System.out.println(ANSI_YELLOW + WARNING_WAIT + ANSI_BLACK + "\n");
        }
        System.out.println(SOURCE_SELECTION + ANSI_GREEN);
        //Processing and generating files for reading
        FileGeneration fileInput = new FileGeneration(args);
        fileInput.getInputFile();

        System.out.println("\n" + SUCCESSFULLY + ANSI_BLACK + "\n");
        System.out.println(SOURCE_DESTINATION + "\s" + files[mode] + ")" + ANSI_GREEN);

        //Processing and generating files for recording
        FileGeneration fileOutput = new FileGeneration(files, args, mode);
        fileOutput.getOutputFiles();

        System.out.println("\n" + SUCCESSFULLY + ANSI_BLACK + "\n");
        //Keys are available only to encoder and decoder, the rest do not need them
        if (mode == 0 || mode == 1) {
            System.out.println(SOURCE_KEY + ANSI_RED);
            System.out.println(KEY_WARNING + ANSI_GREEN);
            shiftKey.getKey(args);
            System.out.println("\n" + KEY_SUCCESSFULLY + ANSI_BLACK + "\n");
        }
        return args;
    }

    public static int getMode(Scanner console) {
        //Choose one of 5 modes, otherwise repeat the menu call
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
                    System.err.println(ERROR_COMMAND);
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
            files[i] = commands.get(i) + FILE_FORMAT;
        }
    }
    public static Map<Integer, String> getCommands() {
        return commands;
    }
}

