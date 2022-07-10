package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
