

package webcrawler;


public class App {

    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler();
        crawler.discoveredWeb("http://www.bbc.com");
        System.out.println("Running");
    }
    
}
