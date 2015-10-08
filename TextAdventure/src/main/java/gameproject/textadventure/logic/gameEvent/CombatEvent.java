
package gameproject.textadventure.logic.gameEvent;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.character.enemies.Enemy;
import javax.swing.JTextArea;


public class CombatEvent {
    
    private Player player;
    private Enemy enemy;
    private JTextArea display;
    
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
        
        // Displays current health situation
        display.append("Player hp: " + this.player.getHealth() + ", "
                + this.enemy.getName() + " hp: "+ this.enemy.getHealth() + "\n");
        
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
        } else if (command.equals("defend")) {
            return !this.player.Defend();
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
                display.append("You have been killed by " + this.enemy.getName());
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
                display.append("You have slain your enemy!\n");
                return true;
        }
        return false;
        
    }
    
    //      -- Setters --
    
    public void SetTextDisplay(JTextArea textDisplay) {
        display = textDisplay;
    }
    
    //      -- Getters --
    
    public Enemy GetEnemy() {
        return this.enemy;
    }
}
