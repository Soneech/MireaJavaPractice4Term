package org.soneech.practice6.abstract_factory;

public class IllusionMageFactory extends MageFactory {
    @Override
    public Mage createMage(String type) {
        return new IllusionMage(type);
    }
}
