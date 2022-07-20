package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Analyse implements Action {
    public static String sourceText;
    char[] arrays = {'с', 'т', 'н', 'и', 'а', 'е', 'о', ' '};
    @Override
    public Result execute(String[] parameters) {
        TreeMap <Integer, char[]> source = new TreeMap<>();
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
                            if (source.size() < 8) {
                                source.put(count, new char[]{aChar});
                            }
                } 
        }catch (IOException e) {
            System.out.println();
        }
        //getStatistic(source);
        for (int key: source.keySet()) {
            char[] value = source.get(key);
                System.out.println(key + " ---> " + Arrays.toString(value));
        }
        return null;
    }
//    public static void getStatistic(TreeMap<Integer, Character> source) {
//        String text = sourceText.replace(source.get(Collections.max(source.keySet())), ' ');
//        String text1 = text.replace(source.get(), 'о');
//        System.out.println(text1);
//
//    }
}
