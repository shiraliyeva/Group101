package use_case.ai_explanation;

import data_access.AiDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.ai_explanation.AiPresenter;
import interface_adapter.ai_explanation.AiViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AiIUseCaseTest {

    @Test
    void testInvokeDataAccessAndPresenter() {
        AiDataAccessInterface dataAccess = new AiDataAccessObject();
        AiOutputBoundary presenter = new AiPresenter(new ViewManagerModel(), new AiViewModel());

        AiInteractor interactor = new AiInteractor(dataAccess, presenter);

        AiInputData inputData = new AiInputData("userWord", "suggestedWord");

        interactor.execute(inputData);

        assertNotNull(presenter);
    }
}
