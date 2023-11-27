package app;

import entity.Text;
import interface_adapter.recommend_word.RecommendController;
import interface_adapter.recommend_word.RecommendViewModel;
import view.RecommendView;
import view.TextAreaView;

public class RecommendWordUseCaseFactory {
    public static RecommendView createRecommendView(RecommendViewModel recommendViewModel, StringBuilder recommendation, TextAreaView textAreaView) {
        return new RecommendView(recommendViewModel, recommendation, textAreaView);

    }
}
