/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unti;

import java.util.Scanner;

/**
 *
 * @author AD
 */
public class Validate {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Returns an input integer from the keyboard.
     *
     * @param messageInfo message info
     * @param min minimum limit value
     * @param max maximum limit value
     * @return the integer value
     */
    public static int getInt(String messageInfo, int min, int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println("Numeric value out of range.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer number.");
            }
        } while (true);
    }

    /**
     * Returns an input string from the keyboard.
     *
     * @param messageInfo message info
     * @param REGEX the pattern to test string is valid or not
     * @param messageError message error
     * @return the string value
     */
    public static String getString(String messageInfo, String messageError, final String REGEX) {
        do {
            System.out.print(messageInfo);
            String str = scanner.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
}
 

