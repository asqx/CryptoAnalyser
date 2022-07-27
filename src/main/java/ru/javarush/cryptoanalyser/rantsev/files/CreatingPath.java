package ru.javarush.cryptoanalyser.rantsev.files;

import ru.javarush.cryptoanalyser.rantsev.exception.ConsoleAppException;
import ru.javarush.cryptoanalyser.rantsev.console.Messages;
import ru.javarush.cryptoanalyser.rantsev.utility.PathFinder;

import java.io.File;
import java.io.IOException;

abstract class CreatingPath {
    private String resultFile;
    String reviewingPath (String console) {
        File file;
        String root = PathFinder.getRoot();
        file = new File(console);
        try {
            if (file.isFile() || file.isDirectory()) {
           resultFile = file.getName();
        } else {
            file = new File(root + console);
            if (!file.isDirectory() || file.createNewFile()) {
                resultFile = file.getName();
            }
        }
        return resultFile;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        throw new ConsoleAppException(Messages.PATH_NO_FIND);
        }
    }

