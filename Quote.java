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
      tag = "";
   }

   // Constructor that assigns both strings
   public Quote (String author, String quoteText)
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
      //don't add empty strings or whitespaces as tags
      if ( !(tag.trim().equals("")) )
         this.tag=tag;
   }
   
   //check if the quote as a given tag
   public boolean hasTag(String tag)
   {
      if (this.tag.equals(""))
         return false;
      else 
         return true;
   }
   
   //remove a given tag
   public void removeTag()
   {
         this.tag = "";
   }
   
   //return a list of all tags
   public String getTag()
   {
      return this.tag;
   }

   @Override
   public String toString ()
   {
      return "Quote {" + "author='" + author + '\'' + ", quoteText='" + quoteText + '\'' + '}';
   }
}
