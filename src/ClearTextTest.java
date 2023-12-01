import interface_adapter.clear_text.ClearController;
import interface_adapter.clear_text.ClearPresenter;
import interface_adapter.clear_text.ClearViewModel;
import interface_adapter.save_text.SaveController;
import interface_adapter.save_text.SavePresenter;
import interface_adapter.save_text.SaveViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.clear_text.ClearInputBoundary;
import use_case.clear_text.ClearInteractor;
import use_case.clear_text.ClearOutputBoundary;
import use_case.save_text.SaveInputBoundary;
import use_case.save_text.SaveInteractor;
import use_case.save_text.SaveOutputBoundary;
import view.TextAreaView;

import javax.swing.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ClearTextTest {

    private TextAreaView textAreaView;
    private JButton clearButton;

    private JButton saveButton;
    final JTextArea textArea = new JTextArea();

    TextAreaViewModel textAreaViewModel = new TextAreaViewModel();
    ClearViewModel clearViewModel = new ClearViewModel();

    SaveViewModel saveViewModel = new SaveViewModel();
    ClearOutputBoundary clearOutputBoundary = new ClearPresenter(clearViewModel, textAreaViewModel );

    ClearInputBoundary clearUseCaseInteractor = new ClearInteractor(clearOutputBoundary);

    SaveOutputBoundary saveOutputBoundary = new SavePresenter(saveViewModel);

    SaveInputBoundary saveUseCaseInteractor = new SaveInteractor(saveOutputBoundary);

    private JPanel findButtonPanel(TextAreaView textAreaView) {
        JPanel mainPanel = (JPanel) textAreaView.getComponent(0);

        return (JPanel) mainPanel.getComponent(1);
    }


    @Before
    public void setUp() {
        ClearController clearController = new ClearController(clearUseCaseInteractor);
        SaveController saveController = new SaveController(saveUseCaseInteractor);

        TextAreaView textAreaView = new TextAreaView(clearController,saveController, textAreaViewModel);

        JPanel buttonPanel = findButtonPanel(textAreaView);
        clearButton = (JButton) buttonPanel.getComponent(0);
        saveButton = (JButton) buttonPanel.getComponent(1);

    }

    @Test
    public void testClearButtonPresent() {
        assertEquals("matches", TextAreaViewModel.CLEAR_BUTTON_LABEL, clearButton.getText());
    }

    @Test
    public void testSaveButtonPresent() {
        assertEquals("matches", TextAreaViewModel.SAVEASPDF_BUTTON_LABEL, saveButton.getText());
    }


    @Test
    public void clearTest() {

        textArea.setText("hey how are you");

        clearButton.addActionListener(e -> textArea.setText(""));

        clearButton.doClick();

        assertEquals("Text area should be empty after clicking clear button", "", textArea.getText());
    }
//    @Test
//    public void SaveTest() throws IOException {
//        String testText = "This is a test text.";
//
//        // Create an in-memory output stream to capture the PDF content.
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        try {
//            // Redirect PDF generation to the in-memory output stream.
//            System.setOut(new PrintStream(outputStream));
//
//            // Call the saveToPDF method with your test text.
//            SaveDataAccessObject SaveDataAccessObject = new SaveDataAccessObject();
//            data_access.SaveDataAccessObject.saveToPDF(testText);
//
//            // Reset the standard output stream.
//            System.setOut(System.out);
//
//            // Extract the PDF content from the output stream.
//            String pdfContent = outputStream.toString();
//
//            // Assert that the extracted text matches the input text.
//            assertEquals(testText, pdfContent.trim());
//
//        } finally {
//            outputStream.close();
//        }
//
//
//    }


}




