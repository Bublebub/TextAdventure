
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
     * Handles both Player and Enemy combat commands
     * 
     * @param command
     * 
     * @return true if combat has ended
     */
    public boolean ExecuteCombatRound(String command) {
        
        // Player turn
        if (!PlayerAction(command)) {
            return false;
        }
        if (EnemyDead()) {
            return true;
        }
        
        // Enemy turn
        this.enemy.attackPlayer(this.player);
        if (PlayerDead()) {
            return true;
        }
        
        System.out.print("Player hp: " + this.player.getHealth() + ", ");
        System.out.println(this.enemy.getName() + " hp: "+ this.enemy.getHealth());
        
        return false;
    }
    
    /**
     * Handles Players combat commands
     * 
     * @param command 
     * 
     * @return true if command was accepted
     */
    public boolean PlayerAction(String command) {
        
        if (command.equals("attack")) {
            this.player.AttackEnemy(this.enemy);
            return true;
        }
        
        return false;
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
     * Checks if Enemy is dead
     * 
     * @return true if Enemy is dead
     */
    public boolean EnemyDead() {
        
        if (this.enemy.getHealth() <= 0) {
                System.out.println("You have slain your enemy");
                return true;
        }
        return false;
        
    }
}
