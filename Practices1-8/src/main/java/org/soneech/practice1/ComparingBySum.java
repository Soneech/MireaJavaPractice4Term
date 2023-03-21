package org.soneech.practice1;

import java.util.Comparator;
import java.util.Scanner;

public class ComparingBySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        Comparator<String> comparator = Comparator.comparingLong(ComparingBySum::numbersSum);
        System.out.println(comparator.compare(str1, str2));
    }

    public static int numbersSum(String str) {
        int result = 0;
        for(char symbol: str.toCharArray()) {
            if (Character.isDigit(symbol)) {
                result += Integer.parseInt(String.valueOf(symbol));
            }
        }
        return result;
    }
}