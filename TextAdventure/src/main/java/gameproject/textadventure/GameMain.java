
package gameproject.textadventure;

import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.AreaBuilder;
import gameproject.textadventure.logic.gameMap.Room;


public class GameMain {


    public static void main(String[] args) {
        // TODO code application logic here
        
        AreaBuilder area = new AreaBuilder(4);
        InputReader input = new InputReader();
        
        try {
            area.buildArea();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        Player player = new Player((Room) area.getGameMap().get("R0"));
        input.start(player);
        
        System.out.println("Hello");
    }
    
}
