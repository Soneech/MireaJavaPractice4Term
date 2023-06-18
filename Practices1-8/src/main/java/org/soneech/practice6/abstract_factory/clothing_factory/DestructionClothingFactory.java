package org.soneech.practice6.abstract_factory.clothing_factory;

import org.soneech.practice6.abstract_factory.clothing.DestructionMageClothing;
import org.soneech.practice6.abstract_factory.clothing.MageClothing;

public class DestructionClothingFactory extends MageClothingFactory {
    @Override
    public MageClothing createClothing() {
        return new DestructionMageClothing();
    }
}
