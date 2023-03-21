package org.soneech.practice6.abstract_factory;

public class IllusionClothingFactory extends MageClothingFactory {
    @Override
    public MageClothing createClothing() {
        return new IllusionMageClothing();
    }
}
