package quotes;
import org.w3c.dom.*;
import java.io.*;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.*;import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.StringWriter;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;



/**
 * SAX parser
 * @author Mongkoldech Rajapakdee & Jeff Offutt
 *         Date: Nov 2009
 */
public class QuoteSaxParser
{
   private String fileName;
   private QuoteSaxHandler handler;
   public static void main(String[] args)
   {
      QuoteSaxParser q = new QuoteSaxParser("quotes.xml");
      QuoteList v = q.getQuoteList();
      v.search("the", 2);
      System.out.println("lol");
   }

public QuoteSaxParser (String fileName)
{
   this.fileName = fileName;
   try
   {
      File quoteFile = new File (fileName);

      handler = new QuoteSaxHandler();
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser =  factory.newSAXParser();
      saxParser.parse (quoteFile, handler);
   } catch (Exception e)
   {
      e.printStackTrace();
   }
}

public QuoteList getQuoteList()
{
   return handler.getQuoteList();
}

public void addQuote(String quote, String author)
{
   try
   {
      File quoteFile = new File (fileName);

      handler = new QuoteSaxHandler();
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = factory.newDocumentBuilder();
      //saxParser.parse (quoteFile, handler);
      Document document = docBuilder.parse(quoteFile);
      
      Node parent = document.getFirstChild();
      NodeList quotes = parent.getChildNodes();
      
      //create quote node
      Node newQuote = document.createElement("quote");
      
      
      //create quote-text node
      Node quoteText = document.createElement("quote-text");
      quoteText.setTextContent(quote);
      newQuote.appendChild(quoteText);
      
      //create author node
      Node authorText = document.createElement("author");
      authorText.setTextContent(author);
      newQuote.appendChild(authorText);
      
      parent.appendChild(newQuote);
      
      
      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
      
      //initialize StreamResult with File object to save to file
      StreamResult result = new StreamResult(new File(fileName));
      DOMSource source = new DOMSource(document);
      transformer.transform(source, result);
      
      //String xmlString = result.getWriter().toString();
      //System.out.println(xmlString);
      
      //quotes.setNamedItem(newQuote);
      
      //System.out.println(quote + " --" + author);
      
      /*NodeList nodes = document.getElementsByTagName("quote");
      Text a = doc.createTextNode("quote");
      Element p = document.createElement("text");
      p.appendChild(a);
      nodes.item(0).getParentNode().insertBefore(p, nodes.item(0));*/
   } catch (Exception e)
   {
      e.printStackTrace();
   }
}
}
