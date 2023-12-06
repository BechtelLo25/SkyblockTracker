import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PriceHistoryTracker {
    
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

    public String getPriceHistory() {
        String currentApiUrl = "https://sky.coflnet.com/api/item/price/" + getItemID(itemID) + "/current?count=1";
        String dayApiUrl = "https://sky.coflnet.com/api/item/price/" + getItemID(itemID)+ "/history/day?=string&=string&=string";
        String weekApiUrl = "https://sky.coflnet.com/api/item/price/" + getItemID(itemID)+ "/history/week?=string&=string&=string";
        String monthApiUrl = "https://sky.coflnet.com/api/item/price/" + getItemID(itemID)+ "/history/month?=string&=string&=string";
        String yearApiUrl = "https://sky.coflnet.com/api/item/price/" + getItemID(itemID)+ "/history/year?=string&=string&=string";

        try {
            HttpClient client = HttpClient.newHttpClient();
    
            HttpRequest currentRequest = HttpRequest.newBuilder()
                    .uri(URI.create(currentApiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();

            HttpRequest dayRequest = HttpRequest.newBuilder()
                    .uri(URI.create(dayApiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();

            HttpRequest weekRequest = HttpRequest.newBuilder()
                    .uri(URI.create(weekApiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();

            HttpRequest monthRequest = HttpRequest.newBuilder()
                    .uri(URI.create(monthApiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();

            HttpRequest yearRequest = HttpRequest.newBuilder()
                    .uri(URI.create(yearApiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            HttpResponse<String> currentResponse = client.send(currentRequest, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> dayResponse = client.send(dayRequest, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> weekResponse = client.send(weekRequest, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> monthResponse = client.send(monthRequest, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> yearResponse = client.send(yearRequest, HttpResponse.BodyHandlers.ofString());

            String buyAndSellPriceCurrent = "Current Sell Price: " + currentResponse.body().substring(currentResponse.body().indexOf("sell") + 6, currentResponse.body().indexOf("buy") -2) + "\n" + "Current Buy Price: " + currentResponse.body().substring(currentResponse.body().indexOf("buy") + 6, currentResponse.body().indexOf("avail") -2) + "\n\n";

            return buyAndSellPriceCurrent;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "Connect to wifi dummy"; 
    }

}
