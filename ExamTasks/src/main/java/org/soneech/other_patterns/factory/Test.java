package org.soneech.other_patterns.factory;

import org.soneech.other_patterns.factory.mage.Mage;
import org.soneech.other_patterns.factory.mage_factory.MageType;
import org.soneech.other_patterns.factory.mage_factory.SimpleMageFactory;

public class Test {
    public static void main(String[] args) {
        SimpleMageFactory mageFactory = new SimpleMageFactory();

        Mage mage = mageFactory.createMage(MageType.ILLUSION);
        mage.getMageInfo();

        mage = mageFactory.createMage(MageType.DESTRUCTION);
        mage.getMageInfo();

        mage = mageFactory.createMage(MageType.RECOVERY);
        mage.getMageInfo();
    }
}
