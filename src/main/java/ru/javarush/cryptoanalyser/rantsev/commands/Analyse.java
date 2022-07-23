package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.entity.Result;
import ru.javarush.cryptoanalyser.rantsev.entity.ResultCode;
import ru.javarush.cryptoanalyser.rantsev.utility.PathFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Analyse implements Action {
    private final Map<Integer, Character> statistic = new TreeMap<>();
    private final TreeMap <Integer, Character> source = new TreeMap<>();

    @Override
    public void execute(String[] parameters) {
        String root = PathFinder.getRoot();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(root + parameters[1]))) {
            String sourceText = Files.readString(Paths.get(root + parameters[0]));
            char[] chars = sourceText
                    .toLowerCase()
                    .toCharArray();
            int count;
                for (char aChar : chars) {
                    count = 0;
                    for (char c : chars) {
                        if (aChar == c) {
                            count += 1;
                        }
                    }
                    if (source.size() < 44) {
                        source.put(count, aChar);
                    }
                }
                getStatistic();
                List<Map.Entry<Integer, Character>> sourceArray = new ArrayList<>(source.entrySet());
            List<Map.Entry<Integer, Character>> statisticArray = new ArrayList<>(statistic.entrySet());

            Map<Integer, Character> analyse = new TreeMap<>();
            for (int i = 0; i < sourceArray.size() && i < statisticArray.size(); i++) {
                analyse.put(sourceArray.get(i).getKey(), statisticArray.get(i).getValue());
            }

            for (int keySource: source.keySet()) {
                char sourceSymbol = source.get(keySource);
                for (int keyAnalyse: analyse.keySet()) {
                    char analyseSymbol = analyse.get(keyAnalyse);
                    for (int i = 0; i < chars.length; i++) {
                        if (sourceSymbol == chars[i] && keySource == keyAnalyse) {
                            chars[i] = analyseSymbol;
                        }
                    }
                }
            }
            writer.write(new String(chars));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        new Result(ResultCode.OK, "File is ready");
    }
    void getStatistic() {
        statistic.put(0, ')');
        statistic.put(1, ':');
        statistic.put(2, '"');
        statistic.put(3, 'ф');
        statistic.put(4, 'ё');
        statistic.put(5, '…');
        statistic.put(6, '?');
        statistic.put(7, 'ц');
        statistic.put(8, '!');
        statistic.put(9, 'э');
        statistic.put(10, '-');
        statistic.put(11, 'щ');
        statistic.put(12, 'ю');
        statistic.put(13, 'ш');
        statistic.put(14, 'ж');
        statistic.put(15, 'й');
        statistic.put(16, 'х');
        statistic.put(17, '-');
        statistic.put(18, 'ч');
        statistic.put(19, '.');
        statistic.put(20, '\t');
        statistic.put(21, 'я');
        statistic.put(22, 'з');
        statistic.put(23, 'б');
        statistic.put(24, 'ь');
        statistic.put(25, ',');
        statistic.put(26, 'ы');
        statistic.put(27, 'г');
        statistic.put(28, 'п');
        statistic.put(29, 'д');
        statistic.put(30, 'у');
        statistic.put(31, 'м');
        statistic.put(32, 'в');
        statistic.put(33, 'л');
        statistic.put(34, 'р');
        statistic.put(35, 'к');
        statistic.put(36, 'с');
        statistic.put(37, 'т');
        statistic.put(38, 'н');
        statistic.put(39, 'и');
        statistic.put(40, 'е');
        statistic.put(41, 'а');
        statistic.put(42, 'о');
        statistic.put(43, ' ');
    }
}
