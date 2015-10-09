
package gameproject.textadventure.logic.gameEvent;

import gameproject.textadventure.logic.character.enemies.Enemy;
import gameproject.textadventure.logic.character.enemies.Goblin;
import gameproject.textadventure.logic.character.player.Player;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class CombatEventTest {
    
    Player player;
    Enemy enemy;
    CombatEvent combat;
    
    @Before
    public void setUp() {
        this.player = new Player(null);
        this.enemy = new Goblin();
        this.combat = new CombatEvent(this.player, this.enemy);
    }
    
    
    @Test
    public void PlayerActionReturnsTrueIfCommandIsAttack() {
        assertEquals(true, this.combat.PlayerAction("attack"));
    }
    
    @Test
    public void PlayerActionReturnsFalseIfCommandIsNotValid() {
        assertEquals(false, this.combat.PlayerAction("test"));
    }
    

    @Test
    public void PlayerDeadReturnsTrueIfDead() {
        this.player.setHealth(0);
        
        assertEquals(true, this.combat.PlayerDead());
    }
    
    @Test
    public void PlayerDeadReturnsFalseIfNotDead() {
        assertEquals(false, this.combat.PlayerDead());
    }
    
    
    @Test
    public void EnemyDeadReturnsTrueIfDead() {
        this.enemy.setHealth(0);
        
        assertEquals(true, this.combat.EnemyDead());
    }
    
    @Test
    public void EnemyDeadReturnsFalseIfNotDead() {
        assertEquals(false, this.combat.EnemyDead());
    }
    
    
}
