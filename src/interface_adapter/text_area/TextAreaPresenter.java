package interface_adapter.text_area;

import interface_adapter.ViewManagerModel;
import interface_adapter.recommend_word.RecommendState;
import interface_adapter.recommend_word.RecommendViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import use_case.recommend_word.RecommendOutputData;
import view.RecommendView;

import javax.swing.*;
import java.awt.*;

public class TextAreaPresenter {
    private final RecommendViewModel recommendViewModel;

    private ViewManagerModel viewManagerModel;

    public TextAreaPresenter(ViewManagerModel viewManagerModel,
                             RecommendViewModel recommendViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recommendViewModel= recommendViewModel;

    }

    public void prepareRecommendView(RecommendOutputData recommendation) {
        RecommendState recommendState = recommendViewModel.getState();
        recommendState.setRecommendText(recommendation.getRecommendation());
        this.recommendViewModel.setState(recommendState);
        recommendViewModel.firePropertyChanged();


        viewManagerModel.setActiveView(recommendViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        RecommendView recommendView = new RecommendView(recommendViewModel);

    }
}
