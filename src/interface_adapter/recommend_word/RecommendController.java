package interface_adapter.recommend_word;

import use_case.recommend_word.RecommendInputBoundary;
import use_case.recommend_word.RecommendInputData;

public class RecommendController {
    final RecommendInputBoundary recommendUseCaseInteractor;

    public RecommendController(RecommendInputBoundary recommendUseCaseInteractor) {
        this.recommendUseCaseInteractor = recommendUseCaseInteractor;
    }

    public String execute(String text) {
        RecommendInputData recommendInputData = new RecommendInputData(text);
        String recommendation = recommendUseCaseInteractor.execute(recommendInputData);
        return recommendation;
    }

}
