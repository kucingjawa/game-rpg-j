package com.mycompany.mavenproject1;


public class Player {
    // Variable
    String name;
    int health;
    int potions;
    
    // Konstanta
    static final int MAX_HEALTH = 100;
    static final int HEAL_AMOUNT = 30;

    // Constructor
    public Player(String name) {
        this.name = name.toUpperCase(); 
        this.health = MAX_HEALTH;
        this.potions = 3;
    }

    // Method void
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public void heal() {
        if (potions > 0) {
            health += HEAL_AMOUNT;
            if (health > MAX_HEALTH) health = MAX_HEALTH;
            potions--;
            System.out.println("Gluk gluk! HP bertambah. HP sekarang: " + health);
            System.out.println("Sisa potion: " + potions);
        } else {
            System.out.println("Potion habis! Bertahanlah!");
        }
    }
}