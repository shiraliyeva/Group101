package interface_adapter.recommend_word;

import data_access.RecommendDataAccessObject;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.recommend_word.*;

import static org.junit.jupiter.api.Assertions.*;

class RecommendControllerTest {
    private RecommendController recommendController;
    @BeforeEach
    void init() {

        RecommendDataAccessInterface apiCall = new RecommendDataAccessObject();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        RecommendViewModel recommendViewModel = new RecommendViewModel();
        RecommendOutputBoundary recommendOutputBoundary = new RecommendPresenter(viewManagerModel, recommendViewModel);
        RecommendInputBoundary recommendInteractor = new RecommendInteractor(apiCall, recommendOutputBoundary);
        RecommendController recommendController = new RecommendController(recommendInteractor);
        this.recommendController = recommendController;
    }

    @Test
    void executeTestSuccess() {

        assertNotNull(recommendController.execute("Happy"));


    }

}