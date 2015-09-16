
package gameproject.textadventure.logic;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameEvent.CombatEvent;
import java.util.Scanner;



public class InputReader {
    
    Scanner scanner;
    Player player;
    
    public void start(Player player) {
        
        this.player = player;
        
        while (true) {
            System.out.print("Command: ");
            this.scanner = new Scanner(System.in);
            
            String command = trimCommand(this.scanner.nextLine());
            
            movementCommands(command);
            checkRoomForEnemy();
            
            
            if (command.equals("exit")) {
                break;
            }
        }
    }
    
    
    private String trimCommand(String command) {
        command.toLowerCase();
        command.trim();
        
        return command;
    }
    
    
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
    
    // Checks if combat should be initialized
    private void checkRoomForEnemy() {
        if (this.player.getLocation().containsEnemy()) {
            CombatEvent combat = new CombatEvent(this.player, this.player.getLocation().getEnemy());
            combat.start();
        }
    }
    
    
    
}
