
package gameproject.textadventure.logic.character.enemies;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.Room;
import java.util.Random;


public class Goblin implements Enemy {

    private String name;
    private int health, attack, damage;
    private Room currentLocation;
    
    /**
     * Creates a Goblin
     */
    public Goblin() {
        this.name = "Goblin";
        
        this.health = 25;
        this.attack = 5;    // Max damage value
        this.damage = 0;    // Varies between 0...this.attack
    }
    
    /**
     * Returns Goblins name
     * 
     * @return this.name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns Goblins health
     * 
     * @return this.health
     */
    @Override
    public int getHealth() {
        return this.health;
    }
    
    /**
     * Returns Goblins attack value
     * 
     * @return this.attack (max damage)
     */
    @Override
    public int getAttack() {
        return this.attack;
    }

    /**
     * Returns Goblins current location
     * 
     * @return this.currentLocation
     */
    @Override
    public Room getLocation() {
        return this.currentLocation;
    }

    /**
     * Changes Goblins name
     * 
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Changes Goblins health value
     * 
     * @param newHealth new health value
     */
    @Override
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    /**
     * Changes Goblins attack value
     * 
     * @param newAttack new attack value (max damage)
     */
    @Override
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    /**
     * Sets Goblin into new location
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
