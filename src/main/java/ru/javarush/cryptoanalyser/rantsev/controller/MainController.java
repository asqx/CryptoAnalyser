package ru.javarush.cryptoanalyser.rantsev.controller;

import ru.javarush.cryptoanalyser.rantsev.commands.Action;
import ru.javarush.cryptoanalyser.rantsev.entity.Result;
import ru.javarush.cryptoanalyser.rantsev.entity.ResultCode;
import ru.javarush.cryptoanalyser.rantsev.exception.ApplicationException;

public class MainController {
    public Result execute(String command, String[] parameters) {
        try {
            Action action = Actions.find(command);
            return action.execute(parameters);
        } catch (ApplicationException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
