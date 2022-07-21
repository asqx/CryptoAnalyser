package ru.javarush.cryptoanalyser.rantsev.controller;

import ru.javarush.cryptoanalyser.rantsev.commands.Action;
import ru.javarush.cryptoanalyser.rantsev.entity.Result;
import ru.javarush.cryptoanalyser.rantsev.entity.ResultCode;
import ru.javarush.cryptoanalyser.rantsev.exception.ConsoleAppException;

public class MainController {
    public void execute(String command, String[] parameters) {
        try {
            Action action = Actions.find(command);
            action.execute(parameters);
        } catch (ConsoleAppException e) {
            new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
