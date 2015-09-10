
package gameproject.textadventure.logic;

import gameproject.textadventure.logic.gameMap.Room;
import java.io.File;
import java.util.Scanner;


public class RoomDataReader {
    
    Scanner scanner;
    
    public RoomDataReader(String fileLocation) throws Exception {
        this.scanner = new Scanner(new File(fileLocation));
    }
    
    public void assignRoomNeigbours(Room room) {
        
    }
    
    
    //          -- Getters --
    
    // Returns next word from file
    public String getNext() {
        return this.scanner.next();
    }
    
    // Returns next line from file
    public String getNextLine() {
        return this.scanner.nextLine();
    }
    
    
}
