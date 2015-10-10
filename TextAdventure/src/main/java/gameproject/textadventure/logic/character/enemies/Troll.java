
package gameproject.textadventure.logic.character.enemies;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.Room;
import java.util.Random;


public class Troll implements Enemy {

    private String name;
    private int health, attack, damage;
    private Room currentLocation;
    
    public Troll() {
        this.name = "Troll";
        
        this.health = 50;
        this.attack = 8;    // Max damage value
        this.damage = 0;    // Varies between 0...this.attack
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public Room getLocation() {
        return currentLocation;
    }

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

    @Override
    public void attackPlayer(Player player) {
        Random random = new Random();
        
        this.damage = random.nextInt(this.attack);
        
        player.setHealth(player.getHealth() - this.damage);
    }
    
}
