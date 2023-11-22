package interface_adapter.text_area;

import use_case.recommend_word.RecommendInputBoundary;
import use_case.recommend_word.RecommendInputData;

public class TextAreaController {
    final RecommendInputBoundary recommendUseCaseInteractor;

    public TextAreaController(RecommendInputBoundary recommendUseCaseInteractor) {
        this.recommendUseCaseInteractor = recommendUseCaseInteractor;
    }

    public void execute(String text) {
        RecommendInputData recommendInputData = new RecommendInputData(text);

        recommendUseCaseInteractor.execute(recommendInputData);
    }
}
