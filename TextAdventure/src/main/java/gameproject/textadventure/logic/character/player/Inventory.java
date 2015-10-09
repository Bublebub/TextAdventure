
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.item.Item;
import gameproject.textadventure.userInterface.components.TextDisplay;
import java.util.HashMap;
import java.util.Map;


public class Inventory {
    
    
    private TextDisplay itemDisplay;
    private Map<String, Item> itemMap = new HashMap<>();
    
    public void Inventory() {
        this.itemDisplay = null;
    }
    
    /**
     * Search for an item from the inventory
     * 
     * @param command contains wanted item
     * 
     * @return wanted Item
     */
    public Item SearchItem(String command) {
        String wanted = command.substring(4);
        
        for (String itemName : this.itemMap.keySet()) {
            if (wanted.equals(itemName.toLowerCase())) {
                return this.itemMap.get(itemName);
            }
        }
        
        return null;
    }
    
    
    /**
     * Clears inventory display and adds all inventory Items names to it
     */
    public void RefreshItemDisplay() {
        this.itemDisplay.ClearDisplay();
        for (String name : this.itemMap.keySet()) {
            this.itemDisplay.AddLine(name + "\n");
        }
    }
    
    /**
     * Adds given Item to inventory
     * 
     * @param name Item name
     * @param item 
     */
    public void AddItem(String name, Item item) {
        this.itemMap.put(name, item);
        this.itemDisplay.AddLine(name + "\n");
    }
    
    /**
     * Removes Item from inventory and refreshes inventory display
     * 
     * @param name 
     */
    public void removeItem(String name) {
        this.itemMap.remove(name);
        RefreshItemDisplay();
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
