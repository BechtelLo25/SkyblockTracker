import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LowestBinTracker {

    public String itemID;
    
    public String getItemID(String itemName) {
        
        String finalName = itemName.substring(0, itemName.indexOf(" ")) + "%20" + itemName.substring(itemName.indexOf(" ") + 1);
        String apiUrl = "https://sky.coflnet.com/api/item/search/" + finalName;

        try {
            HttpClient client = HttpClient.newHttpClient();
    
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

            return response.body().substring(response.body().indexOf("id") + 5, response.body().indexOf("type") - 3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return "Connect to wifi dummy";
    }

    public String getTenAuctions() {
        String apiUrl = "https://sky.coflnet.com/api/player/" + itemID + "/auctions?page=0&=string&=string&=string";

        try {
            HttpClient client = HttpClient.newHttpClient();
    
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String entireResponse = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Connect to wifi dummy";
    }
}
