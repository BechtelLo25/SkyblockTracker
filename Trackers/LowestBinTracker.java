package Trackers;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import src.CommaAdder;

public class LowestBinTracker {
    
    public CommaAdder CommaAdder = new CommaAdder();

    public String itemID;

    public String getItemID(String itemName) {
        
        String finalName = itemName.replaceAll(" ", "%20");
        String apiUrl = "https://sky.coflnet.com/api/item/search/" + finalName;

        try {
            HttpClient client = HttpClient.newHttpClient();
    
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return (response.body().substring(response.body().indexOf("id") + 5, response.body().indexOf("type") - 3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return "Connect to wifi dummy";
    }

    public String getLowestBin() {
        String apiUrl = "https://sky.coflnet.com/api/item/price/" + getItemID(itemID) + "/bin?=string&=string&=string";

        try {
            HttpClient client = HttpClient.newHttpClient();
    
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return CommaAdder.addCommas(response.body().substring(response.body().indexOf("lowest") + 8, response.body().indexOf("uuid") - 2));

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "Connect to wifi dummy"; 
    }

    public String getSecondLowestBin() {
        String apiUrl = "https://sky.coflnet.com/api/item/price/" + getItemID(itemID) + "/bin?=string&=string&=string";

        try {
            HttpClient client = HttpClient.newHttpClient();
    
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return CommaAdder.addCommas(response.body().substring(response.body().indexOf("secondLowest") + 14, response.body().indexOf("}")));

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "Connect to wifi dummy"; 
    }

}
