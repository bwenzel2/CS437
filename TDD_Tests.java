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
    public void quote_setTag() {
        Quote q = new Quote();
        q.setTag("round");
        assertEquals("Expected:", "round", q.getTag());
    }
    
 
    //this adds a quote with a tag to the database, then searches for a quote by that tag and compares the result quote with the one added earlier
    @Test
    public void add_tag_and_search() {
        Quote newQuote = new Quote("this is a test quote", "test author", "test tag");
        quoteserve qserve = new quoteserve();
        qserve.loadQuotes();
        qserve.addQuote(newQuote.getQuoteText(), newQuote.getAuthor(), newQuote.getTag());
        QuoteList tagSearchResults = qserve.findQuotes(newQuote.getTag(), "tag");
        
        assertTrue( tagSearchResults.getSize() == 1 && quotesAreEqual(tagSearchResults.getQuote(0), newQuote) );
   }   

    //helper method that returns whether two quotes have identical text, author, and tag fields
    boolean quotesAreEqual(Quote q1, Quote q2)
    {
        return q1.getQuoteText().equals(q2.getQuoteText()) &&
               q1.getAuthor().equals(q2.getAuthor()) &&
               q1.getTag().equals(q2.getTag());
    }
    
}
