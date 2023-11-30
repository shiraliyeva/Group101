package interface_adapter.clear_text;

import interface_adapter.ViewManagerModel;
import use_case.clear_text.ClearOutputBoundary;
import use_case.clear_text.ClearOutputData;

import javax.swing.*;

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;
    private final JTextArea textArea;

    ViewManagerModel viewManagerModel = new ViewManagerModel();

    public ClearPresenter(ClearViewModel view, JTextArea textArea) {
        this.clearViewModel = view;
        this.textArea = textArea;
    }

    @Override
    public void prepareClearView(ClearOutputData clearOutputData) {
        clearViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(clearViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        textArea.setText(clearOutputData.setData());
    }
    }


