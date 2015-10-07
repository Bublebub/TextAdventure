
package gameproject.textadventure.logic.gameMap;

import gameproject.textadventure.logic.character.enemies.Enemy;
import gameproject.textadventure.logic.item.Item;


/**
 * This class creates rooms where player can/can't go
 * 
 * @author Elmeri
 */
public class Room {
    // Each room knows its neighbours and has a specific description and ID
    private Room east, west, south, north;
    private String description, id;
    private Enemy enemy;
    private Item item;
    
    /**
     * Creates a Room with given ID
     * 
     * @param id 
     */
    public Room(String id) {
        this.id = id;
    }
    
    /**
     * Returns true if room contains an Enemy
     * 
     * @return true if Room contains an Enemy
     */
    public boolean containsEnemy(){
        if (this.enemy != null) {
            return true;
        }
        
        return false;
    }
    
    //              -- Setters --
    
    /**
     * Sets rooms ID
     * 
     * @param id new ID
     */
    public void setID(String id) {
        this.id = id;
    }
    
    /**
     * Sets rooms description
     * 
     * @param text description
     */
    public void setDescription(String text) {
        this.description = text;
    }
    
    /**
     * Sets given Enemy in the room
     * 
     * @param enemy 
     */
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
    
    
    /**
     * Sets rooms East neigbour
     * 
     * @param neighbour (Room)
     */
    public void setEast(Room neighbour) {
        this.east = neighbour;
    }
    
    /**
     * Sets rooms West neigbour
     * 
     * @param neighbour (Room)
     */
    public void setWest(Room neighbour) {
        this.west = neighbour;
    }
    
    /**
     * Sets rooms South neigbour
     * 
     * @param neighbour (Room)
     */
    public void setSouth(Room neighbour) {
        this.south = neighbour;
    }
    
    /**
     * Sets rooms North neigbour
     * 
     * @param neighbour (Room)
     */
    public void setNorth(Room neighbour) {
        this.north = neighbour;
    }
    
    //              -- Getters --
    
    /**
     * Retrieves rooms ID
     * 
     * @return this.id
     */
    public String getID() {
        return this.id;
    }
    
    /**
     * Retrieves rooms description
     * 
     * @return this.description
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Retrieves an Enemy from the room
     * 
     * @return this.enemy
     */
    public Enemy getEnemy() {
        return this.enemy;
    }
    
    public Item getItem() {
        return this.item;
    }
    
    
    /**
     * Retrieves Rooms East neighbour
     * 
     * @return this.east
     */
    public Room getEast() {
        return this.east;
    }
    
    /**
     * Retrieves Rooms West neighbour
     * 
     * @return this.west
     */
    public Room getWest() {
        return this.west;
    }
    
    /**
     * Retrieves Rooms South neighbour
     * 
     * @return this.south
     */
    public Room getSouth() {
        return this.south;
    }
   
    /**
     * Retrieves Rooms North neighbour
     * 
     * @return this.north
     */
    public Room getNorth() {
        return this.north;
    }

    
}
