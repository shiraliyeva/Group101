package use_case.recommend_word;

public class RecommendInteractor implements RecommendInputBoundary {
    final RecommendOutputBoundary recommendPresenter;

    public RecommendInteractor(RecommendOutputBoundary recommendOutputBoundary, RecommendOutputBoundary recommendPresenter) {

        this.recommendPresenter = recommendPresenter;
    }

}
