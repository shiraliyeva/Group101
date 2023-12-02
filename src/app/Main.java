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




public class Main {

    public static void main(String[] args) throws IOException {
        // Main program window

        JFrame application = new JFrame("Vocabulary Builder");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);


        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);
        RecommendViewModel recommendViewModel = new RecommendViewModel();

        AiViewModel aiViewModel = new AiViewModel();

        AiDataAccessObject aiDataAccessObject = new AiDataAccessObject();

        AiController aiController = AiUseCaseFactory.createAiUseCase(viewManagerModel, aiViewModel, aiDataAccessObject);

        TextAreaViewModel textAreaViewModel = new TextAreaViewModel();

        ClearViewModel clearViewModel = new ClearViewModel();
        SaveViewModel saveViewModel = new SaveViewModel();

        ClearController clearController = ClearUseCaseFactory.create(viewManagerModel, clearViewModel, textAreaViewModel);
        SaveController saveController = SaveUseCaseFactory.create(viewManagerModel, saveViewModel);

        RecommendController recommendController = RecommendWordUseCaseFactory.createRecommendController(viewManagerModel, recommendViewModel);

        TextAreaView textAreaView = new TextAreaView(aiController, recommendController, clearController, saveController, textAreaViewModel);

        views.add(textAreaView, textAreaView.viewName);

        viewManagerModel.setActiveView(textAreaView.viewName);
        viewManagerModel.firePropertyChanged();


        application.pack();
        application.setVisible(true);

    }

}