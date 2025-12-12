package com.mycompany.mavenproject1;


import java.util.Random;

public class Enemy {
    // Variable Global
    String name;
    int maxHealth;
    int currentHealth;
    int attackDamage;

    // Array of String (Jenis Musuh)
    static String[] enemyTypes = {"Goblin", "Orc", "Dark Elf", "Dragon", "Slime"};

    // Constructor
    public Enemy(int level) {
        Random rand = new Random();
        this.name = enemyTypes[rand.nextInt(enemyTypes.length)]; 
        // Leveling sederhana
        this.maxHealth = 20 + (level * 10);
        this.currentHealth = this.maxHealth;
        this.attackDamage = 5 + (level * 2);
    }

    // Method attack
    public int attack() {
        Random rand = new Random();
        return rand.nextInt(attackDamage);
    }
}