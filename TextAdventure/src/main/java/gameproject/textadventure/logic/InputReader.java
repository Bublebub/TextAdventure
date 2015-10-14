
package gameproject.textadventure.logic;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameEvent.CombatEvent;
import javax.swing.JTextArea;


/**
 * Reads commands from the user
 * 
 * @author Elmeri
 */
public class InputReader {

    private Player player;
    public boolean inCombat;    // Used to check if player is in combat
    public CombatEvent battle;
    public JTextArea textArea;
    
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
        otherCommands(command);
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
    
    private void otherCommands(String command) {
        
        if (command.equals("loot")) {
            this.player.LootItem();
        } else if (command.startsWith("use")) {
            this.player.UseItem(command);
        }
    }
    
    /**
     * Checks if combat should be initialized
     * (if the Room(Players current location) contains an Enemy)
     */
    private void checkRoomForEnemy() {
        if (this.player.getLocation().containsEnemy() 
                && (this.player.getLocation().getEnemy().getHealth() > 0)) {
            this.battle = new CombatEvent(this.player, this.player.getLocation().getEnemy());
            
            this.textArea.append(this.battle.GetEnemy().getName() + " appears!\n");
            
            inCombat = true;
            
            this.battle.SetTextDisplay(this.textArea);
        }
    }
    
    
    //      -- Setters --
    
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void setTextArea(JTextArea display) {
        this.textArea = display;
    }
    
    //      -- Getters --
    
    public Player GetPlayer() {
        return this.player;
    }
    
    public CombatEvent GetBattle() {
        return this.battle;
    }
    
    
}
