package interface_adapter.save_text;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SaveViewModel {
    public static final String TITLE_LABEL = "Save to PDF";

    public static final String SAVE_BUTTON_LABEL = "Save";

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        firePropertyChanged();
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    void firePropertyChanged()  {
        support.firePropertyChange("content", null, this.content);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
