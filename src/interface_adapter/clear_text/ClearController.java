package interface_adapter.clear_text;

import use_case.clear_text.ClearInputBoundary;
import use_case.clear_text.ClearInputData;


public class ClearController {
    final ClearInputBoundary clearUseCaseInteractor;

    public ClearController(ClearInputBoundary clearUseCaseInteractor) {
        this.clearUseCaseInteractor = clearUseCaseInteractor;
    }

    public void execute() {
        ClearInputData clearInputData = new ClearInputData();
        this.clearUseCaseInteractor.execute(clearInputData);
    }
}