
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
import javax.swing.text.DefaultCaret;

public class UserInterface implements Runnable {
    
    JFrame frame;
    Player player;
    
    JLabel commandLabel, inventoryLabel;
    
    InputReader reader;
    JTextField textField;
    
    JTextArea textArea, inventoryArea;
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
        createLabels(container);
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
    private void createLabels(JFrame container) {
        commandLabel = new JLabel("Commandfield");
        inventoryLabel = new JLabel("Inventory");
        
        commandLabel.setBounds(10, 193, 90, 22);
        inventoryLabel.setBounds(265, 193, 80, 22);
        
        container.add(commandLabel);
        container.add(inventoryLabel);
    }
    
    /**
     * Creates TextField for Player commands
     * 
     * @param container JFrame where components are added
     */
    private void createCommandField(JFrame container){
        textField = new JTextField();
        
        textField.addActionListener(new CommandFieldAction(textField, this.reader, this));
        
        textField.setBounds(10, 215, 220, 22);
        
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
        
        textArea.setLineWrap(true);
        
        //Updates textAreas position
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        textArea.setText(" Welcome Adventurer!\n" + " Commands: go east/west/south/north, loot, use \"item name\"\n" + " Combat commands: attack/defend\n\n");
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
        inventoryArea = new JTextArea();
        inventoryScrollPane = new JScrollPane(inventoryArea);
        inventoryDisplay = new TextDisplay(inventoryArea);
        
        inventoryScrollPane.setBounds(265, 215, 130, 80);
        inventoryScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        
        inventoryArea.setLineWrap(true);
        
        container.add(inventoryScrollPane);
    }
    
    /**
     * Creates all buttons
     * 
     * @param container JFrame where components are added
     */
    public void createButtons(JFrame container) {
        eastBtn.addActionListener(new ButtonAction("go east", this, this.reader));
        westBtn.addActionListener(new ButtonAction("go west", this, this.reader));
        southBtn.addActionListener(new ButtonAction("go south", this, this.reader));
        northBtn.addActionListener(new ButtonAction("go north", this, this.reader));
        
        attackBtn.addActionListener(new ButtonAction("attack", this, this.reader));
        defendBtn.addActionListener(new ButtonAction("defend", this, this.reader));
        
        lootBtn.addActionListener(new ButtonAction("loot", this, this.reader));
        
        buttonPositionSetup();
        addingButtons(container);
        
    }
    
    /**
     * Assigns buttons position
     */
    public void buttonPositionSetup() {
        eastBtn.setBounds(535, 240, 90, 30);
        westBtn.setBounds(445, 240, 90, 30);
        southBtn.setBounds(490, 270, 90, 30);
        northBtn.setBounds(490, 210, 90, 30);
        attackBtn.setBounds(20, 245, 90, 30);
        defendBtn.setBounds(20, 275, 90, 30);
        lootBtn.setBounds(130, 260, 90, 30);
    }
    
    /**
     * Adds buttons to given container
     * 
     * @param container given JFrame
     */
    public void addingButtons(JFrame container) {
        container.add(eastBtn);
        container.add(westBtn);
        container.add(southBtn);
        container.add(northBtn);
        container.add(attackBtn);
        container.add(defendBtn);
        container.add(lootBtn);
    }
    
    //      -- Setters --
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    //      -- Getters --
    
    public Player getPlayer() {
        return player;
    }
    
    public JTextArea getTextArea() {
        return textArea;
    }
    
    public TextDisplay getInventoryDisplay() {
        return inventoryDisplay;
    }
    
    public JLabel getCommandLabel() {
        return commandLabel;
    }
}
