package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;
import ru.javarush.cryptoanalyser.rantsev.entity.ResultCode;
import ru.javarush.cryptoanalyser.rantsev.toplevel.Message;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Bruteforce implements Action{
    int count;
    int resultKey;
    @Override
    public Result execute(String[] parameters) {
        Map<Integer, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(parameters[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(parameters[1]))) {
            while (reader.ready()) {
                String line = reader.readLine();
                char[] chars = line.toCharArray();
                for (int key = 0; key < 44; key++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (chars.length > 10000) {
                        count = 500;
                    } else {
                        count = 0;
                    }
                    for (int i = 0; i < ((chars.length%10000) + count); i++) {
                        char symbol = (char)((int)chars[i] - key);
                        stringBuilder.append(symbol);
                        map.put(key, stringBuilder.toString());
                    }
                }
                for (int key: map.keySet()) {
                    String value = map.get(key);

                    if (value.contains(". ") || value.contains(", ") || value.contains(" и ") || value.contains(" а ") || value.contains(", но")) {
                        resultKey = key;
                    }
                }
                for (char aChar : chars) {
                    writer.write((char) ((int) aChar - resultKey));
                }
            }
        } catch (IOException e) {
            System.err.println(Message.FILE_NO_FIND);
        }
        return new Result(ResultCode.OK, "File is ready");
    }
}
