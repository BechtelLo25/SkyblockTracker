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
        String allApiUrl = "https://sky.coflnet.com/api/item/price/" + getItemID(itemID)+ "/history/full?=string&=string&=string";

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

            HttpRequest allRequest = HttpRequest.newBuilder()
                    .uri(URI.create(allApiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            HttpResponse<String> currentResponse = client.send(currentRequest, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> dayResponse = client.send(dayRequest, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> weekResponse = client.send(weekRequest, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> monthResponse = client.send(monthRequest, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> yearResponse = client.send(allRequest, HttpResponse.BodyHandlers.ofString());

            String buyAndSellPriceCurrent = "Current Sell Price: " + CommaAdder.addCommas(currentResponse.body().substring(currentResponse.body().indexOf("sell") + 6, currentResponse.body().indexOf("buy") - 4)) + "\n\n";
            String buyAndSellPriceDay = "One Day Ago: " + CommaAdder.addCommas(dayResponse.body().substring(dayResponse.body().indexOf("avg") + 5, dayResponse.body().indexOf("volume") - 4)) + "\n\n";
            String buyAndSellPriceWeek = "One Week Ago: " + CommaAdder.addCommas(weekResponse.body().substring(weekResponse.body().indexOf("avg") + 5, weekResponse.body().indexOf("volume") - 4)) + "\n\n";
            String buyAndSellPriceMonth = "One Month Ago: " + CommaAdder.addCommas(monthResponse.body().substring(monthResponse.body().indexOf("avg") + 5, monthResponse.body().indexOf("volume") - 4)) + "\n\n";
            String buyAndSellPriceYear = "One Year Ago: " + CommaAdder.addCommas(yearResponse.body().substring(yearResponse.body().indexOf("avg") + 5, yearResponse.body().indexOf("volume") - 4)) + "\n\n";

            return buyAndSellPriceCurrent + buyAndSellPriceDay + buyAndSellPriceWeek + buyAndSellPriceMonth + buyAndSellPriceYear;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return "Connect to wifi dummy"; 
    }

}
