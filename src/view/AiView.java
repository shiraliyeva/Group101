package view;
import interface_adapter.ai_explanation.AiController;
import interface_adapter.ai_explanation.AiViewModel;
import interface_adapter.text_area.TextAreaViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AiView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "ai explanation";
    public final AiViewModel aiViewModel;
    public final AiController aiController;

    private final JTextArea descriptionArea;

    private final JButton backButton;

    private final JPanel views;

    private final TextAreaViewModel textAreaViewModel;

    private final CardLayout cardLayout;


    public AiView(AiController aiController, AiViewModel aiViewModel, TextAreaViewModel textAreaViewModel, JPanel views, CardLayout cardLayout){
        this.aiController = aiController;
        this.aiViewModel = aiViewModel;
        this.textAreaViewModel = textAreaViewModel;
        this.views = views;
        this.cardLayout = cardLayout;

        JLabel titleLabel = new JLabel(AiViewModel.AIVIEW_TITLE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        // Create a JTextArea for description
        descriptionArea = new JTextArea(AiViewModel.AIVIEW_DESCRIPTION);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false); // To prevent user editing
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        add(backButton);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(titleLabel);
        add(descriptionScrollPane);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource() == backButton) {
                    // Create and switch to a new TextAreaView
//                    TextAreaView newTextAreaView = new TextAreaView(aiController, textAreaViewModel);
                    TextAreaView newTextAreaView = new TextAreaView(aiController, textAreaViewModel, AiView.this);
                    views.add(newTextAreaView, newTextAreaView.viewName);
                    cardLayout.show(views, newTextAreaView.viewName);
                }
            }
        });


    }

    public void updateDescriptionLabel() {
        descriptionArea.setText(aiViewModel.getExplanation());
    }

    public void propertyChange(PropertyChangeEvent evt) {
    }

    public void actionPerformed(ActionEvent evt) {

    }


}

