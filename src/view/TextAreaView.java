package view;

import interface_adapter.text_area.TextAreaController;
import interface_adapter.text_area.TextAreaViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import interface_adapter.text_area.TextAreaState;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import interface_adapter.text_area.TextAreaPresenter;

import use_case.recommend_word.RecommendOutputData;
import view.RecommendView;

public class TextAreaView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "text area";

    private final TextAreaViewModel textAreaViewModel;
    public final JTextArea textArea;

    private final TextAreaPresenter textAreaPresenter;


    public TextAreaView(TextAreaViewModel textAreaViewModel, TextAreaPresenter textAreaPresenter) {
        this.textAreaPresenter = textAreaPresenter;
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
        this.textAreaPresenter.prepareRecommendView(new RecommendOutputData("bread"));



    }


}
