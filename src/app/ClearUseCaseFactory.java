package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.clear_text.ClearController;
import interface_adapter.clear_text.ClearPresenter;
import interface_adapter.clear_text.ClearViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import use_case.clear_text.ClearInputBoundary;
import use_case.clear_text.ClearInteractor;
import use_case.clear_text.ClearOutputBoundary;


public class ClearUseCaseFactory {
     static ClearController create(ViewManagerModel viewManagerModel, ClearViewModel clearViewModel, TextAreaViewModel textAreaViewModel) {

        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(clearViewModel, textAreaViewModel );

        ClearInputBoundary clearUseCaseInteractor = new ClearInteractor(clearOutputBoundary);

        return new ClearController(clearUseCaseInteractor);
    }
}

