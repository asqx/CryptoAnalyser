package ru.javarush.cryptoanalyser.rantsev.utility;

import ru.javarush.cryptoanalyser.rantsev.toplevel.Menu;
import ru.javarush.cryptoanalyser.rantsev.toplevel.Message;

import java.util.Map;

public class ParametersCheck {
    public String[] checkArgs(String[] args) {
        Map<Integer, String> commands = Menu.getCommands();
        String[] verifiedArgs = new String[commands.size() - 1];
        for (int i = 0; i < commands.size() - 1; i++) {
            if (args[0].equals(commands.get(i))) {
                verifiedArgs[0] = args[0];
            } else {
                System.err.println(Message.ERROR_COMMAND);
            }
        }
        checkFiles(args[1]);
        return null;
    }

    public String checkFiles(String args) {

        return null;
    }
}
