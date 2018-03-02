import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;
import static org.junit.Assume.*;

public class TDD_Tests {
    
   
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TDD_Tests");
    }
    
    //==============
    // Quote Tests
    //==============
    @Test
    public void quote_getEmptyTag() {
            Quote q = new Quote();
            assertEquals("", q.getTag());
    }
   

    @Test
    public void quote_setTag() {
        Quote q = new Quote();
        q.setTag("round");
        assertEquals("Expected:", "round", q.getTag());
    }
    
    @Test
    public void quote_removeTag() {
        Quote q = new Quote();
        q.setTag("brown");
        q.removeTag();
        assertEquals("", q.getTag());
    }
    
    @Test
    public void quote_hasTag1() {
        Quote q = new Quote();
        q.setTag("brown");
        assertTrue(q.hasTag("brown"));
    }
    
    @Test
    public void quote_hasTag2() {
        Quote q = new Quote();
        q.setTag("brown");
        q.removeTag();
        assertFalse(q.hasTag("brown"));
    }
    
    //==================
    // QuoteList Tests
    //==================
    
     @Test
    public void QuoteList_addTagToAll() {
        QuoteSaxParser qParser = new QuoteSaxParser("quotes.xml");
        QuoteList quotes = qParser.getQuoteList();
        assertEquals(1,1);
    }
    
}
