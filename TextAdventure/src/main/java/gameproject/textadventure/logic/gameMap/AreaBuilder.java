
package gameproject.textadventure.logic.gameMap;

import gameproject.textadventure.logic.RoomDataReader;
import java.util.HashMap;
import java.util.Map;


public class AreaBuilder {
    
    Map<String, Room> gameMap;
    int roomAmount;
    RoomDataReader roomDataReader;
    
    // Constructor is given the amount of rooms in the map
    public AreaBuilder(int rooms) {
        this.gameMap = new HashMap<>();
        this.roomAmount = rooms;
    }
    
    
    // Builds the games area
    public void buildArea() throws Exception {
        createEmptyMap();
        
        for (String id : this.gameMap.keySet()) {
            this.roomDataReader = new RoomDataReader("src/main/java/gameproject/textadventure/logic/gameMap/roomData/" + id + ".txt");
            
            Room currentRoom = this.gameMap.get(id);
            this.roomDataReader.assignRoomNeighbours(currentRoom);
            this.roomDataReader.assignDescription(currentRoom);
        }
    }
    
    
    // Creates a map with empty rooms
    public void createEmptyMap() {
        for (int i = 0; i < this.roomAmount; i++) {
            this.gameMap.put("R" + i, new Room());
        }
    }
    
    
    
    //          -- Getters --
    
    public Map getGameMap() {
        return this.gameMap;
    }
    
    public int getRoomAmount() {
        return this.roomAmount;
    }
}
