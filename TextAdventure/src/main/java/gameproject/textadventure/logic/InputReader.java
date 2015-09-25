
package gameproject.textadventure.logic;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameEvent.CombatEvent;
import java.util.Scanner;


/**
 * Reads commands from the user
 * 
 * @author Elmeri
 */
public class InputReader {
    
    private Scanner scanner;
    private Player player;
    
    public InputReader() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Starts command reading loop
     * 
     * @param player Player affected by commands
     */
    public void start(Player player) {
        
        this.player = player;
        
        while (true) {
            System.out.print("Command: ");
            String command = trimCommand(this.scanner.nextLine());
            
            movementCommands(command);
            checkRoomForEnemy();
            
            
            if (command.equals("exit")) {
                break;
            }
        }
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
            
            System.out.println(this.player.getLocation().getEnemy().getName() + " appears!");
            
            ReadCombatEventCommands(combat);
            
        }
    }
    
    /**
     * Reads commands when combat is initialized and passes them to given CombatEvent
     * 
     * @param combat CombatEvent where the commands are used
     */
    public void ReadCombatEventCommands(CombatEvent combat) {
        
        while (true) {
            System.out.print("Combat Command: ");
            String command = trimCommand(this.scanner.nextLine());
            
            // Executes combat round and breaks the loop when combat ends
            if (combat.ExecuteCombatRound(command)) {
                break;
            }
        }
        
    }
    
}
