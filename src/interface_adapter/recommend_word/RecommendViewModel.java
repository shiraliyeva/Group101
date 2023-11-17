package interface_adapter.recommend_word;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RecommendViewModel extends ViewModel {
    public static final String RECOMMEND_BUTTON_LABEL = "Recommend";
    public static final String TITLE_LABEL = "Text View";
    public static final String REPLACE_BUTTON_LABEL = "Replace";
    private RecommendState state = new RecommendState();

    public RecommendViewModel(String viewName) {
        super(viewName);
    }

    public void setState(RecommendState state) {
        this.state = state;
    }
    // public String getState() {return state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public RecommendState getState() {
        return state;
    }




}
