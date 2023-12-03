


import interface_adapter.clear_text.ClearPresenter;
import interface_adapter.clear_text.ClearViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.clear_text.*;

import static org.junit.Assert.*;

public class TestClearUseCase {
    private ClearInputBoundary clearInteractor;
    private TextAreaViewModel textAreaViewModel;

    @Before
    public void setup() {
        TextAreaViewModel textAreaViewModel = new TextAreaViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();
        ClearOutputData clearOutputData = new ClearOutputData();
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(clearViewModel, textAreaViewModel);
        this.clearInteractor = new ClearInteractor(clearOutputBoundary);
        this.textAreaViewModel = textAreaViewModel;
    }

    @Test
    public void executeTestSuccess() {
        try {
            ClearInputData clearInputData = new ClearInputData();
            clearInteractor.execute(clearInputData);
        } catch (Exception e) {
            fail("Execution of execute method should not throw an exception");
        }

        assertEquals("",textAreaViewModel.getCurrentText());
    }
}