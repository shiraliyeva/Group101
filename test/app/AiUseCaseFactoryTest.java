package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.ai_explanation.AiController;
import interface_adapter.ai_explanation.AiPresenter;
import interface_adapter.ai_explanation.AiViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import use_case.ai_explanation.AiDataAccessInterface;
import use_case.ai_explanation.AiOutputData;
import view.AiView;

import java.io.IOException;

class AiUseCaseFactoryTest {

    private static class ViewManagerModelStub extends ViewManagerModel {
        @Override
        public void setActiveView(String viewName) {
        }

        @Override
        public String getActiveView() {
            return null;
        }
    }

    private static class AiViewModelStub extends AiViewModel {
        @Override
        public String getViewName() {
            return null;
        }
    }

    private static class AiDataAccessObjectStub implements AiDataAccessInterface {
        @Override
        public String getAiExplanation(String usersWord, String suggestedWord) {
            return null;
        }

    }

    private static class AiPresenterStub extends AiPresenter {
        public AiPresenterStub(ViewManagerModel viewManagerModel, AiViewModel aiViewModel) {
            super(viewManagerModel, aiViewModel);
        }

        @Override
        public void prepareSuccessView(AiOutputData outputData) {

        }
    }

    @Test
    void testCreateAiView() {

        ViewManagerModelStub viewManagerModel = new ViewManagerModelStub();
        AiViewModelStub aiViewModel = new AiViewModelStub();
        AiDataAccessObjectStub aiDataAccessObject = new AiDataAccessObjectStub();

        AiView aiView = AiUseCaseFactory.create(viewManagerModel, aiViewModel, aiDataAccessObject);

        assertNotNull(aiView, "AiView should be created");
    }

    @Test
    void testCreateAiController() {
        ViewManagerModelStub viewManagerModel = new ViewManagerModelStub();
        AiViewModelStub aiViewModel = new AiViewModelStub();

        AiController aiController = null;
        try {
            aiController = AiUseCaseFactory.createAiUseCase(viewManagerModel, aiViewModel, null);
        } catch (IOException e) {
            assertEquals("Could not generate AI explanation.", e.getMessage(), "IOException message should match");
        }
    }

    // TODO: WRITE A TEST THAT CATCHES IOEXCEPTION IF POSSIBLE
}
