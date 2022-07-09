package ru.javarush.cryptoanaliser.rantsev.commands;

import ru.javarush.cryptoanaliser.rantsev.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
