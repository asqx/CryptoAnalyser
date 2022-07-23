package ru.javarush.cryptoanalyser.rantsev.console;
public interface Messages {
    String ANSI_BLACK = "\u001B[30m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_YELLOW = "\u001B[33m";
    String DASH = "-------------------";
    String SELECT_MODE = "Please select mode:";
    String CHOICE_ENCRYPT = "1. Encrypt";
    String CHOICE_DECRYPT = "2. Decrypt";
    String CHOICE_BRUTEFORCE = "3. Bruteforce";
    String CHOICE_ANALYSE = "4. Analyse";
    String CHOICE_EXIT = "5. Exit";
    String ERROR_COMMAND = "Command not found";
    String FILE_FORMAT = ".txt";
    String FILE_NO_FIND = "File not found";
    String PATH_NO_FIND = "Full path no found";
    String FILE_PROCESS = "Failed to process file";
    String SOURCE_SELECTION = "Enter source (full path OR only file name OR enter for text.txt)";
    String SOURCE_DESTINATION = "Enter destination (full path OR only file name OR enter for";
    String WARNING = "Warning: A large file is required, otherwise the analyser may not work correctly.";
    String SUCCESSFULLY = "Notification: File is ready";
    String SOURCE_KEY = "Enter key (int number OR enter for key = 1)";
    String KEY_WARNING = "Warning: The key must be greater than 1, otherwise it will be assigned the value 1";
    String KEY_SUCCESSFULLY = "Notification: Key selected successfully";
    String PARAMETERS = "Parameters passed incorrectly at startup";
    String KEY_ERROR = "Entered not a number";
    String WELCOME = "This is a cryptoanalyser. It has 4 mods. You can read more about them in READMI.txt. Hints will help when working with";
    String WARNING_WAIT = "Notification: The file may take longer to process than usual. Wait, please.";


}
