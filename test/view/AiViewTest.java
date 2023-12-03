package view;

import interface_adapter.ai_explanation.AiViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AiViewTest {

    private static class MockAiViewModel extends AiViewModel {
        private String explanation;

        @Override
        public String getExplanation() {
            return explanation;
        }

        public void setExplanation(String explanation) {
            this.explanation = explanation;
        }
    }

    private MockAiViewModel mockViewModel;
    private AiView aiView;

    @BeforeEach
    void setUp() {
        mockViewModel = new MockAiViewModel();
        aiView = new AiView(mockViewModel);
    }

    @Test
    void testAiViewInitialization() {
        assertNotNull(aiView);
        assertEquals("ai explanation", aiView.viewName,
                "Tests for the initialization of AiView");
        assertNotNull(aiView.aiViewModel);
        assertNotNull(aiView.descriptionArea);
        assertTrue(aiView.isDescriptionAreaLineWrap());
        assertTrue(aiView.isDescriptionAreaWrapStyleWord());
        assertFalse(aiView.isDescriptionAreaEditable());
    }

    @Test
    void testDescriptionArea() {
        assertEquals(AiViewModel.AIVIEW_DESCRIPTION, aiView.getDescriptionAreaText(),
                "Tests that the description area is present before the AI Explanation replaces it");
    }

    @Test
    void testUpdateDescriptionAreaText() {

        String expectedExplanation = "Test explanation";

        mockViewModel.setExplanation(expectedExplanation);
        aiView.updateDescriptionLabel();

        assertEquals(expectedExplanation, aiView.getDescriptionAreaText(),
                "Tests if AiView gets updated with AI Explanation");
    }

}

