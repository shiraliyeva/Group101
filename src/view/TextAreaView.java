package view;

import interface_adapter.text_area.TextAreaViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import interface_adapter.text_area.TextAreaState;

public class TextAreaView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "text area";

    private final TextAreaViewModel textAreaViewModel;
    private final JTextArea textArea;

    public TextAreaView(TextAreaViewModel textAreaViewModel) {
        this.textAreaViewModel = textAreaViewModel;
        this.textAreaViewModel.addPropertyChangeListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton clearButton = new JButton(TextAreaViewModel.CLEAR_BUTTON_LABEL);
        JButton saveButton = new JButton(TextAreaViewModel.SAVEASPDF_BUTTON_LABEL);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);

        // Create a JTextArea
        textArea = new JTextArea(10, 30);
        textArea.setText(TextAreaViewModel.GUIDE_TEXT_AREA);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Add the textArea to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the scrollPane and buttonPanel to a new JPanel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set the layout manager of TextAreaView to BorderLayout
        this.setLayout(new BorderLayout());

        // Add the mainPanel to the CENTER of TextAreaView
        this.add(mainPanel, BorderLayout.CENTER);
    }

    public void propertyChange(PropertyChangeEvent evt) {
    }

    public void actionPerformed(ActionEvent evt) {

    }
}
