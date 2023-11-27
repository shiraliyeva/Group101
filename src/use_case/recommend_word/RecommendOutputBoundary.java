package use_case.recommend_word;

import view.TextAreaView;

public interface RecommendOutputBoundary {
    void prepareRecommendView(StringBuilder recommendation, TextAreaView textAreaView);
}
