package org.soneech.practice6.abstract_factory;

public class IllusionMage extends Mage {
    public IllusionMage(String type) {
        super(type);
    }

    @Override
    public void description() {
        System.out.println("I am illusion mage - " + type);
        System.out.println("My clothing - " + clothing.getName());
    }
}
