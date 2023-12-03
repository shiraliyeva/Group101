package interface_adapter.clear_text;

import interface_adapter.ViewManagerModel;
import interface_adapter.text_area.TextAreaViewModel;
import use_case.clear_text.ClearOutputBoundary;
import use_case.clear_text.ClearOutputData;
import view.TextAreaView;

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;

    private final TextAreaViewModel textAreaViewModel;

    ViewManagerModel viewManagerModel = new ViewManagerModel();

    public ClearPresenter(ClearViewModel view, TextAreaViewModel textAreaViewModel) {
        this.clearViewModel = view;
        this.textAreaViewModel = textAreaViewModel;
    }

    @Override
    public void prepareClearView(ClearOutputData clearOutputData) {
        clearViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();
        textAreaViewModel.storeCurrentText(clearOutputData.setData());
    }
    }


