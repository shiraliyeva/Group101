package view;

import interface_adapter.ai_explanation.AiController;
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
    private final AiView aiView;

    public TextAreaView(AiController aiController, TextAreaViewModel textAreaViewModel, AiView aiView) {
        this.aiView = aiView;
        this.textAreaViewModel = textAreaViewModel;
        this.textAreaViewModel.addPropertyChangeListener(this);
//        this.aiView = aiView;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton clearButton = new JButton(TextAreaViewModel.CLEAR_BUTTON_LABEL);
        JButton saveButton = new JButton(TextAreaViewModel.SAVEASPDF_BUTTON_LABEL);
        JButton askAIButton = new JButton("Ask AI");
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(askAIButton);

        askAIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aiController.execute("chore", "task");
                aiView.updateDescriptionLabel();
//                String previousText = textArea.getText();
//                System.out.println("Text in the JTextArea: " + previousText);
                String currentText = textArea.getText();
                textAreaViewModel.storeCurrentText(currentText); // Store the current text

            }
        });

        // Create a JTextArea
        textArea = new JTextArea(10, 30);
        textArea.setText(TextAreaViewModel.currentText);
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

    public void updateText(String newText) {
        textArea.setText(newText);
    }

    public void propertyChange(PropertyChangeEvent evt) {
    }

    public void actionPerformed(ActionEvent evt) {

    }
}
