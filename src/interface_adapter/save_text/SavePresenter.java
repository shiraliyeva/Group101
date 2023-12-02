package interface_adapter.save_text;

import data_access.SaveDataAccessObject;
import use_case.save_text.SaveOutputBoundary;
import use_case.save_text.SaveOutputData;


public class SavePresenter implements SaveOutputBoundary {
    private final SaveViewModel saveViewModel;

    public SavePresenter(SaveViewModel saveViewModel) {
        this.saveViewModel = saveViewModel;
    }

    @Override
    public void prepareSaveView(SaveOutputData outputData) {
        this.saveViewModel.setContent(outputData.getOutputText());
    }
}

