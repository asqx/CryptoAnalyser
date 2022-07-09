package ru.javarush.cryptoanaliser.rantsev.controller;

import ru.javarush.cryptoanaliser.rantsev.commands.Action;
import ru.javarush.cryptoanaliser.rantsev.commands.Decoder;
import ru.javarush.cryptoanaliser.rantsev.commands.Encoder;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
