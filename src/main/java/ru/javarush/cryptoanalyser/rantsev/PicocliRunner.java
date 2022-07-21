package ru.javarush.cryptoanalyser.rantsev;

import picocli.CommandLine;
import ru.javarush.cryptoanalyser.rantsev.controller.MainController;
import ru.javarush.cryptoanalyser.rantsev.picocli.PicocliApp;

public class PicocliRunner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        PicocliApp application = new PicocliApp(mainController);

        Picocli command = new Picocli(application);
        CommandLine commandLine = new CommandLine(command);
        int exitCode = commandLine.execute(args);
    }
}
