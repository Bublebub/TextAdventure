
package gameproject.textadventure.userInterface.components;


import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.AreaBuilder;
import gameproject.textadventure.logic.gameMap.Room;
import gameproject.textadventure.userInterface.UserInterface;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TextDisplayTest {
    
    AreaBuilder mapMaker;
    InputReader reader;
    UserInterface ui;
    Player player;
    
    @Before
    public void setUp() {
        this.mapMaker = new AreaBuilder(6);
        this.reader = new InputReader();
        this.ui = new UserInterface(this.reader);
        
        try {
            this.mapMaker.buildArea();
        } catch (Exception e) {
            System.out.println("Didn't work");
        }
        
        this.player = new Player((Room) this.mapMaker.getGameMap().get("R0"));
        
        this.reader.setPlayer(this.player);
        
        ui.run();
        
        player.setTextDisplay(ui);
    }
    
    @Test
    public void TextDisplayShowsRightTextWhenNotPossibleToMoveEast() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R5"));
        this.player.moveEast();
        assertEquals(this.ui.getTextDisplay().getText(), "Can't move there!\n");
    }
    
    @Test
    public void TextDisplayShowsRightTextWhenNotPossibleToMoveSouth() {
        this.player.setLocation((Room) this.mapMaker.getGameMap().get("R5"));
        this.player.moveSouth();
        assertEquals(this.ui.getTextDisplay().getText(), "Can't move there!\n");
    }
    
    @Test
    public void TextDisplayShowsRightTextWhenNotPossibleToMoveWest() {
        this.player.moveWest();
        assertEquals(this.ui.getTextDisplay().getText(), "Can't move there!\n");
    }
    
    @Test
    public void TextDisplayShowsRightTextWhenNotPossibleToMoveNorth() {
        this.player.moveNorth();
        assertEquals(this.ui.getTextDisplay().getText(), "Can't move there!\n");
    }
}
