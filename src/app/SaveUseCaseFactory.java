package app;


import interface_adapter.ViewManagerModel;
import interface_adapter.save_text.SaveController;
import interface_adapter.save_text.SavePresenter;
import interface_adapter.save_text.SaveViewModel;
import use_case.save_text.SaveInputBoundary;
import use_case.save_text.SaveInteractor;
import use_case.save_text.SaveOutputBoundary;

public class SaveUseCaseFactory {
    static SaveController create(ViewManagerModel viewManagerModel, SaveViewModel saveViewModel){


        SaveOutputBoundary saveOutputBoundary = new SavePresenter(saveViewModel);

        SaveInputBoundary saveUseCaseInteractor = new SaveInteractor(saveOutputBoundary);


        return new SaveController(saveUseCaseInteractor);
    }
}
