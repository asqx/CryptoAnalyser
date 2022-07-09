package ru.javarush.cryptoanaliser.rantsev.controller;

import ru.javarush.cryptoanaliser.rantsev.commands.Action;
import ru.javarush.cryptoanaliser.rantsev.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        return action.execute(parameters);
    }
}
