package data_access;

import use_case.recommend_word.RecommendDataAccessInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RecommendDataAccessObject implements RecommendDataAccessInterface {


    @Override
    public String getRecommendation(String text) {
        String apiUrl = "https://www.stands4.com/services/v2/syno.php?uid=12086&tokenid=CdUkpotEswlcqlbU&word=" + text;

        try { // calls the API

            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");


            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();
            int start=response.indexOf("<synonyms>");
            int end=response.indexOf("</synonyms>");
            System.out.println(response);
            // deletes the unnecessary JSON parts

            response.delete(end,response.length());
            response.delete(0,start);
            start=response.indexOf(">");
            response.delete(0,start+1);
            System.out.println(response);
            end=response.indexOf(",");
            response.delete(end,response.length());


            return response.toString();



        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
