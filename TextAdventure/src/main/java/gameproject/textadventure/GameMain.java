
package gameproject.textadventure;

import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.character.enemies.Skeleton;
import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.AreaBuilder;
import gameproject.textadventure.logic.gameMap.Room;


public class GameMain {


    public static void main(String[] args) {
        
        AreaBuilder area = new AreaBuilder(6);
        InputReader input = new InputReader();
        
        try {
            area.buildArea();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        Skeleton enemy = new Skeleton();
        Room room = (Room) area.getGameMap().get("R4");
        room.setEnemy(enemy);
        
        System.out.println("Commands: go east/west/south/north/exit" + "\n" + "Combat commands: attack");
        
        Player player = new Player((Room) area.getGameMap().get("R0"));
        input.start(player);
        
        System.out.println("Bye");
    }
    
}
