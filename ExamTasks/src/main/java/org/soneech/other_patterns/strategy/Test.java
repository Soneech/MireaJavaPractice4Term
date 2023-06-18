package org.soneech.other_patterns.strategy;

public class Test {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.execute(5, 10));

        context = new Context(new OperationSubtract());
        System.out.println(context.execute(5, 4));
    }
}
