
package gameproject.textadventure.userInterface.components;

import gameproject.textadventure.logic.InputReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class CommandFieldAction implements ActionListener {

    private String command;
    private InputReader reader;
    private JTextField commandField;
    
    public CommandFieldAction(JTextField commandField, InputReader input) {
        this.commandField = commandField;
        command = commandField.getText();
        reader = input;
    }
    
    public String getCommand() {
        command = commandField.getText();
        return command;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        reader.ExecuteCommand(getCommand());
    }
    
    
    
    
    
}
