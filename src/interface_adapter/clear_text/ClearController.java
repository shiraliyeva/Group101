package interface_adapter.clear_text;

import use_case.clear_text.ClearInputBoundary;
import use_case.clear_text.ClearInputData;

public class ClearController {
    final ClearInputBoundary userClearUseCaseInteractor;

    public ClearController(ClearInputBoundary userClearUseCaseInteractor) {
        this.userClearUseCaseInteractor = userClearUseCaseInteractor;
    }

    public void execute() {
        userClearUseCaseInteractor.ClearData();
    }
}