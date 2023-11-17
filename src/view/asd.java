package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class asd {


    public class PopupMenuExample {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Popup Menu Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JTextArea textArea = new JTextArea(10, 30);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            // Create a JPopupMenu
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem copyItem = new JMenuItem("Copy");
            JMenuItem cutItem = new JMenuItem("Cut");
            JMenuItem pasteItem = new JMenuItem("Paste");

            popupMenu.add(copyItem);
            popupMenu.add(cutItem);
            popupMenu.add(pasteItem);

            // Add a MouseListener to the JTextArea
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

            frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

            frame.setVisible(true);
        }
    }
}
