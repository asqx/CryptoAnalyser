package ru.javarush.cryptoanalyser.rantsev.utility;

import ru.javarush.cryptoanalyser.rantsev.exception.ApplicationException;

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
        } catch (ApplicationException e) {
            String error = "Entered not a number";
            System.err.println(error);
        } catch (NumberFormatException e) {
            System.err.println();
        }
    }
}
