
package gameproject.textadventure.logic.character.enemies;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.Room;


public interface Enemy {
    
    public String getName();
    public int getHealth();
    public int getAttack();
    public Room getLocation();
    
    public void setName(String name);
    public void setHealth(int newHealth);
    public void setAttack(int newAttack);
    public void setLocation(Room newLocation);
    
    
    public void attackPlayer(Player player);
    
    
}
