package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;
import ru.javarush.cryptoanalyser.rantsev.entity.ResultCode;

public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        int key = Integer.parseInt(parameters[2]);
        if (key > 44) {
            key = key%44;
        }
        Cypher cypher = new Cypher(parameters[0], parameters[1], -key);
        cypher.caesarCypher();
        return new Result(ResultCode.OK, "File is ready");
    }
}
