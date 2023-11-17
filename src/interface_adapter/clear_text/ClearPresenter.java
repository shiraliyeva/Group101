package interface_adapter.clear_text;

import use_case.clear_text.ClearOutputBoundary;
import use_case.clear_text.ClearOutputData;

import java.beans.PropertyChangeEvent;

// TODO Complete me, the ViewManagerModel Should contain the whole view of the program and that should
// show the successView

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;
//    private final ViewManagerModel viewManagerModel;

    public ClearPresenter(ClearViewModel view) {
        this.clearViewModel = view;
//        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData clearOutputData) {
        clearViewModel.firePropertyChanged();

//        viewManagerModel.setActiveView(clearViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//        viewManagerModel.showSuccessView();
    }

    }
}

