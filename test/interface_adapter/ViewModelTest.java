package interface_adapter;

import interface_adapter.ai_explanation.AiState;
import interface_adapter.ai_explanation.AiViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ViewModelTest {

    private AiViewModel aiViewModel;

    @BeforeEach
    void setUp() {
        aiViewModel = new AiViewModel();
    }

    @Test
    void testViewModelInitialization() {

        assertEquals("ai explanation", aiViewModel.getViewName(),
                "Tests that the view name is set correctly");
        assertEquals(AiState.class, aiViewModel.getState().getClass(),
                "Tests that the initial state is of type AiState");
    }

    @Test
    void testGetExplanation() {
        AiState state = new AiState();
        state.setExplanation("Test Explanation");
        aiViewModel.setState(state);

        assertEquals("Test Explanation", aiViewModel.getExplanation(),
                "Tests that getExplanation returns the correct explanation");
    }

}
