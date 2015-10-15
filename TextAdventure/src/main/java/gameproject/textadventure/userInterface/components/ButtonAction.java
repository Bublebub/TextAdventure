
package gameproject.textadventure.userInterface.components;

import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.userInterface.UserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonAction implements ActionListener {
    private String command;
    private UserInterface ui;
    private InputReader reader;
    private boolean inCombat;
    private Player player;
    
    public ButtonAction(String text, UserInterface newUI, InputReader input) {
        this.command = text;
        this.ui = newUI;
        this.reader = input;
        this.player = newUI.GetPlayer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (this.player.getHealth() > 0) {
            if (reader.inCombat && (reader.battle != null)) {
                this.inCombat = !reader.battle.ExecuteCombatRound(this.command);
                reader.inCombat = this.inCombat;
            } else {
                reader.ExecuteCommand(this.command);
            }
        }
        
    }
}
