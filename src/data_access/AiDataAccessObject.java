package data_access;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import use_case.ai_explanation.AiDataAccessInterface;

public class AiDataAccessObject implements AiDataAccessInterface {

    @Override
    public String getAiExplanation(String usersWord, String suggestedWord) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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"; // API key goes here.
        // just replace API_KEY
        // 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
        // with the API key on the Google Doc, keep the quotation marks// .
        String model = "gpt-3.5-turbo"; // current model of chatgpt api

        try {
            // Create the HTTP POST request
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            // Build the request body
            String message = "You are an English Professor. Tell me the difference between '"
                    + usersWord + "' and '" + suggestedWord + "' but explain it simply and in 50 words.";
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";
            con.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Extract and return the content from the response
            return extractContentFromResponse(response.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // This method extracts the response expected from chatgpt and returns it.
    private String extractContentFromResponse(String response) {
        int startMarker = response.indexOf("content") + 11; // Marker for where the content starts.
        int endMarker = response.indexOf("\"", startMarker); // Marker for where the content ends.
        return response.substring(startMarker, endMarker); // Returns the substring containing only the response.
    }
}
