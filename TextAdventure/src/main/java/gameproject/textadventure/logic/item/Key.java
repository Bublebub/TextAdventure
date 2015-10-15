
package gameproject.textadventure.logic.item;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.AreaBuilder;
import gameproject.textadventure.logic.gameMap.Room;

public class Key implements Item {

    private String name, description;
    private AreaBuilder area;   // Used to find rooms that will be connected
    
    public Key(AreaBuilder area) {
        this.name = "Key";
        this.area = area;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void Use(Player player) {
        if (player.getLocation().equals(this.area.getGameMap().get("R11")) || 
                player.getLocation().equals(this.area.getGameMap().get("R6"))) {
            
            // Gets the rooms which have the same door
            Room roomSouth = (Room) this.area.getGameMap().get("R11");
            Room roomNorth = (Room) this.area.getGameMap().get("R6");
            
            // Sets the rooms to neighbours (opens a door)
            roomSouth.setNorth(roomNorth);
            roomNorth.setSouth(roomSouth);
            
            player.getTextArea().append("You use " + name + " to unlock the door\n\n");
            player.inventory.removeItem(name);
        } else {
            player.getTextArea().append("Can't use this here...\n\n");
        }
        
        
    }
    
}
