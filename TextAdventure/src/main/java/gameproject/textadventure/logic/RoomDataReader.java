
package gameproject.textadventure.logic;

import gameproject.textadventure.logic.gameMap.Room;
import java.io.File;
import java.util.Map;
import java.util.Scanner;


public class RoomDataReader {
    
    Scanner scanner;
    Map gameMap;
    
    public RoomDataReader(String fileLocation) throws Exception {
        this.scanner = new Scanner(new File(fileLocation));
    }
    
    // Assigns all rooms neighbours
    public void assignRoomNeighbours(Room room) {
        String wallOrRoom; // Used to check if side has a room/wall
        
        for (int i = 0; i < 4; i++) {
            String neighbour = this.scanner.next(); // Gets neighbours side (E, W, S, N)
            
            if (neighbour.equals("East:")) {
                assignEastNeighbour(room, this.gameMap);
                
            } else if (neighbour.equals("West:")) {
                assignWestNeighbour(room, this.gameMap);
                
            } else if (neighbour.equals("South:")) {
                assignSouthNeighbour(room, this.gameMap);
                
            } else if (neighbour.equals("North:")) {
                assignNorthNeighbour(room, this.gameMap);
                
            }
        }
    }
    
    
    //  Assigns rooms East neighbour (if it has one)
    public void assignEastNeighbour(Room room, Map<String, Room> map) {
        if (!this.scanner.next().equals("Wall")) {
            room.setEast(map.get(this.scanner.next()));
        }
    }
    
    //  Assigns rooms West neighbour (if it has one)
    public void assignWestNeighbour(Room room, Map<String, Room> map) {
        if (!this.scanner.next().equals("Wall")) {
            room.setWest(map.get(this.scanner.next()));
        }
    }
    
    //  Assigns rooms South neighbour (if it has one)
    public void assignSouthNeighbour(Room room, Map<String, Room> map) {
        if (!this.scanner.next().equals("Wall")) {
            room.setSouth(map.get(this.scanner.next()));
        }
    }
    
    //  Assigns rooms North neighbour (if it has one)
    public void assignNorthNeighbour(Room room, Map<String, Room> map) {
        if (!this.scanner.next().equals("Wall")) {
            room.setNorth(map.get(this.scanner.next()));
        }
    }
    
    
    // Assigns rooms description from file
    public void assignDescription(Room room) {
        String description = "";
        
        while (this.scanner.hasNext()) {
            if (this.scanner.next().equals("Description:")) {
                while (this.scanner.hasNextLine()) {
                    description += this.scanner.nextLine();
                }
            }
        }
        
        room.setDescription(description);
    }
}
