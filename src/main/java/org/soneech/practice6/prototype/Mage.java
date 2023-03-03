package org.soneech.practice6.prototype;

public class Mage extends Character {
    private String weapon;
    private int health;
    private int mana;

    public Mage(String weapon, int health, int mana) {
        this.weapon = weapon;
        this.health = health;
        this.mana = mana;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public Character copy() {
        return new Mage(this.weapon, this.health, this.mana);
    }

    @Override
    public String toString() {
        return "class: mage; weapon: " + weapon + "; health: " + health + "; mana: " + mana;
    }
}
