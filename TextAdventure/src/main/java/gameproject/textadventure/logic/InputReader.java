
package gameproject.textadventure.logic;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameEvent.CombatEvent;


/**
 * Reads commands from the user
 * 
 * @author Elmeri
 */
public class InputReader {

    private Player player;
    public String commandt;
    public boolean inCombat;    // Used to check if player is in combat
    public CombatEvent battle;
    
    public InputReader() {
    }
    
    /**
     * Executes given command
     * 
     * @param givenCommand command
     */
    public void ExecuteCommand(String givenCommand) {
        
        String command = trimCommand(givenCommand);
            
        movementCommands(command);
        checkRoomForEnemy();
    }
    
    /**
     * Trims given command
     * 
     * @param command
     * 
     * @return trimmed version of command
     */
    public String trimCommand(String command) {
        String trimmedCommand = command;
        
        trimmedCommand = trimmedCommand.toLowerCase();
        trimmedCommand = trimmedCommand.trim();
        
        return trimmedCommand;
    }
    
    /**
     * Handles movement commands
     * 
     * @param command 
     */
    private void movementCommands(String command) {
        
        if (command.equals("go east")) {
            this.player.moveEast();
            
        } else if (command.equals("go west")) {
            this.player.moveWest();
            
        } else if (command.equals("go south")) {
            this.player.moveSouth();
            
        } else if (command.equals("go north")) {
            this.player.moveNorth();
            
        }
    }
    
    /**
     * Checks if combat should be initialized
     * (if the Room(Players current location) contains an Enemy)
     */
    private void checkRoomForEnemy() {
        if (this.player.getLocation().containsEnemy() 
                && (this.player.getLocation().getEnemy().getHealth() > 0)) {
            CombatEvent combat = new CombatEvent(this.player, this.player.getLocation().getEnemy());
            
            inCombat = true;
            battle = combat;
        }
    }
    
    
    //      -- Setters --
    
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
    //      -- Getters --
    
    public Player GetPlayer() {
        return this.player;
    }
    
    
}
