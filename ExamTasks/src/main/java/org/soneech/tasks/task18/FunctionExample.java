package org.soneech.tasks.task18;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> numberType = (n) -> {
          if (n > 0)
              return "Положительное число";
          else if (n == 0)
              return "Ноль";
          return "Отрицательное число";
        };

        System.out.println(numberType.apply(5));
        System.out.println(numberType.apply(0));
        System.out.println(numberType.apply(-1));
    }
}
