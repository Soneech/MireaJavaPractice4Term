package org.soneech.other_patterns.adapter;

public class Test {
    public static void main(String[] args) {
        USB cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();
    }
}
