package by.sazonov.book.scanner;

import java.util.Scanner;

public class ScanFromConsole {
    static Scanner in = new Scanner(System.in);

    public static int getInt() {
        return in.nextInt();
    }

    public static String getString() {
        in.nextLine();
        return in.nextLine();
    }
}
