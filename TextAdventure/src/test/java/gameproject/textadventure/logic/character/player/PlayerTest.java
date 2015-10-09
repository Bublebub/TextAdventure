
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.gameMap.AreaBuilder;
import gameproject.textadventure.logic.gameMap.Room;
import gameproject.textadventure.userInterface.UserInterface;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {
    
    AreaBuilder mapMaker;
    Player player;
    UserInterface ui;
    InputReader reader;
    
    @Before
    public void setUp() {
        this.mapMaker = new AreaBuilder(18);
        this.reader = new InputReader();
        this.ui = new UserInterface(this.reader);
        
        try {
            this.mapMaker.buildArea();
        } catch (Exception e) {
            System.out.println("Didn't work");
        }
        
        this.player = new Player((Room) this.mapMaker.getGameMap().get("R16"));
        
        this.reader.setPlayer(this.player);
        
        ui.run();
        
        player.setTextArea(ui);
        
    }
    
    
    @Test
    public void ConstructorSetsPlayerToStartRoom() {
        assertEquals(this.mapMaker.getGameMap().get("R16"), this.player.getLocation());
    }
    
    
    // Movement tests from starting room
    
    
    @Test
    public void playerCanMoveToEastRoomFromStart() {
        this.player.moveEast();
        assertEquals(this.mapMaker.getGameMap().get("R17"), this.player.getLocation());
    }
    
    @Test
    public void playerCanMoveToWestRoomFromStart() {
        this.player.moveWest();
        assertEquals(this.mapMaker.getGameMap().get("R15"), this.player.getLocation());
    }
    
    @Test
    public void playerCanNotMoveToSouthFromStart() {
        this.player.moveSouth();
        
        // If player can't move, currentLocation stays the same
        assertEquals(this.mapMaker.getGameMap().get("R16"), this.player.getLocation());
    }
    
    @Test
    public void playerCanNotMoveToNorthFromStart() {
        this.player.moveNorth();
        
        // If player can't move, currentLocation stays the same
        assertEquals(this.mapMaker.getGameMap().get("R16"), this.player.getLocation());
    }
    
    
    // Movement tests from other rooms
    
    
    @Test
    public void playerCanNotMoveToWestFromOtherRoom() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R11"));
        
        this.player.moveWest();
        
        assertEquals(this.mapMaker.getGameMap().get("R11"), this.player.getLocation());
    }
    
    @Test
    public void playerCanMoveToNorthFromOtherRoom() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R15"));
        
        this.player.moveNorth();
        
        assertEquals(this.mapMaker.getGameMap().get("R11"), this.player.getLocation());
    }
    
    
    @Test
    public void playerCanNotMoveToEastFromOtherRoom() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R17"));
        
        this.player.moveEast();
        
        assertEquals(this.mapMaker.getGameMap().get("R17"), this.player.getLocation());
    }
    
    @Test
    public void playerCanMoveToSouthFromOtherRoom() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R11"));
        
        this.player.moveSouth();
        
        assertEquals(this.mapMaker.getGameMap().get("R15"), this.player.getLocation());
    }
    
    
}
