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

    }
}