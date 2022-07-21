package ru.javarush.cryptoanalyser.rantsev.entity;

public record Result(ResultCode resultCode, String message) {

    @Override
    public String toString() {
        return "Result:" + resultCode +
                ", message='" + message;
    }

}
