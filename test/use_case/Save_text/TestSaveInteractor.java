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

public class TestSaveInteractor {
    private SaveInputBoundary saveInteractor;
    private TextAreaViewModel textAreaViewModel;


    @Before
    public void setup() {
        TextAreaViewModel textAreaViewModel = new TextAreaViewModel();
        SaveViewModel saveViewModel = new SaveViewModel();
        SaveOutputBoundary saveOutputBoundary = new SavePresenter(saveViewModel);
        SaveDataAccessInterface saveDataAccessInterface = new SaveDataAccessObject();

        this.saveInteractor = new SaveInteractor(saveDataAccessInterface,
                saveOutputBoundary);
        this.textAreaViewModel = textAreaViewModel;

    }

    @Test
    public void executeTestSuccess() {
        JTextArea textArea = new JTextArea();
        SaveInputData saveInputData = new SaveInputData(textArea.getText());
        saveInteractor.execute(saveInputData);
        assertEquals("Please input your text here...", textAreaViewModel.getCurrentText());
    }
}
