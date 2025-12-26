package Exceptions;

public class CookiesEatingException extends Exception {
    public CookiesEatingException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Упс! Похоже кто-то поссорился с печеньками :/";
    }
}
