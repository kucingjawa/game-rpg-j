package com.mycompany.mavenproject1;


import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;

        System.out.println("=================================");
        System.out.println("      THE JAVA DUNGEON RPG       ");
        System.out.println("=================================");
        
        System.out.print("Masukkan nama Hero: ");
        String inputName = scanner.nextLine();
        
        Player hero = new Player(inputName);
        System.out.println("Selamat datang, " + hero.name + "!");

        // GAME LOOP
        GAME:
        while (running) {
            System.out.println("---------------------------------");
            Enemy enemy = new Enemy(rand.nextInt(3) + 1);
            System.out.println("\n# " + enemy.name + " liar muncul! #\n");

            // COMBAT LOOP
            while (enemy.currentHealth > 0) {
                System.out.println("HP " + hero.name + ": " + hero.health);
                System.out.println("HP " + enemy.name + ": " + enemy.currentHealth);
                System.out.println("\nAksi:");
                System.out.println("1. Serang");
                System.out.println("2. Minum Potion");
                System.out.println("3. Lari");
                System.out.print("Pilih: ");

                String input = scanner.nextLine();

                try {
                    int choice = Integer.parseInt(input);

                    switch (choice) {
                        case 1:
                            int damageDealt = rand.nextInt(20) + 5;
                            int damageTaken = enemy.attack();
                            
                            enemy.currentHealth -= damageDealt;
                            hero.takeDamage(damageTaken);
                            
                            System.out.println("\n> Kamu menyerang " + enemy.name + " (" + damageDealt + " dmg)");
                            System.out.println("> " + enemy.name + " membalas (" + damageTaken + " dmg)");
                            
                            if (hero.health < 1) {
                                System.out.println("\n💀 Kamu tewas di dalam dungeon...");
                                break GAME;
                            }
                            break;

                        case 2:
                            hero.heal();
                            break;

                        case 3:
                            System.out.println("\nKamu lari terbirit-birit!");
                            continue GAME;

                        default:
                            System.out.println("Pilih angka 1-3!");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] Masukkan angka saja!");
                }
            }
            
            if (hero.health > 0) {
                System.out.println("---------------------------------");
                System.out.println(" # Musuh kalah! Potion +1 # ");
                hero.potions++;
                
                System.out.println("\nLanjut?");
                System.out.println("1. Lanjut");
                System.out.println("2. Keluar");
                
                String input = scanner.nextLine();
                if (input.equals("2")) {
                    System.out.println("Keluar dungeon. Skor tersimpan.");
                    break;
                }
            }
        }
        scanner.close();
    }
}