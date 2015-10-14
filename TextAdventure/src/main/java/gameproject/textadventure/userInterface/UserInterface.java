
package gameproject.textadventure.userInterface;

import gameproject.textadventure.logic.InputReader;
import gameproject.textadventure.logic.character.player.Player;
import gameproject.textadventure.userInterface.components.ButtonAction;
import gameproject.textadventure.userInterface.components.CommandFieldAction;
import gameproject.textadventure.userInterface.components.TextDisplay;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {
    
    JFrame frame;
    Player player;
    
    JLabel commandLabel;
    
    InputReader reader;
    JTextField textField;
    
    JTextArea textArea, inventory;
    JScrollPane textAreaScrollPane, inventoryScrollPane;
    TextDisplay textDisplay, inventoryDisplay;
    
    JButton eastBtn = new JButton("go East"),
            westBtn = new JButton("go West"),
            southBtn = new JButton("go South"),
            northBtn = new JButton("go North"),
            attackBtn = new JButton("Attack"),
            defendBtn = new JButton("Defend"),
            lootBtn = new JButton("Loot");
    
    public UserInterface(InputReader inputReader) {
        this.reader = inputReader;
    }
    
    @Override
    public void run() {
        
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(640, 340));
        
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame);
        frame.setVisible(true);
        
        frame.setResizable(false);
        
        frame.pack();
        
        
    }
    
    /**
     * Creates all the components for JFrame
     * 
     * @param container JFrame where components are added
     */
    private void createComponents(JFrame container) {
        createLabel(container);
        createCommandField(container);
        createTextDisplayArea(container);
        createInventory(container);
        createButtons(container);
    }
    
    /**
     * Creates label for commandfield
     * 
     * @param container JFrame where components are added
     */
    private void createLabel(JFrame container) {
        commandLabel = new JLabel();
        
        commandLabel.setText("Commandfield");
        commandLabel.setBounds(10, 193, 250, 22);
        
        container.add(commandLabel);
    }
    
    /**
     * Creates TextField for Player commands
     * 
     * @param container JFrame where components are added
     */
    private void createCommandField(JFrame container){
        textField = new JTextField();
        
        textField.addActionListener(new CommandFieldAction(textField, this.reader, this));
        
        textField.setBounds(10, 215, 250, 22);
        
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
        
        textArea.setText(" Welcome Adventurer!\n" + "Commands: loot, go east/west/south/north\n" + "Combat commands: attack/defend\n\n");
        textArea.append(" You wake up in a cold and dark dungeon and the last thing you remember was falling into a well while you \n were getting some water for your dogs...\n"
                + " After looking around for a while, you see that it is only possible to continue either to the West or to the East.\n\n");
        
        container.add(textAreaScrollPane);
    }
    
    /**
     * Creates Inventory where items are shown
     * 
     * @param container JFrame where components are added
     */
    private void createInventory(JFrame container) {
        inventory = new JTextArea();
        inventoryScrollPane = new JScrollPane(inventory);
        inventoryDisplay = new TextDisplay(inventory);
        
        inventoryScrollPane.setBounds(10, 245, 150, 60);
        inventoryScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        
        inventory.setLineWrap(true);
        
        container.add(inventoryScrollPane);
    }
    
    public void createButtons(JFrame container) {
        eastBtn.addActionListener(new ButtonAction("go east", this, this.reader));
        westBtn.addActionListener(new ButtonAction("go west", this, this.reader));
        southBtn.addActionListener(new ButtonAction("go south", this, this.reader));
        northBtn.addActionListener(new ButtonAction("go north", this, this.reader));
        
        attackBtn.addActionListener(new ButtonAction("attack", this, this.reader));
        defendBtn.addActionListener(new ButtonAction("defend", this, this.reader));
        
        lootBtn.addActionListener(new ButtonAction("loot", this, this.reader));
        
        ButtonPositionSetup();
        
        container.add(eastBtn);
        container.add(westBtn);
        container.add(southBtn);
        container.add(northBtn);
    }
    
    public void ButtonPositionSetup() {
        eastBtn.setBounds(390, 240, 90, 30);
        westBtn.setBounds(300, 240, 90, 30);
        southBtn.setBounds(345, 270, 90, 30);
        northBtn.setBounds(345, 210, 90, 30);
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
    
    public JLabel GetCommandLabel() {
        return commandLabel;
    }
}
