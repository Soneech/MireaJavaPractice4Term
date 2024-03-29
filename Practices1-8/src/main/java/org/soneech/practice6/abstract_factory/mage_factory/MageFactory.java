package org.soneech.practice6.abstract_factory.mage_factory;

import org.soneech.practice6.abstract_factory.clothing_factory.MageClothingFactory;
import org.soneech.practice6.abstract_factory.mage.Mage;

public abstract class MageFactory {
    public Mage create(MageClothingFactory factory, String type) {
        Mage mage = createMage(type);
        mage.setClothing(factory.createClothing());
        return mage;
    }
    public abstract Mage createMage(String type);
}
