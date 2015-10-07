
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.character.enemies.Enemy;
import gameproject.textadventure.logic.gameMap.Room;
import gameproject.textadventure.userInterface.UserInterface;
import java.util.Random;
import javax.swing.JTextArea;


public class Player {
    
    private String name;
    private int health, attack, damage, blockChance;
    private Room currentLocation;
    private JTextArea textDisplay;
    private Inventory inventory;
    
    
    
    
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
        this.inventory = new Inventory();
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
    
    public boolean Defend() {
        Random random = new Random();
        
        this.blockChance = random.nextInt(2);
        
        if (this.blockChance == 0) {
            textDisplay.append("You manage to defend yourself and gain 5 hp.\n");
            
            if (this.health >= 95) {
                this.health = 5;
            } else {
                this.health += 15;
            }
            
            return true;
        }
        
        textDisplay.append("You failed to defend yourself!\n");
        
        return false;
    }
    
    
    
    //          -- Movement --
    
    /**
     * Moves player East and gets rooms description
     */
    public void moveEast() {
        if (this.currentLocation.getEast() == null) {
            textDisplay.append("Can't move there!\n");
        } else {
            this.currentLocation = this.currentLocation.getEast();
            textDisplay.append(this.currentLocation.getDescription() + "\n");
        }
    }
    
    /**
     * Moves player West and gets rooms description
     */
    public void moveWest() {
        if (this.currentLocation.getWest() == null) {
            textDisplay.append("Can't move there!\n");
        } else {
            this.currentLocation = this.currentLocation.getWest();
            textDisplay.append(this.currentLocation.getDescription() + "\n");
        }
    }
    
    /**
     * Moves player South and gets rooms description
     */
    public void moveSouth() {
        if (this.currentLocation.getSouth() == null) {
            textDisplay.append("Can't move there!\n");
        } else {
            this.currentLocation = this.currentLocation.getSouth();
            textDisplay.append(this.currentLocation.getDescription() + "\n");
        }
    }
    
    /**
     * Moves player North and gets rooms description
     */
    public void moveNorth() {
        if (this.currentLocation.getNorth() == null) {
            textDisplay.append("Can't move there!\n");
        } else {
            this.currentLocation = this.currentLocation.getNorth();
            textDisplay.append(this.currentLocation.getDescription() + "\n");
        }
    }
    
    
    
    //          -- Setters --
    
    /**
     * Sets JTextArea where games information is shown
     * 
     * @param ui UserInterface where JTextArea is created
     */
    public void setTextDisplay(UserInterface ui) {
        textDisplay = ui.getTextDisplay();
    }
    
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
    
    
    public String getName() {
        return this.name;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    public Room getLocation() {
        return this.currentLocation;
    }
    
    public Inventory getInventory() {
        return this.inventory;
    }
    
}
