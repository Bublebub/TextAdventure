
package gameproject.textadventure.logic;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class InputReaderTest {

    InputReader reader;
    
    @Before
    public void setUp() {
        this.reader = new InputReader();
    }
    
    
    @Test
    public void trimCommandWorks() {
        String test = " TestString ";
        
        assertEquals("teststring", this.reader.trimCommand(test));
    };
        
    
    
}
