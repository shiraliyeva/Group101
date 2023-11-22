package view;

import interface_adapter.recommend_word.RecommendViewModel;
import interface_adapter.text_area.TextAreaViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.*;

public class RecommendView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "recommendation";
    private final RecommendViewModel recommendViewModel;

    public RecommendView(RecommendViewModel recommendViewModel) {

        JFrame frame = new JFrame("Recommendation");

        frame.setSize(200,200);
        CardLayout cardLayout1 = new CardLayout();
        JPanel views1 = new JPanel((cardLayout1));

        this.recommendViewModel=recommendViewModel;
        this.addPropertyChangeListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton replaceButton = new JButton(RecommendViewModel.REPLACE_BUTTON_LABEL);
        JButton aiButton = new JButton(RecommendViewModel.AI_BUTTON_LABEL);
        panel.add(replaceButton);
        panel.add(aiButton);
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel, BorderLayout.SOUTH);
        this.setLayout(new BorderLayout());
        frame.add(views1);
        frame.getContentPane().add(new JScrollPane(panel), BorderLayout.CENTER);
        frame.setVisible(true);


        // Add the mainPanel to the CENTER of TextAreaView
        this.add(mainPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}



