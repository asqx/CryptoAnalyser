package ru.javarush.cryptoanalyser.rantsev.files;

import ru.javarush.cryptoanalyser.rantsev.exception.ApplicationException;
import ru.javarush.cryptoanalyser.rantsev.toplevel.Message;

import java.nio.file.Files;
import java.nio.file.Path;

abstract class CreatingPath {
    String reviewingPath (String console){
        Path path = Path.of(console);
        if (Files.exists(path) && !Files.isDirectory(path)) {
            Path getFileName = path.getFileName();
            console = getFileName.toString();
            return console;
        }
        throw new ApplicationException(Message.PATH_NO_FIND);
    }
}
