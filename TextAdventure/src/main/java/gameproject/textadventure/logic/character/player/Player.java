
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.gameMap.Room;


public class Player {
    
    String name;
    int health;
    int attack;
    Room currentLocation;
    
    // Creates player in the assigned room
    public Player(Room start) {
        this.name = "Adventurer";
        this.health = 100;
        this.attack = 5;
        this.currentLocation = start;
    }
    
    
    //          -- Setters --
    
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
    
}
