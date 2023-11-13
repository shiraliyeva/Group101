package use_case.clear_text;

public class ClearInteractor implements ClearInputBoundary{
    public void execute() {
        ClearOutputData clearOutputData = new ClearOutputData();
        ClearOutputBoundary clearOutputBoundary = new ClearOutputBoundary()
        // still need to implement the prepare success view
        clearOutputBoundary.prepareSuccessView(clearOutputData);
    }
}
