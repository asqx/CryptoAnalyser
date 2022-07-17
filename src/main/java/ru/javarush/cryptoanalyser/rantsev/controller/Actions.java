package ru.javarush.cryptoanalyser.rantsev.controller;

import ru.javarush.cryptoanalyser.rantsev.commands.*;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new Bruteforce()),
    ANALYSE(new Analyse());



    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
