package use_case.recommend_word;

import data_access.RecommendDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.recommend_word.RecommendPresenter;
import interface_adapter.recommend_word.RecommendViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.View;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RecommendInteractorTest {
    private RecommendInputBoundary recommendInteractor;
    @BeforeEach
    void init() {
        RecommendDataAccessInterface apiCall = new RecommendDataAccessObject();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        RecommendViewModel recommendViewModel = new RecommendViewModel();
        RecommendOutputBoundary recommendOutputBoundary = new RecommendPresenter(viewManagerModel, recommendViewModel);
        RecommendInputBoundary recommendInteractor = new RecommendInteractor(apiCall, recommendOutputBoundary);
        this.recommendInteractor = recommendInteractor;
    }

    @Test
    void executeTestSuccess() {

        assertNotNull(recommendInteractor.execute(new RecommendInputData("Happy")));


    }
}