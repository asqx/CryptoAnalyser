package ru.javarush.cryptoanalyser.rantsev.utility;

import java.io.File;

public class PathFinder {
    public static String getRoot() {
        String root = System.getProperty("user.dir");
        return root + File.separator + "text" + File.separator;
    }
}
