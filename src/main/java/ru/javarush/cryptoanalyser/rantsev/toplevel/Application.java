package ru.javarush.cryptoanalyser.rantsev.toplevel;

import ru.javarush.cryptoanalyser.rantsev.controller.MainController;
import ru.javarush.cryptoanalyser.rantsev.utility.ParametersCheck;


import java.util.Arrays;

public class Application {
    private final MainController mainController;
    private final Menu menu;
    public Application(MainController mainController, Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }
    public void run(String[] args) {
            if (args.length == 0) {
                String[] run = menu.getArgs();
                String command = run[0];
                String[] parameters = Arrays.copyOfRange(run, 1,run.length);
                mainController.execute(command, parameters);
            } else if (args.length == 4){
                ParametersCheck parametersCheck = new ParametersCheck();
                parametersCheck.checkArgs(args);
                String command = args[0];
                String[] parameters = Arrays.copyOfRange(args, 1, args.length);
                mainController.execute(command, parameters);
            } else {
                System.err.println(Message.PARAMETERS);
            }
    }
}
