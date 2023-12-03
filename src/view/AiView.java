package view;

import interface_adapter.ai_explanation.AiViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AiView extends JPanel{
    public final String viewName = "ai explanation";
    public final AiViewModel aiViewModel;
    final JTextArea descriptionArea;

    public AiView(AiViewModel aiViewModel){
        this.aiViewModel = aiViewModel;

        // Create a JTextArea for description
        descriptionArea = new JTextArea(AiViewModel.AIVIEW_DESCRIPTION, 10, 30);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false); // To prevent user editing
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(descriptionScrollPane);

        JFrame frame = new JFrame(AiViewModel.AIVIEW_TITLE);
        frame.getContentPane().add(this);  // Add the AiView panel to the JFrame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void updateDescriptionLabel() {
        descriptionArea.setText(aiViewModel.getExplanation());
    }

//    public void propertyChange(PropertyChangeEvent evt) {
//
//    }
//
//    public void actionPerformed(ActionEvent evt) {
//
//    }

    public String getDescriptionAreaText() {
        return descriptionArea.getText();
    }

    public boolean isDescriptionAreaLineWrap() {
        return descriptionArea.getLineWrap();
    }

    public boolean isDescriptionAreaWrapStyleWord() {
        return descriptionArea.getWrapStyleWord();
    }

    public boolean isDescriptionAreaEditable() {
        return descriptionArea.isEditable();
    }

}

