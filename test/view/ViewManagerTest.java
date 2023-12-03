package view;

import app.AiUseCaseFactory;
import app.ClearUseCaseFactory;
import app.RecommendWordUseCaseFactory;
import app.SaveUseCaseFactory;
import data_access.AiDataAccessObject;
import data_access.RecommendDataAccessObject;
import data_access.SaveDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.ai_explanation.AiController;
import interface_adapter.ai_explanation.AiPresenter;
import interface_adapter.ai_explanation.AiViewModel;
import interface_adapter.clear_text.ClearController;
import interface_adapter.clear_text.ClearPresenter;
import interface_adapter.clear_text.ClearViewModel;
import interface_adapter.recommend_word.RecommendController;
import interface_adapter.recommend_word.RecommendPresenter;
import interface_adapter.recommend_word.RecommendViewModel;
import interface_adapter.save_text.SaveController;
import interface_adapter.save_text.SavePresenter;
import interface_adapter.save_text.SaveViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import use_case.ai_explanation.AiDataAccessInterface;
import use_case.ai_explanation.AiInputBoundary;
import use_case.ai_explanation.AiInteractor;
import use_case.ai_explanation.AiOutputBoundary;
import use_case.clear_text.ClearInputBoundary;
import use_case.clear_text.ClearInteractor;
import use_case.clear_text.ClearOutputBoundary;
import use_case.recommend_word.RecommendDataAccessInterface;
import use_case.recommend_word.RecommendInputBoundary;
import use_case.recommend_word.RecommendInteractor;
import use_case.recommend_word.RecommendOutputBoundary;
import use_case.save_text.SaveDataAccessInterface;
import use_case.save_text.SaveInputBoundary;
import use_case.save_text.SaveInteractor;
import use_case.save_text.SaveOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


import static org.junit.jupiter.api.Assertions.*;

class ViewManagerTest {
    private JButton clearButton;

    private JButton saveButton;
    final JTextArea textArea = new JTextArea();
    private ViewManagerModel viewManagerModel;

    TextAreaViewModel textAreaViewModel = new TextAreaViewModel();

    ClearViewModel clearViewModel = new ClearViewModel();

    SaveViewModel saveViewModel = new SaveViewModel();

    AiViewModel aiViewModel = new AiViewModel();

    RecommendViewModel recommendViewModel = new RecommendViewModel();
    ClearOutputBoundary clearOutputBoundary = new ClearPresenter(clearViewModel, textAreaViewModel );

    ClearInputBoundary clearUseCaseInteractor = new ClearInteractor(clearOutputBoundary);

    SaveDataAccessInterface saveDataAccessObject = new SaveDataAccessObject();

    SaveOutputBoundary saveOutputBoundary = new SavePresenter(saveViewModel);

    SaveInputBoundary saveUseCaseInteractor = new SaveInteractor(saveDataAccessObject, saveOutputBoundary);

    RecommendDataAccessInterface recommendDataAccessObject = new RecommendDataAccessObject();

    RecommendOutputBoundary recommendOutputBoundary = new RecommendPresenter(viewManagerModel, recommendViewModel);
    RecommendInputBoundary recommendUseCaseInteractor = new RecommendInteractor(recommendDataAccessObject, recommendOutputBoundary);
    AiDataAccessInterface aiDataAccessObject = new AiDataAccessObject();

    AiOutputBoundary aiOutputBoundary = new AiPresenter(viewManagerModel, aiViewModel);
    AiInputBoundary responseAiUseCaseInteractor = new AiInteractor(aiDataAccessObject, aiOutputBoundary);

    @Test
    void testSetActiveView() {
        JFrame application = new JFrame();

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        viewManagerModel = new ViewManagerModel();
        ViewManager viewManager = new ViewManager(views, cardLayout, viewManagerModel);


        ClearController clearController = new ClearController(clearUseCaseInteractor);
        SaveController saveController = new SaveController(saveUseCaseInteractor);
        AiController aiController = new AiController(responseAiUseCaseInteractor);
        RecommendController recommendController = new RecommendController(recommendUseCaseInteractor);

        TextAreaView textAreaView = new TextAreaView(aiController, recommendController, clearController,saveController, textAreaViewModel);

        views.add(textAreaView, textAreaView.viewName);

        viewManagerModel.setActiveView(textAreaView.viewName);

        PropertyChangeEvent event = new PropertyChangeEvent(this, "view", "currentView", "text area");

        viewManager.propertyChange(event);

        String actual = viewManagerModel.getActiveView();

        application.pack();
        application.setVisible(true);

        assertEquals("text area", actual);
    }

}

