
package gameproject.textadventure.userInterface.components;

import javax.swing.JTextArea;


public class TextDisplay {
    
    JTextArea display;
    
    public TextDisplay(JTextArea area) {
        display = area;
        display.setEditable(false);
    }
    
}
