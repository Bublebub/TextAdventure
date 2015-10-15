
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
    
    //      -- Getters --
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getHealth() {
        return this.health;
    }
    
    @Override
    public int getAttack() {
        return this.attack;
    }
    
    @Override
    public Room getLocation() {
        return this.currentLocation;
    }

    //      -- Setters --
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    
    @Override
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }
    
    @Override
    public void setLocation(Room newLocation) {
        this.currentLocation = newLocation;
    }
    
}
