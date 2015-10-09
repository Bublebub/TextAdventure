
package gameproject.textadventure.logic.item;

import gameproject.textadventure.logic.character.player.Player;


public class HealthPotion implements Item {

    private String name, description;
    private int healAmount;
    
    public HealthPotion(int hp) {
        name = "Health Potion";
        healAmount = hp;
        description = "Heals for " + healAmount + " hp";
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    

    @Override
    public void Use(Player player) {
        player.setHealth(player.getHealth() + healAmount);
        
        if (player.getHealth() > 100) {
            player.setHealth(100);
        }
        
    }
    
    
    
}
