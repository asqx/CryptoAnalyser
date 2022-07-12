package ru.javarush.cryptoanalyser.rantsev;

import ru.javarush.cryptoanalyser.rantsev.color.Colors;
import ru.javarush.cryptoanalyser.rantsev.controller.Actions;
import java.util.Scanner;

public class Menu {
    private final Scanner console;
    public Menu(Scanner console) {
        this.console = console;
    }
    public void callMenu(String command) {
        System.out.println("----------------" + Colors.ANSI_PURPLE);
        System.out.println("Please select mode:" + Colors.ANSI_CYAN);
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt" + Colors.ANSI_BLACK);
        System.out.println("----------------");
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
