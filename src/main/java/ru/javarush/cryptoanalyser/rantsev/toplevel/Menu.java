package ru.javarush.cryptoanalyser.rantsev.toplevel;

import ru.javarush.cryptoanalyser.rantsev.controller.Actions;
import java.util.Scanner;

public class Menu {
    private final Scanner console;
    public Menu(Scanner console) {
        this.console = console;
    }
    public void callMenu(String command) {
        System.out.println("-------------------" + Message.ANSI_PURPLE);
        System.out.println("Please select mode:" + Message.ANSI_CYAN);
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt" + Message.ANSI_BLACK);
        System.out.println("-------------------");
        while (console.hasNextInt()) {
            int numbers = console.nextInt();
            switch (numbers) {
                case 1,2,3,4 -> {
                    Actions.find(command);
                    return;
                }
            }
        }
    }
}
