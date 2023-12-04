package view;

import interface_adapter.ai_explanation.AiController;
import interface_adapter.ai_explanation.AiViewModel;
import interface_adapter.recommend_word.RecommendViewModel;
import view.command.AiCommand;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.*;

public class RecommendView extends JPanel implements ActionListener, PropertyChangeListener{
    private final RecommendViewModel recommendViewModel;
    private final TextAreaView textAreaView;
    public final String viewName="Recommendation";
    private String recommendation;


    public RecommendView(AiController aiController,RecommendViewModel recommendViewModel, TextAreaView textAreaView, String recommendation) {
        this.recommendation=recommendation;

        JFrame frame = new JFrame("Recommendation");

        frame.setSize(500,500);
        JLabel recommend = new JLabel(recommendation);

        this.recommendViewModel=recommendViewModel;
        this.recommendViewModel.addPropertyChangeListener(this);
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

        AiCommand aiCommand = new AiCommand(aiController, textAreaView.textArea.getSelectedText(), recommendation);

        aiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aiCommand.execute();
//                aiController.execute(textAreaView.textArea.getSelectedText(), recommendation);
                AiView aiView = new AiView(new AiViewModel());
                aiView.updateDescriptionLabel();
            }
        });



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}



