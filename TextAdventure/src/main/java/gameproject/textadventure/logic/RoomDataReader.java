
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
    public void assignRoomNeighbours(Room room, Map<String, Room> map) {
        
        
        for (int i = 0; i < 4; i++) {
            String neighbour = this.scanner.next(); // Gets neighbours side (E, W, S, N)
            String wallOrRoom; // Used to check if side has a room/wall
            
            System.out.print(neighbour);
            
            if (neighbour.equals("East:")) {
                wallOrRoom = this.scanner.next();
                
                System.out.println(wallOrRoom);
                
                if (!wallOrRoom.equals("Wall")) {
                    room.setEast(map.get(wallOrRoom));
                }
                
            } else if (neighbour.equals("West:")) {
                wallOrRoom = this.scanner.next();
        
                System.out.println(wallOrRoom);
                
                if (!wallOrRoom.equals("Wall")) {
                    room.setEast(map.get(wallOrRoom));
                }
                
            } else if (neighbour.equals("South:")) {
                wallOrRoom = this.scanner.next();
        
                System.out.println(wallOrRoom);
                
                if (!wallOrRoom.equals("Wall")) {
                    room.setEast(map.get(wallOrRoom));
                }
                
            } else if (neighbour.equals("North:")) {
                wallOrRoom = this.scanner.next();
        
                System.out.println(wallOrRoom);
                
                if (!wallOrRoom.equals("Wall")) {
                    room.setEast(map.get(wallOrRoom));
                }
                
            }
        }
    }
    
    
    // Assigns rooms description from file
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
