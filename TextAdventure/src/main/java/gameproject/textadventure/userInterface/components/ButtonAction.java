
package gameproject.textadventure.userInterface.components;

import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.userInterface.UserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonAction implements ActionListener {
    private String command;
    private UserInterface ui;
    private InputReader reader;
    
    public ButtonAction(String text, UserInterface newUI, InputReader input) {
        this.command = text;
        this.ui = newUI;
        this.reader = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.command.startsWith("go") || this.command.equals("loot")) {
            reader.ExecuteCommand(command);
        } else {
            
        }
    }
}
