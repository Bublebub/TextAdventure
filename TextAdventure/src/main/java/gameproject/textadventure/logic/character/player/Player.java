
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.gameMap.Room;


public class Player {
    
    String name;
    int health, attack;
    Room currentLocation;
    
    // Creates player in the assigned room
    public Player(Room start) {
        this.name = "Adventurer";
        this.health = 100;
        this.attack = 5;
        this.currentLocation = start;
    }
    
    //          -- Movement --
    
    // Moves player East and gets rooms description
    public void moveEast() {
        if (this.currentLocation.getEast() == null) {
            System.out.println("Can't move there!");
        } else {
            this.currentLocation = this.currentLocation.getEast();
            System.out.println(this.currentLocation.getDescription());
        }
    }
    
    // Moves player West and gets rooms description
    public void moveWest() {
        if (this.currentLocation.getWest() == null) {
            System.out.println("Can't move there!");
        } else {
            this.currentLocation = this.currentLocation.getWest();
            System.out.println(this.currentLocation.getDescription());
        }
    }
    
    // Moves player South and gets rooms description
    public void moveSouth() {
        if (this.currentLocation.getSouth() == null) {
            System.out.println("Can't move there!");
        } else {
            this.currentLocation = this.currentLocation.getSouth();
            System.out.println(this.currentLocation.getDescription());
        }
    }
    
    // Moves player North and gets rooms description
    public void moveNorth() {
        if (this.currentLocation.getNorth() == null) {
            System.out.println("Can't move there!");
        } else {
            this.currentLocation = this.currentLocation.getNorth();
            System.out.println(this.currentLocation.getDescription());
        }
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
