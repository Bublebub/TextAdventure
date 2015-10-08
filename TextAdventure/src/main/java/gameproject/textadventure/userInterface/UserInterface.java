
package gameproject.textadventure.userInterface;

import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.userInterface.components.CommandFieldAction;
import gameproject.textadventure.userInterface.components.TextDisplay;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {
    
    JFrame frame;
    Player player;
    
    InputReader reader;
    JTextField textField;
    
    JTextArea textArea, inventory;
    JScrollPane textAreaScrollPane, inventoryScrollPane;
    TextDisplay textDisplay, inventoryDisplay;
    
    public UserInterface(InputReader inputReader) {
        this.reader = inputReader;
    }
    
    @Override
    public void run() {
        
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(640, 480));
        
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame);
        frame.setVisible(true);
        
        frame.setResizable(false);
        
        frame.pack();
        
        
    }
    
    
    private void createComponents(JFrame container) {
        createCommandField(container);
        createTextDisplayArea(container);
        createInventory(container);
    }
    
    
    /**
     * Creates TextField for Player commands
     * 
     * @param container JFrame where components are added
     */
    private void createCommandField(JFrame container){
        textField = new JTextField();
        
        textField.addActionListener(new CommandFieldAction(textField, this.reader, this));
        
        textField.setBounds(10, 340, 250, 22);
        
        container.add(textField);
    }
    
    /**
     * Creates TextArea to display games information
     * 
     * @param container JFrame where components are added
     */
    private void createTextDisplayArea(JFrame container) {
        textArea = new JTextArea();
        textAreaScrollPane = new JScrollPane(textArea);
        textDisplay = new TextDisplay(textArea);
        
        textAreaScrollPane.setBounds(10, 10, 615, 180);
        textAreaScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        
        textArea.setLineWrap(true);
        
        textArea.setText("Commands: go east / west / south / north\n" + "Combat commands: attack\n");
        
        container.add(textAreaScrollPane);
    }
    
    private void createInventory(JFrame container) {
        inventory = new JTextArea();
        inventoryScrollPane = new JScrollPane(inventory);
        inventoryDisplay = new TextDisplay(inventory);
        
        inventoryScrollPane.setBounds(300, 350, 100, 50);
        inventoryScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        
        inventory.setLineWrap(true);
        
        container.add(inventoryScrollPane);
    }
    
    //      -- Setters --
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    //      -- Getters --
    
    public JTextArea getTextArea() {
        return textArea;
    }
    
    public TextDisplay GetInventoryDisplay() {
        return inventoryDisplay;
    }
}
