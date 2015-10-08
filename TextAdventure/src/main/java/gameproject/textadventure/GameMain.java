
package gameproject.textadventure;


import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.character.enemies.Skeleton;
import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.AreaBuilder;
import gameproject.textadventure.logic.gameMap.Room;
import gameproject.textadventure.logic.item.HealthPotion;
import gameproject.textadventure.userInterface.UserInterface;


public class GameMain {


    public static void main(String[] args) {
        
        AreaBuilder area = new AreaBuilder(6);
        InputReader input = new InputReader();
        UserInterface ui = new UserInterface(input);
        
        try {
            area.buildArea();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        Skeleton enemy = new Skeleton();
        Room room = (Room) area.getGameMap().get("R4");
        room.setEnemy(enemy);
        
        Player player = new Player((Room) area.getGameMap().get("R0"));
        
        input.setPlayer(player);
        ui.setPlayer(player);
        
        ui.run();
        
        player.setTextDisplay(ui);
        player.inventory.SetInventoryDisplay(ui.GetInventoryDisplay());
        
        //input.start(player);
        
    }
    
}
