package interface_adapter.save_text;

import java.beans.PropertyChangeSupport;

public class SaveViewModel {
    public static final String TITLE_LABEL = "Save to PDF";

    public static final String SAVE_BUTTON_LABEL = "Save";

    public String content;



    public void setContent(String content) {
        this.content = content;
        firePropertyChanged();
    }

    public String getContent() {
        return content;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    void firePropertyChanged()  {
        support.firePropertyChange("content", null, this.content);
    }
}