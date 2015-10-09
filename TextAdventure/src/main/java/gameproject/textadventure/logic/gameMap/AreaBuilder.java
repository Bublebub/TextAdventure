
package gameproject.textadventure.logic.gameMap;

import gameproject.textadventure.logic.RoomDataReader;
import gameproject.textadventure.logic.character.enemies.Goblin;
import gameproject.textadventure.logic.character.enemies.Troll;
import gameproject.textadventure.logic.item.HealthPotion;
import gameproject.textadventure.logic.item.Key;
import java.util.HashMap;
import java.util.Map;


public class AreaBuilder {
    
    private Map<String, Room> gameMap;
    private int roomAmount;
    private RoomDataReader roomDataReader;
    
    /**
     * Constructor is given the amount of rooms in the map
     * 
     * @param rooms amount of rooms in the map
     */
    public AreaBuilder(int rooms) {
        this.gameMap = new HashMap<>();
        this.roomAmount = rooms;
    }
    
    /**
     * Builds the game area
     * 
     * @throws Exception 
     */
    public void buildArea() throws Exception {
        createEmptyMap();
        
        for (String id : this.gameMap.keySet()) {
            
            // Gives datareader correct path to rooms info
            this.roomDataReader = new RoomDataReader("src/main/java/gameproject/textadventure/logic/gameMap/roomData/" + id + ".txt");
            
            Room currentRoom = this.gameMap.get(id);
            
            this.roomDataReader.assignRoomNeighbours(currentRoom, this.gameMap);
            this.roomDataReader.assignDescription(currentRoom);
            
        }
        
        createItems();
        createEnemies();
        
    }
    
    
    /**
     * Creates a map with empty rooms
     */
    public void createEmptyMap() {
        for (int i = 0; i < this.roomAmount; i++) {
            this.gameMap.put("R" + i, new Room("R" + i));
        }
    }
    
    public void createItems() {
        Key key = new Key(this);
        HealthPotion firstPotion = new HealthPotion(30);
        HealthPotion secondPotion = new HealthPotion(50);
        secondPotion.setName("Grand Potion");
        
        this.gameMap.get("R13").setItem(key);
        
        this.gameMap.get("R3").setItem(firstPotion);
        this.gameMap.get("R12").setItem(secondPotion);
    }
    
    public void createEnemies() {
        Troll troll = new Troll();
        Goblin firstGoblin = new Goblin();
        Goblin secondGoblin = new Goblin();
        
        this.gameMap.get("R1").setEnemy(troll);
        this.gameMap.get("R12").setEnemy(firstGoblin);
        this.gameMap.get("R14").setEnemy(secondGoblin);
    }
    
    //          -- Getters --
    
    /**
     * Returns Map of Rooms in the game area
     * 
     * @return this.gameMap
     */
    public Map getGameMap() {
        return this.gameMap;
    }
    
    /**
     * Returns the amount of Rooms in the game
     * 
     * @return this.roomAmount
     */
    public int getRoomAmount() {
        return this.roomAmount;
    }
}
