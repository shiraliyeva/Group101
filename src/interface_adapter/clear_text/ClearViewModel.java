package interface_adapter.clear_text;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ClearViewModel{
    // extends View, should extend the main view that fidan is implementing

    private static final String CLEAR_PROPERTY = "Clear";
    private final String ViewName;

    public ClearViewModel() {
        this.ViewName = "Clear";
    }
    
    public Object getViewName() {
        return this.ViewName;
    }


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange(CLEAR_PROPERTY, false, true);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
}
    }