package interface_adapter.recommend_word;

import use_case.recommend_word.RecommendInputBoundary;

public class RecommendController {
    final RecommendInputBoundary recommendUseCaseInteractor;

    public RecommendController(RecommendInputBoundary recommendUseCaseInteractor) {
        this.recommendUseCaseInteractor = recommendUseCaseInteractor;
    }

    public String execute(String recommendInputData) {

        return recommendUseCaseInteractor.execute(recommendInputData);
    }

}
