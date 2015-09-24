
package gameproject.textadventure.logic.character.enemies;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.Room;
import java.util.Random;


public class Skeleton implements Enemy {

    private String name;
    private int health, attack, damage;
    private Room currentLocation;
    
    /**
     * Creates Skeleton in assigned Room
     * 
     * @param room starting Room
     */
    public Skeleton(Room room) {
        this.name = "Skeleton";
        
        this.health = 25;
        this.attack = 3;    // Max damage value
        this.damage = 0;    // Varies between 0...this.attack
        
        this.currentLocation = room;
    }
    
    /**
     * Returns Skeletons name
     * 
     * @return this.name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns Skeletons health
     * 
     * @return this.health
     */
    @Override
    public int getHealth() {
        return this.health;
    }
    
    /**
     * Returns Skeletons attack value
     * 
     * @return this.attack (max damage)
     */
    @Override
    public int getAttack() {
        return this.attack;
    }

    /**
     * Returns Skeletons current location
     * 
     * @return this.currentLocation
     */
    @Override
    public Room getLocation() {
        return this.currentLocation;
    }

    /**
     * Changes Skeletons name
     * 
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Changes Skeletons health value
     * 
     * @param newHealth new health value
     */
    @Override
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    /**
     * Changes Skeletons attack value
     * 
     * @param newAttack new attack value (max damage)
     */
    @Override
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    /**
     * Sets Skeleton into new location
     * 
     * @param newLocation 
     */
    @Override
    public void setLocation(Room newLocation) {
        this.currentLocation = newLocation;
    }
    
    /**
     * Damages targeted players health based on attack value
     * 
     * @param player targeted player
     */
    @Override
    public void attackPlayer(Player player) {
        Random random = new Random();
        
        this.damage = random.nextInt(this.attack);
        
        player.setHealth(player.getHealth() - this.damage);
    }
    
}
