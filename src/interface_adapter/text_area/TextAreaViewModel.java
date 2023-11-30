package interface_adapter.text_area;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TextAreaViewModel extends ViewModel {

    public static final String CLEAR_BUTTON_LABEL = "Clear";
    public static final String SAVEASPDF_BUTTON_LABEL = "Print/Save";

    public static final String GUIDE_TEXT_AREA = "Please input your text here...";
    private TextAreaState state = new TextAreaState();
    

    public TextAreaViewModel() {
        super("text area");
    }

    public void setState(TextAreaState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public TextAreaState getState() {
        return state;
    }
}
