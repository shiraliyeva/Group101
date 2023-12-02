package view;


import interface_adapter.ai_explanation.AiController;
import interface_adapter.clear_text.ClearController;
import interface_adapter.save_text.SaveController;

import interface_adapter.recommend_word.RecommendViewModel;
import interface_adapter.text_area.TextAreaViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import use_case.save_text.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import interface_adapter.recommend_word.RecommendController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TextAreaView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "text area";
    private final AiController aiController;
    private final TextAreaViewModel textAreaViewModel;
    public final JTextArea textArea;
    private final RecommendController recommendController;
    private final ClearController clearController;
    private final SaveController saveController;

    public TextAreaView(AiController aiController, RecommendController recommendController,
                        ClearController clearController, SaveController saveController,
                        TextAreaViewModel textAreaViewModel) {
        this.aiController = aiController;
        this.recommendController = recommendController;
        this.clearController = clearController;
        this.saveController = saveController;
        this.textAreaViewModel = textAreaViewModel;
        this.textAreaViewModel.addPropertyChangeListener(this);

        // Create button panel
        JButton clearButton = createButton(TextAreaViewModel.CLEAR_BUTTON_LABEL);
        JButton saveButton = createButton(TextAreaViewModel.SAVEASPDF_BUTTON_LABEL);
        JPanel buttonPanel = createButtonPanel(clearButton, saveButton);

        // Create text area
        textArea = createTextArea();

        // Create scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create main panel
        JPanel mainPanel = createMainPanel(scrollPane, buttonPanel);

        // Set layout manager to BorderLayout
        this.setLayout(new BorderLayout());

        // Add main panel to the center
        this.add(mainPanel, BorderLayout.CENTER);

        // Handle recommend item click
        recommendControllerItem();

    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        return button;
    }

    private JPanel createButtonPanel(JButton clearButton, JButton saveButton) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);

        // Set action listeners
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearController.execute();
                textArea.setText(textAreaViewModel.getCurrentText());
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveInputData saveInputData = new SaveInputData(textArea.getText());
                saveController.execute(saveInputData.getText());
            }
        });

        return buttonPanel;
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setText(TextAreaViewModel.currentText);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    private JPanel createMainPanel(JScrollPane scrollPane, JPanel buttonPanel) {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        return mainPanel;
    }

    private void recommendControllerItem() {
        JMenuItem recommendItem = new JMenuItem("Recommend");
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(recommendItem);

        recommendItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = textArea.getSelectedText();
                handleRecommendClick(selectedText);
            }
        });

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }


    private void handleRecommendClick(String text) {
        String recommendation = recommendController.execute(text);
        new RecommendView(aiController, new RecommendViewModel(), this, recommendation);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property change if needed
    }

    public void actionPerformed(ActionEvent evt) {
        // Handle action event if needed
    }
}

