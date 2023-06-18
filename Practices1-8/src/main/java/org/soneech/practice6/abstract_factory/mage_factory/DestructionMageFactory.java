package org.soneech.practice6.abstract_factory.mage_factory;

import org.soneech.practice6.abstract_factory.mage.DestructionMage;
import org.soneech.practice6.abstract_factory.mage.Mage;

public class DestructionMageFactory extends MageFactory {
    @Override
    public Mage createMage(String type) {
        return new DestructionMage(type);
    }
}
