import interface_adapter.save_text.SaveViewModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SaveView extends JPanel implements ActionListener, PropertyChangeListener {

    private SaveViewModel SaveviewModel;
    private JTextField contentTextField;

    public SaveView(SaveViewModel viewModel) {
        this.SaveviewModel = viewModel;
        viewModel.addPropertyChangeListener(this);

        initialize();
    }

    private void initialize() {
        JLabel titleLabel = new JLabel(SaveViewModel.TITLE_LABEL);
        add(titleLabel);

        contentTextField = new JTextField(20);
        contentTextField.setText(SaveviewModel.getContent());
        add(contentTextField);

        JButton saveButton = new JButton(SaveViewModel.SAVE_BUTTON_LABEL);
        saveButton.addActionListener(this);
        add(saveButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(SaveViewModel.SAVE_BUTTON_LABEL)) {
            // Save button clicked, perform save action
            saveContent();
        }
    }

    private void saveContent() {
        String newContent = contentTextField.getText();
        SaveviewModel.setContent(newContent);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("content".equals(evt.getPropertyName())) {
            contentTextField.setText(SaveviewModel.getContent());
        }
    }

    public static void main(String[] args) {
        SaveViewModel viewModel = new SaveViewModel();
        SaveView saveView = new SaveView(viewModel);
        viewModel.setContent("New Content");
    }
}
