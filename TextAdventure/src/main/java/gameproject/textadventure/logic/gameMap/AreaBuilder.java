
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
    
    
    /*  Current room layout:
        [R0] [R1]
        [R2] [R4]
    */
    
    // Builds the game area
    public void buildArea() throws Exception {
        createEmptyMap();
        
        for (String id : this.gameMap.keySet()) {
            
            // Gives datareader correct path to rooms info
            this.roomDataReader = new RoomDataReader("src/main/java/gameproject/textadventure/logic/gameMap/roomData/" + id + ".txt");
            
            Room currentRoom = this.gameMap.get(id);
            
            this.roomDataReader.assignRoomNeighbours(currentRoom, this.gameMap);
            this.roomDataReader.assignDescription(currentRoom);
            
        }
        
    }
    
    
    // Creates a map with empty rooms
    public void createEmptyMap() {
        for (int i = 0; i < this.roomAmount; i++) {
            this.gameMap.put("R" + i, new Room("R" + i));
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
