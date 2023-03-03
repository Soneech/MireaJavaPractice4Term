package org.soneech.practice6.abstract_factory;

public class DestructionMage extends Mage {

    public DestructionMage(String type) {
        super(type);
    }

    @Override
    public void description() {
        System.out.println("I am a destruction mage - " + type);
        System.out.println("My clothing - " + clothing.getName());
    }
}
