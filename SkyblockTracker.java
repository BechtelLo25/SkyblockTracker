import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SkyblockTracker {

    public String playerID;

    public String getTenAuctions() {
        String apiUrl = "https://sky.coflnet.com/api/player/" + playerID + "/auctions?page=0&=string&=string&=string";

        try {
            // Create an HttpClient
            HttpClient client = HttpClient.newHttpClient();
    
            // Create an HttpRequest with method GET and headers
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String firstAuction = "Last Auction: " + (response.body().substring(response.body().indexOf("itemName") + 11, response.body().indexOf("tag") - 3));
            return firstAuction;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Connect to wifi dummy";
    }
}