
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.character.enemies.Enemy;
import gameproject.textadventure.logic.gameMap.Room;
import gameproject.textadventure.logic.item.Item;
import gameproject.textadventure.userInterface.UserInterface;
import java.util.Random;
import javax.swing.JTextArea;


public class Player {
    
    private String name;
    private int health, attack, damage, blockChance;
    private Room currentLocation;
    private JTextArea textArea;
    public Inventory inventory;
    
    
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
    
    
    //      -- Combat --
    
    /**
     * Damages the health of targeted Enemy
     * 
     * @param enemy target
     */
    public void attackEnemy(Enemy enemy) {
        Random random = new Random();
        
        this.damage = random.nextInt(this.attack);
        
        enemy.setHealth(enemy.getHealth() - this.damage);
    }
    
    /**
     * 30% chance to block enemy attack and heal for 5 hitpoins
     * 
     * @return true if attack was defended
     */
    public boolean defend() {
        Random random = new Random();
        
        this.blockChance = random.nextInt(2);
        
        if (this.blockChance == 0) {
            textArea.append("You manage to defend yourself and gain 5 hp.\n");
            
            if (this.health >= 95) {
                this.health = 100;
            } else {
                this.health += 5;
            }
            return true;
        }
        
        textArea.append("You failed to defend yourself!\n");
        
        return false;
    }
    
    /**
     * Gets Item from Room, if it has one
     */
    public void lootItem() {
        if (this.currentLocation.containsItem()) {
            this.inventory.addItem(this.currentLocation.getItem().getName(), this.currentLocation.getItem());
            this.currentLocation.setItem(null);
        } else {
            textArea.append("Nothing to loot\n");
        }
    }
    
    /**
     * Uses item from the inventory
     * 
     * @param command tells which item to use
     */
    public void useItem(String command) {
        Item item = this.inventory.searchItem(command);
        
        if (item != null) {
            item.Use(this);
        } else {
            textArea.append("Not possible\n\n");
        }
    }
    
    
    //          -- Movement --
    
    /**
     * Moves player East and gets rooms description
     */
    public void moveEast() {
        if (this.currentLocation.getEast() == null) {
            textArea.append("Can't move there!\n\n");
        } else {
            this.currentLocation = this.currentLocation.getEast();
            textArea.append(this.currentLocation.getDescription() + "\n");
        }
    }
    
    /**
     * Moves player West and gets rooms description
     */
    public void moveWest() {
        if (this.currentLocation.getWest() == null) {
            textArea.append("Can't move there!\n\n");
        } else {
            this.currentLocation = this.currentLocation.getWest();
            textArea.append(this.currentLocation.getDescription() + "\n");
        }
    }
    
    /**
     * Moves player South and gets rooms description
     */
    public void moveSouth() {
        if (this.currentLocation.getSouth() == null) {
            textArea.append("Can't move there!\n\n");
        } else {
            this.currentLocation = this.currentLocation.getSouth();
            textArea.append(this.currentLocation.getDescription() + "\n");
        }
    }
    
    /**
     * Moves player North and gets rooms description
     */
    public void moveNorth() {
        if (this.currentLocation.getNorth() == null) {
            textArea.append("Can't move there!\n\n");
        } else {
            this.currentLocation = this.currentLocation.getNorth();
            textArea.append(this.currentLocation.getDescription() + "\n");
        }
    }
    
    
    //          -- Setters --
    
    
    public void setTextArea(UserInterface ui) {
        textArea = ui.getTextArea();
    }
    
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    
    
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }
    
    
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
    
    public JTextArea getTextArea() {
        return this.textArea;
    }
    
}
