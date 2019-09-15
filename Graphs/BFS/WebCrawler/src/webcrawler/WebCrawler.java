package webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private Queue<String> queue;
    private List<String> discoveredWebsites;

    // constructor
    public WebCrawler() {
        this.queue = new LinkedList<>();
        this.discoveredWebsites = new ArrayList<>();
    }

    // discovered web
    public void discoveredWeb(String root) {
        this.queue.add(root);
        this.discoveredWebsites.add(root);

        // apply bfs
        while (queue.isEmpty() == false) {
            String website = this.queue.remove();
            /* from this website find rawHTML
             then stack all the sites using bfs
             readURL method will download the whole website content */
            String rawHTML = readURL(website);
            
            // regex to get the url from each line
            String regex = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(rawHTML);
            
            while (matcher.find()) {
                String actualURL = matcher.group();
                
                if (!discoveredWebsites.contains(actualURL)) {
                    discoveredWebsites.add(actualURL);
                    System.out.println("Actual found url: " + actualURL);
                    queue.add(actualURL);
                }
            }
            
        }
    }

    // readURL 
    private String readURL(String website) {
        String rawHTML = "";
        try {
            URL url = new URL(website);
            // open the url to read the data
            BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
            // lets read the data line by line and fetch the url from it using regex
            String inputLine = "";
            // until we have some data to read
            while ((inputLine = buffer.readLine()) != null) {
                rawHTML += inputLine;
            } 
            // close buffer reader
            buffer.close();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("ERROR/INCORRECT URL RECEIVED");
        }
        
        return rawHTML;
    }

}
