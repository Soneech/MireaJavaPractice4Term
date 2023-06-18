package org.soneech.practice6.abstract_factory.clothing_factory;

import org.soneech.practice6.abstract_factory.clothing.IllusionMageClothing;
import org.soneech.practice6.abstract_factory.clothing.MageClothing;

public class IllusionClothingFactory extends MageClothingFactory {
    @Override
    public MageClothing createClothing() {
        return new IllusionMageClothing();
    }
}
