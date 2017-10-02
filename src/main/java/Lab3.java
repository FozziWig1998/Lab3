import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 * I have no idea what this lab is about but,
 * it is called Simple Web Scraping.
 * @author riyadave
 *
 */
public class Lab3 {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
/**
 *
 * @param args this is the main method that will print the amount of words in the test
 */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
       String fullText = urlToString("http://erdani.com/tdpl/hamlet.txt");
       String[] lines = fullText.split("\\n");

       Scanner stdin = new Scanner(System.in);
       int searchWordOccurance = 0;

       System.out.print("which word do you want to count the occurance for?");
       String searchWord = stdin.nextLine();
       int numWords = 0;

       for (int i = 0; i < lines.length; i++) {
           String[] wordsPerLine = lines[i].split("[\\s,.!?;()-]");
           numWords += wordsPerLine.length;
           for (int j = 0; j < wordsPerLine.length; j++) {
               if (wordsPerLine[j].equals(searchWord)) {
                   searchWordOccurance++;
               }
           }
       }
       System.out.println("Total number of words: " + numWords);
       stdin.close();
       System.out.print(searchWord + " showed up " + searchWordOccurance + " times.");


    }

}
