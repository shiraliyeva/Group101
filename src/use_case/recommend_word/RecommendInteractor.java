package use_case.recommend_word;

public class RecommendInteractor implements RecommendInputBoundary {

    private final RecommendDataAccessInterface recommendDataAccessObject;
    final RecommendOutputBoundary recommendPresenter;

    public RecommendInteractor(RecommendDataAccessInterface recommendDataAccessObject, RecommendOutputBoundary recommendPresenter) {
        this.recommendDataAccessObject = recommendDataAccessObject;

        this.recommendPresenter = recommendPresenter;
    }

    @Override
    public String execute(RecommendInputData recommendInputData) {

        String recommendation=recommendDataAccessObject.getRecommendation(recommendInputData.getText());
        RecommendOutputData recommendOutputData= new RecommendOutputData(recommendation);
        recommendPresenter.prepareRecommendView(recommendOutputData);
        return recommendOutputData.getRecommendation();
    }
}
