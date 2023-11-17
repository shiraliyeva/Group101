package use_case.save_text;

public class SaveInteractor implements SaveInputBoundary {
    private SaveOutputBoundary saveOutputBoundary;

    public SaveInteractor(SaveOutputBoundary saveOutputBoundary) {
        this.saveOutputBoundary = saveOutputBoundary;
    }
    public void saveText(SaveInputData inputData) {
        this.saveOutputBoundary.success(inputData);
    }
}
