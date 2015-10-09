
package gameproject.textadventure.userInterface.components;

import javax.swing.JTextArea;


public class TextDisplay {
    
    private JTextArea display;
    
    public TextDisplay(JTextArea area) {
        display = area;
        display.setEditable(false);
    }
    
    /**
     * Adds String to display
     * 
     * @param line 
     */
    public void AddLine(String line) {
        this.display.append(line);
    }
    
    /**
     * Clears display text
     */
    public void ClearDisplay() {
        this.display.setText("");
    }

    
}
