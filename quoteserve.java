package quotes;
import java.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner; 


/**
 * @author Jeff Offutt & Mongkoldech Rajapakdee
 *         Date: Nov, 2009
 *
 * Wiring the pieces together:
 *    quoteserve.java -- The servlet (entry point)
 *    QuoteList.java -- A list of quotes, representing what's read from the XML file
 *                      Used by quoteserve.java
 *    Quote.java -- A simple Quote bean; two entries, author and quote-text
 *                      Used by QuoteList.java
 *    QuoteSaxHandler.java -- Callback methods for the parser, populates QuoteList
 *                      Used by QuoteSaxParser
 *    QuoteSaxParser.java -- Parses the XML file
 *                      Used by quoteserve.java
 *    quotes.js -- JS used by the HTML created in quoteserve
 *    quotes.xml -- Data file, read by QuoteSaxParser
 */
public class quoteserve
{
   // Data filepath
   private static final String quoteFileName = "quotes.xml";
   // Stores all the quotes from the xml file
   private QuoteList quoteList;
   // Scanner to read input from CLI
   private static Scanner reader;
   
   // Main method
   public static void main(String[] args)
   {
      quoteserve q = new quoteserve();
      q.run();
   }
   
   
public void run()
{
   init();
   ArrayList<String> recentSearches = new ArrayList<String>();
   String searchText = null;
   String searchScope = null;
   boolean quit = false;
   while(!quit)
   {
      System.out.println("Welcome to Quotes!\nRecent Searches:" + recentSearches + "\n\nTo search, enter 'search', to quit, enter 'quit':");
      reader = new Scanner(System.in);
      String cmd = reader.next();
      if (cmd.equals("search"))
      {
         System.out.println("Enter text to search for: ");
         searchText = reader.next();
         System.out.println("Enter search scope: must be one of 'text', 'author', or 'both': ");
         searchScope = reader.next();
         while (!searchScope.equals("text") && !searchScope.equals("author") && !searchScope.equals("both"))
         {
            System.out.println("Incorrect scope specified, must be exactly one of 'text', 'author', or 'both'. Please enter search scope again: ");
            searchScope = reader.next();
         }
         recentSearches.add(searchText);
         if (recentSearches.size() > 5)
            recentSearches.remove(0);
            
            
            
         //run search
         if (searchText != null && !searchText.equals(""))
         {  // Received a search request
            int searchScopeInt = QuoteList.SearchBothVal; // Default
            if (searchScope != null && !searchScope.equals(""))
            {  // If no parameter value, let it default.
               if (searchScope.equals ("quote"))
               {
                  searchScopeInt = QuoteList.SearchTextVal;
               } else if (searchScope.equals ("author"))
               {
                  searchScopeInt = QuoteList.SearchAuthorVal;
               } else if (searchScope.equals ("both"))
               {
                  searchScopeInt = QuoteList.SearchBothVal;
               }
            }

            QuoteList searchRes = quoteList.search(searchText, searchScopeInt);
            Quote quoteTmp;
            if (searchRes.getSize() == 0)
            {
               System.out.println ("Your search - "+ searchText +" - did not match any quotes.");
            }
            else
            {
               System.out.println ("\n\n==== Results: ====");
               for (int i = 0; i < searchRes.getSize() ; i++)
               {
                  quoteTmp = searchRes.getQuote(i);
                  System.out.println (quoteTmp.getQuoteText());
                  System.out.println ("--" + quoteTmp.getAuthor() + "");
               }
               System.out.println ("\n");
            }
         }
      }
      else if (cmd.equals("quit"))
      {
         System.out.println("Goodbye!\n");
         quit = true;
      }
      else
      {
         System.out.println("Error, incorrect command specified, must be exactly one of 'search' or quit'.\n");
      }
      
   }
   reader.close();
}

// init() reads the quotes file from disk and stores in quoteList
public void init()
{
   QuoteSaxParser qParser = new QuoteSaxParser (quoteFileName);
   quoteList = qParser.getQuoteList();
}

} // end quoteserve class
