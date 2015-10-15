
package gameproject.textadventure.logic.item;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameMap.AreaBuilder;


public class Rope implements Item{

    private String name;
    private AreaBuilder area;
    
    public Rope(AreaBuilder area) {
        this.name = "Rope";
        this.area = area;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void Use(Player player) {
        if (player.getLocation().equals(this.area.getGameMap().get("R16"))) {
            player.getTextArea().append("You tie up the rope to a rock and throw it up the well.\n"
                    + " It seems like it has stuck between something quite nicely, so you try to risk it and climb up the slippery walls...\n"
                    + "And little by little, you manage to climb up and push yourself back to your own backyard!\n"
                    + "Congratulations! You have succesfully escaped the dungeon!\n");
            
            player.setHealth(0);    // Stops player from using commands
            player.inventory.removeItem(name);
        } else {
            player.getTextArea().append("Can't use this here...\n\n");
        }
    }
    
}
