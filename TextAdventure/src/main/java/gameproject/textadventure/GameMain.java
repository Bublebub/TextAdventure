
package gameproject.textadventure;


import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.AreaBuilder;
import gameproject.textadventure.logic.gameMap.Room;
import gameproject.textadventure.userInterface.UserInterface;


public class GameMain {

    public static void main(String[] args) {
        
        AreaBuilder area = new AreaBuilder(18);
        InputReader input = new InputReader();
        UserInterface ui = new UserInterface(input);
        
        try {
            area.buildArea();
        } catch (Exception e) {
            System.out.println("Couldn't build the area");
        }
        
        Player player = new Player((Room) area.getGameMap().get("R16"));
        
        input.setPlayer(player);
        ui.setPlayer(player);
        
        ui.run();
        
        input.setTextArea(ui.getTextArea());
        
        player.setTextArea(ui);
        player.inventory.setInventoryDisplay(ui.getInventoryDisplay());
        
        
        
    }
    
}
