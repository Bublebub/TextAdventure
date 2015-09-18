
package gameproject.textadventure.logic.gameEvent;

import gameproject.textadventure.logic.character.enemies.Enemy;
import gameproject.textadventure.logic.character.player.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CombatEventTest {
    
    Player player;
    Enemy enemy;
    CombatEvent combat;
    
    @Before
    public void setUp() {
        this.player = new Player(null);
        this.combat = new CombatEvent(this.player, this.enemy);
    }

    
}
