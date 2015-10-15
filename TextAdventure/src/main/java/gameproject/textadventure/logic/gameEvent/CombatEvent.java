
package gameproject.textadventure.logic.gameEvent;

import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.character.enemies.Enemy;
import javax.swing.JTextArea;


public class CombatEvent {
    
    private Player player;
    private Enemy enemy;
    private JTextArea textArea;
    
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
    public boolean executeCombatRound(String command) {
        
        // Player turn
        if (!playerAction(command)) {
            return false;
        }
        if (enemyDead()) {
            return true;
        }
        
        // Enemy turn
        this.enemy.attackPlayer(this.player);
        if (playerDead()) {
            return true;
        }
        
        // Displays current health situation
        textArea.append("Player hp: " + this.player.getHealth() + ", "
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
    public boolean playerAction(String command) {
        
        if (command.equals("attack")) {
            this.player.attackEnemy(this.enemy);
            return true;
        } else if (command.equals("defend")) {
            return !this.player.defend();
        }
        
        return false;
    }
    
    /**
     * Checks if Player is dead
     * 
     * @return true if Player is dead
     */
    public boolean playerDead() {
        if (this.player.getHealth() <= 0) {
                textArea.append("You have been killed by " + this.enemy.getName() + "\n\n");
                return true;
        }
        return false;
    }
    
    /**
     * Checks if Enemy is dead
     * 
     * @return true if Enemy is dead
     */
    public boolean enemyDead() {
        
        if (this.enemy.getHealth() <= 0) {
                textArea.append("You have slain your enemy!\n\n");
                return true;
        }
        return false;
        
    }
    
    //      -- Setters --
    
    public void setTextArea(JTextArea textDisplay) {
        textArea = textDisplay;
    }
    
    //      -- Getters --
    
    public Enemy getEnemy() {
        return this.enemy;
    }
}
