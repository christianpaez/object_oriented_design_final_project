package filters.test;

import filters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertTrue(((BasicFilter)f).getWord().equals("trump"));
    }

    @Test
    public void testOrSimple() throws SyntaxError {
        Filter f = new Parser("trump or clinton").parse();
        assertTrue(f.toString().equals("(trump or clinton)"));
    }

    @Test
    public void testAndSimple() throws SyntaxError {
        Filter f = new Parser("obama and trump").parse();
        assertTrue(f.toString().equals("(obama and trump)"));
    }

    @Test
    public void testHairy() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        assertTrue(x.toString().equals("(((trump and (evil or blue)) and red) or (green and not not purple))"));
    }
}
