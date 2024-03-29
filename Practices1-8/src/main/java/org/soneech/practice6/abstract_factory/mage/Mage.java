package org.soneech.practice6.abstract_factory.mage;

import org.soneech.practice6.abstract_factory.clothing.MageClothing;

public abstract class Mage {
    String type;
    MageClothing clothing;

    public Mage(String type) {
        this.type = type;
    }

    public void setClothing(MageClothing clothing) {
        this.clothing = clothing;
    }

    public abstract void description();
}
