package org.soneech.practice6.abstract_factory;

public class DestructionClothingFactory extends MageClothingFactory {
    @Override
    public MageClothing createClothing() {
        return new DestructionMageClothing();
    }
}
