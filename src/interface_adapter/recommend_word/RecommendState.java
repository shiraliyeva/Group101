package interface_adapter.recommend_word;

public class RecommendState {
    private StringBuilder recommendText = new StringBuilder();
    public RecommendState() {

    }
    public RecommendState(RecommendState copy) {
        recommendText = copy.recommendText;
    }

    public StringBuilder getRecommendText() {
        return recommendText;
    }
    public void setRecommendText(StringBuilder text) {
        this.recommendText=text;

    }
    public String toString() {
        return "RecommendState{" +
                "recommendText=" + recommendText + '}';
    }
}
