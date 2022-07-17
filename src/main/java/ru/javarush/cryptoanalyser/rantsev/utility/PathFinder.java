package ru.javarush.cryptoanalyser.rantsev.utility;

import java.io.File;
public class PathFinder {
    public static String getRoot() {
        String root = System.getProperty("user.dir");
        return root + File.separator + "text.txt" + File.separator;
    }
    public static String getRoot(int mode, String[] files) {
        String root = System.getProperty("user.dir");
        return root + File.separator + files[mode] + File.separator;
    }
}
