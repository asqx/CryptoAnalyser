package ru.javarush.cryptoanalyser.rantsev.controller;

import ru.javarush.cryptoanalyser.rantsev.commands.Action;
import ru.javarush.cryptoanalyser.rantsev.commands.Decoder;
import ru.javarush.cryptoanalyser.rantsev.commands.Encoder;

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
