
import interface_adapter.clear_text.*;
import interface_adapter.text_area.TextAreaViewModel;
import org.junit.Before;
import use_case.clear_text.ClearInteractor;
import use_case.clear_text.ClearOutputBoundary;
import use_case.clear_text.ClearInputBoundary;

import static org.junit.Assert.assertEquals;


public class ClearControllerTest {
    private ClearController clearController;
    private TextAreaViewModel textAreaViewModel;

    @Before
    public void setup() {

        TextAreaViewModel textAreaViewModel = new TextAreaViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(clearViewModel, textAreaViewModel);
        ClearInputBoundary clearInteractor = new ClearInteractor(clearOutputBoundary);
        this.clearController = new ClearController(clearInteractor);
        this.textAreaViewModel = textAreaViewModel;


    }

    @org.junit.Test
    public void executeTestSuccess() {
        clearController.execute();
        assertEquals("", textAreaViewModel.getCurrentText());
    }
}
