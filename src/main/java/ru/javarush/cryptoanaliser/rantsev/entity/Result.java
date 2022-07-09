package ru.javarush.cryptoanaliser.rantsev.entity;

public class Result {

    private final ResultCode resultCode;
    private final String message;

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                '}';
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    public Result(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
