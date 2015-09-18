
package gameproject.textadventure.logic.gameEvent;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.character.enemies.Enemy;


public class CombatEvent {
    
    Player player;
    Enemy enemy;
    
    public CombatEvent(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }
    
    // Starts combat event loop
    public void start() {
        
        while (true) {
            
            if (PlayerDead()) {
                break;
            } else if (EnemyDead()) {
                break;
            }
            
            
            
        }
    }
    
    // Return true if player is dead
    public boolean PlayerDead() {
        if (this.player.getHealth() <= 0) {
                System.out.println("You have been slained by " + this.enemy.getName());
                return true;
        }
        return false;
    }
    
    // Returns true if enemy is dead
    public boolean EnemyDead() {
        
        if (this.enemy.getHealth() <= 0) {
                System.out.println("You have slain your enemy");
                this.enemy.getLocation().setEnemy(null);
                return true;
        }
        return false;
        
    }
    
    
    
}
