package ru.javarush.cryptoanaliser.rantsev.commands;

import ru.javarush.cryptoanaliser.rantsev.entity.Result;
import ru.javarush.cryptoanaliser.rantsev.entity.ResultCode;

public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        //TODO need dev logic decrypt
        String txtFile = parameters[0];
        String encryptedFile = parameters[0];
        return new Result(ResultCode.OK, "read all bytes");
    }
}
