package interface_adapter.recommend_word;

import app.RecommendWordUseCaseFactory;
import entity.Text;
import interface_adapter.ViewManagerModel;
import interface_adapter.recommend_word.RecommendState;
import interface_adapter.recommend_word.RecommendViewModel;
import use_case.recommend_word.RecommendInteractor;
import use_case.recommend_word.RecommendOutputBoundary;
import view.TextAreaView;


public class RecommendPresenter implements RecommendOutputBoundary {
    private final RecommendViewModel recommendViewModel;


    private ViewManagerModel viewManagerModel;


    public RecommendPresenter(ViewManagerModel viewManagerModel,
                              RecommendViewModel recommendViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recommendViewModel = recommendViewModel;

    }
//    @Override
//    public void prepareRecommendView(StringBuilder recommendation, TextAreaView textAreaView) {
//        RecommendState recommendState = recommendViewModel.getState();
//        recommendState.setRecommendText(recommendation);
//        this.recommendViewModel.setState(recommendState);
//        recommendViewModel.firePropertyChanged();
//
//        viewManagerModel.setActiveView(recommendViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//        RecommendWordUseCaseFactory.createRecommendView(recommendViewModel, recommendation, textAreaView);

// }

}



