package util;

import java.util.Scanner;

public class InputUtil {
    public static String requireText(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
