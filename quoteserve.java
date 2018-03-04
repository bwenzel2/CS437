//package quotes;
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
   loadQuotes();
   ArrayList<String> recentSearches = new ArrayList<String>();
   boolean quit = false;
   while(!quit)
   {
      System.out.println("Welcome to Quotes!\nRecent Searches:" + recentSearches + "\n\nTo search, enter 'search'\nTo add a new quote, enter 'add'\nTo quit, enter 'quit':");
      reader = new Scanner(System.in);
      String cmd = reader.nextLine();
      if (cmd.equals("add"))
      {
         System.out.println("Enter quotation text: ");
         String quote = reader.nextLine();
         System.out.println("Enter author name: ");
         String author = reader.nextLine();
         System.out.println("Enter tag text: ");
          String tag = reader.nextLine();
          
          
          
         addQuote(quote, author, tag);
      }
      else if (cmd.equals("search"))
      {
         System.out.println("Enter text to search for: ");
         String searchText = reader.nextLine();
         System.out.println("Enter search scope: must be one of 'text', 'author', 'both', or 'tag': ");
         String searchScope = reader.nextLine();
         while (!searchScope.equals("text") && !searchScope.equals("author") && !searchScope.equals("both") && !searchScope.equals("tag"))
         {
            System.out.println("Incorrect scope specified, must be exactly one of 'text', 'author', 'both', or 'tag'. Please enter search scope again: ");
            searchScope = reader.nextLine();
         }
         recentSearches.add(searchText);
         if (recentSearches.size() > 5)
            recentSearches.remove(0);
            
            
            
         //run search and print
         QuoteList searchResults = findQuotes(searchText, searchScope);
         printSearchResults(searchResults, searchText);
      }
      /* else if (cmd.equals("tag"))
      {
         System.out.println("First, find the quote(s) you wish to tag.");
         System.out.println("Enter text to search for: ");
         String searchText = reader.nextLine();
         System.out.println("Enter search scope: must be one of 'text', 'author', 'both', or 'tag': ");
         String searchScope = reader.nextLine();
         while (!searchScope.equals("text") && !searchScope.equals("author") && !searchScope.equals("both") && !searchScope.equals("tag"))
         {
            System.out.println("Incorrect scope specified, must be exactly one of 'text', 'author', 'both', or 'tag'. Please enter search scope again: ");
            searchScope = reader.nextLine();
         }
         recentSearches.add(searchText);
         if (recentSearches.size() > 5)
            recentSearches.remove(0);
            
            
         QuoteList searchResults = findQuotes(searchText, searchScope);
         printSearchResults(searchResults, searchText);
         
         System.out.println("Please choose a command:\n • Enter 'tag' to tag every quote in your search results (note that this will overwrite the existing tag for any quote that has one)\n • Enter 'remove' to remove the tag of every quote in your search results\n • Enter 'done' to go back to the main prompt");
      }*/
      else if (cmd.equals("quit"))
      {
         System.out.println("Goodbye!\n");
         quit = true;
      }
      else
      {
         System.out.println("Error, incorrect command specified, must be exactly one of 'search' or quit'.");
      }
      System.out.println("\n");
      
   }
   reader.close();
}

// reads the quotes file from disk and stores in quoteList
public void loadQuotes()
{
   QuoteSaxParser qParser = new QuoteSaxParser (quoteFileName);
   quoteList = qParser.getQuoteList();
}

public QuoteList findQuotes(String searchText, String searchScope)
{
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
         } else if (searchScope.equals ("tag"))
         {
             System.out.println("Hello there");
             searchScopeInt = QuoteList.SearchTagVal;
         }
          
      }

      return quoteList.search(searchText, searchScopeInt);
   }
   //return empty quote list
   return new QuoteList();
}

public void printSearchResults(QuoteList searchRes, String searchText)
{
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
      System.out.println("\n");
   }
}

void addQuote(String quote, String author, String tag)
{
   //error checking the quote, must not be a null string or an empty string
   if (quote == null || quote.trim().length() < 0)
   {
      System.out.println("Error: invalid quote provided (must contain at least one non-whitespace character)!");
      return;
   }
   //error checking the author, must not be a null string or an empty string
   if (author == null || author.trim().length() < 0)
   {
      System.out.println("Error: invalid author provided (must contain at least one non-whitespace character)!");
      return;
   }
    if (tag == null || tag.trim().length() < 0)
    {
        System.out.println("Error: invalid keyword provided (must contain at least one non-whitespace character)!");
        return;
    }
    

    
   QuoteSaxParser qParser = new QuoteSaxParser(quoteFileName);
   qParser.addQuote(quote, author, tag);
   System.out.println("Quote added to the database!");
   //reload database to include the newly-added quote
   loadQuotes();
}

} // end quoteserve class
