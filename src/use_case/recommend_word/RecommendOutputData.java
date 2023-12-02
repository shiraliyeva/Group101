package use_case.recommend_word;

public class RecommendOutputData {
    private String recommendation;

    public RecommendOutputData(String recommendation) {this.recommendation = recommendation;}
    public String getRecommendation() {
        return recommendation;
    }
    public void setRecommendation(String recommendation) {
        this.recommendation=recommendation;
    }
}
