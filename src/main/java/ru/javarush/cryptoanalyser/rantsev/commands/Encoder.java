package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;
import ru.javarush.cryptoanalyser.rantsev.entity.ResultCode;

public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        //TODO need dev logic decrypt
        String txtFile = parameters[0];
        String encryptedFile = parameters[1];
        System.out.println("енкодер");
        return new Result(ResultCode.OK, "read all bytes");
    }
}
