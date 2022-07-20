package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;
import ru.javarush.cryptoanalyser.rantsev.entity.ResultCode;
import ru.javarush.cryptoanalyser.rantsev.toplevel.Message;
import ru.javarush.cryptoanalyser.rantsev.utility.PathFinder;

import java.io.*;

public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        String root = PathFinder.getRoot();
        int key = Integer.parseInt(parameters[2]);
        if (key > 44) {
            key = key%44;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(root + parameters[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(root + parameters[1]))) {
            while (reader.ready()) {
                int line = reader.read();
                writer.write((char)(line - key));
            }
        } catch (IOException e) {
            System.err.println(Message.FILE_NO_FIND);
        }
        return new Result(ResultCode.OK, "File is ready");
    }
}
