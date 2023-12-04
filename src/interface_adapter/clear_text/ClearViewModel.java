package interface_adapter.clear_text;
import java.beans.PropertyChangeSupport;

public class ClearViewModel{

    private static final String CLEAR_PROPERTY = "Clear";
    private String clearTextInput;

    public ClearViewModel() {
    }


    private ClearState state = new ClearState();



    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }


}
