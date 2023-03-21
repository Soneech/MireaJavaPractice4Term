package org.soneech.practice6.abstract_factory;

public class DestructionMageFactory extends MageFactory {
    @Override
    public Mage createMage(String type) {
        return new DestructionMage(type);
    }
}
