package ru.javarush.cryptoanalyser.rantsev.files;

import ru.javarush.cryptoanalyser.rantsev.exception.ConsoleAppException;
import ru.javarush.cryptoanalyser.rantsev.console.Message;

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
        throw new ConsoleAppException(Message.PATH_NO_FIND);
    }
}
