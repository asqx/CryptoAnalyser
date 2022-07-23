package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;
import ru.javarush.cryptoanalyser.rantsev.entity.ResultCode;
import ru.javarush.cryptoanalyser.rantsev.console.Messages;
import ru.javarush.cryptoanalyser.rantsev.utility.PathFinder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Bruteforce implements Action{
    int count;
    int resultKey;
    @Override
    public void execute(String[] parameters) {
        String root = PathFinder.getRoot();
        Map<Integer, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(root + parameters[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(root + parameters[1]))) {
            while (reader.ready()) {
                //Read text line by line from an array
                String line = reader.readLine();
                char[] chars = line.toCharArray();
                for (int key = 0; key < 44; key++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (chars.length > 10000) {
                        count = 500;
                    } else {
                        count = 0;
                    }
                    //Set bottom border based on text size
                    for (int i = 0; i < ((chars.length%10000) + count); i++) {
                        char symbol = (char)((int)chars[i] - key);
                        stringBuilder.append(symbol);
                        map.put(key, stringBuilder.toString());
                    }
                }
                for (int key: map.keySet()) {
                    String value = map.get(key);
                    //In 44 options, we search by words, and write down the desired key
                    if (value.contains(". ") ||
                            value.contains(", ") ||
                            value.contains(" и ") ||
                            value.contains(" а ") ||
                            value.contains(", но")) {
                        resultKey = key;
                    }
                }
                for (char aChar : chars) {
                    writer.write((char)((int) aChar - resultKey));
                }
            }
        } catch (IOException e) {
            System.err.println(Messages.FILE_NO_FIND);
        }
        new Result(ResultCode.OK, "File is ready");
    }
}
