import data_access.SaveDataAccessObject;
import interface_adapter.save_text.SavePresenter;
import interface_adapter.save_text.SaveViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.save_text.*;


import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestSaveUseCase {
    private SaveInputBoundary saveInteractor;
    private TextAreaViewModel textAreaViewModel;
    private SaveViewModel saveViewModel;

    @Before
    public void setup() {
        TextAreaViewModel textAreaViewModel = new TextAreaViewModel();
        SaveViewModel saveViewModel = new SaveViewModel();
        JTextArea textArea = new JTextArea();
        SaveInputData saveInputData = new SaveInputData(textArea.getText());
        String outputText = saveInputData.getText();
        SaveOutputData saveOutputData = new SaveOutputData(outputText);
        SaveOutputBoundary saveOutputBoundary = new SavePresenter(saveViewModel);
        SaveDataAccessInterface saveDataAccessInterface = new SaveDataAccessObject();

        this.saveInteractor = new SaveInteractor(saveDataAccessInterface,
                saveOutputBoundary);
        this.textAreaViewModel = textAreaViewModel;
        this.saveViewModel = saveViewModel;
    }

    @Test
    public void executeTestSuccess() {
        try {
            JTextArea textArea = new JTextArea();
            SaveInputData saveInputData = new SaveInputData(textArea.getText());
            saveInteractor.execute(saveInputData);
        } catch (Exception e) {
            fail("Execution of execute method should not throw an exception");
        }
        assertEquals("", saveViewModel.getContent());
    }
}
