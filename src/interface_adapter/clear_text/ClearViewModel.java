package interface_adapter.clear_text;

import use_case.clear_text.ClearOutputData;

import java.beans.PropertyChangeSupport;

public class ClearViewModel{

    private static final String CLEAR_PROPERTY = "Clear";
    ClearOutputData clearOutputData = new ClearOutputData();
    private String clearTextInput;

    public ClearViewModel() {
    }
    
    public String getViewName() {
        return "ClearButton";
    }

    private ClearState state = new ClearState();

    public void setState(ClearState state){
        this.state = state;
    }


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }


}
