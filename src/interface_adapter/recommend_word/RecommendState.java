package interface_adapter.recommend_word;

public class RecommendState {
    private String recommendText = "";
    public RecommendState() {

    }
    public RecommendState(RecommendState copy) {
        recommendText = copy.recommendText;
    }

    public String getRecommendText() {
        return recommendText;
    }
    public void setRecommendText(String text) {
        this.recommendText=text;

    }
    public String toString() {
        return "RecommendState{" +
                "recommendText=" + recommendText + '}';
    }
}
