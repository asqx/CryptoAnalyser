package ru.javarush.cryptoanalyser.rantsev.console;

import ru.javarush.cryptoanalyser.rantsev.controller.MainController;
import ru.javarush.cryptoanalyser.rantsev.exception.ConsoleAppException;
import ru.javarush.cryptoanalyser.rantsev.utility.ParametersCheck;


import java.util.Arrays;

public class ConsoleApp {
    private final MainController mainController;
    private final Menu menu;
    public ConsoleApp(MainController mainController, Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }
    public void run(String[] args) {
            //Without parameters in the console
            if (args.length == 0) {
                String[] run = menu.getArgs();
                String command = run[0];
                String[] parameters = Arrays.copyOfRange(run, 1,run.length);
                mainController.execute(command, parameters);
            } else if (args.length == 4){
                //With parameters from the console
                ParametersCheck parametersCheck = new ParametersCheck();
                String[] verifiedArgs = parametersCheck.checkArgs(args);
                String command = verifiedArgs[0];
                String[] parameters = Arrays.copyOfRange(verifiedArgs, 1, verifiedArgs.length);
                mainController.execute(command, parameters);
            } else {
                throw new ConsoleAppException(Message.PARAMETERS);
            }
    }
}
