package ru.javarush.cryptoanalyser.rantsev.commands;

import ru.javarush.cryptoanalyser.rantsev.utility.PathFinder;

import java.io.*;

public class CypherCaesar {
    private final String fileIn;
    private final String fileOut;
    private final int key;
    public CypherCaesar(String fileIn, String fileOut, int key) {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
        this.key = key;
    }
    void getCypher() {
        String root = PathFinder.getRoot();
        try (BufferedReader reader = new BufferedReader(new FileReader(root + fileIn));
             BufferedWriter writer = new BufferedWriter(new FileWriter(root + fileOut))) {
            while (reader.ready()) {
                int line = reader.read();
                writer.write((char)(line + key));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
