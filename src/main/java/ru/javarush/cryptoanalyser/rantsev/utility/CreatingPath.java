package ru.javarush.cryptoanalyser.rantsev.utility;

import ru.javarush.cryptoanalyser.rantsev.toplevel.Message;

import java.nio.file.Files;
import java.nio.file.Path;

public class CreatingPath {
     void checkPathTxt (String[]args){
        Path path = Path.of(CreatingFile.getConsoleReader());
        if (Files.exists(path) && !Files.isDirectory(path)) {
            Path getFileName = path.getFileName();
            args[1] = getFileName.toString();
        } else {
            System.err.println(Message.FILE_NO_FIND);
            System.exit(1);
        }
    }
    void checkPathStandard (String[]args) {
        Path path = Path.of(CreatingFile.getConsoleReader());
        if (Files.exists(path) && !Files.isDirectory(path)) {
            Path getFileName = path.getFileName();
            args[2] = getFileName.toString();
        } else {
            System.err.println(Message.FILE_NO_FIND);
            System.exit(1);
        }
    }
}
