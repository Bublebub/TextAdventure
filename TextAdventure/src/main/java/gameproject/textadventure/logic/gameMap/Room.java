
package gameproject.textadventure.logic.gameMap;

import gameproject.textadventure.logic.character.enemies.Enemy;


// This class creates rooms where player can/can't go
public class Room {
    // Each room knows its neighbours and has a specific description and ID
    Room east, west, south, north;
    String description, id;
    Enemy enemy;
    
    public Room(String id) {
        this.id = id;
    }
    
    // Returns true if room contains an enemy
    public boolean containsEnemy(){
        if (this.enemy != null) {
            return true;
        }
        
        return false;
    }
    
    //              -- Setters --
    
    // Sets rooms ID
    public void setID(String id) {
        this.id = id;
    }
    
    // Sets rooms description
    public void setDescription(String text) {
        this.description = text;
    }
    
    // Sets an enemy in the room
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
    
    
    
    // Sets rooms East neigbour
    public void setEast(Room neighbour) {
        this.east = neighbour;
    }
    
    // Sets rooms West neigbour
    public void setWest(Room neighbour) {
        this.west = neighbour;
    }
    
    // Sets rooms South neigbour
    public void setSouth(Room neighbour) {
        this.south = neighbour;
    }
    
    // Sets rooms North neigbour
    public void setNorth(Room neighbour) {
        this.north = neighbour;
    }
    
    //              -- Getters --
    
    // Retrieves rooms ID
    public String getID() {
        return this.id;
    }
    
    // Retrieves rooms description
    public String getDescription() {
        return this.description;
    }
    
    // Gets an enemy from the room
    public Enemy getEnemy() {
        return this.enemy;
    }
    
    
    // Retrieves East neighbour
    public Room getEast() {
        return this.east;
    }
    
    // Retrieves West neighbour
    public Room getWest() {
        return this.west;
    }
    
    // Retrieves South neighbour
    public Room getSouth() {
        return this.south;
    }
   
    // Retrieves North neighbour
    public Room getNorth() {
        return this.north;
    }

    
}
