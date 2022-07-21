package ru.javarush.cryptoanalyser.rantsev.utility;

import ru.javarush.cryptoanalyser.rantsev.exception.ConsoleAppException;
import ru.javarush.cryptoanalyser.rantsev.console.Message;

import java.util.Scanner;

public class ShiftKey {
    public void getKey(String[] args) {
        Scanner console = new Scanner(System.in);
        String key = console.nextLine();
        if (key.equals("")) {
            args[3] = "1";
        }
        try {
            int keyInt = Integer.parseInt(key);
            if (keyInt > 1) {
                args[3] = key;
            } else {
                args[3] = "1";
            }
        } catch (ConsoleAppException e) {
            throw new ConsoleAppException(Message.KEY_ERROR);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Message.KEY_ERROR);
        }
    }
}
