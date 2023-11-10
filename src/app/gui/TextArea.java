package app.gui;
import javax.swing.*;
import java.awt.*;

public class TextArea {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Area");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton button1 = new JButton("Save as PDF");
        JButton button2 = new JButton("Clear");
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        // Create a JTextArea
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Add the textArea to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the scrollPane to the frame's content pane
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Add the buttonPanel to the frame's content pane at the SOUTH position
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
