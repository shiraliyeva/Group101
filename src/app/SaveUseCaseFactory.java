package app;


import interface_adapter.ViewManagerModel;
import interface_adapter.save_text.SaveController;
import interface_adapter.save_text.SavePresenter;
import interface_adapter.save_text.SaveViewModel;
import use_case.save_text.SaveDataAccessInterface;
import use_case.save_text.SaveInputBoundary;
import use_case.save_text.SaveInteractor;
import use_case.save_text.SaveOutputBoundary;

public class SaveUseCaseFactory {
    public static SaveController create(ViewManagerModel viewManagerModel, SaveViewModel saveViewModel,
                                        SaveDataAccessInterface saveDataAccessObject){


        SaveOutputBoundary saveOutputBoundary = new SavePresenter(saveViewModel);

        SaveInputBoundary saveUseCaseInteractor = new SaveInteractor(saveDataAccessObject, saveOutputBoundary);


        return new SaveController(saveUseCaseInteractor);
    }
}
