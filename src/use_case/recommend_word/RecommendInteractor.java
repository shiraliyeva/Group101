package use_case.recommend_word;

import javax.swing.*;

public class RecommendInteractor implements RecommendInputBoundary {
    final RecommendOutputBoundary recommendPresenter;

    public RecommendInteractor(RecommendOutputBoundary recommendOutputBoundary) {

        this.recommendPresenter = recommendOutputBoundary;
    }

    public void replaceRecommendation(JTextArea textArea,String s,int start, int end) {
        textArea.replaceRange(s,start,end);



    }
    @Override
    public void findRecommendation(String recommendInputData) {

    }
}
