package ru.javarush.cryptoanalyser.rantsev.toplevel;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;
import ru.javarush.cryptoanalyser.rantsev.controller.MainController;



import java.util.Arrays;

public class Application {
    private final MainController mainController;
    private final Menu menu;




    public Application(MainController mainController, Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }
    public Result run(String[] args) {
        if (args.length == 0) {
            menu.callMenu();
        }
            String command = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainController.execute(command, parameters);
    }
}
