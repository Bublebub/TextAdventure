
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.character.enemies.Enemy;
import gameproject.textadventure.logic.gameMap.Room;
import java.util.Random;


public class Player {
    
    private String name;
    private int health, attack, damage;
    private Room currentLocation;
    
    /**
     * Creates Player in the assigned Room
     * 
     * @param start starting Room
     */
    public Player(Room start) {
        this.name = "Adventurer";
        this.health = 100;
        this.attack = 5;    // Max damage value
        this.damage = 0;    // Varies between 0..this.attack
        this.currentLocation = start;
    }
    
    /**
     * Damages the health of targeted Enemy
     * 
     * @param enemy target
     */
    public void AttackEnemy(Enemy enemy) {
        Random random = new Random();
        
        this.damage = random.nextInt(this.attack);
        
        enemy.setHealth(enemy.getHealth() - this.damage);
    }
    
    //          -- Movement --
    
    /**
     * Moves player East and gets rooms description
     */
    public void moveEast() {
        if (this.currentLocation.getEast() == null) {
            System.out.println("Can't move there!");
        } else {
            this.currentLocation = this.currentLocation.getEast();
            System.out.println(this.currentLocation.getDescription());
        }
    }
    
    /**
     * Moves player West and gets rooms description
     */
    public void moveWest() {
        if (this.currentLocation.getWest() == null) {
            System.out.println("Can't move there!");
        } else {
            this.currentLocation = this.currentLocation.getWest();
            System.out.println(this.currentLocation.getDescription());
        }
    }
    
    /**
     * Moves player South and gets rooms description
     */
    public void moveSouth() {
        if (this.currentLocation.getSouth() == null) {
            System.out.println("Can't move there!");
        } else {
            this.currentLocation = this.currentLocation.getSouth();
            System.out.println(this.currentLocation.getDescription());
        }
    }
    
    /**
     * Moves player North and gets rooms description
     */
    public void moveNorth() {
        if (this.currentLocation.getNorth() == null) {
            System.out.println("Can't move there!");
        } else {
            this.currentLocation = this.currentLocation.getNorth();
            System.out.println(this.currentLocation.getDescription());
        }
    }
    
    
    
    //          -- Setters --
    
    /**
     * Sets Players name
     * 
     * @param newName 
     */
    public void setName(String newName) {
        this.name = newName;
    }
    
    /**
     * Sets players health
     * 
     * @param newHealth 
     */
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    
    /**
     * Sets Players attack value
     * 
     * @param newAttack new attack value (max damage)
     */
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }
    
    /**
     * Sets Player to given location
     * 
     * @param newLocation Room
     */
    public void setLocation(Room newLocation) {
        this.currentLocation = newLocation;
    }
    
    
    //          -- Getters --
    
    /**
     * Returns Players name
     * 
     * @return this.name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns Players health
     * 
     * @return this.health
     */
    public int getHealth() {
        return this.health;
    }
    
    /**
     * Returns Players attack value
     * 
     * @return this.attack (max damage)
     */
    public int getAttack() {
        return this.attack;
    }
    
    /**
     * Returns Players current location
     * 
     * @return this.currentLocation (Room)
     */
    public Room getLocation() {
        return this.currentLocation;
    }
    
}
