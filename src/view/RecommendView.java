package view;

import interface_adapter.ai_explanation.AiController;
import interface_adapter.ai_explanation.AiViewModel;
import interface_adapter.recommend_word.RecommendViewModel;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.*;

public class RecommendView extends JPanel{
    private final RecommendViewModel recommendViewModel;
    private final TextAreaView textAreaView;
    public final String viewName="Recommendation";
    private String recommendation;
    private JLabel labelTest;
    private JButton replaceButtonTest;
    private JButton aiButtonTest;


    public RecommendView(AiController aiController,RecommendViewModel recommendViewModel, TextAreaView textAreaView, String recommendation) {
        this.recommendation=recommendation;

        JFrame frame = new JFrame("Recommendation");

        frame.setSize(500,500);
        JLabel recommend = new JLabel(recommendation);
        this.labelTest= recommend;

        this.recommendViewModel=recommendViewModel;
        this.textAreaView=textAreaView;
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton replaceButton = new JButton(RecommendViewModel.REPLACE_BUTTON_LABEL);
        JButton aiButton = new JButton(RecommendViewModel.AI_BUTTON_LABEL);
        buttonPanel.add(replaceButton);
        buttonPanel.add(aiButton);

        this.setLayout(new BorderLayout());
        frame.getContentPane().add(new JScrollPane(mainPanel), BorderLayout.CENTER);
        mainPanel.add(recommend, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        replaceButtonTest=replaceButton;
        aiButtonTest=aiButton;

        frame.pack();
        frame.setVisible(true);
        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This method is called when the replace button is clicked
                textAreaView.textArea.getSelectedText();
                textAreaView.textArea.replaceSelection(recommendation);
            }
        });

        aiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aiController.execute(textAreaView.textArea.getSelectedText(), recommendation);
                AiView aiView = new AiView(new AiViewModel());
                aiView.updateDescriptionLabel();
            }
        });



    }



    public String getRecommendation() {
        return recommendation;
    }
    public JLabel getTest() {
        return labelTest;
    }

    public JButton getReplaceButtonTest() {
        return replaceButtonTest;
    }
    public JButton getAiButtonTest() {
        return aiButtonTest;
    }
}



