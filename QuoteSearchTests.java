import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;
import static org.junit.Assume.*;

public class QuoteSearchTests {
    
   
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("QuoteSearchTests");
    }
   

    @Test
    public void match_author_test() {
        //load quote file and store quotes in a QuoteList
        QuoteSaxParser qParser = new QuoteSaxParser("quotes.xml");
        QuoteList quotes = qParser.getQuoteList();
        
        //run search
        QuoteList searchResults = quotes.search("Richard Nixon", 0);
        
        assertTrue(searchResults.getSize() == 1 && searchResults.getQuote(0).getQuoteText().equals("I know that you believe you understand what you think I said, but I am not sure you realize that what you heard is not what I meant."));
   }
    
        
    @Test
    public void match_text_test() {
        //load quote file and store quotes in a QuoteList
        QuoteSaxParser qParser = new QuoteSaxParser("quotes.xml");
        QuoteList quotes = qParser.getQuoteList();
        
        //run search
        QuoteList searchResults = quotes.search("Eschew obfuscation!", 1);
        
        assertTrue(searchResults.getSize() == 1 && searchResults.getQuote(0).getAuthor().equals("Don Cunningham"));
   }
    
        
    @Test
    public void match_both_test() {
        
        //Create the quote List to search
        QuoteList quotes = new QuoteList();
        
        //Not sure how to put all the quotes in the quotelist here
        
        QuoteList searchResults = quotes.search("test", 2);
        
        //Need to figure out what we should do for assertion. Maybe Create a Quote object with the exact quote we want?
        
        assertTrue(true);
  
   }
    
    @Test
    public void match_none_test() {
        
        //Create the quote List to search
        QuoteList quotes = new QuoteList();
        
        //Not sure how to put all the quotes in the quotelist here
        
        QuoteList searchResults = quotes.search("test", 0);
        
        //Need to figure out what we should do for assertion. Maybe Create a Quote object with the exact quote we want?
        
        assertTrue(true);
  
   }
}