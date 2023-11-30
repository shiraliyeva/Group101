package view;

import interface_adapter.clear_text.ClearController;
import interface_adapter.clear_text.ClearPresenter;
import interface_adapter.clear_text.ClearViewModel;
import interface_adapter.save_text.SaveController;
import interface_adapter.save_text.SavePresenter;
import interface_adapter.save_text.SaveViewModel;
import interface_adapter.text_area.TextAreaViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import use_case.clear_text.*;
import use_case.save_text.*;

public class TextAreaView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "text area";

    private final TextAreaViewModel textAreaViewModel;
//    private final SaveController saveController;
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

        clearButton.addActionListener(new ActionListener() {
            final ClearViewModel clearViewModel = new ClearViewModel();

            final ClearOutputBoundary clearOutputBoundary = new ClearPresenter(clearViewModel, textArea);

            final ClearInputBoundary clearUseCaseInteractor = new ClearInteractor(clearOutputBoundary);
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(clearButton)) {

                    ClearController clearController = new ClearController(clearUseCaseInteractor);
                    clearController.execute();
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {

            final SaveViewModel saveViewModel = new SaveViewModel();

            final SaveOutputBoundary saveOutputBoundary = new SavePresenter(saveViewModel);

            final SaveInputBoundary saveUseCaseInteractor = new SaveInteractor(saveOutputBoundary);
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(saveButton)) {
                    SaveInputData saveInputData = new SaveInputData(textArea.getText());

                    SaveController saveController = new SaveController(saveUseCaseInteractor);
                    saveController.execute(saveInputData.getText());
                }
            }
        });
    }

    public void propertyChange(PropertyChangeEvent evt) {
    }

    public void actionPerformed(ActionEvent evt) {
    }
}

