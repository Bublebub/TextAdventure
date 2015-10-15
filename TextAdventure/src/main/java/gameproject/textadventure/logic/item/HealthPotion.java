
package gameproject.textadventure.logic.item;

import gameproject.textadventure.logic.character.player.Player;


public class HealthPotion implements Item {

    private String name;
    private int healAmount;
    
    public HealthPotion(int hp) {
        name = "Health Potion";
        healAmount = hp;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void Use(Player player) {
        player.setHealth(player.getHealth() + healAmount);
        player.getTextArea().append(name + " heals you for " + healAmount + "hp" + "\n\n");
        
        if (player.getHealth() > 100) {
            player.setHealth(100);
        }
        
        player.inventory.removeItem(name);
    }
    
}
