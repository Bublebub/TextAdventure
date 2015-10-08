
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.item.Item;
import gameproject.textadventure.userInterface.components.TextDisplay;
import java.util.HashMap;
import java.util.Map;


public class Inventory {
    
    
    private TextDisplay itemDisplay;
    Map<String, Item> itemMap;
    
    public void Inventory() {
        this.itemMap = new HashMap<>();
        this.itemDisplay = null;
    }
    
    public void refreshItemDisplay() {
    }
    
    public void AddItem(String name, Item item) {
        
        this.itemMap.put(name, item);
        this.itemDisplay.AddLine(name + "\n");
    }
    
    public void removeItem(String name) {
        this.itemMap.remove(name);
        
    }
    
    //      -- Setters --
    
    public void SetInventoryDisplay(TextDisplay display) {
        this.itemDisplay = display;
    }
    
    //      -- Getters --
    
    public Item GetItem(String name) {
        return this.itemMap.get(name);
    }
    
}
