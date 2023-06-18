package org.soneech.practice6.abstract_factory.mage_factory;

import org.soneech.practice6.abstract_factory.mage.IllusionMage;
import org.soneech.practice6.abstract_factory.mage.Mage;

public class IllusionMageFactory extends MageFactory {
    @Override
    public Mage createMage(String type) {
        return new IllusionMage(type);
    }
}
