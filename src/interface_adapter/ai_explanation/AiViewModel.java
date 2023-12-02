package interface_adapter.ai_explanation;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AiViewModel extends ViewModel {

    public static final String AIVIEW_TITLE = "AI Explanation";
    public static final String AIVIEW_DESCRIPTION = "Waiting for ChatGPT..";

    private static AiState state = new AiState();


    public String getExplanation() {
        return state.getExplanation();
    }

    public AiViewModel(){
        super("ai explanation");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public void setState(AiState state){
        this.state = state;
        firePropertyChanged();
    }

    public AiState getState(){return state;}
}
