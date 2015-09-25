
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.gameMap.AreaBuilder;
import gameproject.textadventure.logic.gameMap.Room;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {
    
    AreaBuilder mapMaker;
    Player player;
    
    @Before
    public void setUp() {
        this.mapMaker = new AreaBuilder(6);
        
        try {
            this.mapMaker.buildArea();
        } catch (Exception e) {
            System.out.println("Didn't work");
        }
        
        this.player = new Player((Room) this.mapMaker.getGameMap().get("R0"));
        
    }
    
    
    @Test
    public void ConstructorSetsPlayerToStartRoom() {
        assertEquals(this.mapMaker.getGameMap().get("R0"), this.player.getLocation());
    }
    
    
    // Movement tests from starting room
    
    
    @Test
    public void playerCanMoveToEastRoomFromStart() {
        this.player.moveEast();
        assertEquals(this.mapMaker.getGameMap().get("R1"), this.player.getLocation());
    }
    
    @Test
    public void playerCanMoveToSouthRoomFromStart() {
        this.player.moveSouth();
        assertEquals(this.mapMaker.getGameMap().get("R2"), this.player.getLocation());
    }
    
    @Test
    public void playerCanNotMoveToWestFromStart() {
        this.player.moveWest();
        
        // If player can't move, currentLocation stays the same
        assertEquals(this.mapMaker.getGameMap().get("R0"), this.player.getLocation());
    }
    
    @Test
    public void playerCanNotMoveToNorthFromStart() {
        this.player.moveNorth();
        
        // If player can't move, currentLocation stays the same
        assertEquals(this.mapMaker.getGameMap().get("R0"), this.player.getLocation());
    }
    
    
    // Movement tests from other rooms
    
    
    @Test
    public void playerCanMoveToWestFromOtherRoom() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R1"));
        
        this.player.moveWest();
        
        assertEquals(this.mapMaker.getGameMap().get("R0"), this.player.getLocation());
    }
    
    @Test
    public void playerCanMoveToNorthFromOtherRoom() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R2"));
        
        this.player.moveNorth();
        
        assertEquals(this.mapMaker.getGameMap().get("R0"), this.player.getLocation());
    }
    
    
    @Test
    public void playerCanNotMoveToEastFromOtherRoom() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R1"));
        
        this.player.moveNorth();
        
        assertEquals(this.mapMaker.getGameMap().get("R1"), this.player.getLocation());
    }
    
    @Test
    public void playerCanNotMoveToSouthFromOtherRoom() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R4"));
        
        this.player.moveSouth();
        
        assertEquals(this.mapMaker.getGameMap().get("R4"), this.player.getLocation());
    }
    
    
}
