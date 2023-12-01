package interface_adapter.recommend_word;

import interface_adapter.ViewManagerModel;
import use_case.recommend_word.RecommendOutputBoundary;


public class RecommendPresenter implements RecommendOutputBoundary {
    private final RecommendViewModel recommendViewModel;


    private ViewManagerModel viewManagerModel;


    public RecommendPresenter(ViewManagerModel viewManagerModel,
                              RecommendViewModel recommendViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recommendViewModel = recommendViewModel;

    }
}



