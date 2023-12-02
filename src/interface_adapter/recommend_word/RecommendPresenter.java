package interface_adapter.recommend_word;

import interface_adapter.ViewManagerModel;
import use_case.recommend_word.RecommendOutputBoundary;
import use_case.recommend_word.RecommendOutputData;


public class RecommendPresenter implements RecommendOutputBoundary {
    private final RecommendViewModel recommendViewModel;
    private RecommendOutputData recommendOutputData;


    private ViewManagerModel viewManagerModel;


    public RecommendPresenter(ViewManagerModel viewManagerModel,
                              RecommendViewModel recommendViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recommendViewModel = recommendViewModel;

    }
    public void prepareRecommendView(RecommendOutputData recommendation) {

        RecommendState recommendState = recommendViewModel.getState();
        recommendState.setRecommendText(recommendation.getRecommendation());
        this.recommendViewModel.setState(recommendState);
        this.recommendViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(recommendViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
        this.recommendOutputData= recommendation;

    }

}



