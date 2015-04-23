package com.github.ronanquillevere;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Document doc = Jsoup.connect("https://www.youtube.com/results?search_query=cover").get();
        
        Element results = doc.getElementById("results");
        
        Elements itemSection = results.getElementsByClass("item-section");
        Iterator<Element> it = itemSection.iterator();
        while (it.hasNext())
        {
           Element next = it.next();
           Elements items = next.getElementsByTag("li");
           Iterator<Element> it2 = items.iterator();
           while (it2.hasNext())
           {
               Element next2 = it2.next();
               Elements titles = next2.getElementsByClass("yt-lockup-title");
               Iterator<Element> it3 = titles.iterator();
               while (it3.hasNext())
               {
                   Element next3 = it3.next();
                   String coverTitle = next3.child(0).html();
                   System.out.println("Cover title : " + coverTitle );
               }
           }
        }
        
    }
}
