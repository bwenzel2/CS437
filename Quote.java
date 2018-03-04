//package quotes;

/**
 * Quote data object.
 * @author Mongkoldech Rajapakdee & Jeff offutt
 *         Date: Nov 2009
 * A quote has two parts, an author and a quoteText.
 * This bean class provides getters and setters for both, plus a toString()
 */

public class Quote
{
   private String author;
   private String quoteText;
   private String tag;

   // Default constructor does nothing
   public Quote ()
   {
      //make the tag empty
   }

   // Constructor that assigns both strings
   public Quote (String author, String quoteText, String tag)
   {
      this.author = author;
      this.quoteText = quoteText;
   }

   // Getter and setter for author
   public String getAuthor ()
   {
      return author;
   }
   public void setAuthor (String author)
   {
      this.author = author;
   }

   // Getter and setter for quoteText
   public String getQuoteText ()
   {
      return quoteText;
   }
   public void setQuoteText (String quoteText)
   {
      this.quoteText = quoteText;
   }
   
   //Getter for tags
   public void setTag(String tag)
   {
        this.tag=tag;
   }
   
   //return a list of all tags
   public String getTag()
   {
      return this.tag;
   }

   @Override
   public String toString ()
   {
      return "Quote {" + "author='" + author + '\'' + ", quoteText='" + quoteText + '\'' + ", tag='" + tag + '\'' + '}';
   }
}
