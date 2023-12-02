package use_case.recommend_word;

public class RecommendInteractor implements RecommendInputBoundary {

    private final RecommendDataAccessInterface recommendDataAccessObject;
    final RecommendOutputBoundary recommendPresenter;

    public RecommendInteractor(RecommendDataAccessInterface recommendDataAccessObject, RecommendOutputBoundary recommendOutputBoundary) {
        this.recommendDataAccessObject = recommendDataAccessObject;

        this.recommendPresenter = recommendOutputBoundary;
    }

    @Override
    public String execute(RecommendInputData recommendInputData) {

        String recommendation=recommendDataAccessObject.getRecommendation(recommendInputData.getText());
        RecommendOutputData recommendOutputData= new RecommendOutputData(recommendation);
        return recommendOutputData.getRecommendation();
    }
}
