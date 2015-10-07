
package gameproject.textadventure.logic.character.player;

import gameproject.textadventure.logic.item.Item;
import java.util.HashMap;
import java.util.Map;


public class Inventory {
    
    private Map<String, Item> itemMap;
    
    public void Inventory() {
        this.itemMap = new HashMap<>();
    }
    
    public void AddItem(String name, Item item) {
        this.itemMap.put(name, item);
    }
    
    //      -- Getters --
    
    public Item GetItem(String name) {
        return this.itemMap.get(name);
    }
    
}
