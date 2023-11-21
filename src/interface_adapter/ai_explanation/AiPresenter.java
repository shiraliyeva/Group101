package interface_adapter.ai_explanation;

import interface_adapter.ViewManagerModel;
import use_case.ai_explanation.AiOutputBoundary;
import use_case.ai_explanation.AiOutputData;
import view.AiView;


public class AiPresenter implements AiOutputBoundary {

    private final AiViewModel aiViewModel;
    private final ViewManagerModel viewManagerModel;


    public AiPresenter(ViewManagerModel viewManagerModel,
                          AiViewModel aiViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.aiViewModel = aiViewModel;
    }

    @Override
    public void prepareSuccessView(AiOutputData response) {
        // On success, switch to the logged in view.

        AiState aiState = aiViewModel.getState();
        aiState.setExplanation(response.getExplanation());
        this.aiViewModel.setState(aiState);
        this.aiViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(aiViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();


    }
}