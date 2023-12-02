package app;

import data_access.RecommendDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.ai_explanation.AiController;
import interface_adapter.recommend_word.RecommendController;
import interface_adapter.recommend_word.RecommendPresenter;
import interface_adapter.recommend_word.RecommendViewModel;
import use_case.recommend_word.RecommendInteractor;
import use_case.recommend_word.RecommendOutputBoundary;
import view.RecommendView;
import view.TextAreaView;

public class RecommendWordUseCaseFactory {

    public static RecommendView createRecommendView(AiController aiController, RecommendViewModel recommendViewModel, TextAreaView textAreaView) {

        return new RecommendView(aiController, recommendViewModel, textAreaView, null);

    }
    /**
     * @param viewManagerModel a ViewManagerModel
     * @param recommendViewModel the recommendViewModel
     * @return a RecommendController class
     */
    static RecommendController createRecommendController(ViewManagerModel viewManagerModel,
                                                                RecommendViewModel recommendViewModel) {


        RecommendDataAccessObject recommendDataAccessObject= new RecommendDataAccessObject();
        RecommendOutputBoundary recommendOutputBoundary = new RecommendPresenter(viewManagerModel, recommendViewModel);
        RecommendInteractor recommendInteractor = new RecommendInteractor(recommendDataAccessObject,recommendOutputBoundary);
        return new RecommendController(recommendInteractor);
    }
}
