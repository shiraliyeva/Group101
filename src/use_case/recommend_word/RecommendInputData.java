package use_case.recommend_word;

public class RecommendInputData {
    private String text;

    public RecommendInputData(String text) {
        this.text=text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text=text;

    }
}
