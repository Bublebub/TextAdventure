
package gameproject.textadventure.logic.gameEvent;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.character.enemies.Enemy;


public class CombatEvent {
    
    private Player player;
    private Enemy enemy;
    
    public CombatEvent(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }
    
    /**
     * Starts combat event loop
     */
    public void start() {
        
        while (true) {
            
            if (PlayerDead()) {
                break;
                
            } else if (EnemyDead()) {
                break;
                
            }
            
            
        }
    }
    
    /**
     * Checks if Player is dead
     * 
     * @return true if Player is dead
     */
    public boolean PlayerDead() {
        if (this.player.getHealth() <= 0) {
                System.out.println("You have been killed by " + this.enemy.getName());
                return true;
        }
        return false;
    }
    
    /**
     * Returns true if Enemy is dead
     * 
     * @return true if Enemy is dead
     */
    public boolean EnemyDead() {
        
        if (this.enemy.getHealth() <= 0) {
                System.out.println("You have slain your enemy");
                this.enemy.getLocation().setEnemy(null);
                return true;
        }
        return false;
        
    }
    
    /**
     * Handles Players combat commands
     * 
     * @param command 
     */
    public void PlayerAction(String command) {
        
        if (command.equals("attack")) {
            this.player.AttackEnemy(this.enemy);
        }
    }
    
    
    
    
}
