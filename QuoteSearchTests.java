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
        
        assertTrue(searchResults.getSize() == 1);
        assertTrue(searchResults.getQuote(0).getQuoteText().equals("I know that you believe you understand what you think I said, but I am not sure you realize that what you heard is not what I meant."));
   }
    
        
    @Test
    public void match_text_test() {
        //load quote file and store quotes in a QuoteList
        QuoteSaxParser qParser = new QuoteSaxParser("quotes.xml");
        QuoteList quotes = qParser.getQuoteList();
        
        //run search
        QuoteList searchResults = quotes.search("Eschew obfuscation!", 1);
        
        assertTrue(searchResults.getSize() == 1);
        assertTrue(searchResults.getQuote(0).getAuthor().equals("Don Cunningham"));
   }
    
        
    @Test
    public void match_both_test() {
        //load quote file and store quotes in a QuoteList
        QuoteSaxParser qParser = new QuoteSaxParser("quotes.xml");
        QuoteList quotes = qParser.getQuoteList();
        
        //run search
        QuoteList searchResults = quotes.search("the", 2);
        
        
        System.out.println(searchResults.getQuote(0).getAuthor());
        
        //Need to figure out what we should do for assertion. Maybe Create a Quote object with the exact quote we want?
        
        //check size
        assertTrue(searchResults.getSize() == 4);
        
        //check quotes
        assertTrue(searchResults.getQuote(0).getQuoteText().equals("For every problem there is one solution which is simple, neat, and wrong."));
        assertTrue(searchResults.getQuote(1).getQuoteText().equals("The only man who behaves sensibly is my tailor; he takes my measure anew every time he sees me, whilst all the rest go on with their old measurements, expecting them to fit me."));
        assertTrue(searchResults.getQuote(2).getQuoteText().equals("We often do not know how to make those decisions [about a system design] until we can play with the system."));
        assertTrue(searchResults.getQuote(3).getQuoteText().equals("My life is has been one continual search for answers to one short question. The subject and the answer changes, but the question remains simply\" \"Why?\"."));
        //check authors
        assertTrue(searchResults.getQuote(0).getAuthor().equals("H. L. Mencken"));
        assertTrue(searchResults.getQuote(1).getAuthor().equals("George Bernard Shaw"));
        assertTrue(searchResults.getQuote(2).getAuthor().equals("David Parnas \"Software Aspects of SDI\""));
        assertTrue(searchResults.getQuote(3).getAuthor().equals("The Anonymous Researcher"));
   }
    
    @Test
    public void match_none_author_test() {
        
        //arrange
        QuoteSaxParser qParser = new QuoteSaxParser("quotes.xml");
        QuoteList quotes = qParser.getQuoteList();
        
        //act
        QuoteList searchResults = quotes.search("nope", 0);
        
        //assert
        assertTrue(searchResults.getSize() == 0);
   }

    @Test
    public void match_none_text_test() {
        
        //arrange
        QuoteSaxParser qParser = new QuoteSaxParser("quotes.xml");
        QuoteList quotes = qParser.getQuoteList();
        
        //act
        QuoteList searchResults = quotes.search("nope", 1);
        
        //assert
        assertTrue(searchResults.getSize() == 0);
   }

    @Test
    public void match_none_both_test() {
        
        //arrange
        QuoteSaxParser qParser = new QuoteSaxParser("quotes.xml");
        QuoteList quotes = qParser.getQuoteList();
        
        //act
        QuoteList searchResults = quotes.search("nope", 2);
        
        //assert
        assertTrue(searchResults.getSize() == 0);
   }
}