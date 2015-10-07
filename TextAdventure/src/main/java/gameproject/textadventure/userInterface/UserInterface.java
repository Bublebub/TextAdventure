
package gameproject.textadventure.userInterface;

import gameproject.textadventure.logic.InputReader;
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
    InputReader reader;
    JTextField textField;
    JTextArea textArea;
    JScrollPane scrollPane;
    TextDisplay textDisplay;
    
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
        scrollPane = new JScrollPane(textArea);
        textDisplay = new TextDisplay(textArea);
        
        scrollPane.setBounds(10, 20, 250, 300);
        scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        
        textArea.setLineWrap(true);
        
        textArea.setText("Commands: go east / west / south / north\n" + "Combat commands: attack\n");
        
        container.add(scrollPane);
    }
    
    //      -- Getters --
    
    public JTextArea getTextDisplay() {
        return textArea;
    }
}
