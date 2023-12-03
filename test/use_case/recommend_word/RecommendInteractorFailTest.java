package use_case.recommend_word;

import data_access.RecommendDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.recommend_word.RecommendPresenter;
import interface_adapter.recommend_word.RecommendViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RecommendInteractorFailTest {
    private RecommendInputBoundary recommendInteractor;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        RecommendDataAccessInterface apiCall = new RecommendDataAccessObject();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        RecommendViewModel recommendViewModel = new RecommendViewModel();
        RecommendOutputBoundary recommendOutputBoundary = new RecommendPresenter(viewManagerModel, recommendViewModel);
        RecommendInputBoundary recommendInteractor = new RecommendInteractor(apiCall, recommendOutputBoundary);
        this.recommendInteractor = recommendInteractor;
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testNoSynonym() {
        // Your code that calls System.out.println
        recommendInteractor.execute(new RecommendInputData("asdhiashdiosadsaiohasdodhi"));

        // Use assertEquals to verify the output
        assertEquals("Your highlighted word does not have a synonym, try it again but remove spaces from the start or the end of the word\r\n", outputStreamCaptor.toString());
    }
}

