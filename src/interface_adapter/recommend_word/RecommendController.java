package interface_adapter.recommend_word;

import use_case.recommend_word.RecommendInputBoundary;
import use_case.recommend_word.RecommendInputData;

public class RecommendController {
    final RecommendInputBoundary recommendUseCaseInteractor;

    public RecommendController(RecommendInputBoundary recommendUseCaseInteractor) {
        this.recommendUseCaseInteractor = recommendUseCaseInteractor;
    }

    /**
     * @param text the word that you want to find a synonym for
     * @return the synonym
     */

    public String execute(String text) {
        RecommendInputData recommendInputData = new RecommendInputData(text);
        String recommendation = recommendUseCaseInteractor.execute(recommendInputData);
        return recommendation;
    }

}
