package ru.javarush.cryptoanalyser.rantsev.picocli;

public interface Messages {
    String APP_NAME = "CryptoAnalyser";
    String ENCODE = "encode";
    String DECODE = "decode";
    String BRUTEFORCE = "bruteforce";
    String ANALYSE = "analyse";
    String COMMAND_HELP = "Show help on command";
    String ENCODE_HELP = "This mod encrypts the file using a key with a shift that you specify yourself.";
    String DECODE_HELP = "This mod decrypts the file using a key with a shift that you specify yourself.";
    String BRUTEFORCE_HELP = "This mod decrypts by brute force.";
    String ANALYSE_HELP = "This mode collects statistics on characters in the text, and replaces them with frequently used ones.";
    String ANALYSE_WARNING = "Warning: Decryption in this mode may not be accurate. Statistics taken from common open sources";
    String SOURCE_FILE = "<source file>";
    String FILE_HELP = "You must specify a file with text, or the full path to it";
    String DESTINATION_FILE = "<destination file>";
    String KEY = "<key>";
    String KEY_HELP = "You need to set a key. It must be an integer";
    String PERFORMED = "Performed";
    String WELCOME = "This is a cryptoanalyser. It has 5 mods";

    String ANSI_BLACK = "\u001B[30m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_YELLOW = "\u001B[33m";
}
