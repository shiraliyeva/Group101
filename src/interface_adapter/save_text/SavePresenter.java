package interface_adapter.save_text;

import use_case.save_text.SaveInputData;
import use_case.save_text.SaveOutputBoundary;

public class SavePresenter implements SaveOutputBoundary {
    private final SaveViewModel saveViewModel;

    public SavePresenter(SaveViewModel saveViewModel) {
        this.saveViewModel = saveViewModel;
    }

    public void success(SaveInputData inputData) {
        this.saveViewModel.firePropertyChanged();

    }

    public void prepareFailView(String error) {
        saveViewModel.firePropertyChanged();
    }
}