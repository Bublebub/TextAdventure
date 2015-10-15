
package gameproject.textadventure.userInterface.components;

import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.logic.gameEvent.CombatEvent;
import gameproject.textadventure.userInterface.UserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class CommandFieldAction implements ActionListener {

    private String command;
    private InputReader reader;
    private JTextField commandField;
    private boolean inCombat;     // Used to check if player is in combat
    private CombatEvent battle;
    private UserInterface ui;
    private Player player;
    
    public CommandFieldAction(JTextField commandField, InputReader input, UserInterface newUI) {
        this.commandField = commandField;
        this.command = commandField.getText();
        this.reader = input;
        this.inCombat = false;
        this.ui = newUI;
        this.player = newUI.GetPlayer();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (this.player.getHealth() > 0) {
            if (reader.inCombat && (reader.battle != null)) {
                this.inCombat = !reader.battle.ExecuteCombatRound(getCommand());
                reader.inCombat = this.inCombat;
            } else {
                reader.ExecuteCommand(getCommand());
            }
        }
        
    }
    
    //      -- Getters --
    
    public String getCommand() {
        command = commandField.getText();
        return command;
    }
}
