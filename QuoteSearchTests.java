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
        
        //Create the quote List to search
        QuoteList quotes = new QuoteList();
        
        //Not sure how to put all the quotes in the quotelist here
        
        QuoteList searchResults = quotes.search("test", 0);
        
        //Need to figure out what we should do for assertion. Maybe Create a Quote object with the exact quote we want?
        
        assertTrue(true);
  
   }
    
        
    @Test
    public void match_text_test() {
        
        //Create the quote List to search
        QuoteList quotes = new QuoteList();
        
        //Not sure how to put all the quotes in the quotelist here
        
        QuoteList searchResults = quotes.search("test", 1);
        
        //Need to figure out what we should do for assertion. Maybe Create a Quote object with the exact quote we want?
        
        assertTrue(true);
  
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