import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AuctionTracker {

    public String playerID;

    public String getUuid(String name) {
        
        String apiUrl = "https://sky.coflnet.com/api/search/player/" + name;

        try {
            // Create an HttpClient
            HttpClient client = HttpClient.newHttpClient();
    
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body().substring(response.body().indexOf("uuid") + 7, response.body().indexOf("hitCount") - 3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return "Connect to wifi dummy";
    }

    public String getTenAuctions() {
        String apiUrl = "https://sky.coflnet.com/api/player/" + playerID + "/auctions?page=0&=string&=string&=string";

        try {
            // Create an HttpClient
            HttpClient client = HttpClient.newHttpClient();
    
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("accept", "text/plain")
                    .GET()
                    .build();
    
            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Entire Response and variables beginning with "after" are the entire response without the auction info that came before
            // The variables that end in info are only the information for that specific auction
            String entireResponse = response.body();
            String firstAuctionInfo = entireResponse.substring(0, entireResponse.indexOf("bin") + 11);
            String afterFirstAuctionInfo = entireResponse.substring(firstAuctionInfo.length());
            String secondAuctionInfo = afterFirstAuctionInfo.substring(0, afterFirstAuctionInfo.indexOf("bin") + 11);
            String afterSecondAuctionInfo = afterFirstAuctionInfo.substring(secondAuctionInfo.length());
            String thirdAuctionInfo = afterSecondAuctionInfo.substring(0, afterSecondAuctionInfo.indexOf("bin") + 11);
            String afterThirdAuctionInfo = afterSecondAuctionInfo.substring(thirdAuctionInfo.length());
            String fourthAuctionInfo = afterThirdAuctionInfo.substring(0, afterThirdAuctionInfo.indexOf("bin") + 11);
            String afterFourthAuctionInfo = afterThirdAuctionInfo.substring(fourthAuctionInfo.length());
            String fifthAuctionInfo = afterFourthAuctionInfo.substring(0, afterFourthAuctionInfo.indexOf("bin") + 11);
            String afterFifthAuctionInfo = afterFourthAuctionInfo.substring(fifthAuctionInfo.length());
            String sixthAuctionInfo = afterFifthAuctionInfo.substring(0, afterFifthAuctionInfo.indexOf("bin") + 11);
            String afterSixthAuctionInfo = afterFifthAuctionInfo.substring(sixthAuctionInfo.length());
            String seventhAuctionInfo = afterSixthAuctionInfo.substring(0, afterSixthAuctionInfo.indexOf("bin") + 11);
            String afterSeventhAuctionInfo = afterSixthAuctionInfo.substring(seventhAuctionInfo.length());
            String eighthAuctionInfo = afterSeventhAuctionInfo.substring(0, afterSeventhAuctionInfo.indexOf("bin") + 11);
            String afterEighthAuctionInfo = afterSeventhAuctionInfo.substring(eighthAuctionInfo.length());
            String ninthAuctionInfo = afterEighthAuctionInfo.substring(0, afterEighthAuctionInfo.indexOf("bin") + 11);
            String afterNinthAuctionInfo = afterEighthAuctionInfo.substring(ninthAuctionInfo.length());
            String tenthAuctionInfo = afterNinthAuctionInfo.substring(0, afterNinthAuctionInfo.indexOf("bin") + 11);

            // Each of these strings are the name of the item that is being sold
            String firstAuction = (firstAuctionInfo.substring(firstAuctionInfo.indexOf("itemName") + 11, firstAuctionInfo.indexOf("tag") - 3)) + " - ";
            String secondAuction = (secondAuctionInfo.substring(secondAuctionInfo.indexOf("itemName") + 11, secondAuctionInfo.indexOf("tag") - 3)) + " - ";
            String thirdAuction = (thirdAuctionInfo.substring(thirdAuctionInfo.indexOf("itemName") + 11, thirdAuctionInfo.indexOf("tag") - 3)) + " - ";
            String fourthAuction = (fourthAuctionInfo.substring(fourthAuctionInfo.indexOf("itemName") + 11, fourthAuctionInfo.indexOf("tag") - 3)) + " - ";
            String fifthAuction = (fifthAuctionInfo.substring(fifthAuctionInfo.indexOf("itemName") + 11, fifthAuctionInfo.indexOf("tag") - 3)) + " - ";
            String sixthAuction = (sixthAuctionInfo.substring(sixthAuctionInfo.indexOf("itemName") + 11, sixthAuctionInfo.indexOf("tag") - 3)) + " - ";
            String seventhAuction = (seventhAuctionInfo.substring(seventhAuctionInfo.indexOf("itemName") + 11, seventhAuctionInfo.indexOf("tag") - 3)) + " - ";
            String eighthAuction = (eighthAuctionInfo.substring(eighthAuctionInfo.indexOf("itemName") + 11, eighthAuctionInfo.indexOf("tag") - 3)) + " - ";
            String ninthAuction = (ninthAuctionInfo.substring(ninthAuctionInfo.indexOf("itemName") + 11, ninthAuctionInfo.indexOf("tag") - 3)) + " - ";
            String tenthAuction = (tenthAuctionInfo.substring(tenthAuctionInfo.indexOf("itemName") + 11, tenthAuctionInfo.indexOf("tag") - 3)) + " - ";

            // If statements that decide if the items have sold or not
            if(firstAuctionInfo.substring(firstAuctionInfo.indexOf("highestBid") + 12, firstAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                firstAuction += "Has not sold\n";
            }
            else {
                firstAuction += "Sold for " + firstAuctionInfo.substring(firstAuctionInfo.indexOf("highestBid") + 12, firstAuctionInfo.indexOf("itemName") - 2) + "\n";
            }

            if(secondAuctionInfo.substring(secondAuctionInfo.indexOf("highestBid") + 12, secondAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                secondAuction += "Has not sold\n";
            }
            else {
                secondAuction += "Sold for " + secondAuctionInfo.substring(secondAuctionInfo.indexOf("highestBid") + 12, secondAuctionInfo.indexOf("itemName") - 2) + "\n";
            }

            if(thirdAuctionInfo.substring(thirdAuctionInfo.indexOf("highestBid") + 12, thirdAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                thirdAuction += "Has not sold\n";
            }
            else {
                thirdAuction += "Sold for " + thirdAuctionInfo.substring(thirdAuctionInfo.indexOf("highestBid") + 12, thirdAuctionInfo.indexOf("itemName") - 2) + "\n";
            }

            if(fourthAuctionInfo.substring(fourthAuctionInfo.indexOf("highestBid") + 12, fourthAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                fourthAuction += "Has not sold\n";
            }
            else {
                fourthAuction += "Sold for " + fourthAuctionInfo.substring(fourthAuctionInfo.indexOf("highestBid") + 12, fourthAuctionInfo.indexOf("itemName") - 2) + "\n";
            }

            if(fifthAuctionInfo.substring(fifthAuctionInfo.indexOf("highestBid") + 12, fifthAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                fifthAuction += "Has not sold\n";
            }
            else {
                fifthAuction += "Sold for " + fifthAuctionInfo.substring(fifthAuctionInfo.indexOf("highestBid") + 12, fifthAuctionInfo.indexOf("itemName") - 2) + "\n";
            }

            if (sixthAuctionInfo.substring(sixthAuctionInfo.indexOf("highestBid") + 12, sixthAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                sixthAuction += "Has not sold\n";
            } else {
                sixthAuction += "Sold for " + sixthAuctionInfo.substring(sixthAuctionInfo.indexOf("highestBid") + 12, sixthAuctionInfo.indexOf("itemName") - 2) + "\n";
            }

            if (seventhAuctionInfo.substring(seventhAuctionInfo.indexOf("highestBid") + 12, seventhAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                seventhAuction += "Has not sold\n";
            } else {
                seventhAuction += "Sold for " + seventhAuctionInfo.substring(seventhAuctionInfo.indexOf("highestBid") + 12, seventhAuctionInfo.indexOf("itemName") - 2) + "\n";
            }

            if (eighthAuctionInfo.substring(eighthAuctionInfo.indexOf("highestBid") + 12, eighthAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                eighthAuction += "Has not sold\n";
            } else {
                eighthAuction += "Sold for " + eighthAuctionInfo.substring(eighthAuctionInfo.indexOf("highestBid") + 12, eighthAuctionInfo.indexOf("itemName") - 2) + "\n";
            }

            if (ninthAuctionInfo.substring(ninthAuctionInfo.indexOf("highestBid") + 12, ninthAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                ninthAuction += "Has not sold\n";
            } else {
                ninthAuction += "Sold for " + ninthAuctionInfo.substring(ninthAuctionInfo.indexOf("highestBid") + 12, ninthAuctionInfo.indexOf("itemName") - 2) + "\n";
            }

            if (tenthAuctionInfo.substring(tenthAuctionInfo.indexOf("highestBid") + 12, tenthAuctionInfo.indexOf("highestBid") + 13).equals("0")) {
                tenthAuction += "Has not sold\n";
            } else {
                tenthAuction += "Sold for " + tenthAuctionInfo.substring(tenthAuctionInfo.indexOf("highestBid") + 12, tenthAuctionInfo.indexOf("itemName") - 2) + "\n";
            }
            
            return firstAuction + secondAuction + thirdAuction + fourthAuction + fifthAuction + sixthAuction + seventhAuction + eighthAuction + ninthAuction + tenthAuction;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Connect to wifi dummy";
    }
}