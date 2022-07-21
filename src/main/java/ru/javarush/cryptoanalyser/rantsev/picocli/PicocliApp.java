package ru.javarush.cryptoanalyser.rantsev.picocli;

import ru.javarush.cryptoanalyser.rantsev.controller.MainController;
import ru.javarush.cryptoanalyser.rantsev.utility.ParametersCheck;
import java.util.Arrays;

public class PicocliApp {
    private final MainController mainController;
    public PicocliApp(MainController mainController) {
        this.mainController = mainController;
    }
    public void run (String[] args) {
        if (args.length == 4) {
            ParametersCheck parametersCheck = new ParametersCheck();
            String[] verifiedArgs = parametersCheck.checkArgs(args);
            String command = verifiedArgs[0];
            String[] parameters = Arrays.copyOfRange(verifiedArgs, 1, verifiedArgs.length);
            mainController.execute(command, parameters);
        }
    }
}
