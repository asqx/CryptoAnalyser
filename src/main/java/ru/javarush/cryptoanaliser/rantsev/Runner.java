package ru.javarush.cryptoanaliser.rantsev;

import ru.javarush.cryptoanaliser.rantsev.toplevel.Application;
import ru.javarush.cryptoanaliser.rantsev.controller.MainController;
import ru.javarush.cryptoanaliser.rantsev.entity.Result;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);
    }
}
