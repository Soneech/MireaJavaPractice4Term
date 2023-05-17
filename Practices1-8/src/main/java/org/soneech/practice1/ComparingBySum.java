package org.soneech.practice1;

import java.util.Comparator;
import java.util.Scanner;

public class ComparingBySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        Comparator<String> comparator = Comparator.comparingLong(ComparingBySum::numbersSum);
        int result = comparator.compare(str1, str2);
        if (result == 0) {
            System.out.println("Сумма цифр для чисел одинакова");
        }
        else if (result == 1) {
            System.out.println("Сумма цифр первого числа больше");
        }
        else {
            System.out.println("Сумма цифр второго числа больше");
        }
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