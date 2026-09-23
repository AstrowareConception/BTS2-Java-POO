package fr.bts.sio.fundamentals;

import java.util.Scanner;

public final class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String prompt, int minimum, int maximum) {
        throw new UnsupportedOperationException("À implémenter dans l'atelier 3");
    }

    public String readRequiredText(String prompt) {
        throw new UnsupportedOperationException("À implémenter dans l'atelier 3");
    }
}
