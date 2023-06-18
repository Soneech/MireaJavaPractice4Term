package org.soneech.other_patterns.factory.mage_factory;

import org.soneech.other_patterns.factory.mage.DestructionMage;
import org.soneech.other_patterns.factory.mage.IllusionMage;
import org.soneech.other_patterns.factory.mage.Mage;
import org.soneech.other_patterns.factory.mage.RecoveryMage;

public class SimpleMageFactory {
    public Mage createMage (MageType type) {
        Mage mage = switch (type) {
            case DESTRUCTION -> new DestructionMage();
            case ILLUSION -> new IllusionMage();
            case RECOVERY -> new RecoveryMage();
        };
        return mage;
    }
}
