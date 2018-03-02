//package quotes;
import java.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner; 

class Quotes {
	private static final String quoteFileName = "quotes.xml";
	
	// Stores all the quotes from the xml file
	//private static QuoteList quoteList;
	
	public static void main(String[] args) {
		QuoteSaxParser a = new QuoteSaxParser(quoteFileName);
		QuoteList quoteList = a.getQuoteList();
		String searchText;
		String searchScope;
		System.out.println("Enter search text: ");
		Scanner reader = new Scanner(System.in);
		searchText = reader.next();
		System.out.println("Enter a number for search scope: must be one of 'text', 'author', or 'both': ");
		searchScope = reader.next();
		reader.close();
		
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
				System.out.println ("\n");
				for (int i = 0; i < searchRes.getSize() ; i++)
				{
					quoteTmp = searchRes.getQuote(i);
					System.out.println (quoteTmp.getQuoteText());
					System.out.println ("--" + quoteTmp.getAuthor() + "");
				}
				System.out.println ("\n");
			}
		}
		System.out.println ("</td>");
	}
}