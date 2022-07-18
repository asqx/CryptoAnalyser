package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Analyse implements Action {
    String sourceText;
    @Override
    public Result execute(String[] parameters) {
        TreeMap <Integer, Character> source = new TreeMap<>();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(parameters[1]))) {
            sourceText = Files.readString(Paths.get(parameters[0]));
            char[] chars = sourceText.toCharArray();
            int count;
            System.out.println("Length: " + chars.length);
            for (char aChar : chars) {
                count = 0;
                for (char c : chars) {
                    if (aChar == c) {
                        count += 1;
                    }
                }
                source.put(count, aChar);
            }
        } catch (IOException e) {
            System.out.println();
        }
        for (int key: source.keySet()) {
            char count = source.get(key);
            System.out.println(key + " ---> " + count);
        }
        getStatistic(source);
        return null;
    }

    void getStatistic(TreeMap<Integer, Character> source) {
        String targexText;
        int max = Collections.max(source.keySet());
        targexText = sourceText.replace(source.get(max), ' ');
        for (int i = max; i < source.size(); i--) {
            targexText = sourceText.replace(source.get(i), 'о');
            targexText = sourceText.replace(source.get(i - 1), 'е');
            break;
        }
        System.out.println(targexText);
    }
}
