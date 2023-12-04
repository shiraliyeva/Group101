package use_case.clear_text;

import interface_adapter.clear_text.ClearPresenter;
import interface_adapter.clear_text.ClearViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.clear_text.*;

import static org.junit.Assert.*;

public class TestClearInteractor {
    private ClearInputBoundary clearInteractor;
    private TextAreaViewModel textAreaViewModel;

    @Before
    public void setup() {
        TextAreaViewModel textAreaViewModel = new TextAreaViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();

        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(clearViewModel, textAreaViewModel);
        this.clearInteractor = new ClearInteractor(clearOutputBoundary);
        this.textAreaViewModel = textAreaViewModel;
    }

    @Test
    public void executeTestSuccess() {
        ClearInputData clearInputData = new ClearInputData();
        clearInteractor.execute(clearInputData);
        assertEquals("", textAreaViewModel.getCurrentText());
        assertNotNull(clearInteractor);
    }
}