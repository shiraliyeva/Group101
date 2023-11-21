package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.ai_explanation.AiController;
import interface_adapter.ai_explanation.AiPresenter;
import interface_adapter.ai_explanation.AiViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import use_case.ai_explanation.AiDataAccessInterface;
import use_case.ai_explanation.AiInputBoundary;
import use_case.ai_explanation.AiInteractor;
import use_case.ai_explanation.AiOutputBoundary;
import view.AiView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AiUseCaseFactory {

    /** Prevent instantiation. */
    private AiUseCaseFactory() {}

    public static AiView create(
            ViewManagerModel viewManagerModel,
            AiViewModel aiViewModel,
            AiDataAccessInterface aiDataAccessObject,
            TextAreaViewModel textAreaViewModel,
            JPanel views,
            CardLayout cardLayout) {

        try {
            AiController aiController = createAiUseCase(viewManagerModel, aiViewModel, aiDataAccessObject);
            return new AiView(aiController, aiViewModel, textAreaViewModel, views,cardLayout);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not generate AI explanation.");
        }

        return null;
    }

    private static AiController createAiUseCase(
            ViewManagerModel viewManagerModel,
            AiViewModel aiViewModel,
            AiDataAccessInterface aiDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        AiOutputBoundary aiOutputBoundary = new AiPresenter(viewManagerModel, aiViewModel);

        AiInputBoundary aiInteractor = new AiInteractor(
                aiDataAccessObject, aiOutputBoundary);

        return new AiController(aiInteractor);
    }
}



