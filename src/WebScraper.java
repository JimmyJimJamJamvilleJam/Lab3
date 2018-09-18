
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebScraper {
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

    public static void main(String[] args) {
        String websiteText = urlToString("http://erdani.com/tdpl/hamlet.txt");
        websiteText.trim();
        String[] wordsInText = websiteText.split(" ");
        System.out.println(wordsInText.length);
        //Scanner myScanner = new Scanner(System.in.toString());
       // String searchWord = myScanner.next();
        String searchWord = "Prince";
        for (int i = 0; i < wordsInText.length; i++) {
            wordsInText[i].trim();
            if(searchWord.toLowerCase().equals(wordsInText[i].toLowerCase())) {
                System.out.println(wordsInText[i]);
            }
        }
    }

}
