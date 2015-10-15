
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
    public Item searchItem(String command) {
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
    public void refreshItemDisplay() {
        this.itemDisplay.clearDisplay();
        for (String name : this.itemMap.keySet()) {
            this.itemDisplay.addLine(name + "\n");
        }
    }
    
    /**
     * Adds given Item to inventory
     * 
     * @param name Item name
     * @param item 
     */
    public void addItem(String name, Item item) {
        this.itemMap.put(name, item);
        this.itemDisplay.addLine(name + "\n");
    }
    
    /**
     * Removes Item from inventory and refreshes inventory display
     * 
     * @param name 
     */
    public void removeItem(String name) {
        this.itemMap.remove(name);
        refreshItemDisplay();
    }
    
    //      -- Setters --
    
    public void setInventoryDisplay(TextDisplay display) {
        this.itemDisplay = display;
    }
    
    //      -- Getters --
    
    public Item getItem(String name) {
        return this.itemMap.get(name);
    }
    
}
