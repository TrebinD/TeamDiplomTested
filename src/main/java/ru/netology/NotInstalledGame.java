package ru.netology;

public class NotInstalledGame extends RuntimeException {
    public NotInstalledGame(String s) {
        super(s);
    }
}
