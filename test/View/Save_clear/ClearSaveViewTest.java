package View.Save_clear;

import javax.swing.*;
import java.awt.*;
import app.Main;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class ClearSaveViewTest {

    private JFrame app;

    @Before
    public void setUp() throws Exception {
        Main.main(null);
        for (Window window : Window.getWindows()) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }


    }
    @org.junit.Test
    public void testClearButtonPresent() {
        JButton clearButton = findButtonWithText(app.getContentPane(), "Clear");
        assert clearButton != null;
        assertEquals( "Clear", clearButton.getText());
    }
    @org.junit.Test
    public void testClearButtonFunctionality() {
        JButton clearButton = findButtonWithText(app.getContentPane(), "Clear");
        JTextArea textArea = findTextArea(app);

        assert textArea != null;
        textArea.setText("Test Text");
        assert clearButton != null;
        clearButton.doClick();

        assertEquals("", textArea.getText());
    }
    @org.junit.Test
    public void testSaveButtonPresent() {
        JButton saveButton = findButtonWithText(app.getContentPane(), "Print/Save");
        assert saveButton != null;
        assertEquals( "Print/Save", saveButton.getText());
    }


    @org.junit.Test
    public void testSaveButtonFunctionality() {
        JButton saveButton = findButtonWithText(app.getContentPane(), "Print/Save");
        JTextArea textArea = findTextArea(app);
        assert textArea != null;
        textArea.setText("Text for test");
        assert saveButton != null;
        saveButton.doClick();

        assertEquals("Text saved/printed", textArea.getText());
    }

    private JButton findButtonWithText(Container container, String buttonText) {
        for (Component component : container.getComponents()) {
            if (component instanceof JButton && ((JButton) component).getText().equals(buttonText)) {
                return (JButton) component;
            } else if (component instanceof Container) {
                JButton button = findButtonWithText((Container) component, buttonText);
                if (button != null) {
                    return button;
                }
            }
        }
        return null;
    }

    private JTextArea findTextArea(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JTextArea) {
                return (JTextArea) component;
            } else if (component instanceof Container) {
                JTextArea textArea = findTextArea((Container) component);
                if (textArea != null) {
                    return textArea;
                }
            }
        }
        return null;
    }
}