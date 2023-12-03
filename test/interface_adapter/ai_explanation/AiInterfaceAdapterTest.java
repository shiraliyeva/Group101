package interface_adapter.ai_explanation;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.ai_explanation.AiInputBoundary;
import use_case.ai_explanation.AiInputData;
import use_case.ai_explanation.AiOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AiInterfaceAdapterTest {

    @Test
    void testPrepareSuccessView() {
        AiViewModel viewModel = new AiViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        AiPresenter presenter = new AiPresenter(viewManagerModel, viewModel);

        AiOutputData outputData = new AiOutputData("Explanation");

        presenter.prepareSuccessView(outputData);

        assertNotNull(viewModel.getState());
        assertEquals("Explanation", viewModel.getState().getExplanation());

        assertNotNull(viewManagerModel.getActiveView());
        assertEquals(viewModel.getViewName(), viewManagerModel.getActiveView(),
                "Tests that prepareSuccessView is working and updates the view");
    }

    private static class AiInputBoundaryStub implements AiInputBoundary {
        private AiInputData inputData;

        @Override
        public void execute(AiInputData aiInputData) {
            this.inputData = aiInputData;
        }

        public AiInputData getInputData() {
            return inputData;
        }
    }

    @Test
    void testInvokeUseCaseInteractor() {

        AiInputBoundaryStub useCaseInteractor = new AiInputBoundaryStub();

        AiController controller = new AiController(useCaseInteractor);

        controller.execute("userWord", "suggestedWord");

        AiInputData inputData = useCaseInteractor.getInputData();

        assertNotNull(inputData);
        assertEquals("userWord", inputData.getUsersWord());
        assertEquals("suggestedWord", inputData.getSuggestedWord());

        assertNotNull(controller);
    }

    @Test
    void testGetExplanation() {
        AiViewModel viewModel = new AiViewModel();

        AiState newState = new AiState();
        newState.setExplanation("Test Explanation");
        viewModel.setState(newState);

        assertEquals("Test Explanation", viewModel.getExplanation(),
                "Tests that getExplanation returns the correct explanation");
    }

    @Test
    void testCopyConstructor() {
        AiState originalState = new AiState();
        originalState.setExplanation("Original Explanation");

        AiState copiedState = new AiState(originalState);

        assertEquals("Original Explanation", copiedState.getExplanation(),
                "Tests that the copy constructor correctly copies the explanation");
    }
}
