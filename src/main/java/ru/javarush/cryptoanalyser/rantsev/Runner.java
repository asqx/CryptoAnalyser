package ru.javarush.cryptoanalyser.rantsev;

import ru.javarush.cryptoanalyser.rantsev.toplevel.Application;
import ru.javarush.cryptoanalyser.rantsev.controller.MainController;
import ru.javarush.cryptoanalyser.rantsev.toplevel.Menu;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Menu menu = new Menu(console);
        MainController mainController = new MainController();
        Application application = new Application(mainController, menu);
        application.run(args);
    }
}
