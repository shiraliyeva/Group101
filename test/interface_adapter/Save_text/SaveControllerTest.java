import data_access.SaveDataAccessObject;
import interface_adapter.save_text.SaveController;
import interface_adapter.save_text.SavePresenter;
import interface_adapter.save_text.SaveViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.save_text.*;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class SaveControllerTest {
    private SaveInputBoundary saveInteractor;
    private TextAreaViewModel textAreaViewModel;
    private SaveController saveController;

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
        SaveInputBoundary saveInputBoundary = new SaveInteractor(saveDataAccessInterface,
                saveOutputBoundary);

        this.saveController = new SaveController(saveInputBoundary);
        this.textAreaViewModel = textAreaViewModel;
    }

    @Test
    public void executeTestSuccess() {
        JTextArea textArea = new JTextArea();
        SaveInputData saveInputData = new SaveInputData(textArea.getText());
        saveController.execute(saveInputData.getText());
        assertEquals("Please input your text here...", textAreaViewModel.getCurrentText());
    }
}