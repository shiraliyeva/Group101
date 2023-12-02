package app;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;

import data_access.AiDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.ai_explanation.AiController;
import interface_adapter.ai_explanation.AiViewModel;
import interface_adapter.text_area.TextAreaViewModel;

import view.ViewManager;
import view.TextAreaView;

public class Main {

    public static void main(String[] args) throws IOException {

        // Main program window

        JFrame application = new JFrame("Vocabulary Builder");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        TextAreaViewModel textAreaViewModel = new TextAreaViewModel();
        AiViewModel aiViewModel = new AiViewModel();

        AiDataAccessObject aiDataAccessObject = new AiDataAccessObject();

        AiController aiController = AiUseCaseFactory.createAiUseCase(viewManagerModel, aiViewModel, aiDataAccessObject);

        TextAreaView textAreaView = new TextAreaView(aiController, textAreaViewModel);
        views.add(textAreaView, textAreaView.viewName);

        viewManagerModel.setActiveView(textAreaView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}