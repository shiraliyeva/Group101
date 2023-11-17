package view;

import interface_adapter.recommend_word.RecommendViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecommendView extends JPanel implements ActionListener, PropertyChangeListener{
    final String viewName = "recommendation";
    final RecommendViewModel recommendViewModel;

    final JTextArea recommendInputArea = new JTextArea(15,15);


    JMenuItem recommendItem = new JMenuItem("Recommend");
    JMenuItem replaceItem = new JMenuItem("Replace");
    JPopupMenu popupMenu = new JPopupMenu(recommendItem.getText());

    public RecommendView(RecommendViewModel recommendViewModel) {
        this.recommendViewModel = recommendViewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Popup Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
