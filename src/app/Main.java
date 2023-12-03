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
import data_access.SaveDataAccessObject;
import interface_adapter.ViewManagerModel;


import interface_adapter.ai_explanation.AiController;
import interface_adapter.ai_explanation.AiViewModel;
import interface_adapter.clear_text.ClearController;
import interface_adapter.clear_text.ClearViewModel;
import interface_adapter.save_text.SaveController;
import interface_adapter.save_text.SaveViewModel;

import interface_adapter.recommend_word.RecommendController;
import interface_adapter.recommend_word.RecommendViewModel;
import interface_adapter.text_area.TextAreaViewModel;

import view.ViewManager;
import view.TextAreaView;




import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Main program window
        JFrame application = new JFrame("Vocabulary Builder");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Card layout for managing different views
        CardLayout cardLayout = new CardLayout();

        // Panel to hold various views with card layout
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // View manager to keep track of and manage the current view
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // View models
        RecommendViewModel recommendViewModel = new RecommendViewModel();
        AiViewModel aiViewModel = new AiViewModel();
        TextAreaViewModel textAreaViewModel = new TextAreaViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();
        SaveViewModel saveViewModel = new SaveViewModel();

        // Data access objects
        AiDataAccessObject aiDataAccessObject = new AiDataAccessObject();
        SaveDataAccessObject saveDataAccessObject = new SaveDataAccessObject();

        // Controllers
        AiController aiController = AiUseCaseFactory.createAiUseCase(viewManagerModel, aiViewModel, aiDataAccessObject);
        ClearController clearController = ClearUseCaseFactory.create(viewManagerModel, clearViewModel, textAreaViewModel);
        SaveController saveController = SaveUseCaseFactory.create(viewManagerModel, saveViewModel, saveDataAccessObject);
        RecommendController recommendController = RecommendWordUseCaseFactory.createRecommendController(viewManagerModel, recommendViewModel);

        // TextAreaView setup
        TextAreaView textAreaView = new TextAreaView(aiController, recommendController, clearController, saveController, textAreaViewModel);
        views.add(textAreaView, textAreaView.viewName);

        // Set active view and update UI
        viewManagerModel.setActiveView(textAreaView.viewName);
        viewManagerModel.firePropertyChanged();

        // Display the application
        application.pack();
        application.setVisible(true);
    }
}
