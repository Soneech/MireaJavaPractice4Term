package org.soneech.practice6.prototype;

public class Warrior extends Character {
    private String weapon;
    private int health;
    private int stamina;

    public Warrior(String weapon, int health, int stamina) {
        this.weapon = weapon;
        this.health = health;
        this.stamina = stamina;
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

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public Character copy() {
        return new Warrior(this.weapon, this.health, this.stamina);
    }

    @Override
    public String toString() {
        return "class: warrior; weapon: " + weapon + "; health: " + health + "; stamina: " + stamina;
    }
}
