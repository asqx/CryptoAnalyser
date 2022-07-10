package ru.javarush.cryptoanalyser.rantsev.controller;

import ru.javarush.cryptoanalyser.rantsev.commands.Action;
import ru.javarush.cryptoanalyser.rantsev.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        return action.execute(parameters);
    }
}
