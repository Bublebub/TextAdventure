
package gameproject.textadventure.logic;

import gameproject.textadventure.logic.gameMap.Room;
import java.io.File;
import java.util.Map;
import java.util.Scanner;

/**
 * Reads rooms info from textfiles
 * 
 * @author Elmeri
 */
public class RoomDataReader {
    
    private Scanner scanner;
    
    /**
     * Constuctor is given files location
     * 
     * @param fileLocation path to the file
     * 
     * @throws Exception 
     */
    public RoomDataReader(String fileLocation) throws Exception {
        this.scanner = new Scanner(new File(fileLocation));
    }
    
    /**
     * Assigns all neighbours for given Room
     * 
     * @param room
     * 
     * @param map gets neighbours from the Map
     */
    public void assignRoomNeighbours(Room room, Map<String, Room> map) {
        
        for (int i = 0; i < 4; i++) {
            String neighbour = this.scanner.next(); // Gets neighbours side (E, W, S, N)
            
            if (neighbour.equals("East:")) {
                assignEastNeighbour(room, map);
                
            } else if (neighbour.equals("West:")) {
                assignWestNeighbour(room, map);
                
            } else if (neighbour.equals("South:")) {
                assignSouthNeighbour(room, map);
                
            } else if (neighbour.equals("North:")) {
                assignNorthNeighbour(room, map);
            }
        }
    }
    
    private void assignEastNeighbour(Room room, Map map) {
        String wallOrRoom = this.scanner.next();
                
        if (!wallOrRoom.equals("Wall")) {
            room.setEast((Room) map.get(wallOrRoom));
        }
    }
    
    private void assignWestNeighbour(Room room, Map map) {
        String wallOrRoom = this.scanner.next();
                
        if (!wallOrRoom.equals("Wall")) {
            room.setWest((Room) map.get(wallOrRoom));
        }
    }
    
    private void assignSouthNeighbour(Room room, Map map) {
        String wallOrRoom = this.scanner.next();
                
        if (!wallOrRoom.equals("Wall")) {
            room.setSouth((Room) map.get(wallOrRoom));
        }
    }
    
    private void assignNorthNeighbour(Room room, Map map) {
        String wallOrRoom = this.scanner.next();
                
        if (!wallOrRoom.equals("Wall")) {
            room.setNorth((Room) map.get(wallOrRoom));
        }
    }
    
    
    /**
     * Assigns description to given Room from textfile
     * 
     * @param room 
     */
    public void assignDescription(Room room) {
        
        if (this.scanner.next().equals("Description:")) {
            String description = "";
            
            while (this.scanner.hasNextLine()) {
                description += this.scanner.nextLine();
            }
            
            room.setDescription(description);
        }
    }
}
