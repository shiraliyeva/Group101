package app;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import data_access.AiDataAccessObject;
import data_access.FileUserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.ai_explanation.AiController;
import interface_adapter.ai_explanation.AiViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import use_case.ai_explanation.AiDataAccessInterface;
import use_case.ai_explanation.AiInputBoundary;
import view.AiView;
import view.ViewManager;
import view.TextAreaView;

public class Main {

    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Vocabulary Builder");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        TextAreaViewModel textAreaViewModel = new TextAreaViewModel();
        AiViewModel aiViewModel = new AiViewModel();

        AiDataAccessObject aiDataAccessObject;

        aiDataAccessObject = new AiDataAccessObject();

//        AiView aiView = new AiView(aiViewModel);
        AiView aiView = AiUseCaseFactory.create(viewManagerModel, aiViewModel, aiDataAccessObject, textAreaViewModel, views, cardLayout);
        AiController aiController = aiView.aiController;
        views.add(aiView, aiView.viewName);

        TextAreaView textAreaView = new TextAreaView(aiController, textAreaViewModel, aiView);
        views.add(textAreaView, textAreaView.viewName);

        viewManagerModel.setActiveView(textAreaView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

//        System.out.println(chatGPT("You are an English Professor. " +
//                "Tell me the difference between 'smart' and 'wise' but explain " +
//                "it simply and in 50 words."));
        // Prints out a response to the question.
    }

//    public static String chatGPT(String message) {
//        String url = "https://api.openai.com/v1/chat/completions";
//        String apiKey = "API_KEY"; // API key goes here.
//        // just replace API_KEY
//        // with the API key on the Google Doc, keep the quotation marks// .
//        String model = "gpt-3.5-turbo"; // current model of chatgpt api
//
//        try {
//            // Create the HTTP POST request
//            URL obj = new URL(url);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//            con.setRequestMethod("POST");
//            con.setRequestProperty("Authorization", "Bearer " + apiKey);
//            con.setRequestProperty("Content-Type", "application/json");
//
//            // Build the request body
//            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";
//            con.setDoOutput(true);
//            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
//            writer.write(body);
//            writer.flush();
//            writer.close();
//
//            // Get the response
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            // returns the extracted contents of the response.
//            return extractContentFromResponse(response.toString());
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // This method extracts the response expected from chatgpt and returns it.
//    public static String extractContentFromResponse(String response) {
//        int startMarker = response.indexOf("content")+11; // Marker for where the content starts.
//        int endMarker = response.indexOf("\"", startMarker); // Marker for where the content ends.
//        return response.substring(startMarker, endMarker); // Returns the substring containing only the response.
//    }
}