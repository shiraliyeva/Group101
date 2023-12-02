package view;


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

public class TextAreaView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "text area";

    private TextAreaViewModel textAreaViewModel;
    public final JTextArea textArea;

    private RecommendController recommendController;


    private ClearController clearController;

    private SaveController saveController;


    public TextAreaView(RecommendController recommendController, ClearController clearController,SaveController saveController,TextAreaViewModel textAreaViewModel) {
        this.textAreaViewModel = textAreaViewModel;
        this.clearController = clearController;
        this.saveController = saveController;
        this.recommendController= recommendController;
        this.textAreaViewModel.addPropertyChangeListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton clearButton = new JButton(TextAreaViewModel.CLEAR_BUTTON_LABEL);
        JButton saveButton = new JButton(TextAreaViewModel.SAVEASPDF_BUTTON_LABEL);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);

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

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(clearButton)) {
                    clearController.execute();
                    textArea.setText(textAreaViewModel.getCurrentText());
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(saveButton)) {
                    SaveInputData saveInputData = new SaveInputData(textArea.getText());
                    saveController.execute(saveInputData.getText());
                }
            }
        });
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem recommendItem = new JMenuItem("Recommend");
        popupMenu.add(recommendItem);

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


        recommendItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = textArea.getSelectedText();
                handleRecommendClick("Recommend",selectedText);
            }

        });

    }

    public void propertyChange(PropertyChangeEvent evt) {
    }

    public void actionPerformed(ActionEvent evt) {
    }
    private void handleRecommendClick(String option, String text) {
        System.out.println(option + " chosen");
        System.out.println(text+ " selected");
        String recommendation=recommendController.execute(text);
        new RecommendView(new RecommendViewModel(),this,recommendation);



    }

}

