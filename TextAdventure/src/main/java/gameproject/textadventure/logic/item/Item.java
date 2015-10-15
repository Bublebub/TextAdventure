
package gameproject.textadventure.logic.item;

import gameproject.textadventure.logic.character.player.Player;


public interface Item {
    public String getName();
    public void Use(Player player);
}
