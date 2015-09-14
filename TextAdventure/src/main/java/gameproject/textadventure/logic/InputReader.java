
package gameproject.textadventure.logic;

import gameproject.textadventure.logic.character.player.Player;
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
            
            if (command.equals("go east")) {
                this.player.moveEast();
            } else if (command.equals("go west")) {
                this.player.moveWest();
            } else if (command.equals("go south")) {
                this.player.moveSouth();
            } else if (command.equals("go north")) {
                this.player.moveNorth();
            } else if (command.equals("exit")) {
                break;
            }
        }
    }
    
    
    private String trimCommand(String command) {
        command.toLowerCase();
        command.trim();
        
        return command;
    }
    
    
    
}
